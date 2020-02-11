package ExceptionsExercises.model;

import ExceptionsExercises.model.exceptions.DomainException;
import ExceptionsExercises.model.interfaces.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationImpl implements Reservation {
    private Integer roomNumber;
    private Date checkinDate;
    private Date checkoutDate;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ReservationImpl(Integer roomNumber, Date checkinDate, Date checkoutDate) throws DomainException{
        if (checkinDate.after(checkoutDate)){
            throw new DomainException("Data de CheckIn não pode ser maior que data de Checkout");
        }
        this.roomNumber = roomNumber;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public Long getDurationInDays() {
        long diffBetweenDates = this.checkoutDate.getTime() - this.checkinDate.getTime();
        return TimeUnit.DAYS.convert(diffBetweenDates, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Error when making reservation. The dates must be future dates") ;
        }
        if (checkIn.after(checkOut)){
            throw new DomainException("Data de CheckIn não pode ser maior que data de Checkout");
        }

        this.checkinDate = checkIn;
        this.checkoutDate = checkOut;

        return null;
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
