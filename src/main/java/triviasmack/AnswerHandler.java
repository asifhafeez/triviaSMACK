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

public class AnswerHandler {

public String setQuestion(){
  String question = "<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>";
  return question;
}


public SpeechletResponse getAnswerResponse(final Intent intent) {
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

}
