package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinCondition m_winRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinCondition();

  }
  
  public void Stand() {
	  if (m_deck != null) {
		  ShowHand();
		  while (m_hitRule.DoHit(this)) {
			  dealCard(this, true);
		  }
	  }
  }
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      dealCard(a_player, true);
      
      return true;
    }
    return false;
  }
  
  public void dealCard (Player a_player, boolean b) {
	  Card c;
	  c = m_deck.GetCard();
	  c.Show(b);
	  a_player.DealCard(c);
  }

  public boolean IsDealerWinner(Player a_player) {
	  return m_winRule.winCondition(this, a_player, g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
}