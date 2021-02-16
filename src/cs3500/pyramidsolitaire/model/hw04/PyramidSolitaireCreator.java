package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 *Demonstrate the creatoe of the Pyramid Solitaire game for each game type¬.
 */
public class PyramidSolitaireCreator {

  /**
   * This documents the three possible values of game type.
   */
  public enum GameType {
    BASIC,
    RELAXED,
    MULTIPYRAMID
  }

  /**
   * Returns an instance of (an appropriate subclass of) PyramidSolitaireModel , depending on the
   * value of the parameter..
   */
  public static PyramidSolitaireModel create(GameType type) {
    switch (type) {
      case BASIC:
        return new BasicPyramidSolitaire();
      case RELAXED:
        return new RelaxedPyramidSolitaire();
      case MULTIPYRAMID:
        return new MultiPyramidSolitaire();
      default:
        throw new RuntimeException("Invalid game type.");
    }
  }
}
