package cs3500.pyramidsolitaire.model.hw02;

import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireAbstract;
import java.util.List;

/**
 * Represents the BasicPyramidSolitaire.
 */
public class BasicPyramidSolitaire extends PyramidSolitaireAbstract {

  /**
   * Constructor the initial BasicPyramidSolitaire.
   */
  public BasicPyramidSolitaire() {
    super();
  }

  /**
   * Constructor the BasicPyramidSolitaire while game is playing.
   */
  public BasicPyramidSolitaire(List<Cards> deck, int numRows, int numDraw, List<Cards> stocks,
      List<List<Cards>> pyramids, List<Cards> drawPile, boolean isStartGame) {
    super(deck, numRows, numDraw, stocks, pyramids, drawPile, isStartGame);
  }
}

