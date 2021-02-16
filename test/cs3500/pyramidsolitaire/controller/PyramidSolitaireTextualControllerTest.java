package cs3500.pyramidsolitaire.controller;

import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.Interaction;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Tests for the controller of the Pyramid Solitaire Textual.
 */
public class PyramidSolitaireTextualControllerTest {

  // =======================EXAMPLES========================

  // CARDS WITH SUIT: DIAMONDS
  Cards cd1 = new Cards(Suit.DIAMONDS, Rank.ACE);
  Cards cd2 = new Cards(Suit.DIAMONDS, Rank.TWO);
  Cards cd3 = new Cards(Suit.DIAMONDS, Rank.THREE);
  Cards cd4 = new Cards(Suit.DIAMONDS, Rank.FOUR);
  Cards cd5 = new Cards(Suit.DIAMONDS, Rank.FIVE);
  Cards cd6 = new Cards(Suit.DIAMONDS, Rank.SIX);
  Cards cd7 = new Cards(Suit.DIAMONDS, Rank.SEVEN);
  Cards cd8 = new Cards(Suit.DIAMONDS, Rank.EIGHT);
  Cards cd9 = new Cards(Suit.DIAMONDS, Rank.NINE);
  Cards cd10 = new Cards(Suit.DIAMONDS, Rank.TEN);
  Cards cdj = new Cards(Suit.DIAMONDS, Rank.JACK);
  Cards cdq = new Cards(Suit.DIAMONDS, Rank.QUEEN);
  Cards cdk = new Cards(Suit.DIAMONDS, Rank.KING);
  // CARDS WITH SUIT: CLUBS
  Cards cc1 = new Cards(Suit.CLUBS, Rank.ACE);
  Cards cc2 = new Cards(Suit.CLUBS, Rank.TWO);
  Cards cc3 = new Cards(Suit.CLUBS, Rank.THREE);
  Cards cc4 = new Cards(Suit.CLUBS, Rank.FOUR);
  Cards cc5 = new Cards(Suit.CLUBS, Rank.FIVE);
  Cards cc6 = new Cards(Suit.CLUBS, Rank.SIX);
  Cards cc7 = new Cards(Suit.CLUBS, Rank.SEVEN);
  Cards cc8 = new Cards(Suit.CLUBS, Rank.EIGHT);
  Cards cc9 = new Cards(Suit.CLUBS, Rank.NINE);
  Cards cc10 = new Cards(Suit.CLUBS, Rank.TEN);
  Cards ccj = new Cards(Suit.CLUBS, Rank.JACK);
  Cards ccq = new Cards(Suit.CLUBS, Rank.QUEEN);
  Cards cck = new Cards(Suit.CLUBS, Rank.KING);
  // CARDS WITH SUIT: HEARTS
  Cards ch1 = new Cards(Suit.HEARTS, Rank.ACE);
  Cards ch2 = new Cards(Suit.HEARTS, Rank.TWO);
  Cards ch3 = new Cards(Suit.HEARTS, Rank.THREE);
  Cards ch4 = new Cards(Suit.HEARTS, Rank.FOUR);
  Cards ch5 = new Cards(Suit.HEARTS, Rank.FIVE);
  Cards ch6 = new Cards(Suit.HEARTS, Rank.SIX);
  Cards ch7 = new Cards(Suit.HEARTS, Rank.SEVEN);
  Cards ch8 = new Cards(Suit.HEARTS, Rank.EIGHT);
  Cards ch9 = new Cards(Suit.HEARTS, Rank.NINE);
  Cards ch10 = new Cards(Suit.HEARTS, Rank.TEN);
  Cards chj = new Cards(Suit.HEARTS, Rank.JACK);
  Cards chq = new Cards(Suit.HEARTS, Rank.QUEEN);
  Cards chk = new Cards(Suit.HEARTS, Rank.KING);
  // CARDS WITH SUIT: SPADES
  Cards cs1 = new Cards(Suit.SPADES, Rank.ACE);
  Cards cs2 = new Cards(Suit.SPADES, Rank.TWO);
  Cards cs3 = new Cards(Suit.SPADES, Rank.THREE);
  Cards cs4 = new Cards(Suit.SPADES, Rank.FOUR);
  Cards cs5 = new Cards(Suit.SPADES, Rank.FIVE);
  Cards cs6 = new Cards(Suit.SPADES, Rank.SIX);
  Cards cs7 = new Cards(Suit.SPADES, Rank.SEVEN);
  Cards cs8 = new Cards(Suit.SPADES, Rank.EIGHT);
  Cards cs9 = new Cards(Suit.SPADES, Rank.NINE);
  Cards cs10 = new Cards(Suit.SPADES, Rank.TEN);
  Cards csj = new Cards(Suit.SPADES, Rank.JACK);
  Cards csq = new Cards(Suit.SPADES, Rank.QUEEN);
  Cards csk = new Cards(Suit.SPADES, Rank.KING);


