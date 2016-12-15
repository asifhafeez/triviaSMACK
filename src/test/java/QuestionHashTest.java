package triviasmack;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Object;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;


public class QuestionHashTest {
  @Test
  public void testGetQuestions(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    int hashSize = hash.questions.size();
    assertEquals(33, hashSize);
  }
  @Test
  public void testGetQuestionArray(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    int arraySize = hash.questionsAsArray.size();
    assertEquals(33, arraySize);
  }

  @Test
  public void testMapHashKeyToArray(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    int arraySize = hash.questionsAsArray.size();
    assertEquals(33, arraySize);
  }



  @Test
  public void testRandomQuestion(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    String question1 = hash.randomQuestion();
    String question2 = hash.randomQuestion();
    assertThat(question2, is(not(question1)));

  }
  @Test
  public void testGetAnswer(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    String result = hash.getAnswer("What is the capital of England?");
    assertEquals("London", result);

  }
  @Test
  public void testQuestionRemoved(){

    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    int array1 = hash.questionsAsArray.size();
    hash.randomQuestion();
    int array2 = hash.questionsAsArray.size();
    hash.randomQuestion();
    int array3 = hash.questionsAsArray.size();
    assertThat(array1, is(not(array3)));
  }

}
