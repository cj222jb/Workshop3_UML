package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy extends AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {


    player(true, a_deck, a_player);
    dealer(true, a_deck, a_dealer);
    player(true, a_deck, a_player);

    return true;
  }
}