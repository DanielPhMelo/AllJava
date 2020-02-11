package ExceptionsExercises.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainExecution {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int numeroDoQuarto = scanner.nextInt();
        System.out.println("CheckIn Date - dd/mm/yyyy: ");
        Date checkinDate = simpleDateFormat.parse(scanner.next()) ;
        System.out.println("CheckOut Date - dd/mm/yyyy: ");
        Date checkOutDate = simpleDateFormat.parse(scanner.next()) ;

        if (checkinDate.after(checkOutDate)){
            System.out.println("Data de CheckIn não pode ser maior que data de Checkout");
        }else{
            Reservation reservation = new ReservationImpl(numeroDoQuarto, checkinDate, checkOutDate);
            System.out.println(reservation.toString());

            System.out.println();
            System.out.print("Now you can update the reservation dates: ");
            System.out.println("CheckIn Date - dd/mm/yyyy: ");
            checkinDate = simpleDateFormat.parse(scanner.next()) ;
            System.out.println("CheckOut Date - dd/mm/yyyy: ");
            checkOutDate = simpleDateFormat.parse(scanner.next()) ;

            String returnedMessage = reservation.updateDates(checkinDate, checkOutDate);

            if (returnedMessage.equals(null)){
                System.out.println(reservation.toString());
            }else
            {
                System.out.println(returnedMessage);
            }

        }

        scanner.close();
    }
}
