package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.i18n.client.DateTimeFormat;
import edu.pdx.cs410J.AbstractAppointment;

import java.util.Date;

public class Appointment extends AbstractAppointment
{
    @Override
    public String getBeginTimeString()
    {
        return "START " + getBeginTime();
    }

    @Override
    public String getEndTimeString()
    {
        return "END + " + formatDate(getEndTime());
    }

    private String formatDate(Date date) {
        String pattern = "yyyy/MM/dd hh:mm a";
        return DateTimeFormat.getFormat(pattern).format(date);
    }

    @Override
    public Date getEndTime()
    {
        return new Date();
    }

    @Override
    public String getDescription()
    {
        return "My description";
    }

    @Override
    public Date getBeginTime()
    {
        return new Date();
    }
}
