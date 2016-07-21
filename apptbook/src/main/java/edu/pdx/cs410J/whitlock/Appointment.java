package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractAppointment;

public class Appointment extends AbstractAppointment {
  private final String description;
  private final String beginTime;
  private final String endTime;

  public Appointment(String description, String beginTime, String endTime) {
    this.description = description;
    this.beginTime = beginTime;
    this.endTime = endTime;
  }

  @Override
  public String getBeginTimeString() {
    return this.beginTime;
  }

  @Override
  public String getEndTimeString() {
    return this.endTime;
  }

  @Override
  public String getDescription() {
    return this.description;
  }
}
