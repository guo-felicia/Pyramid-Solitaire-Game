import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Cards;
import cs3500.pyramidsolitaire.model.hw02.Cards.Rank;
import cs3500.pyramidsolitaire.model.hw02.Cards.Suit;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Represents the Test class for viewing the basic pyramid Solitaire.
 */

public class PyramidSolitaireTextualViewTest {


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


  List<Cards> initialDeck = List.of(cs6,
      cd9, chk,
      cs10, cs5, ch3,
      ch7, cd4, cs2, csq,
      cc10, cdj, ch2, cdq, cc8,
      cd7, ch8, cc4, chq, cd8, cs4,
      cck, cc3, chj, cd10, cdk, cs8, cd3,
      ch9, cc5, ch5, ccq, cc9,
      ccj, csk, ch4, cc7, cd1, cc6, cd2, cc1, cs9, cs7, ch6, cs3, cd6,
      cd5, cs1, cc2, ch10, csj, ch1);

  List<Cards> relexR0 = Collections.singletonList(cs4);
  List<Cards> relexR1 = Arrays.asList(cd9, chk);
  List<Cards> relexR2 = Arrays.asList(cs10, cdk, ch3);
  List<List<Cards>> relaxedPyramids = Arrays.asList(relexR0, relexR1);
  List<List<Cards>> relaxedPyramids2 = Arrays.asList(relexR0, relexR1, relexR2);
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


  List<Cards> emptyList = Collections.emptyList();
  List<Cards> nullList = Arrays.asList(null, null, null);
  List<List<Cards>> pyramidsForEndGame = List
      .of(Arrays.asList(cc6), Arrays.asList(ch9, csk), Arrays.asList(csq, csj, cd3));
  List<Cards> decks = List.of(cd2, cd3, cc4, cc5, cc6, ch7, ch8, ch9, cs10, csj, csq, csk, cd1);
  List<Cards> stocks = List.of(cd1);
  List<List<Cards>> pyramids = List
      .of(Arrays.asList(cd2), Arrays.asList(cd3, cc4), Arrays.asList(cc5, cc6, ch7),
          Arrays.asList(ch8, ch9, csk, csj));
  List<Cards> draws = List.of(csq, cs10);
  List<Cards> draws2 = List.of(csq, csk);
  List<Cards> drawPile = List.of(ch9, cc5, ch5, cc10, ch9);
  List<List<Cards>> pyramids1 = List
      .of(Arrays.asList(cd2), Arrays.asList(cd3, cc4), Arrays.asList(cc5, cc6, ch7),
          Arrays.asList(ch8, ch9, csk, csj));
  List<List<Cards>> pyramids2 = List
      .of(Arrays.asList(cd2), Arrays.asList(cd3, cc4), Arrays.asList(cc5, cc6, ch7),
          Arrays.asList(ch8, ch9, csk, csj));

  PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(initialDeck, 2, 3, relaxStocks,
      relaxedPyramids, relaxDrawPile, true);
  PyramidSolitaireModel<Cards> game2 = new RelaxedPyramidSolitaire(initialDeck, 3, 3, relaxStocks2,
      relaxedPyramids2, relaxDrawPile2, true);
  PyramidSolitaireModel<Cards> game1 = new BasicPyramidSolitaire(initialDeck,
      4, 2, stocks, pyramids, draws, false);
  PyramidSolitaireModel<Cards> game3 = new BasicPyramidSolitaire(initialDeck,
      3, 2, emptyList, pyramidsForEndGame, nullList, true);


  PyramidSolitaireTextualView view1 = new PyramidSolitaireTextualView(game1);
  PyramidSolitaireTextualView view2 = new PyramidSolitaireTextualView(game2);
  PyramidSolitaireTextualView view3 = new PyramidSolitaireTextualView(game3);

  //'♣' '♦' '♥' '♠'
  String row0 = "      2♦"; //length = 3 + 2*6 = 15
  String row1 = "    3♦  4♣"; //length = 7 + 2*4 = 15
  String row2 = "  5♣  6♣  7♥"; //length = 11 + 2*2 = 15
  String row3 = "8♥  .   .   J♠"; //length = 15
  String draw = "Draw: Q♠, K♠";
  String testStr = row0 + "\n" + row1 + "\n" + row2 + "\n" + row3 + "\n" + draw;
  String testStr2 = row0 + "\n" + row1 + "\n" + row2 + "\n" + "10♥ 9♥  10♠ 10♦\n" + draw;

  //TESTS:

  //Tests for toString() methods
  //case1: If the game is not start
  @Test
  public void testGameNotStart() {
    assertEquals("", view1.toString());
  }

  //case2: the pyramid is empty
  @Test
  public void testWon() {
    List<Cards> r0 = new ArrayList<>();
    r0.add(null);
    List<Cards> r1 = new ArrayList<>();
    r1.add(null);
    r1.add(null);
    List<List<Cards>> winMock = Arrays.asList(r0, r1);
    //possible discards, but no moves
    PyramidSolitaireModel<Cards> game2 = new BasicPyramidSolitaire(initialDeck,
        2, 5, stocks,
        winMock, drawPile, true);
    PyramidSolitaireTextualView view2 = new PyramidSolitaireTextualView(game2);
    assertEquals("You win!", view2.toString());
  }


  //case3: there is no possible move with remaining pyramids and empty draws
  @Test
  public void testGameEndNoMove() {

    assertEquals("Game over. Score: 54", view3.toString());
  }

