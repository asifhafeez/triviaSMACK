package triviasmack;

public class TeamSetup {

  public String setupTeams(String teamOne, String teamTwo){
    String speech = "";
    if (teamOne.isEmpty()) {
      speech = "Game setup. You can choose either pandas, chickens, dolphins, or Asif for your team name. What is the name of team one?";
    } else if (teamTwo.isEmpty()) {
      speech = "What is the name of team two?";
    } else {
      speech = "Game Setup Complete. Team one name is " + teamOne.toString() + ", team two name is " + teamTwo.toString() + ". Please say start quiz to begin.";
    }
    return speech;
  }

  public String defineUser(String currentTeamAttribute, String teamOneName, String teamTwoName){
    if (currentTeamAttribute == teamOneName) {
      currentTeamAttribute = teamTwoName;
    } else {
      currentTeamAttribute = teamOneName;
    }
    return currentTeamAttribute;
  }
}
