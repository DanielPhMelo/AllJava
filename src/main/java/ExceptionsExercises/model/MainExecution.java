package ExceptionsExercises.model;

import ExceptionsExercises.model.exceptions.DomainException;
import ExceptionsExercises.model.interfaces.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room Number: ");
            int numeroDoQuarto = scanner.nextInt();
            System.out.println("CheckIn Date - dd/mm/yyyy: ");
            Date checkinDate = simpleDateFormat.parse(scanner.next());
            System.out.println("CheckOut Date - dd/mm/yyyy: ");
            Date checkOutDate = simpleDateFormat.parse(scanner.next());

            Reservation reservation = new ReservationImpl(numeroDoQuarto, checkinDate, checkOutDate);
            System.out.println(reservation.toString());

            System.out.println();
            System.out.print("Now you can update the reservation dates: ");
            System.out.println("CheckIn Date - dd/mm/yyyy: ");
            checkinDate = simpleDateFormat.parse(scanner.next());
            System.out.println("CheckOut Date - dd/mm/yyyy: ");
            checkOutDate = simpleDateFormat.parse(scanner.next());

            reservation.updateDates(checkinDate, checkOutDate);

            System.out.println(reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format!");
        }
        catch(DomainException e){
            System.out.println("Error in reservation " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("An unknown error has happened!");
        }

        scanner.close();
    }
}
