package cs3500.pyramidsolitaire;

import static cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType.BASIC;
import static cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType.RELAXED;
import static cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType.MULTIPYRAMID;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrate the Pyramid Solitaire game.
 */
public final class PyramidSolitaire {

  /**
   * The main methods for the Pyramid Solitaire game.
   *
   * @param args the input from user.
   */
  public static void main(String[] args) {
    String type = args[0];
    int rows = 7;
    //Integer.parseInt(args)
    //this.getRows(args);
    int draws = 3;
    //this.getDraws(args);
    List<Cards> deck = new ArrayList<>();
    try {
      //switch - create the model
      switch (type) {
        case "basic":
          PyramidSolitaireModel basicPyramidSolitaireModel = PyramidSolitaireCreator.create(BASIC);
          deck = basicPyramidSolitaireModel.getDeck();
          new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out)
              .playGame(basicPyramidSolitaireModel, deck, true, rows, draws);
          break;
        case "relaxed":
          PyramidSolitaireModel relaxedPyramidSolitaireModel = PyramidSolitaireCreator
              .create(RELAXED);
          deck = relaxedPyramidSolitaireModel.getDeck();
          new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out)
              .playGame(relaxedPyramidSolitaireModel, deck, true, rows, draws);
          break;
        case "multipyramid":
          PyramidSolitaireModel mutiPyramidSolitaireModel = PyramidSolitaireCreator
              .create(MULTIPYRAMID);
          deck = mutiPyramidSolitaireModel.getDeck();
          new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out)
              .playGame(mutiPyramidSolitaireModel, deck, true, rows, draws);
          break;
        default:
          throw new RuntimeException("Invalid game type.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*  private int getRows(String[] args) {
    for (int i = 0; i < this.getRows(args); i++) {
      String.
    }
  }*/
}