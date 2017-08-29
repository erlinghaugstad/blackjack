package models;

import java.util.LinkedList;

public class Player
{
    private final String name;
    private final LinkedList<Card> hand;
    private final PlayerType type;

    public Player(String name, PlayerType type)
    {
        this.name = name;
        this.type = type;
        this.hand = new LinkedList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getHandScore()
    {
        return this.hand.stream().mapToInt(i -> i.getValue()).sum();
    }

    public void addCardToHand(Card c)
    {
        this.hand.add(c);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(this.name + ": ");

        for (int i = 0; i < this.hand.size(); i++)
        {
            sb.append(this.hand.get(i).toString());

            if (this.hand.size() > i + 1)
            {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public PlayerType getType()
    {
        return type;
    }

    public enum PlayerType
    {
        DEALER,
        REGULAR
    }
}


