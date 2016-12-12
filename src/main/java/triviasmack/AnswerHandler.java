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

QuestionHash questionHash = new QuestionHash();
String chosenQuestion = "";
String randomAnswer = "";


  public String setQuestion(){
    chosenQuestion = questionHash.randomQuestion();
    String question = "<speak>" + chosenQuestion + "<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
    return question;
  }



  public String checkIfCorrect(final String answer) {
    randomAnswer = questionHash.getAnswer(chosenQuestion);
    String correctAnswer = randomAnswer;

    if (answer.equals(correctAnswer)) {
          return "The answer is " + randomAnswer + ". You are correct!";
         } else {
          return "The answer is " + randomAnswer + ". You are incorrect!";
      }
  }


}
