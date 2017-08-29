import models.Card;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTests extends TestBase
{
    @Test
    public void GetHandScore_EmptyHand_ShouldReturnZero()
    {
        int handScore = regularPlayer.getHandScore();
        Assert.assertEquals(0, handScore);
    }

    @Test
    public void GetHandScore_SingleCardInHand_ShouldReturnValueOfCard()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        int handScore = regularPlayer.getHandScore();
        Assert.assertEquals(5, handScore);
    }

    @Test
    public void GetHandScore_TwoCardsInHand_ShouldReturnSumOfCards()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        int handScore = regularPlayer.getHandScore();
        Assert.assertEquals(16, handScore);
    }

    @Test
    public void GetHandScore_DealerTwoCardsInHand_ShouldReturnSumOfCardsSameAsRegular()
    {
        dealerPlayer.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        int handScore = dealerPlayer.getHandScore();
        Assert.assertEquals(16, handScore);
    }

    @Test
    public void PlayerToString_EmptyHand_ShouldReturnPlayerName()
    {
        Assert.assertEquals(regularPlayer.toString(), "testPlayer: ");
    }

    @Test
    public void PlayerToString_ThreeCardsInHand_ShouldReturnHandAsString()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        regularPlayer.addCardToHand(new Card(Card.Rank.SIX, Card.Suit.HEARTS));
        Assert.assertEquals("testPlayer: D10, H6", regularPlayer.toString());
    }
}