  List<Cards> decks = List.of(cs6,
      cd9, chk,
      cs10, cs5, ch3,
      ch7, cd4, cs2, csq,
      cc10, cdj, ch2, cdq, cc8,
      cd7, ch8, cc4, chq, cd8, cs4,
      cck, cc3, chj, cd10, cdk, cs8, cd3,
      ch9, cc5, ch5, ccq, cc9,
      ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
      cd5, cs1, cc2, ch10, csj, ch1);

  List<Cards> mutiDecks = List.of(cs6,
      cd9, chk,
      cs10, cs5, ch3,
      ch7, cd4, cs2, csq,
      cc10, cdj, ch2, cdq, cc8,
      cd7, ch8, cc4, chq, cd8, cs4,
      cck, cc3, chj, cd10, cdk, cs8, cd3,
      ch9, cc5, ch5, ccq, cc9,
      ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
      cd5, cs1, cc2, ch10, csj, ch1,
      cs6,
      cd9, chk,
      cs10, cs5, ch3,
      ch7, cd4, cs2, csq,
      cc10, cdj, ch2, cdq, cc8,
      cd7, ch8, cc4, chq, cd8, cs4,
      cck, cc3, chj, cd10, cdk, cs8, cd3,
      ch9, cc5, ch5, ccq, cc9,
      ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
      cd5, cs1, cc2, ch10, csj, ch1);


  List<Cards> r0 = Collections.singletonList(cs6);
  List<Cards> r1 = Arrays.asList(cd9, chk);
  List<Cards> r2 = Arrays.asList(cs10, cs5, ch3);
  List<Cards> r3 = Arrays.asList(ch7, cd4, cs2, csq);
  List<Cards> r4 = Arrays.asList(cc10, cdj, ch2, cdq, cc8);
  List<Cards> r5 = Arrays.asList(cd7, ch8, cc4, chq, cd8, cs4);
  List<Cards> r6 = Arrays.asList(cck, cc3, chj, cd10, cdk, cs8, cd3);

  //Pyramid with 7 rows
  List<List<Cards>> pyramids =
      Arrays.asList(r0, r1, r2, r3, r4, r5, r6);
  //Pyramid with 3 rows
  List<List<Cards>> pyramids2 =
      Arrays.asList(r0, r1, r2);
  //Draws and Stocks
  List<Cards> drawPile = List.of(ch9, cc5, ch5, ccq, cc9);
  List<Cards> stocks = List
      .of(ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6, cd5, cs1,
          cc2, ch10, csj, ch1);

  List<Cards> emptyList = new ArrayList<>();
  List<Cards> nullList = Arrays.asList(null, null, null);

  //examples of games
  //Initial game
  PyramidSolitaireModel<Cards> initialGame = new BasicPyramidSolitaire();
  PyramidSolitaireModel<Cards> initialRelaxPyramid = new RelaxedPyramidSolitaire();
  PyramidSolitaireModel<Cards> initialMutiPyramid = new MultiPyramidSolitaire();

