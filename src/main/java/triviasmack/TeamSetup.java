package triviasmack;

public class TeamSetup {

 public String setupTeams(String teamOne, String teamTwo){
    String speech = "";
    if (teamOne == null) {
      speech = "Game setup. What is the name of team one?";
    } else if (teamTwo == null) {
      speech = "What is the name of team two?";
    } else {
      speech = "Game Setup Complete. Team one name is " + teamOne + ", team two name is " + teamTwo;
    }
    return speech;
  }

}
