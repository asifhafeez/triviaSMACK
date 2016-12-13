package triviasmack;

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
    String correctAnswer = randomAnswer.toLowerCase();

    if (answer.equals(correctAnswer)) {
          return "The answer is " + randomAnswer + ". You are correct!";
         } else {
          return "The answer is " + randomAnswer + ". You are incorrect!";
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
