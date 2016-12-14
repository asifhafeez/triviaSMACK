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
  questionHash.getQuestionArray();
}

  public String setQuestion(){
    chosenQuestion = questionHash.randomQuestion();
    String question = "<speak>" + chosenQuestion + "<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
    return question;
  }


    //
    // public String checkIfCorrect(final String answer, String teamOne, String teamTwo, String teamOneScore, String teamTwoScore, String currentTeamAttribute) {
    //   randomAnswer = questionHash.getAnswer(chosenQuestion);
    //   String correctAnswer = randomAnswer.toLowerCase();
    //   System.out.println("----printing answer score from answer handler---");
    //   System.out.println(answer);
    //   System.out.println("----printing teamone name from answer handler---");
    //   System.out.println(teamOne);
    //   System.out.println("----printing teamtwo name from answer handler---");
    //   System.out.println(teamTwo);
    //   System.out.println("----printing teamone score from answer handler---");
    //   System.out.println(teamOneScore);
    //   System.out.println("----printing teamtwo score from answer handler---");
    //   System.out.println(teamTwoScore);
    //   System.out.println("----printing currentTeamAttribute from answer handler---");
    //   System.out.println(currentTeamAttribute);
    //   if (answer.equals(correctAnswer)) {
    //         return "The answer is " + randomAnswer + ". You are correct! " + teamOne + " has " + teamOneScore +". "+ teamTwo + " has " + teamTwoScore+ ". " + currentTeamAttribute+ " is up next.";
    //        } else {
    //         return "The answer is " + randomAnswer + ". You are incorrect! " + teamOne + " has " + teamOneScore +". "+ teamTwo + " has " + teamTwoScore+ ". " + currentTeamAttribute+ " is up next.";
    //     }
    // }
  public String checkIfCorrect(final String answer) {
    randomAnswer = questionHash.getAnswer(chosenQuestion);
    String correctAnswer = randomAnswer.toLowerCase();

    if (answer.equals(correctAnswer)) {
          return "The answer is " + randomAnswer + ". You are correct! ";
         } else {
          return "The answer is " + randomAnswer + ". You are incorrect! ";
      }
  }

   public Integer score(String answer) {
    randomAnswer = questionHash.getAnswer(chosenQuestion);
    String correctAnswer = randomAnswer.toLowerCase();

    if (answer.equals(correctAnswer)) {
          return 1;
         } else {
          return 0;
      }
  }

}
