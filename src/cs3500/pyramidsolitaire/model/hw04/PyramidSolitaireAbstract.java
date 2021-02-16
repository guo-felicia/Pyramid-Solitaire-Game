package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Abstract clas for Pyramid Solitaire game.
 */
public abstract class PyramidSolitaireAbstract implements PyramidSolitaireModel<Cards> {

  protected int numRows;
  protected List<Cards> deck;
  protected int numDraw;
  protected List<Cards> stocks;
  protected List<List<Cards>> pyramids;
  protected List<Cards> drawPile;
  protected boolean isStartGame;

  /**
   * Constructor the initial PyramidSolitaireAbstract.
   */
  protected PyramidSolitaireAbstract() {
    this.deck = new ArrayList<>();
    this.numRows = -1;
    this.numDraw = -1;
    this.stocks = new ArrayList<>();
    this.pyramids = new ArrayList<>(new ArrayList<>());
    this.drawPile = new ArrayList<>();
    this.isStartGame = false;
  }

  /**
   * Constructor the PyramidSolitaireAbstract while game is playing.
   */
  public PyramidSolitaireAbstract(List<Cards> deck, int numRows, int numDraw, List<Cards> stocks,
      List<List<Cards>> pyramids, List<Cards> drawPile, boolean isStartGame) {
    this.deck = deck;
    this.numRows = numRows;
    this.numDraw = numDraw;
    this.stocks = stocks;
    this.pyramids = pyramids;
    this.drawPile = drawPile;
    this.isStartGame = isStartGame;
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
      System.out.println(newDeck);
    }
    return newDeck;
  }

  @Override
  public void startGame(List<Cards> deck, boolean shuffle, int numRows, int numDraw) {
    if (deck != null) {
      //Avoid cheating -- create a copy of deck
      List<Cards> deckMock = new ArrayList<>(deck);
      //define some boolean variables to represent the rule of game
      boolean validDeck = this.isValidDeck(deckMock);
      boolean validDraws = this.isValidDraw(numRows, numDraw);
      int numPyramid = this.getNumPyramidCards(numRows);
      int nextIndexForStocks = numPyramid + numDraw;
      // throws exceptions if the game state is not valid
      if (!validDeck || numRows <= 0 || !validDraws || numPyramid > deckMock.size()) {
        throw new IllegalArgumentException("You may entered invalid deck or numRows or draws");
      } else {
        //check whether the deckMock list need to shuffle
        if (shuffle) {
          this.shuffleCards(deckMock);
          this.deck = new ArrayList<>(deckMock);
        } else {
          this.deck = new ArrayList<>(deckMock);
        }
        //set the initial game state
        this.isStartGame = true;
        this.numRows = numRows;
        this.numDraw = numDraw;
        //check the valid of game board
        if (numPyramid <= this.deck.size()) {
          int numDeck = this.deck.size() / 52;
          this.pyramids = this.createPyramidCards(numPyramid, numDeck);
          this.drawPile = this.getList(this.deck, numPyramid, nextIndexForStocks);
          this.stocks = this.getList(this.deck, nextIndexForStocks, deck.size());
        } else {
          throw new IllegalArgumentException("The game board cannot be initialed.");
        }
      }
    } else {
      throw new IllegalArgumentException("The deck cannot be null.");
    }
  }


  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    Cards c1 = this.getCardAt(row1, card1);
    Cards c2 = this.getCardAt(row2, card2);
    if (c1 == null || c2 == null) {
      throw new IllegalArgumentException("The card is null.");
    } else {
      if (this.isStartGame) {
        boolean isExposed = this.isExposedAdvance(row1, card1, row2, card2);
        //Is sum equal to 13
        boolean isEquals13 = (c1.getRankValue() + c2.getRankValue() == 13);
        //Is pointing to same card
        boolean isNotSameCard = this.notSameCard(row1, card1, row2, card2);
        if (isExposed && isEquals13 && isNotSameCard) {
          this.doRemove(row1, card1);
          this.doRemove(row2, card2);
        } else {
          if (!isEquals13) {
            throw new IllegalArgumentException("The value of card is not 13.");
          } else if (!isExposed) {
            throw new IllegalArgumentException("The card is not exposed yet.");
          } else if (!this.notSameCard(row1, card1, row2, card2)) {
            throw new IllegalArgumentException("The cards you selected is same.");
          }
        }

      } else {
        throw new IllegalStateException("The game is not started.");
      }
    }
  }


  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    Cards c = this.getCardAt(row, card);
    if (c == null) {
      throw new IllegalArgumentException("The card is already removed (it's null).");
    } else {
      if (this.isStartGame) {
        boolean isExposed = this.isExposed(row, card);
        if (isExposed) {
          if (c.getRankValue() == 13) {
            this.doRemove(row, card);
          } else {
            throw new IllegalArgumentException("The value of card is not 13.");
          }
        } else {
          throw new IllegalArgumentException("The card is not exposed yet.");
        }
      } else {
        throw new IllegalStateException("The game is not started.");
      }
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    if (!this.isStartGame) {
      throw new IllegalStateException("The game is not started");
    } else {
      //checks the valid index
      if (drawIndex >= 0 && drawIndex < numDraw) {
        //check if the selected card is exposed
        if (this.isExposed(row, card)) {
          Cards c1 = this.getCardAt(row, card);
          Cards c2 = this.drawPile.get(drawIndex);
          if (c1 == null || c2 == null) {
            throw new IllegalArgumentException("Either the card in draws or in pyramid is null.");
          } else {
            boolean isEqual13 = (c1.getRankValue() + c2.getRankValue() == 13);
            if (isEqual13) {
              // in pyramid: remove the certain cards -- replace by null
              this.doRemove(row, card);
              //in draw pile: replace the certain draw cards with the next card in the stock
              this.removeDraw(drawIndex);
            } else {
              throw new IllegalArgumentException("The value of card is not 13.");
            }
          }
        } else {
          throw new IllegalArgumentException("The card is not exposed yet.");
        }
      } else {
        throw new IllegalArgumentException("The index is not valid.");
      }
    }

  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    if (this.isStartGame) {
      if (drawIndex >= 0 && drawIndex < numDraw) {
        Cards c = this.drawPile.get(drawIndex);
        if (c != null) {
          this.removeDraw(drawIndex);
        } else {
          throw new IllegalArgumentException("The card in the draw is null.");
        }
      } else {
        throw new IllegalArgumentException("The index is not valid.");
      }
    } else {
      throw new IllegalStateException("The game is not started.");
    }
  }


  @Override
  public int getNumRows() {
    if (!this.isStartGame) {
      return -1;
    } else {
      return this.numRows;
    }
  }

  @Override
  public int getNumDraw() {
    if (!this.isStartGame) {
      return -1;
    } else {
      return this.numDraw;
    }
  }

  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    if (!this.isStartGame) {
      throw new IllegalStateException("The game is not started.");
    } else if (row < 0 || row >= this.getNumRows()) {
      throw new IllegalArgumentException("The row number is not valid.");
    } else {
      return this.getRowWidthHelper(row, this.getNumRows());
    }
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    boolean isGameOver = false;
    if (!this.isStartGame) {
      throw new IllegalStateException("The game is not started.");
    } else {
      //define some boolean variables to represent the state of the game
      boolean drawHasCard = this.getDrawCards().stream().anyMatch(Objects::nonNull);
      boolean noDiscards = this.stocks.isEmpty() && !drawHasCard;

      if (this.getScore() == 0) {
        isGameOver = noDiscards;
      } else {
        List<Cards> exposedCards = this.getExposedCards();
        if (!drawHasCard) {
          boolean canMove = this.checkSingleMove(exposedCards) || this.checkPairMove(exposedCards);
          isGameOver = !canMove;
        } else {
          boolean canMove =
              this.checkSingleMove(exposedCards) || this.checkPairMove(exposedCards) || this
                  .checkDrawMove(exposedCards);
          //isGameOver = !canMove;
          isGameOver = false;
        }
      }
    }
    return isGameOver;
  }

  @Override
  public int getScore() throws IllegalStateException {
    if (!this.isStartGame) {
      throw new IllegalStateException("must start the game first");
    } else {
      int preSum = this.getScoreHelper();
      return preSum;
    }
  }


  @Override
  public Cards getCardAt(int row, int card) throws IllegalArgumentException, IllegalStateException {
    if (!this.isStartGame) {
      throw new IllegalStateException("Must start the game first.");
    } else if (row < 0 || row >= this.numRows || card >= this.getRowWidth(row) || card < 0) {
      throw new IllegalArgumentException("The given row and card is not valid.");
    } else {
      List<Cards> getRow = this.pyramids.get(row);
      return getRow.get(card);
    }
  }

  //Gets the number of cards in pyramid
  protected int getNumPyramidCards(int numRows) {
    return numRows * (numRows + 1) / 2;
  }

  //render the given pyramid and get the value of each card
  protected int getScoreHelper() {
    int preSum = 0;
    for (int row = 0; row < this.numRows; row++) {
      for (int card = 0; card <= row; card++) {
        Cards c = this.getCardAt(row, card);
        if (c != null) {
          preSum = preSum + c.getRankValue();
        }
      }
    }
    return preSum;
  }


  @Override
  public List<Cards> getDrawCards() throws IllegalStateException {
    if (!this.isStartGame) {
      throw new IllegalStateException("must start the game first");
    } else {
      List<Cards> copyDraws = new ArrayList<>();
      for (int i = 0; i < this.numDraw; i++) {
        copyDraws.add(this.drawPile.get(i));
      }
      return copyDraws;
    }
  }

  // =============== SOME HELPER METHODS ===============

  //shuflle the card
  private void shuffleCards(List<Cards> deck) {
    Random rand = new Random();
    int j;
    for (int i = 0; i < 52; i++) {
      j = rand.nextInt(52);
      Cards temp = deck.get(i);
      deck.set(i, deck.get(j));
      deck.set(j, temp);
    }
  }

  //Determines whether the deck list is valid
  //checks the duplication and the size of the list
  protected boolean isValidDeck(List<Cards> deck) {
    return deck.size() == 52 && this.checkDuplicates(deck);
  }

  //Determines whether the draw pile is valid
  //checks these conditions:
  //must be non-neg (include 0), can have empty stock
  protected boolean isValidDraw(int numRows, int numDraw) {
    int numPyramid = this.getNumPyramidCards(numRows);
    return (numDraw >= 0) && numDraw < 52 && numDraw + numPyramid <= 52;
  }

  //Checks whether the given list has some duplicates cards
  protected boolean checkDuplicates(List<Cards> original) {
    List<Cards> result = original.stream()
        .distinct()
        .collect(Collectors.toList());
    return result.size() == original.size();
  }

  //Determine whether the two cards is with at same plot in pyramid
  private boolean notSameCard(int row1, int card1, int row2, int card2) {
    return row1 != row2 || card1 != card2;
  }

  //Determines whether the current move is valid
  //checks the card(s) is available at a time
  protected boolean isExposed(int row, int column) {
    boolean isExposed = false;
    if (row == this.numRows - 1) {
      isExposed = true;
    } else {
      int rowBelow = row + 1;
      int colBelow = column + 1;
      if (this.getCardAt(rowBelow, column) == null) {
        isExposed = this.getCardAt(rowBelow, colBelow) == null;
      }
    }
    return isExposed;
  }

  //Gets all exposed element in the pyramid and form a list
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

  //checks is there any King remains
  private boolean checkSingleMove(List<Cards> exposedCards) {
    boolean canMove = false;
    for (int i = 0; i < exposedCards.size(); i++) {
      Cards currCard = exposedCards.get(i);
      if (currCard != null) {
        if (currCard.getRankValue() == 13) {
          canMove = true;
          break;
        }
      }
    }
    return canMove;
  }

  //checks is there any pair could be removed by using draw
  //check if there exist two elements in an exposed card list whose sum is equal to 13
  private boolean checkDrawMove(List<Cards> exposedCards) {
    boolean canMove = false;
    for (int i = 0; i < exposedCards.size(); i++) {
      Cards cPramid = exposedCards.get(i);
      if (canMove) {
        break;
      }
      for (int index = 0; index < this.numDraw; index++) {
        Cards cDraw = this.drawPile.get(index);
        if (cPramid != null && cDraw != null) {
          int value = cPramid.getRankValue() + cDraw.getRankValue();
          if (value == 13) {
            canMove = true;
            break;
          }
        }
      }
    }
    return canMove;
  }


  //Return the row width of the given row and numRows
  protected int getRowWidthHelper(int row, int numRows) {
    return row + 1;
  }


  //Determines whether the selected two card is exposed
  //Normally defined by the strict rule
  //be override in Relax model
  protected boolean isExposedAdvance(int r1, int c1, int r2, int c2) {
    //Is exposed card?
    boolean isFirstCardsExposed = this.isExposed(r1, c1);
    boolean isSecondCardsExposed = this.isExposed(r2, c2);
    boolean isExposed = isFirstCardsExposed && isSecondCardsExposed;
    return isExposed;
  }

  //Create the pyramid card list according to the given number of rows
  private List<List<Cards>> createPyramidCards(int numPyramids, int numDeck) {
    int row = 0;
    int space = this.getRowWidth(row);
    //define an empty lise to start the pyramid
    List<List<Cards>> gameBoard = new ArrayList<>(new ArrayList<>());
    List<Cards> rowCards = new ArrayList<>();
    for (int i = 0; i < numPyramids; i++) {
      if (row <= this.numRows) {
        if (row == 0) {
          space = 0;
        }
        this.addCardHelper(rowCards, i, row, space, numDeck);
        space = space - 1;
        if (space < 0) {
          //append the entire rowCard to the game board
          gameBoard.add(rowCards);
          //empty the current rowCards
          rowCards = new ArrayList<>();
          //move to a new row
          row = row + 1;
          //update new space
          space = row;
        }
      }
    }
    return gameBoard;
  }


  //Add either card or null to the pyramid list
  private void addCardHelper(List<Cards> loc, int i, int row, int space, int numDeck) {
    if (numDeck == 1) {
      Cards card = this.deck.get(i);
      loc.add(card);
    } else {
      //minus one because numRow start at 1 but the row index start at 0
      int overlapsAtRow = (int) Math.ceil(this.numRows / 2) - 1;
      if (row >= overlapsAtRow) {
        Cards card = this.deck.get(i);
        loc.add(card);
      } else {
        this.addCardAtIndex(loc, overlapsAtRow, row, space, i);
      }
    }
  }

  private void addCardAtIndex(List<Cards> loc, int overlapRow, int currentRow, int currentCard,
      int index) {
    int rowNeedToAddSpace = overlapRow - 2;
    int spaceBetweenCard = rowNeedToAddSpace - currentRow + 1;
    int nextAvailableIndex = spaceBetweenCard + 1;

    for (int i = 0; i < this.getRowWidth(currentRow); i += nextAvailableIndex) {
      if (currentCard == i) {
        Cards card = this.deck.get(index);
        loc.add(card);
      } else {
        loc.add(null);
      }
    }
  }

  //Splits the list of Cards by given index
  private List<Cards> getList(List<Cards> mockDeck, int lbound, int ubound) {
    List<Cards> cardsList = new ArrayList<>();
    for (int i = lbound; i < ubound; i++) {
      Cards c = mockDeck.get(i);
      cardsList.add(c);
    }
    return cardsList;
  }

  //Remove the cards at given row and card
  private void doRemove(int row, int card) {
    //find the row of the Card is
    List<Cards> rowOfCard = this.pyramids.get(row);
    //replace the Card with the null at the cards
    List<Cards> rowCardCopy = new ArrayList<>(rowOfCard);
    rowCardCopy.set(card, null);
    this.pyramids.set(row, rowCardCopy);
  }

  //remove the cards from draw according to the latest stock status
  private void removeDraw(int drawIndex) {
    if (this.stocks.isEmpty()) {
      this.drawPile.set(drawIndex, null);
    } else {
      //remove the current card from stock
      List<Cards> stockCopy = new ArrayList<>(this.stocks);
      Cards removedFromStock = stockCopy.remove(0);
      this.stocks = stockCopy;
      //update the draw with new card from stock
      List<Cards> drawCopy = new ArrayList<>(this.drawPile);
      drawCopy.set(drawIndex, removedFromStock);
      this.drawPile = drawCopy;
    }
  }


  //checks is there any pair could be removed
  //check if there exist two elements in an exposed card list whose sum is equal to 13
  private boolean checkPairMove(List<Cards> exposedCards) {
    boolean canMove = false;
    for (int i = 0; i < exposedCards.size(); i++) {
      if (canMove) {
        break;
      }
      for (int j = i + 1; j < exposedCards.size(); j++) {
        Cards c1 = exposedCards.get(i);
        Cards c2 = exposedCards.get(j);
        if (c1 != null && c2 != null) {
          if (c1.getRankValue() + c2.getRankValue() == 13) {
            canMove = true;
            break;
          }
        }
      }
    }
    if (!canMove) {
      canMove = this.checkRelaxedPairMove();
    }
    return canMove;
  }

  //checks is there any pair could be removed in the relax rule
  //check if there exist two elements in an exposed card list whose sum is equal to 13
  protected boolean checkRelaxedPairMove() {
    return false;
  }

}

