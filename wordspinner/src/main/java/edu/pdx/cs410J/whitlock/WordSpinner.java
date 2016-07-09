package edu.pdx.cs410J.whitlock;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class WordSpinner {

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the wordspinner to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  static String spinWord(String word) {
    if (word.length() >= 5) {
      return reverseWord(word);

    } else {
      return word;
    }
  }

  private static String reverseWord(String word) {
    return new StringBuilder(word).reverse().toString();
  }

  static String spinSentence(String sentence) {
    String[] words = sentence.split(" ");
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(spinWord(word));
      sb.append(" ");
    }
    return sb.toString().trim();
  }
}