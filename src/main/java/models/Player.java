package models;

import java.util.Comparator;
import java.util.LinkedList;

public class Player
{
    private final String Name;
    private final LinkedList<Card> Hand;
    private final PlayerType Type;

    public Player(String Name, PlayerType Type)
    {
        this.Name = Name;
        this.Type = Type;
        this.Hand = new LinkedList<>();
    }

    public String getName()
    {
        return this.Name;
    }

    public int getHandScore()
    {
        return this.Hand.stream().mapToInt(i -> i.getValue()).sum();
    }

    public void addCardToHand(Card c)
    {
        this.Hand.add(c);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(this.Name + ": ");

        for (int i = 0; i < this.Hand.size(); i++)
        {
            sb.append(this.Hand.get(i).toString());

            if (this.Hand.size() > i + 1)
            {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    public PlayerType getType()
    {
        return Type;
    }

    public enum PlayerType
    {
        DEALER,
        REGULAR
    }
}


