package edu.pdx.cs410J.whitlock.client;

import java.io.Serializable;

public class Generation implements Serializable {
  private char[][] grid;

  public Generation() {

  }

  public Generation(char[][] grid) {
    this.grid = grid;
  }

  public int getNumberOfRows() {
    return this.grid.length;
  }

  public char[] getRow(int row) {
    return this.grid[row];
  }
}
