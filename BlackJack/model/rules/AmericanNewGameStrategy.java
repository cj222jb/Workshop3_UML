package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    player(true, a_deck, a_player);
    dealer(true, a_deck, a_dealer);
    player(true, a_deck, a_player);
    dealer(false, a_deck, a_dealer);

    return true;
  }

  public void player(boolean status, Deck a_deck, Player a_player){
    Card c;
    c = a_deck.GetCard();
    c.Show(status);
    a_player.DealCard(c);
  }

  public void dealer(boolean status, Deck a_deck, Dealer a_dealer){
    Card c;
    c = a_deck.GetCard();
    c.Show(status);
    a_dealer.DealCard(c);
  }
}