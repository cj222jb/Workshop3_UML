package BlackJack.model.rules;


import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class AdvantagePlayerStrategy implements IWinStrategy{

    public boolean WinRule(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > 21) {
            return true;
        } else if (a_dealer.CalcScore() > 21) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}
