package BlackJack.model.rules;

import BlackJack.model.Player;


public class SoftSeventeenStrategy extends BasicHitStrategy{
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {

        return a_dealer.CalcScore() < g_hitLimit || a_dealer.hasSoftSeventeen();
    }
}