  //case: game is not over and valid approach
  @Test
  public void testNormal() {
    List<Cards> row3 = pyramids1.get(3);
    row3.set(1, null);
    row3.set(2, null);
    PyramidSolitaireModel<Cards> game4 = new BasicPyramidSolitaire(initialDeck,
        4, 2, emptyList, pyramids1, draws2, true);
    PyramidSolitaireTextualView view4 = new PyramidSolitaireTextualView(game4);
    assertEquals(testStr, view4.toString());
  }

  //case: game is not over and valid approach
  @Test
  public void testNormal2() {
    List<Cards> row3 = pyramids2.get(3);
    row3.set(0, ch10);
    row3.set(2, cs10);
    row3.set(3, cd10);
    PyramidSolitaireModel<Cards> game4 = new BasicPyramidSolitaire(initialDeck,
        4, 2, emptyList, pyramids2, draws2, true);
    PyramidSolitaireTextualView view4 = new PyramidSolitaireTextualView(game4);
    assertEquals(testStr2, view4.toString());
  }

  //case: game is over and the draws is all null with empty stock
  @Test
  public void testNullDraw() {
    List<List<Cards>> pyramidsSize3 = List.of(Arrays.asList(cd2), Arrays.asList(cd3, cc4));
    PyramidSolitaireModel<Cards> game5 = new BasicPyramidSolitaire(initialDeck,
        2, 3, emptyList, pyramidsSize3, nullList, true);
    PyramidSolitaireTextualView view5 = new PyramidSolitaireTextualView(game5);
    assertEquals("Game over. Score: 9", view5.toString());
  }

  //TESTS FOR Muti-Pyramid


  //TESTS FOR Relax Pyramid
  //the pyramid is empty
  @Test
  public void testWonRelax() {
    game.remove(1, 1);
    game.remove(1, 0, 0, 0);
    assertNull(game.getCardAt(1, 1));
    assertNull(game.getCardAt(0, 0));
    assertNull(game.getCardAt(1, 0));
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);
    assertEquals("You win!", view.toString());
  }

  //'♣' '♦' '♥' '♠'
  String row0_relax = "  4♠";
  String row1_relax = "9♦  .";
  String draw_relax = "Draw:";
  String testStr_relax = row0_relax + "\n" + row1_relax + "\n" + draw_relax;

  //the pyramid is not end with empty stocks and draws but a possible move due to the relax rule
  @Test
  public void testRelaxMoveNotGameOver() {
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire(initialDeck, 2, 3, emptyList,
        relaxedPyramids, nullList, true);
    game.remove(1, 1);
    assertNull(game.getCardAt(1, 1));
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);
    assertEquals(testStr_relax, view.toString());
  }

  //'♣' '♦' '♥' '♠'
  String row0_relax1 = "  6♠";
  String row1_relax1 = "9♦  .";
  String draw_relax1 = "Draw: 10♠, 5♠, 3♥";
  String testStr_relax1 = row0_relax1 + "\n" + row1_relax1 + "\n" + draw_relax1;
  //the pyramid is not end with empty stocks and draws but a possible move due to the relax rule

  @Test
  public void testRelaxModel() {
    PyramidSolitaireModel<Cards> game = new RelaxedPyramidSolitaire();
    game.startGame(initialDeck, false, 2, 3);
    game.remove(1, 1);
    assertNull(game.getCardAt(1, 1));
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);
    assertEquals(testStr_relax1, view.toString());
  }

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

  List<Cards> mutiR0 = Arrays.asList(ccj, null, null, ch5, null, null, ch7);
  List<Cards> mutiR1 = Arrays.asList(ch9, cd10, null, chq, ch10, null, cc3, ch6);
  List<Cards> mutiR2 = Arrays.asList(cd3, cc8, ch1, ch4, cs4, chk, cs6, cd3, cs10);
  List<Cards> mutiR3 = Arrays.asList(cdq, ch5, csj, cd9, cs9, cd7, cs3, cc8, cs4, cc5);
  List<Cards> row4 = Arrays.asList(ch1, cck, cs3, ch8, cs1, ch9, cc3, csq, ch3, cc4, ch10);
  List<Cards> row5 = Arrays.asList(cd8, cdq, cdk, cs2, cs1, cc6, cs8, cd1, ch3, cc6, cs2, cc7);
  List<Cards> row6 = Arrays
      .asList(cdk, csj, cdj, cs5, ccq, cs8, cs10, ch2,
          csk, cs5, cd9, cd7, csq);

  List<List<Cards>> mutiPyramids =
      Arrays.asList(mutiR0, mutiR1, mutiR2, mutiR3, row4, row5, row6);
  List<Cards> mutiDrawPile = List.of(chk, cd5, cc10);
  List<Cards> mutiStocks = List
      .of(cd2, cd4, cd6, cc2, cc3, cc9, chj, cs7,
          cd2, cd4, cd6, cc2, cc3, cc9, chj, cs7,
          ccj, ch7, cd10, chq, ch6, ch4, cs6, cs9,
          cc5, cck, ch8, cc4, cd8, cd1, cc7, cdj,
          ccq, ch2, csk, cd5, cc10, cc1, cc1, cdk);

  PyramidSolitaireModel<Cards> mutiGame = new MultiPyramidSolitaire();
  PyramidSolitaireModel<Cards> gameRow7 = new MultiPyramidSolitaire(mutiDecks, 7, 3, mutiStocks,
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

  PyramidSolitaireModel<Cards> gameRow4 = new MultiPyramidSolitaire(mutiDecks, 4, 1, mutiStocks2,
      mutiPyramids2, mutiDrawPile2, true);

  @Test
  public void testMutiPyramidRow7() {
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(gameRow7);
    assertEquals("", view.toString());
  }

  //the pyramid is not end with empty stocks and draws but a possible move due to the relax rule
  @Test
  public void testMutiPyramidRow4() {
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);
    assertEquals("", view.toString());
  }

}