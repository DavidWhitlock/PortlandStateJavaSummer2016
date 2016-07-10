package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static edu.pdx.cs410J.whitlock.WordSpinner.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
public class WordSpinnerPerformanceIT extends InvokeMainTestCase {

  @Test
  public void measurePerformanceOfWordSpinnerWithHugeSentence() {
    HugeSentenceGenerator generator = new HugeSentenceGenerator();
    generator.setSentenceLength(10_000_000);
    generator.setMinimumWordSize(4);
    generator.setMaximumWordSize(10);

    String sentence = generator.generateSentence();
//    System.out.println(sentence.length() + ": " + sentence);

    long duration = measureSpinningSentence(sentence);
    System.out.println("It look " + duration + "ms to spin a sentence of length " + sentence.length());
  }

  @Test
  public void spinningWordsWithStreamsShouldHaveTheSameResultAsOriginalAlgorithm() {
    HugeSentenceGenerator generator = new HugeSentenceGenerator();
    generator.setSentenceLength(10_000_000);
    generator.setMinimumWordSize(4);
    generator.setMaximumWordSize(10);

    String sentence = generator.generateSentence();

    String original = WordSpinner.spinSentence(sentence, new OriginalStrategy());
    String streams = WordSpinner.spinSentence(sentence, new StreamBasedStrategy());
    String parallelStreams = WordSpinner.spinSentence(sentence, new ParallelStreamBasedStrategy());

    assertThat(streams, equalTo(original));
    assertThat(parallelStreams, equalTo(original));
  }

  @Ignore  // Works fine on Dave's laptop, but fails on Travis CI builds.
  @Test
  public void spinningWordsWithStreamsShouldBeFasterThanInitialImplementation() {
    HugeSentenceGenerator generator = new HugeSentenceGenerator();
    generator.setSentenceLength(10_000_000);
    generator.setMinimumWordSize(4);
    generator.setMaximumWordSize(10);

    String sentence = generator.generateSentence();

    long durationOldAlgorithm = measureSpinningSentence(sentence, new OriginalStrategy());
    long durationWithStreams = measureSpinningSentence(sentence, new StreamBasedStrategy());
    long durationWithParallelStreams = measureSpinningSentence(sentence, new ParallelStreamBasedStrategy());

    System.out.println("It look " + durationOldAlgorithm + "ms to spin a sentence of length " + sentence.length() + " with original algorithm");
    System.out.println("It look " + durationWithStreams + "ms to spin a sentence of length " + sentence.length() + " with streams");
    System.out.println("It look " + durationWithParallelStreams + "ms to spin a sentence of length " + sentence.length() + " with parallel streams");

    assertThat(durationWithStreams, lessThan(durationOldAlgorithm));
    assertThat(durationWithParallelStreams, lessThan(durationOldAlgorithm));
  }

  private long measureSpinningSentence(String sentence) {
    return measureSpinningSentence(sentence, new OriginalStrategy());
  }

  private long measureSpinningSentence(String sentence, WordSpinnerStrategy strategy) {
    System.gc();
    long start = System.currentTimeMillis();

    spinSentence(sentence, strategy);

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
        appendRandomWord(sb);
        sb.append(" ");
      }

      return sb.toString();
    }

    private void appendRandomWord(StringBuilder sb) {
      int wordLength = this.minimumWordSize + this.random.nextInt(maximumWordSize - minimumWordSize);

      for (int i = 0; i < wordLength; i++) {
        sb.append(getRandomLetter());
      }

    }

    private char getRandomLetter() {
      int offset = random.nextInt(26);
      return (char) ('a' + offset);
    }
  }
}
