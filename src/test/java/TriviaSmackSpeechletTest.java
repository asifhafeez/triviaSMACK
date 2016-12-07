package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;


public class TriviaSmackSpeechletTest {

  @Test
  public void testConcatenate(){
    TriviaSmackSpeechlet tss = new TriviaSmackSpeechlet();

    String result = tss.concatenate("one", "two");

    assertEquals("onetwo", result);
  }
}
