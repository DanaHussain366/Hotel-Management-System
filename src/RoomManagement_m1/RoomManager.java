/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement_m1;


/**
 * Jana Salem 2241100402
 */

import java.util.ArrayList;


public class RoomManager {
    
    private ArrayList <Room> rooms = new ArrayList <>();
   
    public void addRoom(Room r){
        rooms.add(r);
    }
    
    public Room searchRoomNumber(int roomNumber){
        for (Room r : rooms){
            if (r.getRoomNumber() == roomNumber){
               return r;
            } 
        }
        return null;
    }
    
    public ArrayList<Room> searchRoomType(String roomType) {

        ArrayList<Room> result = new ArrayList<>();

        for (Room r : rooms) {

            if (r.getRoomType().equalsIgnoreCase(roomType)) {
                result.add(r);
            }
        }
        return result;
    }
    
    public ArrayList<Room> searchFloorNumber(int floorNumber) {

        ArrayList<Room> result = new ArrayList<>();

        for (Room r : rooms) {
            
            if (r.getFloorNumber() == floorNumber) {
                result.add(r);
            }
        }
        return result;
    }
    
    public ArrayList<Room> searchRoomStatus(RoomStatus roomStatus) {

        ArrayList<Room> result = new ArrayList<>();

        for (Room r : rooms) {

            if (r.getRoomStatus() == roomStatus) {
                result.add(r);
            }
        }
        return result;
    }
    
    public void editRoom(int roomNumber, int floorNumber, String roomType, int bedCount, double pricePerNight,
        RoomStatus roomStatus, boolean hasAC, boolean hasWifi, boolean hasTV, boolean hasBalcony){
        
        for (Room r : rooms){
            
            if (r.getRoomNumber() == roomNumber){
                
                r.setFloorNumber(floorNumber);
                r.setRoomType(roomType);
                r.setBedCount(bedCount);
                r.setPricePerNight(pricePerNight);
                r.setRoomStatus(roomStatus);
                r.setHasAC(hasAC);
                r.setHasWifi(hasWifi);
                r.setHasTV(hasTV);
                r.setHasBalcony(hasBalcony);
               
                System.out.println("The room has been updated!");
                return; 
            }
        }
        
        System.out.println("No room found.");
    }
    
    public void deleteRoom(int roomNumber){
        
        for (int i = 0; i < rooms.size(); i++) {

            if (rooms.get(i).getRoomNumber() == roomNumber) {

                rooms.remove(i);

                System.out.println("The room has been removed from the system.");
                return;
            }
        }
        
        System.out.println("No room found.");
    }
    
    public void changeRoomStatus (int roomNumber , RoomStatus roomStatus){
        
        for (Room r : rooms){
            if (r.getRoomNumber() == roomNumber){
               r.setRoomStatus(roomStatus);
               System.out.println("The room status has been updated.");
               return;
            } 
        }
        
        System.out.println("No room found.");
    }
    
    public void displayRooms(){
        if (rooms.isEmpty()){
            System.out.println("No rooms found in the system.");
            return;
        }
        
        for (Room r: rooms){
            System.out.println("--------------------------");
            System.out.println(r);
            System.out.println("--------------------------");
        }
    }
    
    public void roomAvailabilityReport (){
        int available = 0;
        int reserved = 0;
        int occupied = 0;
        int maintenance = 0;
      
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
            return;
        } 
        
        for (Room r : rooms){
            
            if (r.getRoomStatus() == RoomStatus.AVAILABLE){
                available++;
            }
            else if (r.getRoomStatus() == RoomStatus.RESERVED){
                reserved++;
            }
            else if (r.getRoomStatus() == RoomStatus.OCCUPIED){
                occupied++;
            }
            else if (r.getRoomStatus() == RoomStatus.MAINTENANCE){
                maintenance++;
            }
        }
        
        System.out.println("--------- Room Availability Report ---------");
        System.out.println("Number of Available Rooms: " + available);
        System.out.println("Number of Reserved Rooms: " + reserved);
        System.out.println("Number of Occupied Rooms: " + occupied);
        System.out.println("Number of Maintenance Rooms: " + maintenance);
        System.out.println("Number of Total Number of Rooms: " + rooms.size());
        System.out.println("--------------------------------------------");
        
    }
    
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    
    
    
}





