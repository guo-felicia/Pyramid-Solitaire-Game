package cs3500.pyramidsolitaire.controller;


import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple controller for interacting with a game of Pyramid Solitaire.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {

  private Readable in;
  private Appendable out;
  private PyramidSolitaireTextualView view;

  /**
   * Constructors of the controller class.
   *
   * @param input  Readable of user's input
   * @param output Appendable to output message for user
   * @throws IllegalArgumentException if the given input and output is null, should throws
   *                                  exception
   */

  public PyramidSolitaireTextualController(Readable input, Appendable output) {
    try {
      Objects.requireNonNull(input);
      Objects.requireNonNull(output);
      this.in = input;
      this.out = output;
      this.view = null;
    } catch (NullPointerException e) {
      throw new IllegalArgumentException("The provided input or output shouldn't be null.");
    }
  }

  @Override
  public <Cards> void playGame(PyramidSolitaireModel<Cards> model, List<Cards> deck,
      boolean shuffle,
      int numRows, int numDraw) {

    boolean isGameOver = false;

    if (model == null || deck == null) {
      throw new IllegalArgumentException("The provided model shouldn't be null.");
    } else {
      try {
        model.startGame(deck, shuffle, numRows, numDraw);
        this.view = new PyramidSolitaireTextualView(model, this.out);
        this.view.render();
      } catch (Exception e) {
        //due to empty model or empty deck
        throw new IllegalStateException("The game cannot be started.");
      }

      if (model.isGameOver()) {
        isGameOver = true;
        try {
          this.view.render();
        } catch (Exception e) {
          this.getMessage("Cannot render successfully.\n");
        }
      } else {

        try {
          Scanner scan = new Scanner(this.in);
          while (!isGameOver && scan.hasNext()) {
            String move = scan.next();
            switch (move) {
              case "rm1":
                List<Integer> coordinates1 = this.checkNextInput(2, scan, model);
                if (coordinates1.isEmpty()) {
                  isGameOver = true;
                } else {
                  this.rmSingle(model, coordinates1);
                  this.out.append("\n");
                  this.view.render();
                }
                break;
              case "rm2":
                List<Integer> coordinates2 = this.checkNextInput(4, scan, model);
                if (coordinates2.isEmpty()) {
                  isGameOver = true;
                } else {
                  this.rmPair(model, coordinates2);
                  this.out.append("\n");
                  this.view.render();
                }
                break;
              case "rmwd":
                List<Integer> coordinates3 = this.checkNextInput(3, scan, model);
                if (coordinates3.isEmpty()) {
                  isGameOver = true;
                } else {
                  this.rmDraw(model, coordinates3);
                  this.out.append("\n");
                  this.view.render();
                }
                break;
              case "dd":
                List<Integer> coordinates4 = this.checkNextInput(1, scan, model);
                if (coordinates4.isEmpty()) {
                  isGameOver = true;
                } else {
                  this.discardCard(model, coordinates4);
                  this.out.append("\n");
                  this.view.render();
                }
                break;
              case "q":
              case "Q":
                this.quitGame(model);
                isGameOver = true;
                break;
              default:
                this.getMessage("Please enter a valid remove specifier.\n");
            }
          }
        } catch (Exception e) {
          this.getMessage("Cannot render the game state.\n");
        }

      }
    }
  }

  //Check the next input from user
  private <Cards> List<Integer> checkNextInput(int expectNumArg, Scanner scan,
      PyramidSolitaireModel<Cards> model) {
    List<Integer> out = new ArrayList<>();
    while (scan.hasNext()) {
      boolean isQuit = false;
      for (int i = 0; out.size() < expectNumArg; i++) {
        if (scan.hasNextInt()) {
          int coordinate = scan.nextInt();
          if (coordinate >= 0) {
            out.add(coordinate);
          }
        } else {
          String input = scan.next();
          if (input.equalsIgnoreCase("q")) {
            this.quitGame(model);
            isQuit = true;
            //delete the elements that may be added before quit since they are meaningless
            out = new ArrayList<>();
            break;
          } else {
            if (scan.hasNext()) {
              //skip the current and wait to check the next input
              //scan.next();
            } else {
              this.getMessage("Please enter a valid remove specifier.\n");
              break;
            }
          }
        }
      }
      break;
    }
    return out;
  }

  //Modify the current state of game removing one card
  private <Cards> void rmSingle(PyramidSolitaireModel<Cards> model, List<Integer> coordinates) {
    try {
      if (coordinates.size() == 2) {
        int r1 = coordinates.get(0);
        int row = this.convert(r1);
        int c1 = coordinates.get(1);
        int column = this.convert(c1);
        model.remove(row, column);
      } else {
        this.getMessage("Invalid input, please re-enter a valid one.\n");
      }
    } catch (Exception e) {
      this.getMessage(this.errorMsg(e));
    }
  }

  //Modify the current state of game removing two cards
  private <Cards> void rmPair(PyramidSolitaireModel<Cards> model, List<Integer> coordinates) {
    try {
      if (coordinates.size() == 4) {
        int r1 = coordinates.get(0);
        int row1 = this.convert(r1);
        int c1 = coordinates.get(1);
        int column1 = this.convert(c1);
        int r2 = coordinates.get(2);
        int row2 = this.convert(r2);
        int c2 = coordinates.get(3);
        int column2 = this.convert(c2);
        model.remove(row1, column1, row2, column2);
        //this.view.render();
      } else {
        this.getMessage("Invalid input, please re-enter a valid one.\n");
      }
    } catch (Exception e) {
      this.getMessage(this.errorMsg(e));
    }
  }

  //Modify the current state of game using draw cards
  private <Cards> void rmDraw(PyramidSolitaireModel<Cards> model, List<Integer> coordinates) {
    try {
      if (coordinates.size() == 3) {
        int index = coordinates.get(0);
        int indexDraw = this.convert(index);
        int r = coordinates.get(1);
        int row = this.convert(r);
        int c = coordinates.get(2);
        int column = this.convert(c);
        model.removeUsingDraw(indexDraw, row, column);
      } else {
        this.getMessage("Invalid input, please re-enter a valid one.\n");
      }
    } catch (Exception e) {
      this.getMessage(this.errorMsg(e));
    }
  }


  //Modify the current state of game by discarding the card in draw pile
  private <Cards> void discardCard(PyramidSolitaireModel<Cards> model, List<Integer> coordinates) {
    try {
      if (coordinates.size() == 1) {
        int c = coordinates.get(0);
        int cardIndex = this.convert(c);
        model.discardDraw(cardIndex);
      } else {
        this.getMessage("Invalid input, please re-enter a valid one.\n");
      }
    } catch (Exception e) {
      this.getMessage(this.errorMsg(e));
    }
  }

  //Quit the game when the player enter q or Q
  private <Cards> void quitGame(PyramidSolitaireModel<Cards> model) {
    try {
      this.out.append("\n");
      String quitStatement = "Game quit!\nState of game when quit:\n";
      String quitStatementUpdate = quitStatement.concat(this.view.toString());
      String score = String.valueOf(model.getScore());
      String scoreMsg = "\nScore: " + score;
      String fullQuit = quitStatementUpdate.concat(scoreMsg);
      this.out.append(fullQuit);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Send the corresponds error message to the player
  private void getMessage(String msg) {
    try {
      this.out.append(msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Format the error message
  private String errorMsg(Exception e) {
    String reason = e.getMessage();
    return "Invalid move. Play again. *" + reason + "*\n";
  }


  //Convert the input row and card number to the number which is used for checking with pyramid
  private int convert(int input) {
    return input - 1;
  }
}