package ReservationAndGuestStay_m2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReservationFiles {

    private ReservationManager manager;

    public ReservationFiles(ReservationManager manager) {
        this.manager = manager;
    }
    public void saveReservations() {

    try {

        PrintWriter writer =
                new PrintWriter("reservations.txt");

        for (Reservation reservation: manager.getReservations()) {

            writer.println(
                    reservation.getReservationId() + "," +
                    reservation.getGuestName() + "," +
                    reservation.getGuestPhone() + "," +
                    reservation.getGuestEmail() + "," +
                    reservation.getPassportNumber() + "," +
                    reservation.getRoomNumber() + "," +
                    reservation.getCheckInDate() + "," +
                    reservation.getCheckOutDate() + "," +
                    reservation.getReservationStatus() 
                );
        }

        writer.close();
        System.out.println("Reservations saved successfully.");

    } catch (IOException e) {

            System.out.println("Error: reservations could not be saved.");
    }
    }
    public void loadReservations() {

    try {

        Scanner input =
                new Scanner(new File("reservations.txt"));

        manager.getReservations().clear();

        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] data = line.split(",");

            int reservationId = Integer.parseInt(data[0]);
            String guestName = data[1];
            String guestPhone = data[2];
            String guestEmail = data[3];
            String passportNumber = data[4];
            int roomNumber = Integer.parseInt(data[5]);
            String checkInDate = data[6];
            String checkOutDate = data[7];

            ReservationStatus status =
                    ReservationStatus.valueOf(data[8]);

            Reservation reservation = new Reservation(
                    reservationId,
                    guestName,
                    guestPhone,
                    guestEmail,
                    passportNumber,
                    roomNumber,
                    checkInDate,
                    checkOutDate,
                    status
            );

            manager.addReservation(reservation);
        }

        input.close();

        System.out.println("Reservations loaded successfully.");

    } catch (IOException e) {

        System.out.println("No reservation file was found.");
        }
    }
    
        }
  