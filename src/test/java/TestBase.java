import models.Player;
import org.junit.Before;

public abstract class TestBase
{
    protected Player regularPlayer;
    protected Player dealerPlayer;

    @Before
    public void setUp()
    {
        regularPlayer = new Player("testPlayer", Player.PlayerType.REGULAR);
        dealerPlayer = new Player("testDealer", Player.PlayerType.DEALER);
    }

}
