package models;

import java.util.LinkedList;
import java.util.Queue;

public class DeckOfCards
{
    private final Queue<Card> cardDeck;

    public DeckOfCards(LinkedList<Card> cardDeck)
    {
        if (cardDeck.size() > 52)
        {
            throw new IllegalArgumentException(String.format("A card deck should have 52 cards, the supplied one had %s", cardDeck.size()));
        }

        this.cardDeck = cardDeck;
    }

    public Card DrawCard()
    {
        if (this.cardDeck.size() == 0)
        {
            throw new IndexOutOfBoundsException("No more cards left in deck");
        }

        return this.cardDeck.remove();
    }

    public int GetNumberOfCardsLeft()
    {
        return this.cardDeck.size();
    }
}