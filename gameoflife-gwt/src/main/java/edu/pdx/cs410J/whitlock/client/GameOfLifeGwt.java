package edu.pdx.cs410J.whitlock.client;

import com.google.common.annotations.VisibleForTesting;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.Collection;

/**
 * A basic GWT class that makes sure that we can send an appointment book back from the server
 */
public class GameOfLifeGwt implements EntryPoint {
  private final Alerter alerter;

  @VisibleForTesting
  Button startGame;

  TextBox numberOfRows;
  TextBox numberOfColumns;

  public GameOfLifeGwt() {
    this(new Alerter() {
      @Override
      public void alert(String message) {
        Window.alert(message);
      }
    });
  }

  @VisibleForTesting
  GameOfLifeGwt(Alerter alerter) {
    this.alerter = alerter;

    addWidgets();
  }

  private void addWidgets() {
    startGame = new Button("Start new Game of Life");
    startGame.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        pingServer();
      }
    });

    numberOfColumns = new TextBox();
    showOnly3Charaters(numberOfColumns);

    numberOfRows = new TextBox();
    showOnly3Charaters(numberOfRows);
  }

  private static void showOnly3Charaters(TextBox numberOfColumns) {
    numberOfColumns.setMaxLength(3);
    numberOfColumns.setVisibleLength(3);
  }

  private void pingServer() {
    PingServiceAsync async = GWT.create(PingService.class);
    async.ping(new AsyncCallback<AppointmentBook>() {

      @Override
      public void onFailure(Throwable ex) {
        alerter.alert(ex.toString());
      }

      @Override
      public void onSuccess(AppointmentBook airline) {
        StringBuilder sb = new StringBuilder(airline.toString());
        Collection<Appointment> flights = airline.getAppointments();
        for (Appointment flight : flights) {
          sb.append(flight);
          sb.append("\n");
        }
        alerter.alert(sb.toString());
      }
    });
  }

  @Override
  public void onModuleLoad() {
    RootPanel rootPanel = RootPanel.get();

    HorizontalPanel panel = new HorizontalPanel();
    panel.add(new Label("Rows"));
    panel.add(numberOfRows);
    panel.add(new Label("by Columns"));
    panel.add(numberOfColumns);
    panel.add(startGame);

    rootPanel.add(panel);
  }

  @VisibleForTesting
  interface Alerter {
    void alert(String message);
  }

}
