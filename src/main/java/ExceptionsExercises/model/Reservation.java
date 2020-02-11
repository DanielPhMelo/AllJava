package ExceptionsExercises.model;

import java.util.Date;
import java.util.GregorianCalendar;

public interface Reservation {
    Long getDurationInDays();
    String updateDates(Date checking, Date checkout);
}
