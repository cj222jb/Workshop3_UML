package BlackJack.model.rules;

import BlackJack.model.Player;

class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        if(a_dealer.hasSoftSeventeen()){
            System.out.println("trueueueue");
        }
      return a_dealer.CalcScore() < g_hitLimit || a_dealer.hasSoftSeventeen();
    }
}