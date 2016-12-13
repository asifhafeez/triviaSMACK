package triviasmack;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.*;

public class QuestionHash {

HashMap<String, String> questions = new HashMap<String, String>();
ArrayList<String> questionsAsArray = new ArrayList<String>();
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
  public ArrayList getQuestionArray() {
    questionsAsArray.add("What won the oscar for best picture in ninteen ninety seven?");
    questionsAsArray.add("What is the capital of England?");
    questionsAsArray.add("What Castle housed Radio one's big weekend in two thousand and sixteen?");
    questionsAsArray.add("Which dee eye why brand was bought by the Focus Group in two thousand?");
    questionsAsArray.add("According to Bart Simpson, what do you not make with salad?");
    questionsAsArray.add("What is the pink sauce, often eaten with prawns");
    questionsAsArray.add("How many fingers am I holding up?");
    questionsAsArray.add("What person am I thinking of?");
    questionsAsArray.add("Which Ford played Indiana Jones and Han Solo");
    questionsAsArray.add("According to Justin Bieber, what might it be too late to say");
    questionsAsArray.add("What is Frankie Bell's favourite drink?");
    questionsAsArray.add("The duke of what was voted the fourteenth greatest Briton of all time?");
    questionsAsArray.add("In what year was Israel founded?");
    questionsAsArray.add("What is the collective noun for a group of owls?");
    questionsAsArray.add("What is the name of the only ay eye to have passed the Turing Test?");
    questionsAsArray.add("In ancient Greek mythology, what river did the souls of the dead have to cross?");
    questionsAsArray.add("Who wrote the Tale of Peter Rabbit?");
    questionsAsArray.add("What is the largest living species of bird that can fly?";
    questionsAsArray.add("Who painted the Birth of Venus?");
    questionsAsArray.add("Which of Henry the eighth’s wives gave birth to Edward the sixth?");
    questionsAsArray.add("What is the tallest mountain on the British Isles?");
    questionsAsArray.add("What is the collective noun for a group of flamingos?");
    questionsAsArray.add("What is the largest state in the yew ess ay?");
    questionsAsArray.add("In which country was the first FIFA World Cup held?");
    questionsAsArray.add("What is the world's only flightless parrot called?");
    questionsAsArray.add("How many bricks to the face does Marv take in Home Alone Two?");
    questionsAsArray.add("Which artist has spent the most number of weeks at number one in the UK music charts with the song I believe?");
    questionsAsArray.add("Who is widely credited as being the first ever computer programmer?");
    questionsAsArray.add("A score of three hundred and ninety two is the highest single word score ever recorded in an English scrabble championship, what is the word?");
    questionsAsArray.add("Which body of water is regarded as the worlds largest lake?", "Caspian Sea");
    questionsAsArray.add("Who ruled France for sixty seven years between eleven thirty seven and twelve oh four, the longest ruling female in history?");
    questionsAsArray.add("Who is Snoopees best friend?");
    questionsAsArray.add("Complete the lyric: Its true wherever you find love it feels like?");
    return questionsAsArray;
  }

  public String randomQuestion() {
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
