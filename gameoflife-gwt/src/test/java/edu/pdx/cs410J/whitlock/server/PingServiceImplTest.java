package edu.pdx.cs410J.whitlock.server;

import edu.pdx.cs410J.whitlock.client.AppointmentBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PingServiceImplTest {

  @Test
  public void pingReturnsExpectedAirline() {
    GenerationServiceImpl service = new GenerationServiceImpl();
    AppointmentBook airline = service.createNewGameOfLife();
    assertThat(airline.getAppointments().size(), equalTo(1));
  }
}
