package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Cards;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Relaxed Pyramid Solitaire class which inherited the interface of
 * PyramidSolitaireModel. This Relaxed Pyramid Solitaire has a relax the rules for which cards can
 * be removed, though. If a card is covered by only one other card, and the player is trying to
 * remove those two cards as a pair, then we treat the pair as uncovered and permit it to be removed
 * it if adds up to 13 as desired. Note that this situation can occur at any point of the game, not
 * just at the very end as the above example shows.
 */
public class RelaxedPyramidSolitaire extends PyramidSolitaireAbstract {

  /**
   * Constructor the initial RelaxedPyramidSolitaire.
   */
  public RelaxedPyramidSolitaire() {
    super();
  }

  /**
   * Constructor the RelaxedPyramidSolitaire while game is playing.
   */
  public RelaxedPyramidSolitaire(List<Cards> deck, int numRows, int numDraw, List<Cards> stocks,
      List<List<Cards>> pyramids, List<Cards> drawPile, boolean isStartGame) {
    super(deck, numRows, numDraw, stocks, pyramids, drawPile, isStartGame);
  }


  //Determines whether the current move is valid
  //checks the card(s) is available at a time
  @Override
  protected boolean isExposedAdvance(int r1, int c1, int r2, int c2) {
    boolean isExposed;
    boolean below1 = (c1 == c2);
    if (r1 == r2 + 1) {
      //r1 is below
      isExposed = this.isExposed(r1, c1);
    } else if (r2 == r1 + 1) {
      //r2 is below
      isExposed = this.isExposed(r2, c2);
    } else {
      isExposed = false;
    }
    return isExposed;
  }

  //checks is there any pair could be removed in the relax rule
  //check if there exist two elements in an exposed card list whose sum is equal to 13
  @Override
  protected boolean checkRelaxedPairMove() {
    boolean canMove = false;
    for (int row = 0; row < this.numRows; row++) {
      for (int card = 0; card <= row; card++) {
        if (this.isExposed(row, card)) {
          if (canMove) {
            //find one pair that can be removed in relax model
            break;
          }
          if (row >= 1) {
            //guarantee that there is one row above the current card
            Cards currentCard = this.getCardAt(row, card);
            if (card == 0) {
              //where the card is at first
              int rowOfPair = row - 1;
              int cardOfPair = card;
              int rowOfNeighbor = row;
              int cardOfNeighbor = card + 1;
              canMove = this
                  .checkValidRelaxPair(rowOfPair, cardOfPair, rowOfNeighbor, cardOfNeighbor,
                      currentCard);

            } else if (card == row) {
              //where the card is at end of row
              int rowOfPair = row - 1;
              int cardOfPair = card - 1;
              int rowOfNeighbor = row;
              int cardOfNeighbor = card - 1;
              canMove = this
                  .checkValidRelaxPair(rowOfPair, cardOfPair, rowOfNeighbor, cardOfNeighbor,
                      currentCard);
            } else {
              //where the card is in the middle
              //Need to check two cards
              int rowOfPair1 = row - 1;
              int cardOfPair1 = card;
              int rowOfNeighbor1 = row;
              int cardOfNeighbor1 = card + 1;
              Boolean canMove1 = this
                  .checkValidRelaxPair(rowOfPair1, cardOfPair1, rowOfNeighbor1, cardOfNeighbor1,
                      currentCard);
              int rowOfPair2 = row - 1;
              int cardOfPair2 = card - 1;
              int rowOfNeighbor2 = row;
              int cardOfNeighbor2 = card - 1;
              Boolean canMove2 = this
                  .checkValidRelaxPair(rowOfPair2, cardOfPair2, rowOfNeighbor2, cardOfNeighbor2,
                      currentCard);
              canMove = canMove1 || canMove2;
            }
          } else {
            //there is only one element remaining in the pyramid cannot do the pair move
            canMove = false;
          }
        }
      }
    }
    return canMove;
  }

  //
  private boolean checkValidRelaxPair(int rowOfPair, int cardOfPair, int rowOfNeighbor,
      int cardOfNeighbor, Cards exposedCard) {
    Cards c = this.getCardAt(rowOfPair, cardOfPair);
    boolean isSum13 = this.isSum13(c, exposedCard);
    boolean canMove = false;
    if (isSum13) {
      Cards neighbor = this.getCardAt(rowOfNeighbor, cardOfNeighbor);
      canMove = (neighbor == null);
    }
    return canMove;
  }

  //Calculate the sum of two cards and determine whether these two cards is sum to 13
  private boolean isSum13(Cards c1, Cards c2) {
    boolean isEqual13 = false;
    if (c1 != null && c2 != null) {
      int sum = c1.getRankValue() + c2.getRankValue();
      isEqual13 = (sum == 13);
    }
    return isEqual13;
  }

  //Check whether the two neighbors has chance of

  //Gets all exposed element in the pyramid and form a list
  @Override
  protected List<Cards> getExposedCards() {
    List<Cards> exposedCards = new ArrayList<>();
    for (int row = 0; row < this.numRows; row++) {
      for (int card = 0; card <= row; card++) {
        if (this.isExposed(row, card)) {
          Cards c = this.getCardAt(row, card);
          exposedCards.add(c);
        }
      }
    }
    return exposedCards;
  }
}
