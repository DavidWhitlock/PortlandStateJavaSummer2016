package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client-side interface to the ping service
 */
public interface GenerationServiceAsync {

  /**
   * Return the current date/time on the server
   */
  void createNewGameOfLife(int numberOfRows, int numberOfColumns, AsyncCallback<Generation> async);
}
