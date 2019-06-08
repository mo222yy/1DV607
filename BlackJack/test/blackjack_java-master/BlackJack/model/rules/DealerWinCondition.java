package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class DealerWinCondition implements IWinCondition {

	@Override
	public boolean winCondition(Dealer dealer, Player player, int maxScore) {
		if (player.CalcScore() > maxScore) {
		      return true;
		    } else if (dealer.CalcScore() > maxScore) {
		      return false;
		    }
		return dealer.CalcScore() >= player.CalcScore();
	}

}
