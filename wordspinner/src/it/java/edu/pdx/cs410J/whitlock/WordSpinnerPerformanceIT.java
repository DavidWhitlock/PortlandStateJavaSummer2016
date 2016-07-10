package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import java.util.Random;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
public class WordSpinnerPerformanceIT extends InvokeMainTestCase {

  @Test
  public void measurePerformanceOfWordSpinnerWithHugeSentence() {
    HugeSentenceGenerator generator = new HugeSentenceGenerator();
    generator.setSentenceLength(100);
    generator.setMinimumWordSize(4);
    generator.setMaximumWordSize(10);

    String sentence = generator.generateSentence();
    System.out.println(sentence);

    long duration = measureSpinningSentence(sentence);
    System.out.println("It look " + duration + "ms to spin a sentence of length " + sentence.length());
    ;
  }

  private long measureSpinningSentence(String sentence) {
    long start = System.currentTimeMillis();

    WordSpinner.spinSentence(sentence);

    long end = System.currentTimeMillis();

    return end - start;
  }

  private class HugeSentenceGenerator {
    private final Random random = new Random();

    private int sentenceLength;
    private int minimumWordSize;
    private int maximumWordSize;

    void setSentenceLength(int sentenceLength) {
      this.sentenceLength = sentenceLength;
    }

    void setMinimumWordSize(int minimumWordSize) {
      this.minimumWordSize = minimumWordSize;
    }

    void setMaximumWordSize(int maximumWordSize) {
      this.maximumWordSize = maximumWordSize;
    }

    String generateSentence() {
      StringBuilder sb = new StringBuilder(this.sentenceLength);

      while (sb.length() <= this.sentenceLength) {
        sb.append(generateRandomWord());
        sb.append(" ");
      }

      return sb.toString();
    }

    private String generateRandomWord() {
      int wordLength = this.minimumWordSize + this.random.nextInt(maximumWordSize - minimumWordSize);

      StringBuilder sb = new StringBuilder(wordLength);
      for (int i = 0; i < wordLength; i++) {
        sb.append(getRandomLetter());
      }

      return sb.toString();
    }

    private char getRandomLetter() {
      int offset = random.nextInt(26);
      return (char) ('a' + offset);
    }
  }
}
