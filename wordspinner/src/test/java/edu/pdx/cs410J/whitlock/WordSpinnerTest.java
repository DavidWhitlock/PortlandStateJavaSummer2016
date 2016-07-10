package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class WordSpinnerTest
{

  @Test
  public void spinningWordWithFewerThan5LettersDoesNothing() {
    String shortWord = "four";
    assertThat(WordSpinner.spinWord(shortWord), equalTo(shortWord));
  }

  @Test
  public void spinningWordWithMoreThan5LettersReversesIt() {
    String longWord = "camel";
    assertThat(WordSpinner.spinWord(longWord), equalTo("lemac"));
  }

  @Test
  public void spinningASentence() {
    String sentence = "Hey fellow warriors";
    String expected = "Hey wollef sroirraw";

    assertThat(WordSpinner.spinSentence(sentence), equalTo(expected));
  }

  @Test
  public void bothSpinningStrategiesReturnSameResults() {
    String sentence = "Hey fellow warriors";
    String expected = "Hey wollef sroirraw";

    assertThat(WordSpinner.spinSentence(sentence, new WordSpinner.OriginalStrategy()), equalTo(expected));
    assertThat(WordSpinner.spinSentence(sentence, new WordSpinner.StreamBasedStrategy()), equalTo(expected));
    assertThat(WordSpinner.spinSentence(sentence, new WordSpinner.ParallelStreamBasedStrategy()), equalTo(expected));

  }

}
