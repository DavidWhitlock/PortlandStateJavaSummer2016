package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class RPNCalculator {

  @VisibleForTesting
  List parseExpression(String expression) {
    ArrayList list = new ArrayList();

    if (expression.equals("")) {
      return list;
    }

    for (String token : expression.split(" ")) {
      list.add(parseToken(token));
    }

    return list;
  }

  private Object parseToken(String token) {
    Object value;

    switch (token) {
      case "+":
        return Operator.ADDITION;

      case "-":
        return Operator.SUBTRACT;

      case "*":
        return Operator.MULTIPLY;

      case "/":
        return Operator.DIVIDE;
    }

    try {
      value = Integer.parseInt(token);
    } catch (NumberFormatException ex) {
      throw new InvalidRPNExpressionException("Invalid expression: " + token);
    }
    return value;
  }

  public int evaluate(String expression) {
    parseExpression(expression);
    return 0;
  }

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  public enum Operator {SUBTRACT, MULTIPLY, DIVIDE, ADDITION}
}