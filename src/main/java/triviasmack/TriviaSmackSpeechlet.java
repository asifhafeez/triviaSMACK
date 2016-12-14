
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
  Integer scoreAttribute = 0;


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


    private SpeechletResponse getSetupResponse(Intent intent, Session session)
        {
          String speechText;
          setTeamAttributes(intent, session);
          return getSpeechlet(gameSetup(session, intent));
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

 private String answerChecker(Intent intent, Session session) {
  if (intent.getSlot("Answer") != null) {
       if (currentTeamAttribute == teamOneName) {
         scoreAttribute = (Integer) session.getAttribute("TeamOneScore") + answerHandler.score(intent.getSlot("Answer").getValue().toLowerCase());
         session.setAttribute("TeamOneScore", scoreAttribute);
       } else {
         scoreAttribute = (Integer) session.getAttribute("TeamTwoScore") + answerHandler.score(intent.getSlot("Answer").getValue().toLowerCase());
         session.setAttribute("TeamTwoScore", scoreAttribute);
       }
       currentTeamAttribute = teamSetup.defineUser(currentTeamAttribute, teamOneName, teamTwoName);
       String teamOneScores = session.getAttribute("TeamOneScore").toString();
       String teamTwoScores = session.getAttribute("TeamTwoScore").toString();
       return answerHandler.checkIfCorrect(intent.getSlot("Answer").getValue().toLowerCase(), teamOneName, teamTwoName, teamOneScores, teamTwoScores, currentTeamAttribute);
  } else {
     return "Nothing received";
  }
 }

 private SpeechletResponse getAnswerResponse(final Intent intent, Session session) {
     String speechText = "";
     String winningTeam = currentTeamAttribute;
     speechText = answerChecker(intent, session);

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

    private SpeechletResponse getSpeechlet(String speechText) {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }



    private void setTeamAttributes(Intent intent, Session session) {
      if (session.getAttribute("TeamOneName") == null) {
        session.setAttribute("TeamOneName", intent.getSlot("TeamOne").getValue());
        currentTeamAttribute = (String) session.getAttribute("TeamOneName");
      }
      session.setAttribute("TeamTwoName", intent.getSlot("TeamTwo").getValue());
    }

    private String gameSetup(Session session, Intent intent){
      if(session.getAttribute("TeamOneName") != null) {
        return checkTeams(session, intent);
      } else {
        return teamSetup.setupTeams(teamOneName, teamTwoName);
      }
    }

    private String checkTeams(Session session, Intent intent){
      if(intent.getSlot("TeamTwo") != null && intent.getSlot("TeamTwo").getValue() != null) {
        return teamTwoSetup(session);
      } else {
        return teamOneSetup(session);
      }
    }

    private String teamOneSetup(Session session){
        teamOneName = session.getAttribute("TeamOneName").toString();
        session.setAttribute("TeamOneScore", 0);
        return teamSetup.setupTeams(teamOneName, teamTwoName);
      }


    private String teamTwoSetup(Session session){
      teamTwoName = session.getAttribute("TeamTwoName").toString();
      currentTeamAttribute = session.getAttribute("TeamOneName").toString();
      session.setAttribute("TeamTwoScore", 0);
      return teamSetup.setupTeams(session.getAttribute("TeamOneName").toString(), session.getAttribute("TeamTwoName").toString());
    }

}
