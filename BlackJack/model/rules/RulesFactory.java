package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new SoftSeventeenStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new InternationalNewGameStrategy();
  }

  public IWinStrategy WinRule() {
    return new AdvantagePlayerStrategy();
  }
}