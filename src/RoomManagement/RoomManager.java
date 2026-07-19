/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement;


/**
 * Jana Salem 2241100402
 */

import java.util.ArrayList;


public class RoomManager {
    
    private ArrayList <Room> rooms = new ArrayList <>();
   
    public void addRoom(Room r){
        rooms.add(r);
    }
    
    public void searchRoomNumber(int roomNumber){
        for (Room r : rooms){
            if (r.getRoomNumber() == roomNumber){
               System.out.println(r);
               return;
            } 
        }
        System.out.println("No room found.");
    }
    
    public void searchRoomType (String roomType){
        boolean found = false;
        for (Room r : rooms){
            if (r.getRoomType().equals(roomType)){
               found = true;
               System.out.println(r);
            }
        }
        
        if (!found){
            System.out.println("No room found.");
        }
    }
    
    public void searchFloorNumber (int floorNumber){
        boolean found = false;
        for (Room r : rooms){
            if (r.getFloorNumber() == floorNumber){
               found = true;
               System.out.println(r);
               
            }
        }
        if (!found){
            System.out.println("No room found.");
        }
    }
    
    public void searchRoomStatus(RoomStatus roomStatus){
        boolean found = false;
        for (Room r : rooms){
            if (r.getRoomStatus() == roomStatus){
                found = true;
               System.out.println(r);
            }
        }
        if (!found){
            System.out.println("No room found.");
        }
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
        
        //clearupp - r is one room object
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





