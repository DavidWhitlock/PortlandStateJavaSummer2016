package edu.pdx.cs410J.whitlock.server;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs410J.whitlock.client.Generation;

import java.io.*;

/**
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class GameOfLife {

  static final char DEAD_CELL = '.';
  private static final char ALIVE_CELL = '*';

  private char[][] grid;
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
  public static void main(String[] args) throws InterruptedException, IOException {
    if (args.length == 0) {
      System.err.println("** Missing file name");
      System.exit(1);
    }

    String fileName = args[0];
    GameOfLife game = readGameFromFile(new File(fileName));

    while (gameHasLiveCells(game)) {
      printGame(game);
      game.computeNextGeneration();
      Thread.sleep(1000);
    }
  }

  @VisibleForTesting
  static boolean gameHasLiveCells(GameOfLife game) {
    for (int row = 0; row < game.getRowCount(); row++) {
      if (rowContainAliveCell(game, row) != -1) {
        return true;
      }
    }

    return false;
  }

  private static int rowContainAliveCell(GameOfLife game, int row) {
    return game.getRow(row).indexOf(GameOfLife.ALIVE_CELL);
  }

  private static void printGame(GameOfLife game) {
    for (int row = 0; row < game.getRowCount(); row++) {
      System.out.println(game.getRow(row));
    }

    System.out.println();
  }

  private static GameOfLife readGameFromFile(File file) throws IOException {
    return parseTextFormat(new FileReader(file));
  }

  void addRow(String row) {
    this.grid[this.nextUnpopulatedRow] = row.toCharArray();
    this.nextUnpopulatedRow++;
  }

  void computeNextGeneration() {
    char[][] newGrid = new char[this.rowCount][this.columnCount];

    for (int row = 0; row < this.rowCount; row++) {
      newGrid[row] = new char[this.columnCount];

      for (int column = 0; column < this.columnCount; column++) {
        newGrid[row][column] = getNextGenerationCell(row, column);
      }
    }

    this.grid = newGrid;
  }

  private char getNextGenerationCell(int row, int column) {
    char cell = getCell(row, column);
    int numberOfLiveNeighbors = getNumberOfLiveNeighbors(row, column);
    if (cell == ALIVE_CELL) {
      if (numberOfLiveNeighbors < 2) {
        return DEAD_CELL;

      } else if (numberOfLiveNeighbors > 3) {
        return DEAD_CELL;

      } else if (numberOfLiveNeighbors == 2 || numberOfLiveNeighbors == 3){
        return ALIVE_CELL;
      }

    } else {
      assert cell == DEAD_CELL;

      if (numberOfLiveNeighbors == 3) {
        return ALIVE_CELL;
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

  @VisibleForTesting
  char getCell(int row, int column) {
    return this.grid[row][column];
  }

  String getRow(int rowIndex) {
    return new String(this.grid[rowIndex]);
  }

  @VisibleForTesting
  int getRowCount() {
    return rowCount;
  }

  @VisibleForTesting
  static GameOfLife parseTextFormat(Reader reader) throws IOException {
    BufferedReader br = new BufferedReader(reader);

    int rowCount = Integer.parseInt(br.readLine());
    int columnCount = Integer.parseInt(br.readLine());

    GameOfLife game = new GameOfLife(rowCount, columnCount);
    for (int row = 0; row < rowCount; row++) {
      game.addRow(br.readLine());
    }

    return game;
  }

  public Generation getCurrentGeneration() {
    return new Generation(this.grid);
  }

  public int getColumnCount() {
    return columnCount;
  }
}