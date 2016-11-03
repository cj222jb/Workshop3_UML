package BlackJack.controller;

import BlackJack.model.Observer;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements Observer{
  private IView a_view;
  private Game a_game;


  public PlayGame(Game a_game, IView a_view) {
    this.a_game = a_game;
    this.a_view = a_view;
    a_game.addObserver(this);
  }
  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();

    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver()) {
      a_view.DisplayGameOver(a_game.IsDealerWinner());
    }
    return a_view.UserChoice(a_game);
  }

  @Override
  public void dealCard(boolean isDealer) {
    if(isDealer) {
      a_view.DisplayWelcomeMessage();
      a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
      a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    }
    try {
      Thread.sleep(2200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}