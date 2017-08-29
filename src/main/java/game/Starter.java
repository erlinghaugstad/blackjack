package game;

import interfaces.IFileReader;
import interfaces.ILogger;
import models.DeckOfCards;
import models.Player;

public class Starter
{
    public static void main(String[] args)
    {
        ILogger logger = new Logger();
        IFileReader reader = new DeckFileReader();

        Game g = new Game(logger);
        DeckOfCards deck;

        if (args.length > 0)
        {
            deck = DeckFactory.CreateFromFileInput(args[0], logger, reader);
        }
        else
        {
            deck = DeckFactory.CreateRandomDeck();
        }

        Player player = new Player("sam", Player.PlayerType.REGULAR);
        Player dealer = new Player("dealer", Player.PlayerType.DEALER);

        g.StartGame(deck, player, dealer);
    }
}
