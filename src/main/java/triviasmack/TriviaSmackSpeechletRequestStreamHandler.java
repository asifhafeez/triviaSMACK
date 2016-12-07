
package triviasmack;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;


public final class TriviaSmackSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds = new HashSet<String>();
    static {
   
        supportedApplicationIds.add("amzn1.ask.skill.0aa0bdbf-5ca7-47d0-bfee-0ebd9b23a411");
    }

    public TriviaSmackSpeechletRequestStreamHandler() {
        super(new TriviaSmackSpeechlet(), supportedApplicationIds);
    }
}
