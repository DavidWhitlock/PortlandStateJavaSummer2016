package edu.pdx.cs410J.kiarashNDave4eva;

public class FizzBuzz {

  static String getValue(int num) {
    if (num % 15 == 0) {
      return "FizzBuzz";

    } else if (num % 5 == 0) {
      return "Buzz";

    } else if (num % 3 == 0) {
      return "Fizz";

    } else {
      return String.valueOf(num);
    }
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      System.out.println(FizzBuzz.getValue(i));
    }
  }
}