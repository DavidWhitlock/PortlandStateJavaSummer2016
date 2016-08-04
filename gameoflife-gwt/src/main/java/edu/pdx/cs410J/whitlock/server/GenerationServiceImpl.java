package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.whitlock.client.Generation;
import edu.pdx.cs410J.whitlock.client.GenerationService;

/**
 * The server-side implementation of the division service
 */
public class GenerationServiceImpl extends RemoteServiceServlet implements GenerationService
{
  @Override
  public Generation createNewGameOfLife(int numberOfRows, int numberOfColumns) {
    GameOfLife game = new GameOfLife(numberOfRows, numberOfColumns);
    return game.getCurrentGeneration();
  }

  @Override
  protected void doUnexpectedFailure(Throwable unhandled) {
    unhandled.printStackTrace(System.err);
    super.doUnexpectedFailure(unhandled);
  }

}
