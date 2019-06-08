package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinCondition {
	boolean winCondition(Dealer dealer, Player player, int maxScore);
}
