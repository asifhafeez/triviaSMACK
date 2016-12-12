package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;


public class QuestionHashTest {

  @Test
  public void testRandomQuestion(){
    QuestionHash hash = new QuestionHash();
    String question = hash.randomQuestion();
    assertEquals("What is the capital of England?", question);

  }
  @Test
  public void testGetAnswer(){
    QuestionHash hash = new QuestionHash();
    hash.getQuestions();
    hash.randomQuestion();
    String result = hash.getAnswer("What is the capital of England?");
    assertEquals("London", result);

  }
}
