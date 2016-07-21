package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppointmentBook extends AbstractAppointmentBook<Appointment> {
  private final String owner;
  private List<Appointment> apppointments = new ArrayList<>();

  public AppointmentBook(String owner) {
    this.owner = owner;

  }

  @Override
  public String getOwnerName() {
    return this.owner;
  }

  @Override
  public Collection<Appointment> getAppointments() {
    return this.apppointments;
  }

  @Override
  public void addAppointment(Appointment appt) {
    this.apppointments.add(appt);
  }
}
