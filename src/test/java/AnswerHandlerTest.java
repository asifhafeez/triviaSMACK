package triviasmack;

import org.junit.Test;
import java.util.ArrayList;
import java.lang.Object;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.*;


public class AnswerHandlerTest {

  // @Test
  // public void iterator_will_return_hello_world(){
  //  //arrange
  //  Iterator i=mock(Iterator.class);
  //  when(i.next()).thenReturn("Hello").thenReturn("World");
  //  //act
  //  String result=i.next()+" "+i.next();
//   //  //assert
//   //  assertEquals("Hello World", result);
//   // }
//   //
//   // public String setQuestion(){
//   //   chosenQuestion = questionHash.randomQuestion();
//   //   String question = "<speak>" + chosenQuestion + "<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
//   //   return question;
//   // }
//   // public String setQuestion(){
//   //   chosenQuestion = questionHash.randomQuestion();
//   //   String question = "<speak>" + chosenQuestion + "<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
//   //   return question;
//   // }
//   QuestionHash questionHash=mock(QuestionHash.class);
//
//
//
//   @Test
//   public void testSetQuestion(){
//
//       // QuestionHash questionHash=mock(QuestionHash.class);
//       when(questionHash.randomQuestion()).thenReturn("What is the capital of England?");
//       AnswerHandler answerhandler = new AnswerHandler();
//       String result = answerhandler.setQuestion();
//       assertEquals("<speak>What is the capital of England?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>", result);
//   }
//
// }
// ------------------
// // code for testing
// // ------------------
// public String checkIfCorrect(final String answer, String teamOneName, String teamTwoName, String teamOneScore, String teamTwoScore, String currentTeamAttribute) {
//   randomAnswer = questionHash.getAnswer(chosenQuestion);
//   String correctAnswer = randomAnswer.toLowerCase();
//   String answerText = teamOneName + " has " + teamOneScore +". "+ teamTwoName + " has " + teamTwoScore+ ". " + currentTeamAttribute+ " is up next.";
//   if (answer.equals(correctAnswer)) {
//         return "The answer is " + randomAnswer + ". You are correct! " + answerText;
//        } else {
//         return "The answer is " + randomAnswer + ". You are incorrect! " + answerText;
//     }
// }
// // -------------------
//
//
//   @Test
//   public void testcheckIfCorrect(){
//     AnswerHandler answerhandler = new AnswerHandler();
//     QuestionHash questionHash = new QuestionHash();
//     String chosenQuestion = "What person am I thinking of?";
//     String result = answerhandler.checkIfCorrect("frankie", "Anna", "Nicole", "One", "Zero", "Nicole");
//     assertEquals("The answer is Frankie. You are correct! Anna has One. Nicole has Zero. Nicole is up next.", result);
//   }
// }


//   @Test
//   public void setQuestionTest() {
//     AnswerHandler answerHandler = new AnswerHandler();
//     assertEquals(answerHandler.setQuestion(), "<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>");
//   }

//   @Test
//   public void correctAnswerTest() {
//     AnswerHandler answerHandler = new AnswerHandler();
//     assertEquals(answerHandler.checkIfCorrect("london"), "The answer is London. You are correct!");
//   }

// @Test
//   public void wrongAnswerTest() {
//     AnswerHandler answerHandler = new AnswerHandler();
//     assertEquals(answerHandler.checkIfCorrect("berlin"), "The answer is London. You are incorrect");
//   }


}
