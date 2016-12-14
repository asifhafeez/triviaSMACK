
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
  String currentTeamAttribute = "";
  String teamOneName = "";
  String teamTwoName = "";

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {

            answerHandler.makeQuestionArray();

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
        if ("FailedIntent".equals(intentName)) {
          return incorrectUtterance(session);
        }
        else if ("TriviaSmackIntent".equals(intentName)) {
            Slot answerSlot = intent.getSlot("Answer");
            String answerValue = answerSlot.getValue();
            if (answerSlot != null && answerValue != null) {
                return getAnswerResponse(intent, session);
            } else {
                return getQuestionResponse(session);
            }

          } else if ("GameSetupIntent".equals(intentName)) {
            System.out.println("Hello 1");
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
        return getSpeechlet(speechText);
    }

    private SpeechletResponse getSpeechlet(String speechText) {
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
          Object teamOneAttribute = session.getAttribute("TeamOneName");
          Object teamTwoAttribute = session.getAttribute("TeamTwoName");

          if (teamOneAttribute == null) {
            session.setAttribute("TeamOneName", teamOneNameValue);
            currentTeamAttribute = (String) session.getAttribute("TeamOneName");
          }

          session.setAttribute("TeamTwoName", intent.getSlot("TeamTwo").getValue());

          if(session.getAttribute("TeamOneName") != null) {
            if(teamTwoNameSlot != null && teamTwoNameValue != null) {
              teamOneName = session.getAttribute("TeamOneName").toString();
              currentTeamAttribute = session.getAttribute("TeamOneName").toString();
              teamTwoName = session.getAttribute("TeamTwoName").toString();
              session.setAttribute("TeamTwoScore", 0);
              speechText = teamSetup.setupTeams(teamOneName, teamTwoName);
            } else {
              teamOneName = session.getAttribute("TeamOneName").toString();
              session.setAttribute("TeamOneScore", 0);
              speechText = teamSetup.setupTeams(teamOneName, teamTwoName);
            }
          } else {
            speechText = teamSetup.setupTeams(teamOneName, teamTwoName);
          }
          return getSpeechlet(speechText);
      }

    private SpeechletResponse getQuestionResponse(final Session session) {
     String question = answerHandler.setQuestion();
     SsmlOutputSpeech speech = new SsmlOutputSpeech();
     speech.setSsml(question);
     session.setAttribute("question", speech);

     Reprompt reprompt = new Reprompt();
     PlainTextOutputSpeech repromptQuestionSpeech = new PlainTextOutputSpeech();
     String repromptWithQuestion = "Don't forget to answer. Your question was " + question;
     repromptQuestionSpeech.setText(repromptWithQuestion);
     reprompt.setOutputSpeech(repromptQuestionSpeech);

     return SpeechletResponse.newAskResponse(speech, reprompt);
   }


    private SpeechletResponse getRepeatResponse(Intent intent, Session session) {
     SsmlOutputSpeech speech = (SsmlOutputSpeech) session.getAttribute("question");

     Reprompt reprompt = new Reprompt();
     reprompt.setOutputSpeech(speech);

     return SpeechletResponse.newAskResponse(speech, reprompt);
 }

 public SpeechletResponse getAnswerResponse(final Intent intent, Session session) {
     Slot answerSlot = intent.getSlot("Answer");
     String answerValue = answerSlot.getValue();
     String realAnswerValue = answerValue.toLowerCase();
     String speechText = "";
     Integer scoreAttribute = 0;
     String winningTeam = currentTeamAttribute;
     if (answerSlot != null)
       {
         if (currentTeamAttribute == teamOneName) {
           scoreAttribute = (Integer) session.getAttribute("TeamOneScore") + answerHandler.score(realAnswerValue);
           session.setAttribute("TeamOneScore", scoreAttribute);

         } else {
           scoreAttribute = (Integer) session.getAttribute("TeamTwoScore") + answerHandler.score(realAnswerValue);
           session.setAttribute("TeamTwoScore", scoreAttribute);
         }
         currentTeamAttribute = teamSetup.defineUser(currentTeamAttribute, teamOneName, teamTwoName);

         String teamOneScores = session.getAttribute("TeamOneScore").toString();
         String teamTwoScores = session.getAttribute("TeamTwoScore").toString();

         speechText = answerHandler.checkIfCorrect(realAnswerValue, teamOneName, teamTwoName, teamOneScores, teamTwoScores, currentTeamAttribute);

      } else {
         speechText = "Nothing received";
      }

      if (scoreAttribute >= 2) {
        speechText = winningTeam + " wins!"; 


        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);
        return SpeechletResponse.newTellResponse(speech);
      }

       PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
       speech.setText(speechText);

       Reprompt reprompt = new Reprompt();
       PlainTextOutputSpeech repromptAnswerSpeech = new PlainTextOutputSpeech();
       repromptAnswerSpeech.setText("To get the next question, say Alexa, next question");
       reprompt.setOutputSpeech(repromptAnswerSpeech);

       return SpeechletResponse.newAskResponse(speech, reprompt);
  }

    private SpeechletResponse incorrectUtterance(Session session) {
      String speechText = "TriviaSmack says no.";

      return getSpeechlet(speechText);

    }


    private SpeechletResponse getHelpResponse() {
      String speechText = "You can ask me to start a quiz!";
      return getSpeechlet(speechText);

    }
}
