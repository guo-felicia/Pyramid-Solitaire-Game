import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;


/**
 * Tests for MutiPyramidSolitaireTest.
 */
public class MutiPyramidSolitaireTest {

  // =======================EXAMPLES========================


  // CARDS WITH SUIT: DIAMONDS
  public Cards cd1 = new Cards(Suit.DIAMONDS, Rank.ACE);
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

  // ==================================

  List<Cards> emptyList = new ArrayList<>();
  List<Cards> nullList = Arrays.asList(null, null, null);
  List<Cards> invalidDecks = List.of(ccj, csk, ch4, cc7, cd1, ccj, csk, ch4, cc7, cd1);

  List<Cards> decks = List.of(cs6,
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

  List<Cards> row0 = Arrays.asList(ccj, null, null, ch5, null, null, ch7);
  List<Cards> row1 = Arrays.asList(ch9, cd10, null, chq, ch10, null, cc3, ch6);
  List<Cards> row2 = Arrays.asList(cd3, cc8, ch1, ch4, cs4, chk, cs6, cd3, cs10);
  List<Cards> row3 = Arrays.asList(cdq, ch5, csj, cd9, cs9, cd7, cs3, cc8, cs4, cc5);
  List<Cards> row4 = Arrays.asList(ch1, cck, cs3, ch8, cs1, ch9, cc3, csq, ch3, cc4, ch10);
  List<Cards> row5 = Arrays.asList(cd8, cdq, cdk, cs2, cs1, cc6, cs8, cd1, ch3, cc6, cs2, cc7);
  List<Cards> row6 = Arrays
      .asList(cdk, csj, cdj, cs5, ccq, cs8, cs10, ch2,
          csk, cs5, cd9, cd7, csq);

  List<List<Cards>> mutiPyramids =
      Arrays.asList(row0, row1, row2, row3, row4, row5, row6);
  List<Cards> mutiDrawPile = List.of(chk, cd5, cc10);
  List<Cards> mutiStocks = List
      .of(cd2, cd4, cd6, cc2, cc3, cc9, chj, cs7,
          cd2, cd4, cd6, cc2, cc3, cc9, chj, cs7,
          ccj, ch7, cd10, chq, ch6, ch4, cs6, cs9,
          cc5, cck, ch8, cc4, cd8, cd1, cc7, cdj,
          ccq, ch2, csk, cd5, cc10, cc1, cc1, cdk);

  PyramidSolitaireModel<Cards> initialGame = new MultiPyramidSolitaire();
  PyramidSolitaireModel<Cards> gameStarted = new MultiPyramidSolitaire();
  PyramidSolitaireModel<Cards> gameRow7 = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
      mutiPyramids, mutiDrawPile, true);

  List<Cards> r0 = Arrays.asList(cs6, null, cd9, null, chk); //28
  List<Cards> r1 = Arrays.asList(cs10, cs5, ch3, ch7, cd4, cs2); //31
  List<Cards> r2 = Arrays.asList(csq, cc10, cdj, ch2, cdq, cc8, cd7); //62
  List<Cards> r3 = Arrays.asList(ch8, cc4, chq, cd8, cs4, cck, cc3, chj); //63
  List<List<Cards>> mutiPyramids2 =
      Arrays.asList(r0, r1, r2, r3);
  List<Cards> mutiDrawPile2 = List.of(cd10, cdk, cs8);
  List<Cards> mutiStocks2 = List.of(cd3,
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

  PyramidSolitaireModel<Cards> gameRow4 = new MultiPyramidSolitaire(decks, 4, 1, mutiStocks2,
      mutiPyramids2, mutiDrawPile2, true);

  //Invalid end game examples:
  //empty stocks, but draws is still available
  PyramidSolitaireModel<Cards> endGame1 = new BasicPyramidSolitaire(decks,
      7, 5, emptyList,
      mutiPyramids, mutiDrawPile, true);
  //no discards, but possible moves with pairs in the pyramid
  PyramidSolitaireModel<Cards> endGame2 = new BasicPyramidSolitaire(decks,
      4, 3, emptyList,
      mutiPyramids2, mutiDrawPile2, true);
  //no discards, but possible moves: move using draws
  PyramidSolitaireModel<Cards> endGame3 = new BasicPyramidSolitaire(decks,
      3, 2, emptyList,
      mutiPyramids2, mutiDrawPile2, true);

  //========TEST============

  //Test start the game
  //CHECK THE EXCEPTION CASE
  //checks if the list of decks contains duplication
  // and not has regular length (must contains 52 cards)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDecks() {
    initialGame.startGame(invalidDecks, false, 7, 3);
  }

