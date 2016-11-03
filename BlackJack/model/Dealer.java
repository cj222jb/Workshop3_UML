package BlackJack.model;

import BlackJack.model.rules.*;

import java.util.ArrayList;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;
  private ArrayList<Observer> m_observers;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.WinRule();
    m_observers = new ArrayList<Observer>();
  }

  public void addObserver(Observer a_observer){
    m_observers.add(a_observer);
  }

  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public void getShowDeal(Player a_player){
    boolean isDealer = false;
    boolean isPlayer= false;
    Card c = m_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);
    if(a_player == this){
      isDealer = true;
    }
      for(Observer observer : m_observers){
        observer.dealCard(isDealer);
      }
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      getShowDeal(a_player);
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {

    return m_winRule.WinRule(this,a_player);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public boolean Stand(){
    if(m_deck != null){
      ShowHand();
      while(m_hitRule.DoHit(this)){
        getShowDeal(this);
      }
      return true;
    }
    return false;
  }
}