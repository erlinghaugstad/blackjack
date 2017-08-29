package game;

import interfaces.ILogger;
import models.DeckOfCards;
import models.Player;

import java.util.Arrays;
import java.util.List;

public class Game
{
    private static final int NR_OF_INITIAL_CARDS = 2;

    private final ILogger logger;
    private DeckOfCards deck;

    public Game(ILogger logger)
    {
        this.logger = logger;
    }

    public void StartGame(DeckOfCards deck, Player player, Player dealer)
    {
        this.deck = deck;
        InitializePlayerHands(player, dealer);

        // A player initially got >= 21
        if (RulesEngine.GameIsOver(player, dealer))
        {
            HandleGameOver(player, dealer);
            return;
        }

        // Draw cards for regular plauyers
        while (RulesEngine.PlayerShouldDrawAnotherCard(player))
        {
            player.addCardToHand(this.deck.DrawCard());
        }

        // Draw cards for dealer
        while (!RulesEngine.DealerGameIsOver(dealer, player))
        {
            dealer.addCardToHand(this.deck.DrawCard());
        }

        HandleGameOver(player, dealer);
    }

    private void HandleGameOver(Player player, Player dealer)
    {
        Player winningPlayer = RulesEngine.DetermineWinningPlayer(player, dealer);

        logger.Log(winningPlayer.getName());
        logger.Log(player.toString());
        logger.Log(dealer.toString());
    }

    private void InitializePlayerHands(Player player, Player dealer)
    {
        DrawCardForPlayers(Arrays.asList(player, dealer), NR_OF_INITIAL_CARDS);
    }

    private void DrawCardForPlayers(List<Player> players, int nrCards)
    {
        for (int i = 0; i < nrCards; i++)
        {
            for (Player p : players)
            {
                p.addCardToHand(this.deck.DrawCard());
            }
        }
    }
}
