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

  // @Test
  // public void testOnLaunch(){
  //   TriviaSmackSpeechlet tss = new TriviaSmackSpeechlet();
  //
  //   String result = tss.onLaunch(EdwRequestId.1e064922, 2);
  //
  //   assertEquals("Welcome to Trivia Smack, your gateway quiz", result);
  // }
}
