package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnswerHandlerTest {


// @Test
//   public void testConcatenate(){
//     TriviaSmackSpeechlet tss = new TriviaSmackSpeechlet();

//     String result = tss.concatenate("one", "two");

//     assertEquals("onetwo", result);
//   }

  // @Before public void each() {
  // }


  @Test
  public void setQuestionTest() {
    AnswerHandler answerHandler = new AnswerHandler();
    assertEquals(answerHandler.setQuestion(), "<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>");
  }

  @Test
  public void correctAnswerTest() {
    AnswerHandler answerHandler = new AnswerHandler();
    assertEquals(answerHandler.checkIfCorrect("london"), "The answer is London. You are correct!");
  }

@Test
  public void wrongAnswerTest() {
    AnswerHandler answerHandler = new AnswerHandler();
    assertEquals(answerHandler.checkIfCorrect("berlin"), "The answer is London. You are incorrect");
  }


}