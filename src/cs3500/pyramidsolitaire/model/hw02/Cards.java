package cs3500.pyramidsolitaire.model.hw02;


/**
 * Represents the information for card.
 */
public class Cards {

  /**
   * This documents the suit of card: DIAMONDS('♦'),CLUBS('♣'),HEARTS('♥'),SPADES('♠').
   */
  public enum Suit {
    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES
  }

  /**
   * This documents the rank of card.
   */
  public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
  }

  Suit suit;
  Rank rank;

  /**
   * Constructs a card in terms of its suit and rank.
   *
   * @param suit the suit of the card
   * @param rank the rank of the card
   */
  public Cards(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    if (!(that instanceof Cards)) {
      return false;
    }

    return ((Cards) that).suit == this.suit
        && ((Cards) that).rank == this.rank;
  }

  @Override
  public int hashCode() {
    return suit.hashCode() + rank.hashCode();
    //return Long.hashCode(inSeconds());
  }

  @Override
  public String toString() {
    return this.getRank() + this.getSuit();
  }

  /**
   * Gets the value of the suit of the card.
   *
   * @return the string value of the card's suit
   */
  public String getSuit() {
    switch (suit) {
      case CLUBS:
        return "♣";
      case HEARTS:
        return "♥";
      case SPADES:
        return "♠";
      case DIAMONDS:
        return "♦";
      default:
        throw new RuntimeException("Suit can't be null.");
    }
  }

  /**
   * Gets the value of the rank of the card.
   *
   * @return the string value of the card's rank
   */
  public String getRank() {
    switch (rank) {
      case ACE:
        return "A";
      case TWO:
        return "2";
      case THREE:
        return "3";
      case FOUR:
        return "4";
      case FIVE:
        return "5";
      case SIX:
        return "6";
      case SEVEN:
        return "7";
      case EIGHT:
        return "8";
      case NINE:
        return "9";
      case TEN:
        return "10";
      case JACK:
        return "J";
      case QUEEN:
        return "Q";
      case KING:
        return "K";
      default:
        throw new RuntimeException("Rank can't be null.");
    }
  }

  /**
   * Gets the value of the rank of the card in int.
   *
   * @return the int value of the card's rank
   */
  public int getRankValue() {
    switch (rank) {
      case ACE:
        return 1;
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return 4;
      case FIVE:
        return 5;
      case SIX:
        return 6;
      case SEVEN:
        return 7;
      case EIGHT:
        return 8;
      case NINE:
        return 9;
      case TEN:
        return 10;
      case JACK:
        return 11;
      case QUEEN:
        return 12;
      case KING:
        return 13;
      default:
        throw new RuntimeException("Rank can't be null.");
    }
  }

}


