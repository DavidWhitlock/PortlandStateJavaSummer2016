package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.whitlock.client.Generation;
import edu.pdx.cs410J.whitlock.client.GenerationService;

import java.util.Random;

/**
 * The server-side implementation of the division service
 */
public class GenerationServiceImpl extends RemoteServiceServlet implements GenerationService
{
  @Override
  public Generation createNewGameOfLife(int numberOfRows, int numberOfColumns) {
    GameOfLife game = new GameOfLife(numberOfRows, numberOfColumns);
    populateGameWithRandomCells(game);
    return game.getCurrentGeneration();
  }

  private void populateGameWithRandomCells(GameOfLife game) {
    Random random = new Random();
    for (int row = 0; row < game.getRowCount(); row++) {
      StringBuilder rowString = new StringBuilder();
      for (int column = 0; column < game.getColumnCount(); column++) {
        rowString.append(getRandomCellState(random));
      }
      game.addRow(rowString.toString());
    }

  }

  private char getRandomCellState(Random random) {
    boolean isAlive = random.nextBoolean();
    return isAlive ? '*' : '.';
  }

  @Override
  protected void doUnexpectedFailure(Throwable unhandled) {
    unhandled.printStackTrace(System.err);
    super.doUnexpectedFailure(unhandled);
  }

}
