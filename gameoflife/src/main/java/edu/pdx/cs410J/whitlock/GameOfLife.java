package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class GameOfLife {

  private static final char DEAD_CELL = '.';
  private static final char ALIVE_CELL = '*';

  private final char[][] grid;
  private int nextUnpopulatedRow;
  private final int rowCount;
  private final int columnCount;

  public GameOfLife(int rowCount, int columnCount) {
    this.grid = new char[rowCount][columnCount];
    this.nextUnpopulatedRow = 0;
    this.rowCount = rowCount;
    this.columnCount = columnCount;
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the gameoflife to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  void addRow(String row) {
    this.grid[this.nextUnpopulatedRow] = row.toCharArray();
    this.nextUnpopulatedRow++;
  }

  void computeNextGeneration() {
    for (int row = 0; row < this.rowCount; row++) {
      for (int column = 0; column < this.columnCount; column++) {
        this.grid[row][column] = getNextGenerationCell(row, column);
      }
    }

  }

  private char getNextGenerationCell(int row, int column) {
    char cell = getCell(row, column);
    int numberOfLiveNeighbors = getNumberOfLiveNeighbors(row, column);
    if (cell == ALIVE_CELL) {
      if (numberOfLiveNeighbors < 2) {
        return DEAD_CELL;

      } else if (numberOfLiveNeighbors > 3) {
        return DEAD_CELL;
      }

    }
    return DEAD_CELL;
  }

  @VisibleForTesting
  int getNumberOfLiveNeighbors(int row, int column) {
    int numberLiveNeighbors = 0;

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = column - 1; j <= column + 1; j++) {
        if (!(i == row && j == column)) {
          if (cellIsAlive(i, j)) {
            numberLiveNeighbors++;
          }
        }
      }
    }

    return numberLiveNeighbors;
  }

  private boolean cellIsAlive(int row, int column) {
    if (row < 0) {
      return false;

    } else if (column < 0) {
      return false;

    } else if (column >= this.columnCount) {
      return false;

    } else if (row >= this.rowCount) {
      return false;

    } else {
      return getCell(row, column) == ALIVE_CELL;
    }
  }

  private char getCell(int row, int column) {
    return this.grid[row][column];
  }

  String getRow(int rowIndex) {
    return new String(this.grid[rowIndex]);
  }
}