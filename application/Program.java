package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
  public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("room number: ");
    int number = sc.nextInt();

    System.out.print("check-in date (DD/MM/YYYY): ");
    Date checkIn = sdf.parse(sc.next());

    System.out.print("check-out date (DD/MM/YYYY): ");
    Date checkOut = sdf.parse(sc.next());

    if (!checkOut.after(checkIn)) {
      System.out.println("Error in reservation: check-Out date must be after check-in date.");
    } else {
      Reservation reservation = new Reservation(number, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);

      System.out.println("Enter data to update reservation: ");
      
      System.out.print("check-in date (DD/MM/YYYY): ");
      checkIn = sdf.parse(sc.next());

      System.out.print("check-out date (DD/MM/YYYY): ");
      checkOut = sdf.parse(sc.next());

        String error = reservation.updateDates(checkIn, checkOut);
        if(error != null) {
         System.out.println("error in reservation: " +error);
        }
        else{
          System.out.println("Reservation: " + reservation);
        }
    }
    sc.close();
  }
}