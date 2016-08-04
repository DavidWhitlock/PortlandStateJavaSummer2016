package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * A GWT remote service that returns a dummy appointment book
 */
@RemoteServiceRelativePath("ping")
public interface GenerationService extends RemoteService {

  /**
   * Returns the current date and time on the server
   * @param numberOfRows
   * @param numberOfColumns
   */
  public Generation createNewGameOfLife(int numberOfRows, int numberOfColumns);

}
