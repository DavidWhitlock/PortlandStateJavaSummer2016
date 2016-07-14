package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        return Operation.ADDITION;

      case "-":
        return Operation.SUBTRACT;

      case "*":
        return Operation.MULTIPLY;

      case "/":
        return Operation.DIVIDE;
    }

    try {
      value = Integer.parseInt(token);
    } catch (NumberFormatException ex) {
      throw new InvalidRPNExpressionException("Invalid expression: " + token);
    }
    return value;
  }

  public int evaluate(String expression) {
    List lexemes = parseExpression(expression);
    if (lexemes.isEmpty()) {
      return 0;
    }

    Stack stack = new Stack();

    for (Object lexeme : lexemes) {
      if (lexeme instanceof Integer) {
        stack.push(lexeme);

      } else if (lexeme instanceof Operation) {
        Operation operation = (Operation) lexeme;
        int right = popInt(stack);
        int left = popInt(stack);
        int result = operation.evaluate(left, right);
        stack.push(result);
      }
    }

    return (Integer) stack.pop();
  }

  private int popInt(Stack stack) {
    return (Integer) stack.pop();
  }

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  public enum Operation {SUBTRACT, MULTIPLY, DIVIDE, ADDITION;

    public int evaluate(int left, int right) {
      return left + right;
    }
  }
}