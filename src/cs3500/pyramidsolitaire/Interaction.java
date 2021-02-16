package cs3500.pyramidsolitaire;

/**
 * An interaction with the user consists of some input to send the program and some output to
 * expect.  We represent it as an object that takes in two StringBuilders and produces the intended
 * effects on them.
 */
public interface Interaction {

  void apply(StringBuilder in, StringBuilder out);

  /**
   * Represents the printing of a sequence of lines to output.
   */
  static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line).append('\n');
      }
    };
  }

  /**
   * Represents a user providing the program with  an input.
   */
  static Interaction inputs(String in) {
    return (input, output) -> {
      input.append(in);
    };
  }
}

