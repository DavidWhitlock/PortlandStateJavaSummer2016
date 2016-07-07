package edu.pdx.cs410J.kiarashNDave4eva;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class FizzBuzzTest
{

  @Test
  public void checkFor1() {
    assertThat(FizzBuzz.getValue(1), equalTo("1"));
  }

  @Test
  public void checkFor3() {
    assertThat(FizzBuzz.getValue(3), equalTo("Fizz"));
  }

  @Test
  public void checkFor6() {
    assertThat(FizzBuzz.getValue(6), equalTo("Fizz"));
  }

  @Test
  public void checkFor5() {
    assertThat(FizzBuzz.getValue(5), equalTo("Buzz"));
  }

  @Test
  public void checkFor10() {
    assertThat(FizzBuzz.getValue(10), equalTo("Buzz"));
  }

  @Test
  public void checkFor15() {
    assertThat(FizzBuzz.getValue(15), equalTo("FizzBuzz"));
  }

  @Test
  public void checkFornegative15() {
    assertThat(FizzBuzz.getValue(-15), equalTo("FizzBuzz"));
  }
}
