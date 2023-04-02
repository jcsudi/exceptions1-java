package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import modo.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(),dtf);
		System.out.print("Check-out date (dd/MM/yyyy); ");
		LocalDate checkOut = LocalDate.parse(sc.next(),dtf);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation.toString());
		
			System.out.println();
			System.out.println("Enter data to uptade the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(),dtf);
			System.out.print("Check-out date (dd/MM/yyyy); ");
			checkOut = LocalDate.parse(sc.next(),dtf);
					
			LocalDate dataAtual = LocalDate.now();
			
			if(checkIn.isBefore(dataAtual) || checkOut.isBefore(dataAtual)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			
			else if (!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {

				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation.toString());
				
			}
	
		}
		
		sc.close();
	
	}

}
