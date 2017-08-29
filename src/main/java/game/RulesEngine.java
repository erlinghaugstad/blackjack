package game;

import models.Player;

public class RulesEngine
{
    public static boolean GameIsOver(Player player, Player dealer)
    {
        return player.getHandScore() >= 21 || dealer.getHandScore() >= 21;
    }

    public static boolean PlayerShouldDrawAnotherCard(Player player)
    {
        return player.getHandScore() < 17;
    }

    public static boolean DealerGameIsOver(Player dealer, Player player)
    {
        if (dealer.getHandScore() > 21)
        {
            return true;
        }

        if (dealer.getHandScore() > player.getHandScore())
        {
            return true;
        }

        return false;
    }

    public static Player DetermineWinningPlayer(Player player, Player dealer)
    {
        Player winningPlayer;
        if (playerHasAbove21(player) || PlayerIsBelowDealer(player, dealer))
        {
            winningPlayer = dealer;
        }
        else
        {
            winningPlayer = player;
        }

        return winningPlayer;
    }

    private static boolean playerHasAbove21(Player player)
    {
        return player.getHandScore() > 21;
    }

    private static boolean PlayerIsBelowDealer(Player player, Player dealer)
    {
        return dealer.getHandScore() <= 21 && player.getHandScore() < dealer.getHandScore();
    }
}
