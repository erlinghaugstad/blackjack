import models.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTests
{
    @Test
    public void CardRank_ClubsAceTest_ShouldReturnCA()
    {
        Card c = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        assertEquals(Card.Rank.ACE, c.getRank());
        assertEquals(Card.Suit.CLUBS, c.getSuit());
        assertEquals(11, c.getValue());
        assertEquals("CA", c.toString());
    }

    @Test
    public void CardRank_HeartsSixTest_ShouldReturnH6()
    {
        Card c = new Card(Card.Rank.SIX, Card.Suit.HEARTS);
        assertEquals(Card.Rank.SIX, c.getRank());
        assertEquals(Card.Suit.HEARTS, c.getSuit());
        assertEquals(6, c.getValue());
        assertEquals("H6", c.toString());
    }
}