  // checks if the list of decks is empty
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyDecks() {
    initialGame.startGame(emptyList, false, 7, 3);
  }

  // checks if the deck is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullDecks() {
    initialGame.startGame(null, false, 7, 3);
  }

  // the number of pyramid rows is non-positive : 0 or negative
  @Test(expected = IllegalArgumentException.class)
  public void testRowZero() {
    initialGame.startGame(decks, true, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowNeg() {
    initialGame.startGame(decks, true, -100, 3);
  }

  // the number of draw cards available at a time is negative
  @Test(expected = IllegalArgumentException.class)
  public void testDrawNumNeg() {
    initialGame.startGame(decks, true, 4, -7);
  }

  // the number of draw cards and row number available at a time is both negative
  @Test(expected = IllegalArgumentException.class)
  public void testDrawNumNeg2() {
    initialGame.startGame(decks, true, -4, -7);
  }

  // the full pyramid and draw pile cannot be dealt with the number of given cards in deck
  @Test(expected = IllegalArgumentException.class)
  public void testOverSize() {
    initialGame.startGame(decks, true, 10, 12);
  }

  //CHECK THE VALID CASE of START GAME
  @Test
  public void startGameValidOddRows() {
    //modify the game states
    initialGame.startGame(decks, false, 7, 3);
    //tests the fields to verifying the updating
    assertEquals(104, initialGame.getDeck().size());
    assertEquals(7, initialGame.getNumRows());
    assertEquals(3, initialGame.getNumDraw());
    assertEquals(7, initialGame.getRowWidth(0));
    assertEquals(10, initialGame.getRowWidth(3));
    assertEquals(13, initialGame.getRowWidth(6));
  }

  //CHECK THE VALID CASE of START GAME
  @Test
  public void startGameValidEvenRows() {
    //modify the game states
    initialGame.startGame(decks, false, 2, 1);
    //tests the fields to verifying the updating
    assertEquals(104, initialGame.getDeck().size());
    assertEquals(2, initialGame.getNumRows());
    assertEquals(1, initialGame.getNumDraw());
    assertEquals(3, initialGame.getRowWidth(0));
    assertEquals(4, initialGame.getRowWidth(1));
  }

  //CHECK THE VALID CASE of START GAME
  @Test
  public void startGameValidEvenRows2() {
    //modify the game states
    initialGame.startGame(decks, false, 4, 3);
    //tests the fields to verifying the updating
    assertEquals(104, initialGame.getDeck().size());
    assertEquals(4, initialGame.getNumRows());
    assertEquals(3, initialGame.getNumDraw());
    assertEquals(5, initialGame.getRowWidth(0));
    assertEquals(7, initialGame.getRowWidth(2));
    assertEquals(8, initialGame.getRowWidth(3));
  }

  //Test getDeck valid method
  @Test
  public void getDeck() {
    String deckStr = "[A♦, A♣, A♥, A♠, 2♦, 2♣, 2♥, 2♠, 3♦, 3♣, 3♥, 3♠, 4♦, 4♣, 4♥, 4♠, "
        + "5♦, 5♣, 5♥, 5♠, 6♦, 6♣, 6♥, 6♠, 7♦, 7♣, 7♥, 7♠, 8♦, 8♣, 8♥, 8♠, 9♦, 9♣, 9♥, 9♠, "
        + "10♦, 10♣, 10♥, 10♠, J♦, J♣, J♥, J♠, Q♦, Q♣, Q♥, Q♠, K♦, K♣, K♥, K♠, "
        + "A♦, A♣, A♥, A♠, 2♦, 2♣, 2♥, 2♠, 3♦, 3♣, 3♥, 3♠, 4♦, 4♣, 4♥, 4♠, 5♦, 5♣, 5♥, 5♠, "
        + "6♦, 6♣, 6♥, 6♠, 7♦, 7♣, 7♥, 7♠, 8♦, 8♣, 8♥, 8♠, 9♦, 9♣, 9♥, 9♠, 10♦, 10♣, 10♥, 10♠, "
        + "J♦, J♣, J♥, J♠, Q♦, Q♣, Q♥, Q♠, K♦, K♣, K♥, K♠]";
    assertEquals(deckStr, initialGame.getDeck().toString());
    assertEquals(104, initialGame.getDeck().size());
  }

  //Test getCardAt valid method
  @Test
  public void getCardAtTest1() {
    assertEquals(ccj, gameRow7.getCardAt(0, 0));
    assertEquals(null, gameRow7.getCardAt(0, 1));
  }

  @Test
  public void getCardAtTest2() {
    assertEquals(null, gameRow7.getCardAt(0, 1));
  }

  //Test start Game valid method
  @Test
  public void startMutiGame() {
    initialGame.startGame(decks, true, 7, 3);
    assertEquals(3, initialGame.getNumDraw());
    assertEquals(7, initialGame.getNumRows());
    assertEquals(111, initialGame.getScore());
  }

  //Test getRowWidth valid test for the first row
  @Test
  public void getRowWidthNumRow1() {
    initialGame.startGame(decks, false, 1, 10);
    assertEquals(1, initialGame.getRowWidth(0));
  }

  //Test getRowWidth valid test for the first row
  @Test
  public void getRow0Width() {
    //3 -- miss 4 should be 7
    initialGame.startGame(decks, false, 7, 3);
    assertEquals(7, initialGame.getRowWidth(0));
  }

  //Test getRowWidth valid test for the first row that overlaps
  @Test
  public void getRowFirstRowOverlapWidth() {
    //6 -- miss 4
    initialGame.startGame(decks, false, 7, 3);
    assertEquals(10, initialGame.getRowWidth(3));
  }

  //Test getRowWidth valid test for the first row that overlaps
  @Test
  public void getRow7Width() {
    initialGame.startGame(decks, false, 7, 3);
    assertEquals(13, initialGame.getRowWidth(6));
  }

  //checks the case for valid approach
  @Test
  public void getRowWidthNumRow4() {
    //gameStarted.startGame(decks, false, 4, 1);
    //assertEquals(5, gameStarted.getRowWidth(0));
    assertEquals(5, gameRow4.getRowWidth(0));
  }

  //checks when the numRow is 4, the first row of overlap is row = 2
  //where the width of row = 2 should be 7
  @Test
  public void getRowWidthNumRowEven() {
    gameStarted.startGame(decks, false, 4, 1);
    assertEquals(7, gameStarted.getRowWidth(2));
  }

  //Tests for getRowWidth(int row) INVALID APPROACH
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void getRowWidthInvalid() {
    initialGame.getRowWidth(0);
  }

  //checks the case where the game is started but the row is invalid
  //where the maximum numRow is 7
  @Test(expected = IllegalArgumentException.class)
  public void getRowWidthInvalidRow1() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.getRowWidth(70);
  }

  //where the maximum numRow is 7
  @Test(expected = IllegalArgumentException.class)
  public void getRowWidthInvalidRow2() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.getRowWidth(-7);
  }


  //TEST THE CASE WHERE IT IS PASSED IN RELAX MODEL BUT SHOULD FAIL IN BASIC MODEL
  List<Cards> relexR0 = Arrays.asList(cs4, cd8, chq);
  List<Cards> relexR1 = Arrays.asList(cd9, chk, cs1, cd3, ch10, cc2);
  List<List<Cards>> relaxedPyramids = Arrays.asList(relexR0, relexR1);

  PyramidSolitaireModel<Cards> gameRelax = new MultiPyramidSolitaire(decks, 2, 3, emptyList,
      relaxedPyramids, nullList, true);

  //Test the removePair removing the cards that one card is covered by another card
  //SHOULD THROW EXCEPTION : IllegalArgumentException("The card is not exposed yet.")
  @Test(expected = IllegalArgumentException.class)
  public void testRm2RelaxBelow() {
    gameRelax.remove(1, 1);
    gameRelax.remove(1, 0, 0, 0);
    assertNull(gameRelax.getCardAt(1, 1));
    assertNull(gameRelax.getCardAt(0, 0));
    assertNull(gameRelax.getCardAt(1, 0));
  }

  //Test the game over where the remaining two cards can be removed due to the relaxed rule
  @Test
  public void testIsGameOverRelaxValid() {
    gameRelax.remove(1, 1);
    assertEquals(37, gameRelax.getScore());
    assertTrue(gameRelax.isGameOver());
  }

  //Tests for isGameOver()
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void isGameOverInvalidTest() {
    initialGame.isGameOver();
  }

  //Invalid end game examples:
  //empty stocks, but draws is still available
  @Test
  public void isGameOverTest1() {
    assertFalse(endGame1.isGameOver());
  }

  //no discards, but possible moves : pairs in pyramids
  @Test
  public void isGameOverTest2() {
    assertFalse(endGame2.isGameOver());
  }

  //no discards, but possible moves: move using draws
  @Test
  public void isGameOverTest3() {
    assertFalse(endGame3.isGameOver());
  }


  //possible discards, but no moves
  @Test
  public void isGameOverTest4() {
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);
    //possible discards, but no moves
    PyramidSolitaireModel<Cards> endGame4 = new BasicPyramidSolitaire(decks,
        4, 5, mutiStocks2,
        winMock, mutiDrawPile, true);
    assertFalse(endGame4.isGameOver());
  }

  //Valid end game : there are no more removes possible AND no more draw cards to discard.
  @Test
  public void isGameOverTest5() {
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);
    //Valid end game : there are no more removes possible AND no more draw cards to discard.
    PyramidSolitaireModel<Cards> endGame5 = new BasicPyramidSolitaire(decks,
        2, 3, emptyList,
        winMock, nullList, true);
    assertTrue(endGame5.isGameOver());
  }

  //Test the case
  @Test
  public void isGameOverTest6() {
    PyramidSolitaireModel<Cards> game6 = new BasicPyramidSolitaire(decks,
        7, 3, emptyList, mutiPyramids, nullList, true);
    assertFalse(game6.isGameOver());
  }


  //TEST OTHER METHODS IN ABSTRACT CLASS
  //Tests for the getNumRows
  //checks the case where the game has not started
  @Test
  public void getNumRowsInvalidTest() {
    assertEquals(-1, initialGame.getNumRows());
  }

  //checks the case where the game is started
  @Test
  public void getNumRowsValidTest() {
    //1.define local variable
    PyramidSolitaireModel<Cards> initialGame0 = new MultiPyramidSolitaire();

    //2.modify the game states
    initialGame0.startGame(decks, true, 4, 2);

    //Tests the methods
    assertEquals(4, initialGame0.getNumRows());
  }

  //Tests for getNumDraw
  //checks the case where the game has not started
  @Test
  public void getNumDrawInvalidTest() {
    assertEquals(-1, initialGame.getNumDraw());
  }

  //checks the case where the game is started
  //where the maximum numDraws is 5 due to the numDraw of startGame;
  @Test
  public void getNumDrawValidTest() {
    //1.define local variable
    PyramidSolitaireModel<Cards> initialGame0 = new MultiPyramidSolitaire();

    //2.modify the game states
    initialGame0.startGame(decks, false, 6, 5);

    //Tests the methods
    assertEquals(5, initialGame0.getNumDraw());
  }

  //checks the case when the stock is empty
  @Test
  public void getNumDrawValidTest2() {
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, emptyList,
        mutiPyramids, nullList, true);
    assertEquals(3, game.getNumDraw());
  }

  //checks the case when the stock is empty
  @Test
  public void getNumDrawValidTest3() {
    nullList.set(0, cc1);
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, emptyList,
        mutiPyramids, nullList, true);
    assertEquals(3, game.getNumDraw());
  }


  //Tests for getScore()
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void getScoreInvalidTest() {
    initialGame.getScore();
  }

  //checks the case for valid approach
  @Test
  public void getScoreValidTest() {
    gameStarted.startGame(decks, false, 7, 5);
    assertEquals(205, gameStarted.getScore());
  }

  //checks the case when all cards are removed in the pyramid
  @Test
  public void getScoreWinTest() {
    //define local game
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    r0.add(null);
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    r1.add(null);
    r1.add(null);
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 2, 5, mutiStocks,
        winMock, mutiDrawPile, true);
    assertEquals(0, game.getScore());
  }

  //Test the game over where the remaining two cards can be removed due to the relaxed rule
  @Test
  public void testGetScore() {
    gameRelax.remove(1, 1);
    assertEquals(13, gameRelax.getScore());
  }

  //Test for the normal case where numRow = 7
  @Test
  public void getScoreNumRowOdd7() {
    assertEquals(452, gameRow7.getScore());
  }

  //Test for the normal case where numRow = 4
  @Test
  public void getScoreNumRowEven4() {
    assertEquals(184, gameRow4.getScore());
  }


  //Test for the normal case where numRow = 7 after the rm2
  @Test
  public void getScoreNumRowOdd7AfterRM2() {
    gameRow7.remove(6, 1, 6, 7);
    assertEquals(439, gameRow7.getScore());
  }

  // ==== TEST FOR REMOVE METHOD ========
  //Tests for remove(int row1, int card1, int row2, int card2)
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void removeInvalidGame() {
    initialGame.remove(7, 3, 7, 7);
  }

  //checks the case where the game is started but the attempted remove is invalid
  // case1: where the selected column is not valid
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove1() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(7, 13, 7, 7);
  }

  //NEED TO MODIFY THE EXAMPLES
  // case2: where the sum of two selected cards is not equal to 13
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove2() {
    //1.define local variable
    PyramidSolitaireModel<Cards> gameInitial = new BasicPyramidSolitaire();

    //2.modify the game states
    gameInitial.startGame(decks, false, 7, 3);

    //Tests the remove method
    gameInitial.remove(7, 1, 7, 2);
  }

  // case3: where the two selected cards is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove3() {
    //1.define local variable
    PyramidSolitaireModel<Cards> gameInitial = new BasicPyramidSolitaire();

    //2.modify the game states
    gameInitial.startGame(decks, false, 6, 4);

    //Tests the remove method
    gameInitial.remove(3, 1, 4, 2);
  }

  //checks the case where the game is started but the attempted remove is invalid
  // case4: where the two coordinates is point to the same card
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove4() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(7, 13, 7, 13);
  }

  //CHECK THE VALID APPROACH
  @Test
  public void removeValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
        mutiPyramids, mutiDrawPile, true);
    //2.modify the game states
    game.remove(6, 1, 6, 7);
    //3.tests the fields to verifying the updating
    assertEquals(439, game.getScore());
  }


  //Tests for remove(int row, int card)
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void removeSingleInvalidGame() {
    initialGame.remove(10, 0);
  }

  //checks the case where the game is started but the attempted remove is invalid
  // case1: where the selected column is not valid
  @Test(expected = IllegalArgumentException.class)
  public void removeSingleInvalidMove1() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(7, -1);
  }

  // case2: where the selected card is not equal to 13
  @Test(expected = IllegalArgumentException.class)
  public void removeSingleInvalidMove2() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(7, 6);
  }

  // case3: where the selected card is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void removeSingleInvalidMove3() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(0, 0);
  }

  //CHECK THE VALID APPROACH
  @Test
  public void removeSingleValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
        mutiPyramids, mutiDrawPile, true);
    //2.modify the game states
    game.remove(6, 8);
    //3.tests the fields to verifying the updating
    assertEquals(439, game.getScore());
  }


  //Tests for removeUsingDraw(int drawIndex, int row, int card)
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void removeUsingDrawInvalidGame() {
    initialGame.removeUsingDraw(0, 5, 2);
  }

  //checks the case where the game is started but the attempted remove is invalid
  // case1: where the index is not valid : neg / over the size of numDraws
  @Test(expected = IllegalArgumentException.class)
  public void removeUsingDrawNegIndex() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.removeUsingDraw(-10, 5, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void removeUsingDrawBigIndex() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.removeUsingDraw(7, 4, 0);
  }

  // case2: where the selected two cards are not equal to 13
  @Test(expected = IllegalArgumentException.class)
  public void removeUsingDrawInvalidMove2() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.removeUsingDraw(2, 7, 5);
  }

  // case3: where the selected card is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void removeUsingDrawInvalidMove3() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.removeUsingDraw(0, 3, 1);
  }

  //CHECK THE VALID APPROACH
  @Test
  public void removeUsingDrawValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
        mutiPyramids, mutiDrawPile, true);
    //2.modify the game states
    game.removeUsingDraw(1, 6, 5);
    //3.tests the fields to verifying the updating
    assertEquals(444, game.getScore());
    assertEquals(3, game.getNumDraw());
  }

  //Tests for discardDraw(int drawIndex)
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void discardDrawInvalidGame() {
    initialGame.discardDraw(0);
  }

  //checks the case where the game is started but the attempted remove is invalid
  // case1: where the index is negative
  @Test(expected = IllegalArgumentException.class)
  public void discardDrawNegIndex() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.discardDraw(-2);
  }

  // case1: where the index is over the numDraw
  @Test(expected = IllegalArgumentException.class)
  public void removeUsingBigIndex() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.discardDraw(100);
  }

  //CHECK THE VALID APPROACH
  @Test
  public void discardDrawValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
        mutiPyramids, mutiDrawPile, true);
    //2.modify the game states
    game.discardDraw(2);
    //3.tests the fields to verifying the updating
    assertEquals(452, game.getScore());
    assertEquals(5, game.getNumDraw()); // QUESTION - directly filled by stock?
  }

  //TEST METHODS IN ABSTRACT CLASS WORKS WELL

  //Tests for getCardAt(int row, int card)
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void getCardAtInvalidGame() {
    initialGame.getCardAt(0, 0);
  }

  //checks the case where the game is started but the coordinates is invalid
  @Test(expected = IllegalArgumentException.class)
  public void getCardAtInvalidRow() {
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.getCardAt(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getCardAtInvalidCard() {
    //width of the first row is 7
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.getCardAt(0, 14);
  }

  //checks the case for valid approach where there is no card at the coordinate
  @Test
  public void getCardAtTestNull() {
    // modify the game state
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.remove(6, 3, 6, 6);
    assertNull(gameStarted.getCardAt(6, 3));
    assertNull(gameStarted.getCardAt(6, 6));
  }

  //Tests for getDrawCards()
  //checks the case where the game has not started IllegalStateException
  @Test(expected = IllegalStateException.class)
  public void getDrawCardsInvalid() {
    initialGame.getDrawCards();
  }

  //  List<Cards> drawPile = Arrays.asList(c1,c2,c3,c4);
  //checks the case for valid approach
  @Test
  public void getDrawCardsTest() {
    List<Cards> mutiDrawPile = List.of(chq, cd8, cs4);
    gameStarted.startGame(decks, false, 7, 3);
    assertEquals(mutiDrawPile, gameStarted.getDrawCards());
  }

  //checks the case for valid approach where there is no card at the coordinate
  @Test
  public void getDrawCardsTest2() {
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, mutiStocks,
        mutiPyramids, nullList, true);
    assertEquals(nullList, game.getDrawCards());
  }

  //checks the case when the stock is empty
  @Test
  public void getDrawCardsTest3() {
    PyramidSolitaireModel<Cards> game = new MultiPyramidSolitaire(decks, 7, 3, emptyList,
        mutiPyramids, nullList, true);
    assertEquals(nullList, game.getDrawCards());
  }

}