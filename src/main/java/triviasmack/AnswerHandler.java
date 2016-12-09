package triviasmack;

public class AnswerHandler {

 public String setQuestion(){
    String question = "<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>";
    return question;
  }
  
  public String checkIfCorrect(final String answer) {
    String correctAnswer = "london";

    if (answer.equals(correctAnswer)) {
          return "The answer is London. You are correct!";
         } else {
          return "The answer is London. You are incorrect";
      }
  }

}
