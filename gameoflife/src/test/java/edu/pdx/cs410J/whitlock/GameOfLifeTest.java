package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class GameOfLifeTest
{

  @Test
  public void oneDeadCellStaysDead() {
    GameOfLife game = new GameOfLife(1, 1);
    game.addRow(".");
    game.computeNextGeneration();
    assertThat(game.getRow(0), equalTo("."));
  }

  @Test
  public void oneLiveCellDies() {
    GameOfLife game = new GameOfLife(1, 1);
    game.addRow("*");
    game.computeNextGeneration();
    assertThat(game.getRow(0), equalTo("."));
  }

  @Test
  public void noLiveNeighborsAtTopLeft() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("*.");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(0, 0), equalTo(0));
  }

  @Test
  public void oneLiveNeighborToTheNorthwest() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("*.");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(1, 1), equalTo(1));
  }

  @Test
  public void oneLiveNeighborToTheNorth() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("*.");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(1, 0), equalTo(1));
  }

  @Test
  public void noLiveNeighborsAtTopRight() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(0, 1), equalTo(0));
  }

  @Test
  public void oneLiveNeighborToTheNortheast() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow(".*");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(1, 0), equalTo(1));
  }

  @Test
  public void oneLiveNeighborToTheEast() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow(".*");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(0, 0), equalTo(1));
  }

  @Test
  public void noLiveNeighborsAtBottomRight() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(1, 1), equalTo(0));
  }

  @Test
  public void oneLiveNeighborToTheSoutheast() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow(".*");
    assertThat(game.getNumberOfLiveNeighbors(0, 0), equalTo(1));
  }

  @Test
  public void oneLiveNeighborToTheSouth() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow(".*");
    assertThat(game.getNumberOfLiveNeighbors(0, 1), equalTo(1));
  }

  @Test
  public void noLiveNeighborsAtBottomLeft() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow("..");
    assertThat(game.getNumberOfLiveNeighbors(1, 0), equalTo(0));
  }

  @Test
  public void oneLiveNeighborToTheSouthwest() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow("*.");
    assertThat(game.getNumberOfLiveNeighbors(0, 1), equalTo(1));
  }

  @Test
  public void oneLiveNeighborToTheWest() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("..");
    game.addRow("*.");
    assertThat(game.getNumberOfLiveNeighbors(1, 1), equalTo(1));
  }

  @Test
  public void liveCellWithTwoNeighborsLives() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("**");
    game.addRow("*.");
    game.computeNextGeneration();
    assertThat(game.getRow(0), equalTo("**"));
    assertThat(game.getRow(1).charAt(0), equalTo('*'));
  }

  @Test
  public void deadCellWithThreeLiveNeighborsBecomesAlive() {
    GameOfLife game = new GameOfLife(2, 2);
    game.addRow("**");
    game.addRow("*.");
    game.computeNextGeneration();
    assertThat(game.getRow(1).charAt(1), equalTo('*'));
  }

  @Test
  public void deadCellWithFourLiveNeighborsStaysDead() {
    GameOfLife game = new GameOfLife(2, 3);
    game.addRow("**.");
    game.addRow("*.*");
    game.computeNextGeneration();
    assertThat(game.getRow(1).charAt(1), equalTo('.'));
  }

}
