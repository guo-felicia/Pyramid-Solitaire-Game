import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;


/**
 * Tests for RelaxedPyramidSolitaireTest.
 */
public class RelaxedPyramidSolitaireTest {
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

  List<Cards> row0 = Collections.singletonList(cs6);
  List<Cards> row1 = Arrays.asList(cd9, chk);
  List<Cards> row2 = Arrays.asList(cs10, cs5, ch3);
  List<Cards> row3 = Arrays.asList(ch7, cd4, cs2, csq);
  List<Cards> row4 = Arrays.asList(cc10, cdj, ch2, cdq, cc8);
  List<Cards> row5 = Arrays.asList(cd7, ch8, cc4, chq, cd8, cs4);
  List<Cards> row6 = Arrays.asList(cck, cc3, chj, cd10, cdk, cs8, cd3);

  List<List<Cards>> pyramids =
      Arrays.asList(row0, row1, row2, row3, row4, row5, row6);
  List<Cards> drawPile = List.of(ch9, cc5, ch5, ccq, cc9);
  List<Cards> stocks = List
      .of(ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6, cd5, cs1,
          cc2, ch10, csj, ch1);

  // =====================================================
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

  //Examples of invalid decks
  List<Cards> emptyList = new ArrayList<>();
  List<Cards> invalidDecks = List.of(ccj, csk, ch4, cc7, cd1, ccj, csk, ch4, cc7, cd1);
  //Examples of valid cards
  List<Cards> nullList = Arrays.asList(null, null, null);
  List<List<Cards>> pyramidsForEndGame = List
      .of(Collections.singletonList(cs6), Arrays.asList(cd9, chk), Arrays.asList(cs10, csk, ch3));
  List<Cards> drawForEndGame = List.of(cs1, cs10);
  List<List<Cards>> exposedList = List.of(Collections.singletonList(cs6), Arrays.asList(cs10, ch3));

  //Invalid end game examples:
  //empty stocks, but draws is still available
  PyramidSolitaireModel<Cards> endGame1 = new RelaxedPyramidSolitaire(decks,
      7, 5, emptyList,
      pyramids, drawPile, true);
  //no discards, but possible moves with pairs in the pyramid
  PyramidSolitaireModel<Cards> endGame2 = new RelaxedPyramidSolitaire(decks,
      2, 2, emptyList,
      exposedList, nullList, true);
  //no discards, but possible moves: move using draws
  PyramidSolitaireModel<Cards> endGame3 = new RelaxedPyramidSolitaire(decks,
      3, 2, emptyList,
      pyramidsForEndGame, drawForEndGame, true);

  // ==================================

  List<Cards> relaxDrawPile = Arrays.asList(cs10, cs5, ch3);
  List<Cards> relaxStocks = List
      .of(ch7, cd4, cs2, csq,
          cc10, cdj, ch2, cdq, cc8,
          cd7, ch8, cc4, chq, cd8, cs4,
          cck, cc3, chj, cd10, cdk, cs8, cd3,
          ch9, cc5, ch5, ccq, cc9, ccj,
          csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
          cd5, cs1,
          cc2, ch10, csj, ch1);

  List<Cards> relaxDrawPile2 = List.of(ch7, cd4, cs2);
  List<Cards> relaxStocks2 = List
      .of(csq,
          cc10, cdj, ch2, cdq, cc8,
          cd7, ch8, cc4, chq, cd8, cs4,
          cck, cc3, chj, cd10, cs5, cs8, cd3,
          ch9, cc5, ch5, ccq, cc9, ccj,
          csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
          cd5, cs1,
          cc2, ch10, csj, ch1);

  PyramidSolitaireModel<Cards> initialGame = new RelaxedPyramidSolitaire();
  PyramidSolitaireModel<Cards> gameStarted = new RelaxedPyramidSolitaire();

  List<Cards> relexR0 = Collections.singletonList(cs4);
  List<Cards> relexR1 = Arrays.asList(cd9, chk);
  List<Cards> relexR2 = Arrays.asList(cs10, cdk, ch3);
  List<List<Cards>> relaxedPyramids = Arrays.asList(relexR0, relexR1);
  List<List<Cards>> relaxedPyramids2 = Arrays.asList(relexR0, relexR1, relexR2);

  PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 2, 3, relaxStocks,
      relaxedPyramids, relaxDrawPile, true);

  PyramidSolitaireModel<Cards> game2 = new RelaxedPyramidSolitaire(decks, 3, 3, relaxStocks2,
      relaxedPyramids2, relaxDrawPile2, true);

  List<Cards> relexR0g3 = Collections.singletonList(cs4);
  List<Cards> relexR1g3 = Arrays.asList(chk, cs10);
  List<Cards> relexR2g3 = Arrays.asList(cd9, cdk, ch3);
  List<List<Cards>> relaxedPyramids3 = Arrays.asList(relexR0g3, relexR1g3, relexR2g3);
  PyramidSolitaireModel<Cards> game3 = new RelaxedPyramidSolitaire(decks, 3, 3, relaxStocks2,
      relaxedPyramids3, relaxDrawPile2, true);

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
  public void startGameValid() {
    //modify the game states
    initialGame.startGame(decks, false, 5, 2);
    //tests the fields to verifying the updating
    assertEquals(52, initialGame.getDeck().size());
    assertEquals(5, initialGame.getNumRows());
    assertEquals(2, initialGame.getNumDraw());
  }

  //Test for get Deck and initilize the deck
  @Test
  public void getDeckTest() {

    String decks = "[A♦, A♣, A♥, A♠, 2♦, 2♣, 2♥, 2♠, 3♦, 3♣, 3♥, 3♠, 4♦, 4♣, 4♥, 4♠, "
        + "5♦, 5♣, 5♥, 5♠, 6♦, 6♣, 6♥, 6♠, 7♦, 7♣, 7♥, 7♠, 8♦, 8♣, 8♥, 8♠, 9♦, 9♣, 9♥, 9♠,"
        + " 10♦, 10♣, 10♥, 10♠, J♦, J♣, J♥, J♠, Q♦, Q♣, Q♥, Q♠, K♦, K♣, K♥, K♠]";
    assertEquals(decks, initialGame.getDeck().toString());
  }


  //Test for the remove methods
  // -- VALID CASE
  //Test single remove
  @Test
  public void testSingleMoveValid() {
    game.remove(1, 1);
    assertNull(game.getCardAt(1, 1));
  }

  //Test the removePair methods valid
  //remove one card so that the remaining two cards is
  //a pair that covered with each other but can be removed dur to relax rule
  @Test
  public void testRm2RelaxBelow() {
    game.remove(1, 1);
    game.remove(1, 0, 0, 0);
    assertNull(game.getCardAt(1, 1));
    assertNull(game.getCardAt(0, 0));
    assertNull(game.getCardAt(1, 0));
  }

  @Test
  public void testRm2RelaxBelowSwitchOrder() {
    game.remove(1, 1);
    game.remove(0, 0, 1, 0);
    assertNull(game.getCardAt(1, 1));
    assertNull(game.getCardAt(0, 0));
    assertNull(game.getCardAt(1, 0));
  }

  //The first card is the card be covered,
  // and the second card is below the first card
  @Test
  public void testRm2RelaxLeft() {
    game3.remove(2, 1);
    game3.remove(1, 1, 2, 2);
    assertNull(game3.getCardAt(2, 1));
    assertNull(game3.getCardAt(1, 1));
    assertNull(game3.getCardAt(2, 2));
  }

  //scwitch the card, the first card is the card below
  @Test
  public void testRm2RelaxLeftScitch() {
    game3.remove(2, 1);
    game3.remove(2, 2, 1, 1);
    assertNull(game3.getCardAt(2, 1));
    assertNull(game3.getCardAt(1, 1));
    assertNull(game3.getCardAt(2, 2));
  }

  //test the normal remove
  @Test
  public void testRm2Basic() {
    game2.remove(2, 0, 2, 2);
    assertNull(game2.getCardAt(2, 0));
    assertNull(game2.getCardAt(2, 2));
  }

  //test the basic remove by using draws in Relax Model
  @Test
  public void removeUsingDrawValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 5, stocks,
        pyramids, drawPile, true);
    //2.modify the game states
    game.removeUsingDraw(1, 6, 5);
    //3.tests the fields to verifying the updating
    assertEquals(210, game.getScore());
    assertEquals(5, game.getNumDraw());
  }

  //test the basic discard in Relax Model
  @Test
  public void discardDrawValid() {
    //1.define local variable
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 5, stocks,
        pyramids, drawPile, true);
    //2.modify the game states
    game.discardDraw(3);
    //3.tests the fields to verifying the updating
    assertEquals(218, game.getScore());
    assertEquals(5, game.getNumDraw());
    //check other properties???
  }

  //CHECK THE INVALID APPROACH OF REMOVE PAIR
  //Test the removePair methods invalid
  //where the two cards is not covered and close to each other
  @Test(expected = IllegalArgumentException.class)
  public void testRm2InvalidCardNotPair() {
    game2.remove(2, 1);
    game2.remove(2, 2, 1, 0);
  }

  //Test the removePair methods invalid
  //where the two cards is exactly covered with each other but not sum to 13
  @Test(expected = IllegalArgumentException.class)
  public void testRm2InvalidNot13() {
    game2.remove(2, 1);
    game2.remove(2, 0, 1, 1);
  }

  //TEST OTHER INVALID REMOVE NORMAL PAIR CASE IN RELAX MODEL
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

  // case2: where the sum of two selected cards is not equal to 13
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove2() {
    //1.define local variable
    PyramidSolitaireModel<Cards> gameInitial = new RelaxedPyramidSolitaire();

    //2.modify the game states
    gameInitial.startGame(decks, false, 7, 3);

    //Tests the remove method
    gameInitial.remove(7, 1, 7, 2);
  }

  // case3: where the two selected cards is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void removeInvalidMove3() {
    //1.define local variable
    PyramidSolitaireModel<Cards> gameInitial = new RelaxedPyramidSolitaire();

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

  //CHECK THE SINGLE INVALID APPROACH
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

  //CHECK THE REWD INVALID APPROACH
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

  //CHECK THE DISCARD INVALID APPROACH
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


  //TEST GAME OVER of RELAX MODEL
  //Test the game over where the remaining two cards can be removed due to the relaxed rule
  @Test
  public void testIsGameOverRelaxValid() {
    //where there only two cards in pyramids that can be removed
    //no cards in draws or stocks -- no discards
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 2, 3, emptyList,
        relaxedPyramids, nullList, true);
    game.remove(1, 1);
    assertFalse(game.isGameOver());
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
    PyramidSolitaireModel<Cards> endGame4 = new RelaxedPyramidSolitaire(decks,
        2, 5, stocks,
        winMock, drawPile, true);
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
    PyramidSolitaireModel<Cards> endGame5 = new RelaxedPyramidSolitaire(decks,
        2, 3, emptyList,
        winMock, nullList, true);
    assertTrue(endGame5.isGameOver());
  }

  //Test the case
  @Test
  public void isGameOverTest6() {
    PyramidSolitaireModel<Cards> game6 = new RelaxedPyramidSolitaire(decks,
        7, 3, emptyList, pyramids, nullList, true);
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
    PyramidSolitaireModel<Cards> initialGame0 = new RelaxedPyramidSolitaire();

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
    PyramidSolitaireModel<Cards> initialGame0 = new RelaxedPyramidSolitaire();

    //2.modify the game states
    initialGame0.startGame(decks, false, 6, 5);

    //Tests the methods
    assertEquals(5, initialGame0.getNumDraw());
  }

  //checks the case when the stock is empty
  @Test
  public void getNumDrawValidTest2() {
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 3, emptyList,
        pyramids, nullList, true);
    assertEquals(3, game.getNumDraw());
  }

  //checks the case when the stock is empty
  @Test
  public void getNumDrawValidTest3() {
    nullList.set(0, cc1);
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 3, emptyList,
        pyramids, nullList, true);
    assertEquals(3, game.getNumDraw());
  }

  //Tests for getRowWidth(int row)
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

  //checks the case for valid approach
  @Test
  public void getRowWidthTestZero() {
    gameStarted.startGame(decks, false, 7, 5);
    assertEquals(1, gameStarted.getRowWidth(0));
  }

  @Test
  public void getRowWidthTest() {
    gameStarted.startGame(decks, false, 7, 5);
    assertEquals(4, gameStarted.getRowWidth(3));
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
    assertEquals(218, gameStarted.getScore());
  }

  //checks the case when all cards are removed in the pyramid
  @Test
  public void getScoreWinTest() {
    //define local game
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 2, 5, stocks,
        winMock, drawPile, true);
    assertEquals(0, game.getScore());
  }

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
    gameStarted.startGame(decks, false, 7, 5);
    gameStarted.getCardAt(0, 4);
  }

  //checks the case for valid approach
  @Test
  public void getCardAtTest() {
    gameStarted.startGame(decks, false, 7, 5);
    assertEquals(cck, gameStarted.getCardAt(6, 0));
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
    gameStarted.startGame(decks, false, 7, 5);
    assertEquals(drawPile, gameStarted.getDrawCards());
  }

  //checks the case for valid approach where there is no card at the coordinate
  @Test
  public void getDrawCardsTest2() {
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 3, stocks,
        pyramids, nullList, true);
    assertEquals(nullList, game.getDrawCards());
  }

  //checks the case when the stock is empty
  @Test
  public void getDrawCardsTest3() {
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(decks, 7, 3, emptyList,
        pyramids, nullList, true);
    assertEquals(nullList, game.getDrawCards());
  }


}