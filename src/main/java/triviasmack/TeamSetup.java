package triviasmack;

public class TeamSetup {

 public String setupTeams(String teamOne, String teamTwo){
    String speech = "";
    if (teamOne.isEmpty()) {
      speech = "Game setup. What is the name of team one?";
    } else if (teamTwo.isEmpty()) {
      speech = "What is the name of team two?";
    } else {
      speech = "Game Setup Complete. Team one name is " + teamOne + ", team two name is " + teamTwo;
    }
    return speech;
  }

  public String defineUser(String currentTeamAttribute, String teamOneName, String teamTwoName){
    System.out.println("Check for teamOneName");
    System.out.println(teamOneName);
    System.out.println("Check for teamTwoName");
    System.out.println(teamTwoName);
      if (currentTeamAttribute == teamOneName) {
        currentTeamAttribute = teamTwoName;
      } else {
        currentTeamAttribute = teamOneName;
      }
      return currentTeamAttribute;
    }
}
