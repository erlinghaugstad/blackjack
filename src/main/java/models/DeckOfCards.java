package models;

import java.util.LinkedList;
import java.util.Queue;

public class DeckOfCards
{
    private final Queue<Card> CardDeck;

    public DeckOfCards(LinkedList<Card> CardDeck)
    {
        if (CardDeck.size() > 52)
        {
            throw new IllegalArgumentException(String.format("A card deck should have 52 cards, the supplied one had %s", CardDeck.size()));
        }

        this.CardDeck = CardDeck;
    }

    public Card DrawCard()
    {
        if (this.CardDeck.size() == 0)
        {
            throw new IndexOutOfBoundsException("No more cards left in deck");
        }

        return this.CardDeck.remove();
    }

    public int GetNumberOfCardsLeft()
    {
        return this.CardDeck.size();
    }
}