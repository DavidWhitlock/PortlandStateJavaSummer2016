package edu.pdx.cs410J.whitlock;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class is represents a <code>Student</code>.
 */
public class WordSpinner {

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

  static String spinSentence(String sentence, WordSpinnerStrategy strategy) {
    return strategy.spinSentence(sentence);
  }

  static String spinSentence(String sentence) {
    return spinSentence(sentence, new StreamBasedStrategy());
  }

  interface WordSpinnerStrategy {
    String spinSentence(String sentence);
  }

  static class OriginalStrategy implements WordSpinnerStrategy {
    @Override
    public String spinSentence(String sentence) {
      String[] words = sentence.split(" ");
      StringBuilder sb = new StringBuilder();
      for (String word : words) {
        sb.append(spinWord(word));
        sb.append(" ");
      }
      return sb.toString().trim();
    }
  }

  static class StreamBasedStrategy implements WordSpinnerStrategy {
    @Override
    public String spinSentence(String sentence) {
      Pattern pattern = Pattern.compile(" ");

      return pattern.splitAsStream(sentence)
//        .parallel()
        .map(WordSpinner::spinWord)
        .collect(Collectors.joining(" "));
    }
  }
}