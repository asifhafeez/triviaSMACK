package triviasmack;
import java.util.*;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;

public class AnswerHandler {
  QuestionHash questionHash = new QuestionHash();
  String chosenQuestion = "";
  String randomAnswer = "";

  public void makeQuestionArray(){
    questionHash.getQuestions();
  }

  public String setQuestion(){
    chosenQuestion = questionHash.randomQuestion();
    String question = "<speak>" + chosenQuestion + "<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
    return question;
  }


  public String checkIfCorrect(final String answer, String teamOneName, String teamTwoName, String teamOneScore, String teamTwoScore, String currentTeamAttribute) {
    String correctAnswer = getCorrectAnswer();
    String answerText = teamOneName + " has " + teamOneScore +". "+ teamTwoName + " has " + teamTwoScore+ ". " + currentTeamAttribute+ " is up next. Say next question to get the next question";
    return verifyAnswer(answer, correctAnswer, answerText);
  }

  public String verifyAnswer(final String answer, String correctAnswer, String answerText){
    if (answer.equals(correctAnswer)) {
      return getAlexaAnswer(correctAnswer, "correct", answerText);
    } else {
      return getAlexaAnswer(correctAnswer, "incorrect", answerText);
    }
  }

  public String getAlexaAnswer(String correctAnswer, String validation, String answerText){
    return "The answer is " + correctAnswer + ". You are " + validation + "! " + answerText;
  }

  public Integer score(String answer) {
    String correctAnswer = getCorrectAnswer();

    if (answer.equals(correctAnswer)) {
      return 1;
    } else {
      return 0;
    }
  }

  public String getCorrectAnswer(){
    randomAnswer = questionHash.getAnswer(chosenQuestion);
    return randomAnswer.toLowerCase();
  }

}
