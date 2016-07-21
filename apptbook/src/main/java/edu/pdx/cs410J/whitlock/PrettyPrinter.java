package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.IOException;
import java.io.PrintWriter;

public class PrettyPrinter implements AppointmentBookDumper {
  private final PrintWriter writer;

  public PrettyPrinter(PrintWriter pw) {
    this.writer = pw;
  }

  @Override
  public void dump(AbstractAppointmentBook abstractAppointmentBook) throws IOException {
    this.writer.println(abstractAppointmentBook.getOwnerName());

    AppointmentBook appointmentBook = (AppointmentBook) abstractAppointmentBook;
    for (Appointment appointment : appointmentBook.getAppointments()) {
      this.writer.println(appointment.getDescription());
      this.writer.println(appointment.getBeginTimeString());
      this.writer.println(appointment.getEndTimeString());

    }
  }
}
