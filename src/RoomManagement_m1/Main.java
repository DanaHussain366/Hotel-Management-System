/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement_m1;

/**
 *
 * @author jj
 */
public class Main {
    
    public static void main(String[] args) {

        RoomManager manager = new RoomManager();
        RoomFiles files = new RoomFiles(manager);

        files.loadRooms();

        manager.displayRooms();

    }
}
