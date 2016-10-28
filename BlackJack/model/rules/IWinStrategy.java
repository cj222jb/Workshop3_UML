package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

/**
 * Created by carl on 2016-10-27.
 */
public interface IWinStrategy {
    boolean WinRule(Dealer a_dealer, Player a_player);
}
