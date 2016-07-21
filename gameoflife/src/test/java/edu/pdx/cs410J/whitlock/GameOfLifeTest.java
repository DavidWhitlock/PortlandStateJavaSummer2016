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

}
