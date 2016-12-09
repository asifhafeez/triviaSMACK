package triviasmack;

import org.junit.Test;
import static org.junit.Assert.*;

public class TeamSetupTest {

  @Test
  public void setupIntroductionTest() {
    TeamSetup teamSetup = new TeamSetup();
    assertEquals(teamSetup.setupIntroduction(), "Game setup. What is the name of player one?");
  }

  


}