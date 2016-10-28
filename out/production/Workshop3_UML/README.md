# blackjack_java

Fork this code to work with java in workshop 3. This repo only contains java files.


Changes we made :

In stand method in class "Game" we instead return m_dealer.Stand();

In dealer we implemented the method Stand() according to the sequence diagram, it looks like this:

  public boolean Stand(){
    if(m_deck != null){
      ShowHand();
      while(m_hitRule.DoHit(this)){
        Card c = m_deck.GetCard();
        c.Show(true);
        DealCard(c);
      }
      return true;
    }
    return false;
  }


In BasicHitStrategy we added a or statement in the return to DoHit , with the method hasSoftSeventeen();
HasSoftSeventeen is created in player and looks like this : 

 public boolean hasSoftSeventeen(){
      if(CalcScore() == 17){
          for (Card c: GetHand()
               ) {
              if (c.GetValue() == Card.Value.Ace)
                  return true;
          }
      }
      return false;
  }