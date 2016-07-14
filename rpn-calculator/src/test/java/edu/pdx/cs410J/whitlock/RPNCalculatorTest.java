package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class RPNCalculatorTest
{

  @Test
  public void emptyExpressionEvaluatesToZero() {
    RPNCalculator calculator = new RPNCalculator();
    assertThat(calculator.evaluate(""), equalTo(0));
  }

  @Test
  public void nonNumberIssuesError() {
    String invalid = "QQQ";
    RPNCalculator calculator = new RPNCalculator();
    try {
      calculator.evaluate(invalid);

    } catch (InvalidRPNExpressionException ex) {
      assertThat(ex.getMessage(), containsString("Invalid expression: " + invalid));
    }
  }

  @Ignore
  @Test
  public void oneOperandIssuesError() {
    RPNCalculator calculator = new RPNCalculator();
    try {
      calculator.evaluate("1");

    } catch (InvalidRPNExpressionException ex) {
      assertThat(ex.getMessage(), containsString("Missing operator"));
    }
  }

}
