package Reservation_GuestStayManagement_m2;
import java.util.ArrayList;
public class ReservationManager {
    
 private ArrayList<Reservation> reservations;

    public ReservationManager() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added successfully.");
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    /*this will show that if the ID matches any reservation ID in the list
    it will return the reservation.However, if it didn't it will return 
    null
    */
   public Reservation searchById(int searchedId) {

    for (Reservation reservation : reservations) {

        if (reservation.getReservationId() == searchedId) {
            return reservation;
        }
    }

    return null;
}
   public ArrayList<Reservation> searchByGuestName(String searchedName) {

    ArrayList<Reservation> results = new ArrayList<>();

    for (Reservation reservation : reservations) {

        if (reservation.getGuestName().equalsIgnoreCase(searchedName)) {
            results.add(reservation);
        }
    }

    return results;
   }
   /* This will search for reservations using the room number
  if the room number matches the reservation will be added
  to the results list
 */
   public ArrayList<Reservation> searchByRoomNumber(int searchedRoomNumber) {

    ArrayList<Reservation> results = new ArrayList<>();

    for (Reservation reservation : reservations) {

        if (reservation.getRoomNumber() == searchedRoomNumber) {
            results.add(reservation);
        }
    }

    return results;
    }
   /*
    This will search for the reservation using its ID.
    If the reservation is found, the information will be updated
    and the method will return true. If it is not found
    the method will return false.
   */
  public boolean editReservation(int reservationId,String newGuestName,String newGuestPhone,String newGuestEmail,
  String newPassportNumber,int newRoomNumber,String newCheckInDate,String newCheckOutDate)
   {

    Reservation reservation = searchById(reservationId);

    if (reservation == null) {
        return false;
    }

    reservation.setGuestName(newGuestName);
    reservation.setGuestPhone(newGuestPhone);
    reservation.setGuestEmail(newGuestEmail);
    reservation.setPassportNumber(newPassportNumber);
    reservation.setRoomNumber(newRoomNumber);
    reservation.setCheckInDate(newCheckInDate);
    reservation.setCheckOutDate(newCheckOutDate);

    return true;
}
  // cancellation method
  public boolean cancelReservation(int reservationId) {

    Reservation reservation = searchById(reservationId);

    if (reservation == null) {
        return false;
    }

    if (reservation.getReservationStatus()
            == ReservationStatus.CHECKED_OUT) {
        return false;
    }

    reservation.setReservationStatus(
            ReservationStatus.CANCELLED
    );

    return true;
 }
  //check in and check out 
  public boolean checkInCheckOut(
        int reservationId,
        ReservationStatus newStatus) {

    Reservation reservation = searchById(reservationId);

    if (reservation == null) {
        return false;
    }

    ReservationStatus currentStatus =
            reservation.getReservationStatus();

    if (currentStatus == ReservationStatus.RESERVED&& newStatus == ReservationStatus.CHECKED_IN)
    {

        reservation.setReservationStatus(
                ReservationStatus.CHECKED_IN
        );

        return true;
    }

    if (currentStatus == ReservationStatus.CHECKED_IN
            && newStatus == ReservationStatus.CHECKED_OUT) {

        reservation.setReservationStatus(
                ReservationStatus.CHECKED_OUT
        );

        return true;
    }

    return false;
}
  public void displayReservations() {

    if (reservations.isEmpty()) {
        System.out.println("No reservations found.");
        return;
    }

    for (Reservation reservation : reservations) {
        System.out.println(reservation);
    }
}
 public void reservationReport() {

    int reserved = 0;
    int checkedIn = 0;
    int checkedOut = 0;
    int cancelled = 0;

    for (Reservation reservation : reservations) {

        ReservationStatus status =
                reservation.getReservationStatus();

        if (status != null) {

            switch (status) {

                case RESERVED -> reserved++;
                case CHECKED_IN -> checkedIn++;
                case CHECKED_OUT -> checkedOut++;
                case CANCELLED -> cancelled++;
            }
        }
    }

    System.out.println("----- Reservation Report -----");
    System.out.println("Total reservations: " + reservations.size());
    System.out.println("Reserved: " + reserved);
    System.out.println("Checked in: " + checkedIn);
    System.out.println("Checked out: " + checkedOut);
    System.out.println("Cancelled: " + cancelled);
    }
}
