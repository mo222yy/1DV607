package BlackJack.model;

import java.util.List;
import java.util.Observable;
import java.util.LinkedList;

public class Player extends Observable{

  private List<Card> m_hand;
  protected final int g_maxScore = 21;
  private Observer observer;

  public Player()
  {
    m_hand = new LinkedList<Card>();
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
    notifyObservers();
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear();
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand)
    {
      c.Show(true);
    }
    this.notifyObservers();
  }
  
  public int CalcScore()
  {
    int score = 0;
    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
        	score += getCardIntValue(c);
        }
    }
    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  public int getCardIntValue (Card c) {
	   int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
    
    return cardScores[c.GetValue().ordinal()];
  }
  public void notifyObservers() {
	  this.observer.update();
  }
  public void setObserver(Observer o){
	  this.observer = o;
  }
}