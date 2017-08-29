package models;

public class Card
{
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank()
    {
        return this.rank;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public int getValue()
    {
        return this.rank.getValue();
    }

    @Override
    public String toString()
    {
        return this.suit.toString() + this.rank.toString();
    }

    public enum Suit
    {
        CLUBS("C"),
        HEARTS("H"),
        DIAMONDS("D"),
        SPADES("S");

        private final String abbrev;

        Suit(final String abbrev)
        {
            this.abbrev = abbrev;
        }

        @Override
        public String toString()
        {
            return this.abbrev;
        }
    }

    public enum Rank
    {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10, "J"),
        QUEEN(10, "Q"),
        KING(10, "K"),
        ACE(11, "A");

        private final int value;
        private final String abbrev;

        Rank(final int newValue, final String abbrev)
        {
            this.value = newValue;
            this.abbrev = abbrev;
        }

        Rank(final int newValue)
        {
            this.value = newValue;
            this.abbrev = Integer.toString(newValue);
        }

        public int getValue()
        {
            return this.value;
        }

        @Override
        public String toString()
        {
            return this.abbrev;
        }
    }
}