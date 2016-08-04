package edu.pdx.cs410J.whitlock.client;

import java.io.Serializable;

public class Generation implements Serializable {
  private int numberOfRows = 3;

  public int getNumberOfRows() {
    return numberOfRows;
  }

  public char[] getRow(int row) {
    return "*.*.*".toCharArray();
  }
}
