package Reservation_GuestStayManagement_m2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
   private int reservationId;
    private String guestName;
    private String guestPhone;
    private String guestEmail;
    private String passportNumber;
    private int roomNumber;
    private String checkInDate;
    private String checkOutDate;
    private ReservationStatus reservationStatus; 
    //constructor
    public Reservation(int reservationId, String guestName,
        String guestPhone, String guestEmail,
        String passportNumber, int roomNumber,
        String checkInDate, String checkOutDate,
        ReservationStatus reservationStatus) {

    this.reservationId = reservationId;
    this.guestName = guestName;
    this.guestPhone = guestPhone;
    this.guestEmail = guestEmail;
    this.passportNumber = passportNumber;
    this.roomNumber = roomNumber;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.reservationStatus = reservationStatus;
    }
    //getters and setters
        public int getReservationId() {
    return reservationId;
}

public void setReservationId(int reservationId) {
    this.reservationId = reservationId;
}

public String getGuestName() {
    return guestName;
}

public void setGuestName(String guestName) {
    this.guestName = guestName;
}

    public String getGuestPhone() {
    return guestPhone;
}

    public void setGuestPhone(String guestPhone) {
    this.guestPhone = guestPhone;
}

    public String getGuestEmail() {
    return guestEmail;
}

    public void setGuestEmail(String guestEmail) {
    this.guestEmail = guestEmail;
}

    public String getPassportNumber() {
    return passportNumber;
}

    public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
}

    public int getRoomNumber() {
    return roomNumber;
}

    public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
}

    public String getCheckInDate() {
    return checkInDate;
}

    public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
}

    public String getCheckOutDate() {
    return checkOutDate;
}

    public void setCheckOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
}

    public ReservationStatus getReservationStatus() {
    return reservationStatus;
}
        //Reservationstatus is an enum
    public void setReservationStatus(ReservationStatus reservationStatus) {
    this.reservationStatus = reservationStatus;
}
    @Override
   
    public String toString() {
    return reservationId + " - " + guestName + " - Room " + roomNumber + " - " + reservationStatus;
    }
    public long calculateNumberOfNights() {

    DateTimeFormatter format;
       format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate checkIn;
       checkIn = LocalDate.parse(checkInDate, format);

    LocalDate checkOut;
       checkOut = LocalDate.parse(checkOutDate, format);

    return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

} 


