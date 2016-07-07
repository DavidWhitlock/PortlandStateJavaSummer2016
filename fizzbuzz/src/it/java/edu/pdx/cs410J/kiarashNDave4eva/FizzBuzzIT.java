package edu.pdx.cs410J.kiarashNDave4eva;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
public class FizzBuzzIT extends InvokeMainTestCase {
  @Test
  public void invokingMainPrintsOutFizzBuzzFor1To5() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(FizzBuzz.class);

    String expected = "1\n2\nFizz\n4\nBuzz";
    assertThat(result.getOut(), containsString(expected));
  }

  @Test
  public void invokingMainPrintsOutFizzBuzzFor10To15() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(FizzBuzz.class);

    String expected = "Buzz\n11\nFizz\n13\n14\nFizzBuzz";
    assertThat(result.getOut(), containsString(expected));
  }

}
