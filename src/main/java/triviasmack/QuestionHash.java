package triviasmack;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.*;

public class QuestionHash {

HashMap<String, String> questions = new HashMap<String, String>();
String randomQuestion = "";

// public static void main(String args[]) {
//     }
  //
  public HashMap getQuestions(){
     questions.put("How old is Miquita Oliver?", "Thirty two");
     questions.put("What is the capital of England?", "London");
     return questions;
  }


  public String randomQuestion() {
    ArrayList<String> questionsAsArray = new ArrayList<String>();
    questionsAsArray.add("How old is Miquita Oliver?");
    questionsAsArray.add("What is the capital of England?");
    Random random = new Random();
    randomQuestion = questionsAsArray.get(random.nextInt(questionsAsArray.size()));
    return randomQuestion;
  };

  public String getAnswer(final String randomQuestion){
    getQuestions();
    String answer = questions.get(randomQuestion);
    return answer;
  }


}
