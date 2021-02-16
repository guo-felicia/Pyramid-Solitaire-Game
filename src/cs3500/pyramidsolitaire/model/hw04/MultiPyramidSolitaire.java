package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Muti-Pyramid Solitaire class which inherited the interface of
 * PyramidSolitaireModel. It uses the same rules as the original game, but uses a larger board and a
 * larger deck of cards.
 *
 * @author tongfeiguo
 */
public class MultiPyramidSolitaire extends PyramidSolitaireAbstract {

  /**
   * Constructor the initial MutiPyramidSolitaire.
   */
  public MultiPyramidSolitaire() {
    super();
  }

  /**
   * Constructor the MutiPyramidSolitaire while game is playing.
   */

  public MultiPyramidSolitaire(List<Cards> deck, int numRows, int numDraw, List<Cards> stocks,
      List<List<Cards>> pyramids, List<Cards> drawPile, boolean isStartGame) {
    super(deck, numRows, numDraw, stocks, pyramids, drawPile, isStartGame);
  }


  @Override
  public List<Cards> getDeck() {
    // initialize deck
    List<Cards> newDeck = new ArrayList<>();
    for (int i = 0; i < 52; i++) {
      for (Rank r : Rank.values()) {
        for (Suit s : Suit.values()) {
          Cards c = new Cards(s, r);
          newDeck.add(c);
          i++;
        }
      }
    }
    List<Cards> totalDeck = new ArrayList<>(newDeck);
    totalDeck.addAll(newDeck);
    return totalDeck;
  }

  @Override
  protected int getNumPyramidCards(int numRows) {
    //for loop use the getrowidth methods
    int count = 0;
    if (numRows == 1) {
      //minus one because numRow start at 1 but the row index start at 0
      count = 1;
    } else {
      int overlapsAtRow = this.getFirstOverlapRow(numRows);
      for (int row = 0; row < numRows; row++) {
        int width = this.getWidthOverlap(row, overlapsAtRow);
        count = width + count;
      }
    }
    return count;
  }

  @Override
  protected int getScoreHelper() {
    int preSum = 0;

    for (int row = 0; row < this.numRows; row++) {
      int width = this.getRowWidth(row);
      for (int card = 0; card < width; card++) {
        Cards c = this.getCardAt(row, card);
        if (c != null) {
          preSum = preSum + c.getRankValue();
        }
      }
    }
    return preSum;
  }

  /*
          how many cards overlaps per row:
        overlap 2 cards for each row
        first row (R4 start with 1) overlap: no Overlap: 4 * 3 = 12; actual: 10
         || row - overlapsAtRow = 0;
        second row (R5 start with 1) overlap: no Overlap: 5 * 3 = 15; actual: 11
         || row - overlapsAtRow = 1;
        ...
        last row(e.g. R7) overlap: no Overlap: 7 * 3 = 21; actual: 13 || row - overlapsAtRow = 3;
        10 + 3 = 13;

        calculate the unmodified row width for that row:
        (row + 1) * # Decks
   */

  @Override
  protected int getRowWidthHelper(int row, int numRows) {
    //numrow = 7;
    //numRows/2 = 3;
    //7,8,9,...,13

    if (numRows == 1) {
      //minus one because numRow start at 1 but the row index start at 0
      return 1;
    } else {
      int overlapsAtRow = this.getFirstOverlapRow(numRows);
      int width = this.getWidthOverlap(row, overlapsAtRow);
      return width;
    }
  }

  //Find the row number which will be overlapped first
  private int getFirstOverlapRow(int numRows) {
    int overlapsAtRow;
    if (numRows == 2) {
      overlapsAtRow = 1;
    } else {
      overlapsAtRow = numRows / 2;
    }
    return overlapsAtRow;
  }

  //Calculated the exactly width of the row
  private int getWidthOverlap(int row, int overlapsAtRow) {
    int numPyramids = 3;
    if (row >= overlapsAtRow) {
      //on the first row, the card will overlapped is 2 so minus 2
      int numCardsAtFirstOverlap = (overlapsAtRow + 1) * numPyramids - 2;
      return numCardsAtFirstOverlap + (row - overlapsAtRow);
    } else {
      if (overlapsAtRow >= 2) {
        int firstRowNeedToAddSpace = overlapsAtRow - 2;
        int spaceBetweenCard = firstRowNeedToAddSpace - row + 1;
        int numCard = (row + 1) * numPyramids;
        return spaceBetweenCard * (numPyramids - 1) + numCard;
      } else {
        int numCardsAtFirstOverlap = (overlapsAtRow + 1) * numPyramids - 2;
        return numCardsAtFirstOverlap + (row - overlapsAtRow);
      }
    }
  }

  @Override
  protected boolean isValidDeck(List<Cards> deck) {
    //more than two deck
    return deck.size() == 104 && this.checkDuplicates(deck);
  }

  @Override
  protected boolean isValidDraw(int numRows, int numDraw) {
    int numPyramid = this.getNumPyramidCards(numRows);
    return (numDraw >= 0) && numDraw < 104 && numDraw + numPyramid <= 104;
  }

  @Override
  //Checks whether the given list has some duplicates cards
  protected boolean checkDuplicates(List<Cards> original) {
    /*List<Cards> result = original.stream()
        .distinct()
        .collect(Collectors.toList());
    return result.size() == original.size();*/
    //for loop dup
    return true;
  }

  @Override
  //Gets all exposed element in the pyramid and form a list
  protected List<Cards> getExposedCards() {
    List<Cards> exposedCards = new ArrayList<>();
    for (int row = 0; row < this.numRows; row++) {
      int width = this.getRowWidth(row);
      for (int card = 0; card < width; card++) {
        if (this.isExposed(row, card)) {
          Cards c = this.getCardAt(row, card);
          exposedCards.add(c);
        }
      }
    }
    return exposedCards;
  }
}
