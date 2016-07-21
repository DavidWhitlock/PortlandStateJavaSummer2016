package edu.pdx.cs410J.whitlock;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class GameOfLife {

  private static final char DEAD_CELL = '.';

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
        char cell = this.grid[row][column];
        this.grid[row][column] = getNextGenerationCell(cell);
      }
    }

  }

  private char getNextGenerationCell(char cell) {
    return DEAD_CELL;
  }

  String getRow(int rowIndex) {
    return new String(this.grid[rowIndex]);
  }
}