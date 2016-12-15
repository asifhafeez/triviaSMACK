package triviasmack;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.*;

public class QuestionHash {

  HashMap<String, String> questions = new HashMap<String, String>();
  ArrayList<String> questionsAsArray;
  String randomQuestion = "";

  public HashMap getQuestions(){
    questions.put("What won the oscar for best picture in ninteen ninety seven?", "Titanic");
    questions.put("What is the capital of England?", "London");
    questions.put("What Castle housed Radio one's big weekend in two thousand and sixteen?", "Powderham");
    questions.put("Which dee eye why brand was bought by the Focus Group in two thousand?", "Wicks");
    questions.put("According to Bart Simpson, what do you not make with salad?", "Friends");
    questions.put("What is the name of Henry the eighth's warship", "Mary Rose");
    questions.put("How many fingers am I holding up?", "Seven");
    questions.put("What person am I thinking of?", "Frankie");
    questions.put("Which Ford played Indiana Jones and Han Solo", "Harrison");
    questions.put("According to Justin Bieber, what might it be too late to say?", "Sorry");
    questions.put("What is Frankie Bell's favourite drink?", "Sambuka");
    questions.put("The duke of what was voted the fourteenth greatest Briton of all time?", "Wellington");
    questions.put("In which country was the first FIFA World Cup held?", "Uruguay");
    questions.put("What is the world's only flightless parrot called?", "Kakapo");
    questions.put("How many bricks to the face does Marv take in Home Alone Two?", "Four");
    questions.put("Which artist has spent the most number of weeks at number one in the UK music charts with the song I believe?", "Frankie Laine");
    questions.put("Who is widely credited as being the first ever computer programmer?", "Ada Lovelace");
    questions.put("A score of three hundred and ninety two is the highest single word score ever recorded in an English scrabble championship, what is the word?", "Caziques");
    questions.put("Which body of water is regarded as the worlds largest lake?", "Caspian Sea");
    questions.put("Who ruled France for sixty seven years between eleven thirty seven and twelve oh four, the longest ruling female in history?", "Eleanor of Aquitaine");
    questions.put("Who is Snoopees best friend?", "Woodstock");
    questions.put("Complete the lyric: Its true wherever you find love it feels like?", "Christmas");
    questions.put("In what year was Israel founded?", "nineteen forty eight");
    questions.put("What is the collective noun for a group of owls?", "Parliament");
    questions.put("What is the name of the only ay eye to have passed the Turing Test?", "Eugene Goostman");
    questions.put("In ancient Greek mythology, what river did the souls of the dead have to cross?", "Styx");
    questions.put("Who wrote the Tale of Peter Rabbit?", "Beatrix Potter");
    questions.put("What is the largest living species of bird that can fly?", "Albatross");
    questions.put("Who painted the Birth of Venus?", "Botticelli");
    questions.put("Which of Henry the eighth’s wives gave birth to Edward the sixth?", "Jane Seymour");
    questions.put("What is the tallest mountain on the British Isles?", "Ben Nevis");
    questions.put("What is the collective noun for a group of flamingos?", "Flamboyance");
    questions.put("What is the largest state in the yew ess ay?", "Alaska");
    questionsAsArray = getQuestionArray();
    return questions;
  }

  public ArrayList getQuestionArray() {
    ArrayList<String> questionArray = new ArrayList<String>(questions.keySet());
    return questionArray;
  }


  public String randomQuestion() {
    Random random = new Random();
    int questionNumber = random.nextInt(questionsAsArray.size());
    randomQuestion = questionsAsArray.get(questionNumber);
    questionsAsArray.remove(questionNumber);
    return randomQuestion;
  }

  public String getAnswer(final String randomQuestion){
    return questions.get(randomQuestion);
  }
}