  //EXAMPLE OF INPUT
  //tips: \n is newline, \r is carriage return, \t is tab
  // =========== VALID CASE ===========
  //remove (7,1)
  String rm1Valid = "rm1 7 1\n";
  // remove (7,2) (7,4)
  String rm2ValidWSTabs = "rm2\n7 2\t7\r4\n";
  //game.removeUsingDraw(1, 6, 5); -- (1,7,5)
  String rmwdValid = "rmwd\n1\n7\n5\n";
  String ddValid = "dd 1\n";
  // =========== QUIT GAME ===========
  String rm1Q = "rm1 Q 7\n";
  // remove (7,3) (7,6)
  String rm2q = "rm2\n7 3\t7\rq\n";
  //game.removeUsingDraw(1, 6, 5); -- (1,7,5)
  String rmwdQuitquit = "rmwd\n1\nq\nQ\n";
  String ddq = "dd q\n";
  String quitFirst = "q\ndd 1";
  // =========== INVALID INPUT ===========
  String rm1Bogus = "rm1 7 -1\n";
  //CASE1: unexpected string
  String rm1Invalid = "rm1 7 w\n";
  // remove (7,3) (7,6)
  String rm2InvalidAllString = "rm2\na b\tc\rd\n";
  String rmwdInvalidQuit = "rmwd\ne\nq\n-10\n";
  //CASE2: wrong instruction of move specifier
  String rm1InValidMove = "rm 7 -7\n";
  String ddInvalid = "dq d\n";
  //CASE3: miss the argument
  String rm1InvalidMissArg = "rm1 7\n";
  String rmwdMoreArg = "rmwd 7 3 0 7 2\n";
  String ddInvalidMissArg = "dd \n";
  //CASE4：ALL INVALID
  String invalidNoMoveSpecifier = "7 1 7 3\n";
  String invalidAllString = "remove the row one with card 3\n";
  // =========== INVALID MOVE ===========
  String rm1MoveOverBound = "rm1 100 3\n";
  String rm1NotEqual13 = "rm1 7 7\n";
  String rm2NotExposedCard = "rm2 1\n3 1\t4\n";
  String rm2SameCard = "rm2 7 3 7 3\n";
  String rmwdNegIndex = "rmwd -100 7 3\n";
  String ddInvalidIndex = "dd -1\n";
  // =========== VALID MOVE WAITING ===========
  String rm1Wait = "rm1 7 x 0\n";
  String rm2Wait = "rm2 7 0\n7 1\n";
  String rmwdWait = "rmwd n 0 7 s 0\n";
  String ddWait = "dd quit wait 0\n";

  //Error Message due to invalid inputs
  String unexpectedInput = "\nInvalid input, please re-enter a valid one.";
  //Error Message due to invalid move
  String invalidValue = "Invalid move. Play again. *The value of card is not 13.*";
  String notExposed = "Invalid move. Play again. *The card is not exposed yet.*";
  String sameCard = "Invalid move. Play again. *The cards you selected is same.*";
  String notStartGame = "Invalid move. Play again. *The game is not started.*";
  String invalidIndex = "Invalid move. Play again. *must be a valid coordinate*";


  // ========== TEXTURAL VIEW ===========
  String row0 = "            6♠";
  String row1 = "          9♦  K♥";
  String row2 = "        10♠ 5♠  3♥";
  String row3 = "      7♥  4♦  2♠  Q♠";
  String row4 = "    10♣ J♦  2♥  Q♦  8♣";
  String row5 = "  7♦  8♥  4♣  Q♥  8♦  4♠";
  String row6 = "K♣  3♣  J♥  10♦ K♦  8♠  3♦"; //218 - 61 = 157;

  String row6rm1Updated = " .  3♣  J♥  10♦ K♦  8♠  3♦";
  String row6rm1rm2Updated = " .   .  J♥  .  K♦  8♠  3♦";
  String row6rmwdUpdated = " .   .   .  .  K♦  8♠  3♦";

  String draw = "Draw: 9♥, 5♣, 5♥, Q♣, 9♣";
  String drawAfterDiscard = "Draw: J♣, 5♣, 5♥, Q♣, 9♣";
  String score = "Score: 218";
  String gameBoard =
      row0 + "\n" + row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n" + row5 + "\n" + row6
          + "\n" + draw;
  String quitGame = gameBoard + "\n" + score;
  String invalidInput = "Invalid input, please re-enter a valid one.";
  String invalidSpecifier = "Please enter a valid remove specifier.";
  String testStrInvalidInput = gameBoard + "\n" + invalidInput;
  String gameOverLoss = "Game over. Score: ";
  String gameWon = "You win!";
  String quitStatement = "\nGame quit!\nState of game when quit:\n" + quitGame;
  String waitForValidSpecifier = "\nPlease enter a valid remove specifier.";


  // =========== TESTS THE ERROR HANDLING CASE OF START GAME ===========
  //Tests the case when a null model is passed to it
  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameNullModel() throws Exception {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(null, decks, false, 7, 3);
  }

