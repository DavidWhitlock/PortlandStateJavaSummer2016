package edu.pdx.cs410J.whitlock;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class GameOfLife {

  private final char[][] grid;
  private int nextUnpopulatedRow;

  public GameOfLife(int rowCount, int columnCount) {
    this.grid = new char[rowCount][columnCount];
    this.nextUnpopulatedRow = 0;
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

  public void addRow(String row) {
    this.grid[this.nextUnpopulatedRow] = row.toCharArray();
    this.nextUnpopulatedRow++;
  }

  public void computeNextGeneration() {


  }

  public String getRow(int rowIndex) {
    return new String(this.grid[rowIndex]);
  }
}