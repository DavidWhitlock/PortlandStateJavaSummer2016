package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

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
      fail();

    } catch (InvalidRPNExpressionException ex) {
      assertThat(ex.getMessage(), containsString("Invalid expression: " + invalid));
    }
  }

  @Test
  public void canParseNumbers() {
    List list = new RPNCalculator().parseExpression("1 2");
    assertThat(list.get(0), equalTo(1));
    assertThat(list.get(1), equalTo(2));
  }

  @Test
  public void canParseAdditionOperator() {
    List list = new RPNCalculator().parseExpression("+");
    assertThat(list.get(0), equalTo(RPNCalculator.Operation.ADDITION));
  }

  @Test
  public void canParseOperators() {
    List list = new RPNCalculator().parseExpression("+ - * /");
    assertThat(list.get(0), equalTo(RPNCalculator.Operation.ADDITION));
    assertThat(list.get(1), equalTo(RPNCalculator.Operation.SUBTRACT));
    assertThat(list.get(2), equalTo(RPNCalculator.Operation.MULTIPLY));
    assertThat(list.get(3), equalTo(RPNCalculator.Operation.DIVIDE));
  }

  @Test
  public void canPerformAddition() {
    RPNCalculator calculator = new RPNCalculator();
    assertThat(calculator.evaluate("1 2 +"), equalTo(3));
  }

  @Ignore
  @Test
  public void oneOperandIssuesError() {
    RPNCalculator calculator = new RPNCalculator();
    try {
      calculator.evaluate("1");
      fail();

    } catch (InvalidRPNExpressionException ex) {
      assertThat(ex.getMessage(), containsString("Missing operator"));
    }
  }

}
