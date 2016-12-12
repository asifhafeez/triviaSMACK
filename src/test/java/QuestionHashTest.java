package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;


public class QuestionHashTest {

  @Test
  public void testRandomQuestion(){
    QuestionHash hash = new QuestionHash();
    String answer = hash.randomQuestion();
    assertEquals("What is the capital of England?", answer);

  }
}
