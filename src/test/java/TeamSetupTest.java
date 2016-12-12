package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;

public class TeamSetupTest {

  @Test
  public void teamOneNameTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("Game setup. What is the name of team one?", teamSetup.setupTeams("", ""));
  }

  @Test
  public void teamTwoNameTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("What is the name of team two?", teamSetup.setupTeams("pandas", ""));
  }

  @Test
  public void bothTeamsSetupTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals("Game Setup Complete. Team one name is pandas, team two name is dolphins", teamSetup.setupTeams("pandas", "dolphins"));
  }
}
