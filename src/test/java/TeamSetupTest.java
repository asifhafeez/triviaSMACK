package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;

public class TeamSetupTest {

  @Test
  public void teamOneNameTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("Game setup. You can choose either pandas, chickens, dolphins, or Asif for your team name. What is the name of team one?", teamSetup.setupTeams("", ""));
  }

  @Test
  public void teamTwoNameTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("What is the name of team two?", teamSetup.setupTeams("pandas", ""));
  }

  @Test
  public void bothTeamsSetupTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("Game Setup Complete. Team one name is pandas, team two name is dolphins. Please say start quiz to begin.", teamSetup.setupTeams("pandas", "dolphins"));
  }
}
