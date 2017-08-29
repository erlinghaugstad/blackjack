import game.DeckFactory;
import game.Game;
import interfaces.IFileReader;
import interfaces.ILogger;
import models.DeckOfCards;
import models.Player;
import org.junit.Assert;
import org.junit.Test;

public class GameTets extends TestBase
{
    @Test
    public void Game_PredefinedDeck_playerShouldWin()
    {
        String cardsDef = "CA, D5, H9, HQ, S8,";
        ILogger logger = new TestLogger();
        IFileReader reader = new TestFileReader(cardsDef);
        DeckOfCards deck = DeckFactory.CreateFromFileInput("random.txt", logger, reader);
        Game g = new Game(logger);
        g.StartGame(deck, regularPlayer, dealerPlayer);

        Assert.assertEquals(String.format("%s\r\n%s: CA, H9\r\n%s: D5, HQ, S8\r\n", regularPlayer.getName(), regularPlayer.getName(), dealerPlayer.getName()), logger.toString());
    }

    @Test
    public void Game_10000RandomTests_PlayerWithHighestScoreShouldWin()
    {
        for(int i = 0; i < 10000; i++)
        {
            //Reinitialize players to make sure hand is empty
            this.setUp();

            ILogger logger = new TestLogger();
            DeckOfCards deck = DeckFactory.CreateRandomDeck();
            Game g = new Game(logger);
            g.StartGame(deck, regularPlayer, dealerPlayer);

            if(regularPlayer.getHandScore() > 21 || (regularPlayer.getHandScore() < dealerPlayer.getHandScore() && dealerPlayer.getHandScore() < 22))
            {
                AssertPlayerWins(logger, dealerPlayer);
            }
            else
            {
                AssertPlayerWins(logger, regularPlayer);
            }
        }
    }

    private void AssertPlayerWins(ILogger logger, Player winner)
    {
        Assert.assertEquals(String.format("%s\r\n%s\r\n%s\r\n", winner.getName(), regularPlayer.toString(), dealerPlayer.toString()), logger.toString());
    }
}
