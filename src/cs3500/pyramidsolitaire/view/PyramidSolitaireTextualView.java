package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the class for viewing the basic pyramid Solitaire.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  private final Appendable ap;

  /**
   * Represents the initial constructor of PyramidSolitaireTextualView.
   *
   * @param model the basic pyramid model
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
    this.ap = null;
  }

  /**
   * Represents the second constructor of PyramidSolitaireTextualView.
   *
   * @param model the basic pyramid model
   * @param ap    the output given to the player
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  @Override
  public void render() throws IOException {
    this.ap.append(this.toString());
  }


  @Override
  public String toString() {
    if (this.isNotStartGame()) {
      return "";
    } else if (this.model.getScore() == 0) {
      return "You win!";
    } else if (this.model.isGameOver()) {
      String score = String.valueOf(this.model.getScore());
      return "Game over. Score: ".concat(score);
    } else {
      if (this.isNormalDeck()) {
        return this.viewBasicPyramid();
      } else {
        return this.viewMutiPyramid();
      }
    }
  }

  //Determine whether the given model is normal or deal with more decks
  private boolean isNormalDeck() {
    boolean isBasicModel = true;
    for (int row = 0; row < this.model.getNumRows(); row++) {
      int expect = row + 1;
      if (expect != this.model.getRowWidth(row)) {
        isBasicModel = false;
        break;
      }
    }
    return isBasicModel;
  }

  //determine the game is not start
  private boolean isNotStartGame() {
    boolean tf = false;
    try {
      this.model.getScore();
    } catch (IllegalStateException e) {
      tf = true;
    }
    return tf;
  }


  // form the pyramid string
  private String viewBasicPyramid() {
    List<Cards> drawPile = (List<Cards>) this.model.getDrawCards();
    int numRows = this.model.getNumRows();
    int totalNumOfPyramid = numRows * (numRows + 1) / 2;
    int totalLength = (3 * numRows) + (numRows - 1);
    int row = 0;
    int column = 0;
    String initStr = "";

    for (int i = 0; i < totalNumOfPyramid; i++) {
      Cards c = (Cards) this.model.getCardAt(row, column);
      //case1: the first element is also the last element
      if (column == 0 && row == 0) {
        initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c) + "\n";
        //increment the row and reset the column
        row = row + 1;
        //case 2:when it is the first element in the row
      } else if (column == 0) {
        if (row == numRows - 1) {
          if (c != null) {
            if (c.getRankValue() == 10) {
              initStr = initStr + c.getRank() + c.getSuit();
            } else {
              initStr = initStr + c.getRank() + c.getSuit() + " ";
            }
          } else {
            initStr = initStr + this.viewCard(c) + " ";
          }
        } else {
          if (c != null) {
            if (c.getRankValue() == 10) {
              initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c);
            } else {
              initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c) + " ";
            }
          } else {
            initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c) + " ";
          }
        }
        //only increment the column number
        column = column + 1;
        //case 3 : when it is the last element in the row
      } else if (column == row) {
        //case 2.1 when it is the last element in the last row
        if (row == numRows - 1) {
          if (c == null) {
            initStr = initStr + " .";
          } else {
            initStr = initStr + this.viewCard(c);
          }
          break;
        } else {
          if (c == null) {
            initStr = initStr + " ." + "\n";
          } else {
            initStr = initStr + this.viewCard(c) + "\n";
          }
          row = row + 1;
          column = 0;
        }
        //case 4 : the element in the middle
      } else {
        if (c != null) {
          if (c.getRankValue() == 10) {
            initStr = initStr + this.viewCard(c);
          } else {
            initStr = initStr + this.viewCard(c) + " ";
          }
        } else {
          initStr = initStr + this.viewCard(c) + " ";
        }
        //only increment the column number
        column = column + 1;
      }
    }
    return initStr + "\n" + this.viewDraws(drawPile);
  }

  // form the pyramid string
  private String viewMutiPyramid() {
    List<Cards> drawPile = (List<Cards>) this.model.getDrawCards();
    int numRow = this.model.getNumRows() - 1;
    int cardsAtLostRow = this.model.getRowWidth(numRow);
    int totalNumOfPyramid = this.getTotalNumPyramid();
    int totalLength = (3 * cardsAtLostRow) + (cardsAtLostRow - 1);
    int row = 0;
    int column = 0;
    String initStr = "";

    for (int i = 0; i < totalNumOfPyramid; i++) {
      Cards c = (Cards) this.model.getCardAt(row, column);
      int width = this.model.getRowWidth(row) - 1;
      //case1: the first element is also the last element
      if (column == 0) {
        if (row == cardsAtLostRow - 1) {
          if (c != null) {
            if (c.getRankValue() == 10) {
              initStr = initStr + c.getRank() + c.getSuit();
            } else {
              initStr = initStr + c.getRank() + c.getSuit() + " ";
            }
          } else {
            initStr = initStr + this.viewCard(c) + " ";
          }
        } else {
          if (c != null) {
            if (c.getRankValue() == 10) {
              initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c);
            } else {
              initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c) + " ";
            }
          } else {
            initStr = initStr + this.addSpace(totalLength, row) + this.viewCard(c) + " ";
          }
        }
        //only increment the column number
        column = column + 1;
        //case 3 : when it is the last element in the row
      } else if (column == width) {
        //case 2.1 when it is the last element in the last row
        if (row == cardsAtLostRow - 1) {
          if (c == null) {
            initStr = initStr + " .";
          } else {
            initStr = initStr + this.viewCard(c);
          }
          break;
        } else {
          if (c == null) {
            initStr = initStr + " ." + "\n";
          } else {
            initStr = initStr + this.viewCard(c) + "\n";
          }
          row = row + 1;
          column = 0;
        }
        //case 4 : the element in the middle
      } else {
        if (c != null) {
          if (c.getRankValue() == 10) {
            initStr = initStr + this.viewCard(c);
          } else {
            initStr = initStr + this.viewCard(c) + " ";
          }
        } else {
          initStr = initStr + this.viewCard(c) + " ";
        }
        //only increment the column number
        column = column + 1;
      }
    }
    return initStr + "\n" + this.viewDraws(drawPile);
  }

  //Calcultes the number of pyramid of the given model
  private int getTotalNumPyramid() {
    int sum = 0;
    for (int i = 0; i < this.model.getNumRows(); i++) {
      int width = this.model.getRowWidth(i);
      sum = width + sum;
    }
    return sum;
  }

  // Forms the string of the card in the order of Rank and Suit
  private String viewCard(Cards c) {
    if (c == null) {
      return " . ";
    } else {
      return " " + c.toString();
    }
  }

  // Forms the string of the card in the order of Rank and Suitof the draw pile
  private String viewDraws(List<Cards> list) {
    String draw = "Draw:";
    if (!this.checkAllNull(list)) {
      for (int i = 0; i < list.size(); i++) {
        Cards c = list.get(i);
        if (i == list.size() - 1) {
          draw = draw.concat(this.viewCard(c));
        } else {
          draw = draw.concat(this.viewCard(c)) + ",";
        }
      }
    }
    return draw;
  }

  // Forms the string for certain formatting by adding some spaces
  private String addSpace(int totalLength, int row) {
    String str = "";
    int cardSpace = 3 * row + (row - 1);
    //int space = (int) Math.floor((totalLength - cardSpace) / 2);
    int space = (totalLength - cardSpace) / 2;
    for (int i = 0; i < space - 3; i++) {
      str = str + " ";
    }
    return str;
  }

  //Gets the value of the card given the rank of card
  private int getValue(String rank) {
    switch (rank) {
      case "J":
        return 11;
      case "Q":
        return 12;
      case "K":
        return 13;
      case "A":
        return 1;
      default:
        return Integer.valueOf(rank);
    }
  }

  //Determines whether all cards are removed from pyramid
  private boolean checkAllNull(List<Cards> list) {
    List<Cards> loC = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {
        loC.add(list.get(i));
      }
    }
    return loC.isEmpty();
  }

}
