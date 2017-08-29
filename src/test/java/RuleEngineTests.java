import game.RulesEngine;
import models.Card;
import org.junit.Assert;
import org.junit.Test;

public class RuleEngineTests extends TestBase
{
    @Test
    public void PlayerGameIsOver_OnePlayerBelow21_ShouldReturnFalse()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        boolean gameIsOver = RulesEngine.GameIsOver(regularPlayer, dealerPlayer);
        Assert.assertEquals(false, gameIsOver);
    }

    @Test
    public void PlayerGameIsOver_OnePlayerAt21_ShouldReturnTrue()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));

        boolean gameIsOver = RulesEngine.GameIsOver(regularPlayer, dealerPlayer);
        Assert.assertEquals(true, gameIsOver);
    }

    @Test
    public void PlayerGameIsOver_PlayerAt22_ShouldReturnTrue()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));

        boolean gameIsOver = RulesEngine.GameIsOver(regularPlayer, dealerPlayer);
        Assert.assertEquals(true, gameIsOver);
    }

    @Test
    public void PlayerGameIsOver_DealerAt22_ShouldReturnTrue()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));

        dealerPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));

        boolean gameIsOver = RulesEngine.GameIsOver(regularPlayer, dealerPlayer);
        Assert.assertEquals(true, gameIsOver);
    }

    @Test
    public void PlayerShouldDrawAnotherCard_ZeroCards_ShouldReturnTrue()
    {
        Assert.assertEquals(true, RulesEngine.PlayerShouldDrawAnotherCard(regularPlayer));
    }

    @Test
    public void PlayerShouldDrawAnotherCard_OneCardBelow_ShouldReturnTrue()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        Assert.assertEquals(true, RulesEngine.PlayerShouldDrawAnotherCard(regularPlayer));
    }

    @Test
    public void PlayerShouldDrawAnotherCard_Above17_ShouldReturnFalse()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.SPADES));
        Assert.assertEquals(false, RulesEngine.PlayerShouldDrawAnotherCard(regularPlayer));
    }

    @Test
    public void DealerGameIsOver_HasZeroCards_PlayerHas1_ShouldReturnFalse()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        Assert.assertEquals(false, RulesEngine.DealerGameIsOver(dealerPlayer, regularPlayer));
    }

    @Test
    public void DealerGameIsOver_HasEqualToPlayer_ShouldReturnFalse()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.HEARTS));
        Assert.assertEquals(false, RulesEngine.DealerGameIsOver(dealerPlayer, regularPlayer));
    }

    @Test
    public void DealerGameIsOver_HasAbovePlayer_ShouldReturnTrue()
    {
        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        Assert.assertEquals(true, RulesEngine.DealerGameIsOver(dealerPlayer, regularPlayer));
    }

    @Test
    public void DetermineWinningPlayer_BothHaveAbove22_ShouldReturnDealer()
    {
        dealerPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));

        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));

        Assert.assertEquals(dealerPlayer.getName(), RulesEngine.DetermineWinningPlayer(regularPlayer, dealerPlayer).getName());
    }

    @Test
    public void DetermineWinningPlayer_DealerHas21_PlayerHas21_ShouldReturnPlayer()
    {
        dealerPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TWO, Card.Suit.SPADES));

        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.FOUR, Card.Suit.CLUBS));

        Assert.assertEquals(regularPlayer.getName(), RulesEngine.DetermineWinningPlayer(regularPlayer, dealerPlayer).getName());
    }

    @Test
    public void DetermineWinningPlayer_DealerHas21_PlayerHas17_ShouldReturnDealer()
    {
        dealerPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TWO, Card.Suit.SPADES));

        regularPlayer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.CLUBS));

        Assert.assertEquals(dealerPlayer.getName(), RulesEngine.DetermineWinningPlayer(regularPlayer, dealerPlayer).getName());
    }

    @Test
    public void DetermineWinningPlayer_DealerHas20_PlayerHas21_ShouldReturnDealer()
    {
        dealerPlayer.addCardToHand(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        dealerPlayer.addCardToHand(new Card(Card.Rank.TWO, Card.Suit.SPADES));

        regularPlayer.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.CLUBS));
        regularPlayer.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.HEARTS));

        Assert.assertEquals(regularPlayer.getName(), RulesEngine.DetermineWinningPlayer(regularPlayer, dealerPlayer).getName());
    }
}
