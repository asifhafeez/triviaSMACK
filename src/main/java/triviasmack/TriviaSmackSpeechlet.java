
package triviasmack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class TriviaSmackSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(TriviaSmackSpeechlet.class);
    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();

        String intentName = (intent != null) ? intent.getName() : null;

        if ("TriviaSmackIntent".equals(intentName)) {
            Slot answerSlot = intent.getSlot("Answer");
            String answerValue = answerSlot.getValue();
            if (answerSlot != null && answerValue != null) {
                return getAnswerResponse(intent);
            } else {
                return getQuestionResponse();
            }
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return getHelpResponse();
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }


    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome to Trivia Smack, your gateway quiz!";


        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }

   
     private SpeechletResponse getQuestionResponse() {

       SsmlOutputSpeech speech = new SsmlOutputSpeech();
       speech.setSsml("<speak>What is the capital of the UK?<break time='1s'/> 5<break time='1s'/> 4<break time='1s'/> 3<break time='1s'/> 2<break time='1s'/> 1<break time='1s'/> TIME'S UP!");

       return SpeechletResponse.newTellResponse(speech);
   }

   private SpeechletResponse getAnswerResponse(final Intent intent) {
        Slot answerSlot = intent.getSlot("Answer");
        String answerValue = answerSlot.getValue();
        String realAnswerValue = answerValue.toLowerCase();
        if (answerSlot != null && answerValue != null) {
            String answer = "london";
            if (answer.equals(realAnswerValue)) {
                String speechText = "The answer is London. You are correct!";

                PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
                speech.setText(speechText);

                Reprompt reprompt = new Reprompt();
                reprompt.setOutputSpeech(speech);

                return SpeechletResponse.newTellResponse(speech);
            } else {
                String speechText = "The answer is London. You are wrong";

                PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
                speech.setText(speechText);

                return SpeechletResponse.newTellResponse(speech);
         }
     } else {
                String speechText = "Nothing received";

                PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
                speech.setText(speechText);

                return SpeechletResponse.newTellResponse(speech);
     }


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
