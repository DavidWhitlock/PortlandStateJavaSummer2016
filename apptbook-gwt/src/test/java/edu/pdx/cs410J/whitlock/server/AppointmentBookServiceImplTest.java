package edu.pdx.cs410J.whitlock.server;

import edu.pdx.cs410J.whitlock.client.AppointmentBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppointmentBookServiceImplTest {

  @Test
  public void serviceReturnsExpectedAirline() {
    AppointmentBookServiceImpl service = new AppointmentBookServiceImpl();
    int numberOfAppointments = 6;
    AppointmentBook airline = service.createAppointmentBook(numberOfAppointments);
    assertThat(airline.getAppointments().size(), equalTo(numberOfAppointments));
  }
}
