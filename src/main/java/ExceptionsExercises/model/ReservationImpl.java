package ExceptionsExercises.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationImpl implements Reservation {
    private Integer roomNumber;
    private Date checkinDate;
    private Date checkoutDate;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ReservationImpl(Integer roomNumber, Date checkinDate, Date checkoutDate) {
        this.roomNumber = roomNumber;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public Long getDurationInDays() {
        long diffBetweenDates = this.checkoutDate.getTime() - this.checkinDate.getTime();
        return TimeUnit.DAYS.convert(diffBetweenDates, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkinDate = checkIn;
        this.checkoutDate = checkOut;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber
                +", Check-in: " +simpleDateFormat.format(this.checkinDate)
                +", Check-in: " +simpleDateFormat.format(this.checkoutDate)
                +", " + this.getDurationInDays() + " nights "
                ;
    }
}