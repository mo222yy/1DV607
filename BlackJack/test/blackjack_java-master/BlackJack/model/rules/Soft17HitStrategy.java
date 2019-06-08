package BlackJack.model.rules;


import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;
	private boolean has_ace = false;
	@Override
	public boolean DoHit(Player a_dealer) {
		has_ace = false;
		int otherCardScore = 0;
		if (a_dealer.CalcScore() == g_hitLimit) {
			Iterable<Card> hand = a_dealer.GetHand();
			for (Card c : hand) {
				if (has_ace && c.GetValue() == Card.Value.Ace) {
					otherCardScore += 1;
				}
				if (c.GetValue() == Card.Value.Ace) {
					has_ace = true;
				}
				if(c.GetValue() != Card.Value.Ace) {
					otherCardScore += a_dealer.getCardIntValue(c);
				}
			}
			if(has_ace && otherCardScore == 6) {
				return true;
			} else {
				return false;
			}
		}
		return a_dealer.CalcScore() < g_hitLimit;
	}

}
