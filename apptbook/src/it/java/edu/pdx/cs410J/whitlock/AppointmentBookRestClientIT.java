package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.web.HttpRequestHelper.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Integration test that tests the REST calls made by {@link AppointmentBookRestClient}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentBookRestClientIT {
  private static final String HOSTNAME = "localhost";
  private static final String PORT = System.getProperty("http.port", "8080");

  private AppointmentBookRestClient newAppointmentBookRestClient() {
    int port = Integer.parseInt(PORT);
    return new AppointmentBookRestClient(HOSTNAME, port);
  }

  @Test
  public void invokingGETWithJustOwnerParameterPrettyPrintsOwnerName() throws IOException {
    AppointmentBookRestClient client = newAppointmentBookRestClient();
    String owner = "PreCannedOwner";
    Response response = client.prettyPrintAppointmentBook(owner);
    assertThat(response.getContent(), response.getCode(), equalTo(200));
    assertThat(response.getContent(), containsString(owner));
  }

  @Test
  public void invokingPOSTCreatesAnAppointment() throws IOException {
    AppointmentBookRestClient client = newAppointmentBookRestClient();
    String owner = "PreCannedOwner";

    String description = "Description";
    String beginTime = "1/1/2016 1:00 PM";
    String endTime = "1/2/2016 2:00 PM";
    Response response = client.createAppointment(owner, description, beginTime, endTime);
    assertThat(response.getContent(), response.getCode(), equalTo(200));

    response = client.prettyPrintAppointmentBook(owner);
    assertThat(response.getContent(), response.getCode(), equalTo(200));
    assertThat(response.getContent(), containsString(owner));
    assertThat(response.getContent(), containsString(description));
    assertThat(response.getContent(), containsString(beginTime));
    assertThat(response.getContent(), containsString(endTime));
  }


}
