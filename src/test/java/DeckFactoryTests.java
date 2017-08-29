import game.DeckFactory;
import interfaces.IFileReader;
import interfaces.ILogger;
import models.DeckOfCards;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static game.DeckFactory.RANDOM_DECK;

public class DeckFactoryTests
{
    ILogger testLogger;

    @Before
    public void setUp()
    {
        testLogger = new TestLogger();
    }

    @Test
    public void CreateRandomDeck_ShouldReturnANewRandomDeck()
    {
        DeckOfCards deck = DeckFactory.CreateRandomDeck();
        Assert.assertEquals(52, deck.GetNumberOfCardsLeft());
    }

    @Test
    public void CreateFromFileInput_EmptyInput_ShouldReturnANewRandomDeck()
    {
        IFileReader reader = new TestFileReader("");
        ILogger logger = new TestLogger();
        DeckOfCards deck = DeckFactory.CreateFromFileInput("random.txt", logger, reader);
        Assert.assertEquals(52, deck.GetNumberOfCardsLeft());
        Assert.assertEquals(String.format("Illegal deck file supplied, file was empty%s\r\n", RANDOM_DECK), logger.toString());
    }

    @Test
    public void CreateFromFileInput_IllegalInput_ShouldReturnANewRandomDeck()
    {
        String cardDef = "CXXSAD";
        IFileReader reader = new TestFileReader(cardDef);
        ILogger logger = new TestLogger();
        DeckOfCards deck = DeckFactory.CreateFromFileInput("random.txt", logger, reader);
        Assert.assertEquals(52, deck.GetNumberOfCardsLeft());
        Assert.assertEquals(String.format("Card definition is not legal %s%s\r\n", cardDef, RANDOM_DECK), logger.toString());
    }

    @Test
    public void CreateFromFileInput_LegalButShortInput_ShouldReturnShortDeck()
    {
        String cardsDef = "CA, D5, H9, HQ, S8,";
        IFileReader reader = new TestFileReader(cardsDef);
        ILogger logger = new TestLogger();
        DeckOfCards deck = DeckFactory.CreateFromFileInput("random.txt", logger, reader);
        Assert.assertEquals(String.format(""), logger.toString());
        Assert.assertEquals(5, deck.GetNumberOfCardsLeft());

        StringBuilder builder = new StringBuilder();
        while (deck.GetNumberOfCardsLeft() > 0)
        {
            builder.append(deck.DrawCard() + ",");

            if (deck.GetNumberOfCardsLeft() != 0)
            {
                builder.append(" ");
            }
        }
        Assert.assertEquals(cardsDef, builder.toString());
    }
}
