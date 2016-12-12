package triviasmack;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.*;

public class QuestionHash {

// public static void main(String args[]) {
//
//   HashMap<String, String> questions = new HashMap<String, String>();
//
//     questions.put("How old is Miquita Oliver?", "Thirty two");
//     questions.put("What is the capital of England?", "London");
//
//     }

  public String randomQuestion() {
    ArrayList<String> questionsAsArray = new ArrayList<String>();
    questionsAsArray.add("How old is Miquita Oliver?");
    questionsAsArray.add("What is the capital of England?");
    Random random = new Random();
    String selection = questionsAsArray.get(random.nextInt(questionsAsArray.size()));
    System.out.println(selection);
    return selection;
  };
//   <String>(map.keySet());
}
