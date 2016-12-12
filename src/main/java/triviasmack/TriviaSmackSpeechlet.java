
package triviasmack;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SsmlOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import java.util.logging.Logger;


public class TriviaSmackSpeechlet implements Speechlet {
  private final static Logger log = Logger.getLogger(TriviaSmackSpeechlet.class.getName());
  AnswerHandler answerHandler = new AnswerHandler();
  TeamSetup teamSetup = new TeamSetup();

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
      
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {

        Intent intent = request.getIntent();

        String intentName = (intent != null) ? intent.getName() : null;
        if ("TriviaSmackIntent".equals(intentName)) {
            Slot answerSlot = intent.getSlot("Answer");
            String answerValue = answerSlot.getValue();
            if (answerSlot != null && answerValue != null) {
                return getAnswerResponse(intent);
            } else {
                return getQuestionResponse(session);
            }
          } else if ("GameSetupIntent".equals(intentName)) {
            return getSetupResponse(intent, session);
          } else if ("AMAZON.HelpIntent".equals(intentName)) {
              return getHelpResponse();
          } else if ("AMAZON.RepeatIntent".equals(intentName)) {
              return getRepeatResponse(intent, session);
          } else {
              throw new SpeechletException("Invalid Intent");
          }
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
    }
    
    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome to Trivia Smack, your gateway quiz!";


        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }

    private SpeechletResponse getSetupResponse(Intent intent, Session session)
        {
          Slot teamOneNameSlot = intent.getSlot("TeamOne");
          Slot teamTwoNameSlot = intent.getSlot("TeamTwo");
          String teamOneNameValue = teamOneNameSlot.getValue();
          String teamTwoNameValue = teamTwoNameSlot.getValue();
          String speechText = "";
          if(teamOneNameSlot != null) {
            if(teamTwoNameSlot != null) {
              session.setAttribute("TeamTwoName", teamTwoNameValue);
              String teamOneName = session.getAttribute("TeamOneName").toString();
              String teamTwoName = session.getAttribute("TeamTwoName").toString();
              speechText = teamSetup.setupTeams(teamOneName, teamTwoName);
            } 
            else {
              session.setAttribute("TeamOneName", teamOneNameValue);
              String teamOneName = session.getAttribute("TeamOneName").toString();
              String teamTwoName = session.getAttribute("TeamTwoName").toString();
              speechText = "Team one name is " + teamOneName + teamSetup.setupTeams(teamOneName, teamTwoName);
            }
          } else {
            speechText = teamSetup.setupTeams(teamOneNameValue, teamTwoNameValue);
          }
          PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
          speech.setText(speechText);

          Reprompt reprompt = new Reprompt();
          reprompt.setOutputSpeech(speech);

          return SpeechletResponse.newAskResponse(speech, reprompt);
          }

    private SpeechletResponse getQuestionResponse(final Session session) {
     String question = answerHandler.setQuestion();
     SsmlOutputSpeech speech = new SsmlOutputSpeech();
     speech.setSsml(question);

     session.setAttribute("question", speech);

     Reprompt reprompt = new Reprompt();
     reprompt.setOutputSpeech(speech);


     return SpeechletResponse.newAskResponse(speech, reprompt);
   }


    private SpeechletResponse getRepeatResponse(Intent intent, Session session) {
     SsmlOutputSpeech speech = (SsmlOutputSpeech) session.getAttribute("question");

     Reprompt reprompt = new Reprompt();
     reprompt.setOutputSpeech(speech);

     return SpeechletResponse.newAskResponse(speech, reprompt);
 }

 public SpeechletResponse getAnswerResponse(final Intent intent) {
     Slot answerSlot = intent.getSlot("Answer");
     String answerValue = answerSlot.getValue();
     String realAnswerValue = answerValue.toLowerCase();
     String speechText = "";
     if (answerSlot != null)
       {
         speechText = answerHandler.checkIfCorrect(realAnswerValue); 
      } else {
         speechText = "Nothing received";
      }
       PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
       speech.setText(speechText);

       return SpeechletResponse.newTellResponse(speech);
  }



    private SpeechletResponse getHelpResponse() {
        String speechText = "You can ask me to start a quiz!";


        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }
}
