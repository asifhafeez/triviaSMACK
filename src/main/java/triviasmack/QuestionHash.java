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
     questions.put("What won the oscar for best picture in ninteen ninety seven?", "Titanic");
     questions.put("What is the capital of England?", "London");
     questions.put("What Castle housed Radio one's big weekend in two thousand and sixteen?", "Powderham");
     questions.put("Which dee eye why brand was bought by the Focus Group in two thousand?", "Wicks");
     questions.put("According to Bart Simpson, what do you not make with salad?", "Friends");
     questions.put("What is the name of Henry the eighth's warship", "MaryRose");
     questions.put("How many fingers am I holding up?", "Seven");
     questions.put("What person am I thinking of?", "Frankie");
     questions.put("Which Ford played Indiana Jones and Han Solo", "Harrison");
     questions.put("According to Justin Bieber, what might it be too late to say?", "Sorry");
     questions.put("What is Frankie Bell's favourite drink?", "Sambuka");
     questions.put("The duke of what was voted the fourteenth greatest Briton of all time?", "Wellington");


     return questions;
  }


  public String randomQuestion() {
    ArrayList<String> questionsAsArray = new ArrayList<String>();
    questionsAsArray.add("What won the oscar for best picture in ninteen ninety seven?");
    questionsAsArray.add("What is the capital of England?");
    questionsAsArray.add("WWhat Castle housed Radio one's big weekend in two thousand and sixteen?");
    questionsAsArray.add("Which dee eye why brand was bought by the Focus Group in two thousand?");
    questionsAsArray.add("According to Bart Simpson, what do you not make with salad?");
    questionsAsArray.add("What is the pink sauce, often eaten with prawns");
    questionsAsArray.add("How many fingers am I holding up?");
    questionsAsArray.add("What person am I thinking of?");
    questionsAsArray.add("Which Ford played Indiana Jones and Han Solo");
    questionsAsArray.add("According to Justin Bieber, what might it be too late to say");
    questionsAsArray.add("What is Frankie Bell's favourite drink?");
    questionsAsArray.add("The duke of what was voted the fourteenth greatest Briton of all time?");

    Random random = new Random();
    int questionNumber = random.nextInt(questionsAsArray.size());
    randomQuestion = questionsAsArray.get(questionNumber);
    questionsAsArray.remove(questionNumber);
    return randomQuestion;
  };

  public String getAnswer(final String randomQuestion){
    getQuestions();
    String answer = questions.get(randomQuestion);
    return answer;
  }


}
