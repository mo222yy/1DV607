package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class PlayerWinCondition implements IWinCondition {

	@Override
	public boolean winCondition(Dealer dealer, Player player, int maxScore) {
		if (dealer.CalcScore() > maxScore) {
		      return false;
		    } else if (player.CalcScore() > maxScore) {
		      return true;
		    }
		return !(dealer.CalcScore() <= player.CalcScore());
	}

}
