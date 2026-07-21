//this class connnects the reservations to the room management module
package Reservation_GuestStayManagement_m2;




import RoomManagement_m1.Room;
import RoomManagement_m1.RoomFiles;
import RoomManagement_m1.RoomManager;
import RoomManagement_m1.RoomStatus;
import java.util.ArrayList;

public class RoomService {

    private RoomManager roomManager;
    private RoomFiles roomFiles;

    public RoomService() {

        roomManager = new RoomManager();
        roomFiles = new RoomFiles(roomManager);

        roomFiles.loadRooms();
    }

    public ArrayList<Room> getAvailableRooms() {

        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : roomManager.getRooms()) {

            if (room.getRoomStatus() == RoomStatus.AVAILABLE) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    // This method finds a room using its room number
    public Room findRoom(int roomNumber) {

        for (Room room : roomManager.getRooms()) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    // This method checks if the room exists and is available
    public boolean isRoomAvailable(int roomNumber) {

        Room room = findRoom(roomNumber);

        if (room == null) {
            return false;
        }

        return room.getRoomStatus() == RoomStatus.AVAILABLE;
    }

    // This method changes an available room's status to reserved
    public boolean reserveRoom(int roomNumber) {

        if (!isRoomAvailable(roomNumber)) {
            return false;
        }

        roomManager.changeRoomStatus(
                roomNumber,
                RoomStatus.RESERVED
        );

        roomFiles.saveRooms();

        return true;
    }
    public boolean occupyRoom(int roomNumber) {

    Room room = findRoom(roomNumber);

    if (room == null) {
        return false;
    }

    if (room.getRoomStatus() != RoomStatus.RESERVED) {
        return false;
    }

    roomManager.changeRoomStatus(
            roomNumber,
            RoomStatus.OCCUPIED
    );

    roomFiles.saveRooms();

    return true;
}
    public boolean releaseRoom(int roomNumber) {

    Room room = findRoom(roomNumber);

    if (room == null) {
        return false;
    }

    if (room.getRoomStatus() != RoomStatus.RESERVED
            && room.getRoomStatus() != RoomStatus.OCCUPIED) {
        return false;
    }

    roomManager.changeRoomStatus(
            roomNumber,
            RoomStatus.AVAILABLE
    );

    roomFiles.saveRooms();

    return true;
}
}
