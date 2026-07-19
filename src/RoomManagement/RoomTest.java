/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement;

/**
 *
 * @author jj
 */
public class RoomTest {
    
    public static void main(String[] args) {

        RoomManager manager = new RoomManager();
        
        RoomFiles files = new RoomFiles(manager);
        
        manager.addRoom(new Room(101, 1, "Single", 1, 30.0, 
                RoomStatus.AVAILABLE, true, true, true, false));
        
        manager.addRoom(new Room(102, 1, "Single", 1, 30.0, 
                RoomStatus.AVAILABLE, true, true, false, false));
        
        manager.addRoom(new Room(201, 2, "Double", 2, 45.0, 
                RoomStatus.RESERVED, true, true, true, false));
        
        manager.addRoom(new Room(202, 2, "Double", 2, 50.0, 
                RoomStatus.AVAILABLE, true, true, true, true));
        
        manager.addRoom(new Room(301, 3, "Suite", 3, 80.0, 
                RoomStatus.OCCUPIED, true, true, true, true));
        
        manager.addRoom(new Room(401, 4, "Family", 4, 95.0, 
                RoomStatus.MAINTENANCE, true, true, true, true));
        
        manager.addRoom(new Room(402, 4, "Deluxe", 2, 70.0, 
                RoomStatus.AVAILABLE, true, true, true, true));
        
        manager.addRoom(new Room(501, 5, "Suite", 3, 85.0, 
                RoomStatus.RESERVED, true, true, true, true));
        
        manager.addRoom(new Room(601, 6, "Family", 4, 100.0, 
                RoomStatus.AVAILABLE, true, true, true, true));
        
        files.saveRooms();

    }

}