  //Test the constructor for the controller when the Readable is null
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNullIn() {
    StringBuffer out = new StringBuffer();
    Reader in = null;
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, false, 7, 3);
  }

  //Test the constructor for the controller when the Appendable is null
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNullOut() {
    StringBuffer out = null;
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, false, 7, 3);
  }

  //If the Appendable object is unable to transmit output
  // or the Readable object is unable to provide inputs (for whatever reason)
  @Test(expected = IllegalStateException.class)
  public void testInvalidTransmit() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, false, 7, 3);
  }

  //Tests the case when a null deck is passed to it
  //throw the exception from the start game [model]
  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameNullDeck() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, null, false, 7, 3);
  }

  //Tests the case when a row number is over the deck size is passed to it
  //throw the exception from the start game [model]
  @Test(expected = IllegalStateException.class)
  public void testStartGameOverBoundRow() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, true, 700, 3);
  }

  //Tests the case when a row number is over the deck size is passed to it
  //throw the exception from the start game [model]
  @Test(expected = IllegalStateException.class)
  public void testStartGameOverBoundRowNeg() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, true, -1, 3);
  }

  //Tests the case when a row number is over the deck size is passed to it
  //throw the exception from the start game [model]
  @Test(expected = IllegalArgumentException.class)
  public void testStartGameOverBoundDraw() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, null, false, 7, 1000);
    assertEquals("The game cannot be started due to invalid parameters for start the game.",
        out.toString());
  }

  //Tests the case when a row number is over the deck size is passed to it
  //throw the exception from the start game [model]
  @Test(expected = IllegalStateException.class)
  public void testStartGameOverBoundDrawNeg() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, null, false, 7, -100);
    assertEquals("The game cannot be started due to invalid parameters for start the game.",
        out.toString());
  }

  //Tests the valid case by using controller to start the game of basic pyramid
  @Test
  public void testStartGameValidBasic() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm1 7 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialGame, decks, false, 7, 3);
    assertEquals(7, initialGame.getNumRows());
    assertEquals(3, initialGame.getNumDraw());
  }

  //Tests the valid case by using controller to start the game of basic pyramid
  @Test
  public void testStartGameValidRelax() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rm2 4 0 4\n4");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialRelaxPyramid, decks, true, 4, 1);
    assertEquals(4, initialRelaxPyramid.getNumRows());
    assertEquals(1, initialRelaxPyramid.getNumDraw());
  }

  //Tests the case when a row number is over the deck size is passed to it
  //throw the exception from the start game [model]
  @Test
  public void testStartGameValidMutiPyramid() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("rmwd 0 7 2");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(initialMutiPyramid, mutiDecks, true, 7, 3);
    assertEquals(7, initialMutiPyramid.getNumRows());
    assertEquals(3, initialMutiPyramid.getNumDraw());
  }

  @Test
  public void testQuit_InputType() {
    String actualOut = this.acturalOut(initialGame, decks, 7, 5, Interaction.inputs(quitFirst),
        Interaction.prints(row6rmwdUpdated));
    String gbEnd = gameBoard + quitStatement;
    assertEquals(gbEnd, actualOut);
  }

  @Test
  public void testQuit2() {
    String actualOut = this.acturalOut(initialGame, decks, 7, 5, Interaction.inputs(rm1Q),
        Interaction.prints(row6rmwdUpdated));
    String gbEnd = gameBoard + quitStatement;
    assertEquals(gbEnd, actualOut);
  }

  @Test
  public void testQuit3() {
    String actualOut = this.acturalOut(initialGame, decks, 7, 5, Interaction.inputs(rm2q),
        Interaction.prints(row6rmwdUpdated));
    String gbEnd = gameBoard + quitStatement;
    assertEquals(gbEnd, actualOut);
  }

  @Test
  public void testRM2() {
    String actualOut = this
        .acturalOut(initialGame, decks, 3, 3, Interaction.inputs("rm2\n3 1\t3\r3\n"),
            Interaction.prints(row6rmwdUpdated));
    String row0 = "    6♠";
    String row1 = "  9♦  K♥";
    String row2 = "10♠ 5♠  3♥";
    String d = "Draw: 7♥, 4♦, 2♠";
    String gb = row0 + "\n" + row1 + "\n" + row2 + "\n" + d;
    String r2 = " .   5♠  .";
    String gbEnd = gb + "\n" + row0 + "\n" + row1 + "\n" + r2 + "\n" + d;
    assertEquals(gbEnd, actualOut);
  }

  @Test
  public void testDiscardCard() {
    String actualOut = this.acturalOut(initialGame, decks, 3, 3, Interaction.inputs("dd 1"),
        Interaction.prints(row6rmwdUpdated));
    //The previouse state:
    String row0 = "    6♠";
    String row1 = "  9♦  K♥";
    String row2 = "10♠ 5♠  3♥";
    String d0 = "Draw: 7♥, 4♦, 2♠";
    String gb = row0 + "\n" + row1 + "\n" + row2 + "\n" + d0;

    String d = "Draw: Q♠, 4♦, 2♠";

    String gbEnd = gb + "\n" + row0 + "\n" + row1 + "\n" + row2 + "\n" + d;
    assertEquals(gbEnd, actualOut);
  }

  //checks the case when all cards are removed in the pyramid
  @Test
  public void testWon() {
    //define local game
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);

    List<Cards> deck = List.of(cdk, cc3, cd10, chj, cs6,
        cd9, chk,
        cs10, cs5, ch3,
        ch7, cd4, cs2, csq,
        cc10, cdj, ch2, cdq, cc8,
        cd7, ch8, cc4, chq, cd8, cs4,
        cck, cs8, cd3,
        ch9, cc5, ch5, ccq, cc9,
        ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
        cd5, cs1, cc2, ch10, csj, ch1);

    PyramidSolitaireModel<Cards> game = new BasicPyramidSolitaire(deck, 2, 5, stocks,
        winMock, drawPile, true);

    String actualOut = this.acturalOut(game, deck, 2, 5, Interaction.inputs("rm2 2 1 2 2\n"),
        Interaction.prints(row6rmwdUpdated),
        Interaction.inputs("rm1 1 1\n"),
        Interaction.prints(row6rmwdUpdated));

    assertEquals("  K♦\n"
        + "3♣  10♦\n"
        + "Draw: J♥, 6♠, 9♦, K♥, 10♠\n"
        + "  K♦\n"
        + " .   .\n"
        + "Draw: J♥, 6♠, 9♦, K♥, 10♠\n"
        + "You win!\n", actualOut);

    assertEquals(0, game.getScore());
  }

  @Test
  public void testBogus() {

    String actualOut = this
        .acturalOut(initialGame, decks, 3, 3, Interaction.inputs("rm2 s -12 3 1\t3\n"
                + "3\n"),
            Interaction.prints(row6rmwdUpdated));
    String row0 = "    6♠";
    String row1 = "  9♦  K♥";
    String row2 = "10♠ 5♠  3♥";
    String d = "Draw: 7♥, 4♦, 2♠";
    String gb = row0 + "\n" + row1 + "\n" + row2 + "\n" + d;
    String r2 = " .   5♠  .";
    String gbEnd =
        gb + "\n" + invalidInput + "\n" + gb + "\n" + invalidInput + "\n" + row0 + "\n" + row1
            + "\n" + r2 + "\n" + d + "\n";
    String gbEnd2 =
        gb + "\n" + row0 + "\n" + row1 + "\n" + r2 + "\n" + d + "\n";
    assertEquals(gbEnd2, actualOut);
  }

  @Test
  public void testBogus2() {

    String actualOut = this
        .acturalOut(initialGame, decks, 3, 3, Interaction.inputs("rm2 -1 3 h 1\t3\n"
                + "3\n"),
            Interaction.prints(row6rmwdUpdated));
    String row0 = "    6♠";
    String row1 = "  9♦  K♥";
    String row2 = "10♠ 5♠  3♥";
    String d = "Draw: 7♥, 4♦, 2♠";
    String gb = row0 + "\n" + row1 + "\n" + row2 + "\n" + d;
    String r2 = " .   5♠  .";
    String gbEnd =
        gb + "\n" + invalidInput + "\n" + gb + "\n" + invalidInput + "\n" + row0 + "\n" + row1
            + "\n" + r2 + "\n" + d + "\n";
    String gbEnd2 =
        gb + "\n" + row0 + "\n" + row1 + "\n" + r2 + "\n" + d + "\n";
    assertEquals(gbEnd2, actualOut);
  }

  @Test
  public void testGameOverLossThroughController() {

    String actualOut = this
        .acturalOut(initialGame, decks, 3, 3, Interaction.inputs("rm2 -1 3 h 1\t3\n"
                + "3\n"),
            Interaction.prints(row6rmwdUpdated));
    String row0 = "    6♠";
    String row1 = "  9♦  K♥";
    String row2 = "10♠ 5♠  3♥";
    String d = "Draw: 7♥, 4♦, 2♠";
    String gb = row0 + "\n" + row1 + "\n" + row2 + "\n" + d;
    String r2 = " .   5♠  .";
    String gbEnd =
        gb + "\n" + invalidInput + "\n" + gb + "\n" + invalidInput + "\n" + row0 + "\n" + row1
            + "\n" + r2 + "\n" + d + "\n";
    String gbEnd2 =
        gb + "\n" + row0 + "\n" + row1 + "\n" + r2 + "\n" + d + "\n";
    assertEquals(gbEnd2, actualOut);
  }


  @Test
  public void testValidMoveWithMoreInputsLose() {
    String actualOut = this
        .acturalOut(initialGame, decks, 6, 7,
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 1\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 2\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 3\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 4\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 5\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 6\n"),
            Interaction.prints(row6rmwdUpdated),
            Interaction.inputs("dd 7\n"),
            Interaction.prints(row6rmwdUpdated));
    //The previouse state:
    String d0 = "Draw: K♣, 3♣, J♥, 10♦, K♦, 8♠, 3♦";
    String gameBoard =
        row0 + "\n" + row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n" + row5
            + "\n" + d0 + "\n" + gameOverLoss + "157\n";
    assertEquals(gameBoard, actualOut);
  }

  // =========== TEST VALID CASE ===========

  //Tests with Interaction methods
  /*@Test
  public void testValidInput() {
    System.out.println(initialGame);
    this.testRun(initialGame,
        Interaction.inputs(rm1Valid),
        Interaction.prints(gameBoard),
        Interaction.inputs(rm2ValidWSTabs),
        Interaction.prints("Expect output"),
        Interaction.inputs("rm1 7 5\n"),
        Interaction.prints("Expect output"),
        Interaction.inputs("rmwd 2 7 6\n"),
        Interaction.prints("Expect output"),
        Interaction.inputs("rmwd 3 6 5\n"),
        Interaction.prints("Expect output"),
        Interaction.inputs("dd 3\n"),
        Interaction.prints("Expect output"),
        Interaction.inputs("dd 5\n"),
        Interaction.prints("Expect output"));
  }*/

  /**
   * Interaction method for testing the controller of certain cases.
   *
   * @param model        the model of the Pyramid Solitaire
   * @param interactions the interaction between the user's input and controller
   */
  public void testRun(PyramidSolitaireModel<Cards> model, Interaction... interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireController controller = new PyramidSolitaireTextualController(input,
        actualOutput);
    controller.playGame(model, decks, false, 7, 5);
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }


  List<List<Cards>> pyramidsForEndGame = List
      .of(Collections.singletonList(cs6), Arrays.asList(cd9, chk), Arrays.asList(cs10, csk, ch3));
  List<Cards> drawForEndGame = List.of(cs1, cs10);
  List<List<Cards>> exposedList = List.of(Collections.singletonList(cs6), Arrays.asList(cs10, ch3));


  //Invalid end game examples:
  //empty stocks, but draws is still available
  PyramidSolitaireModel<Cards> endGame1 = new BasicPyramidSolitaire(decks,
      7, 5, emptyList,
      pyramids, drawPile, true);
  //no discards, but possible moves with pairs in the pyramid
  PyramidSolitaireModel<Cards> endGame2 = new BasicPyramidSolitaire(decks,
      2, 2, emptyList,
      exposedList, nullList, true);
  //no discards, but possible moves: move using draws
  PyramidSolitaireModel<Cards> endGame3 = new BasicPyramidSolitaire(decks,
      3, 2, emptyList,
      pyramidsForEndGame, drawForEndGame, true);


  private String acturalOut(PyramidSolitaireModel<Cards> model, List<Cards> deck, int numRows,
      int numDraw,
      Interaction... interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireController controller = new PyramidSolitaireTextualController(input,
        actualOutput);
    controller.playGame(model, deck, false, numRows, numDraw);
    return actualOutput.toString();
  }

}