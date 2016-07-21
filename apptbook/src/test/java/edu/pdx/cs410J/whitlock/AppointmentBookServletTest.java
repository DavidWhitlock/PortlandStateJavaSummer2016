package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

/**
 * A unit test for the {@link AppointmentBookServlet}.  It uses mockito to
 * provide mock http requests and responses.
 */
public class AppointmentBookServletTest {

  @Test
  public void getOnServletPrettyPrintsPreCannedAppointmentBookOwner() throws ServletException, IOException {
    AppointmentBookServlet servlet = new AppointmentBookServlet();

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    PrintWriter pw = mock(PrintWriter.class);

    String ownerName = "PreCannedOwner";
    when(request.getParameter("owner")).thenReturn(ownerName);

    when(response.getWriter()).thenReturn(pw);

    servlet.doGet(request, response);

    verify(pw).println(ownerName);
    verify(response).setStatus(HttpServletResponse.SC_OK);
  }

  @Test
  public void postToServletCreatesAppointment() throws ServletException, IOException {
    AppointmentBookServlet servlet = new AppointmentBookServlet();

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    PrintWriter pw = mock(PrintWriter.class);

    String ownerName = "PreCannedOwner";
    when(request.getParameter("owner")).thenReturn(ownerName);
    String description = "My description";
    when(request.getParameter("description")).thenReturn(description);
    String beginTime = "1/1/2016 1:00 PM";
    when(request.getParameter("beginTime")).thenReturn(beginTime);
    String endTime = "1/2/2016 2:00 PM";
    when(request.getParameter("endTime")).thenReturn(endTime);


    when(response.getWriter()).thenReturn(pw);

    servlet.doPost(request, response);

    verify(response).setStatus(HttpServletResponse.SC_OK);

    AppointmentBook book = servlet.getAppointmentBookForOwner(ownerName);
    Collection<Appointment> appointments = book.getAppointments();
    assertThat(appointments.size(), equalTo(1));
    Appointment appointment = appointments.iterator().next();
    assertThat(appointment.getDescription(), equalTo(description));
    assertThat(appointment.getBeginTimeString(), equalTo(beginTime));
    assertThat(appointment.getEndTimeString(), equalTo(endTime));
  }
}
