package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;


public class SoftSeventeenStrategy extends BasicHitStrategy{
    private final int g_hitLimit = 17;


    public boolean DoHit(Player a_dealer) {
        boolean hasSoftSeventeen=false;
        boolean hasAce=false;
        int score = 0;

        if(a_dealer.CalcScore() == 17){
            for (Card c: a_dealer.GetHand()) {
                if (c.GetValue() == Card.Value.Ace)
                    hasAce=true;
            }
        }


        if(hasAce){
            int cardScores[] = {
                    2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
            };
            assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

            for(Card c : a_dealer.GetHand()) {
                if (c.GetValue() != Card.Value.Hidden && c.GetValue() !=Card.Value.Ace) {
                    score += cardScores[c.GetValue().ordinal()];
                }
            }
        }

        if(score ==6){
            hasSoftSeventeen=true;
        }



        return a_dealer.CalcScore() < g_hitLimit || hasSoftSeventeen;
    }
}
