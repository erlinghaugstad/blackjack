package game;

import interfaces.IFileReader;
import interfaces.ILogger;
import models.Card;
import models.DeckOfCards;

import java.util.LinkedList;

import static java.util.Collections.shuffle;

public class DeckFactory
{
    public static final String RANDOM_DECK = ", returning random deck for this session.";

    public static DeckOfCards CreateRandomDeck()
    {
        LinkedList<Card> cards = new LinkedList<>();
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                cards.add(new Card(rank, suit));

        shuffle(cards);
        return new DeckOfCards(cards);
    }

    public static DeckOfCards CreateFromFileInput(String path, ILogger logger, IFileReader fileReader)
    {
        String deckString = fileReader.ReadDeckFile(path);

        if (deckString == null || deckString.length() == 0)
        {
            return HandleIllegalInput("Illegal deck file supplied, file was empty", logger);
        }

        String[] splittedDeckString = deckString.split(",");

        LinkedList<Card> cards = new LinkedList<>();
        for (String card : splittedDeckString)
        {
            card = card.trim();
            if (card.length() != 2)
            {
                //From the requirements, allow a deck to be specified without having 52 cards.
                if(cards.size() > 0)
                {
                    break;
                }

                return HandleIllegalInput("Card definition is not legal " + card, logger);
            }

            cards.add(new Card(GetRank(card.substring(1)), GetSuit(card.substring(0, 1))));
        }

        return new DeckOfCards(cards);
    }

    private static Card.Rank GetRank(String c)
    {
        for (Card.Rank rank : Card.Rank.values())
        {
            if (rank.toString().equals(c))
            {
                return rank;
            }
        }

        throw new IllegalArgumentException(c + " is not a valid rank definition");
    }

    private static Card.Suit GetSuit(String c)
    {
        for (Card.Suit suit : Card.Suit.values())
        {
            if (suit.toString().equals(c))
            {
                return suit;
            }
        }

        throw new IllegalArgumentException(c + " is not a valid suit definition");
    }

    private static DeckOfCards HandleIllegalInput(String errorMessage, ILogger logger)
    {
        logger.Log(errorMessage + RANDOM_DECK);
        return DeckFactory.CreateRandomDeck();
    }
}
