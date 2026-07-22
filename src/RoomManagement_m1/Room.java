/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement_m1;

/**
 * Jana Salem 2241100402
 */


public class Room {
    
    private int roomNumber;
    private int floorNumber;
    private String roomType; 
    private int bedCount; 
    private double pricePerNight;
    private RoomStatus roomStatus; 
    private boolean hasAC;
    private boolean hasWifi;
    private boolean hasTV;
    private boolean hasBalcony;
    
    public Room (int roomNumber,int floorNumber,String roomType,int bedCount,double pricePerNight,
                RoomStatus roomStatus,boolean hasAC,boolean hasWifi,boolean hasTV,boolean hasBalcony){
        
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.roomType = roomType;
        this.bedCount = bedCount;
        this.pricePerNight = pricePerNight;
        this.roomStatus = roomStatus;
        this.hasAC = hasAC;
        this.hasWifi = hasWifi;
        this.hasTV = hasTV;
        this.hasBalcony = hasBalcony;
    }
    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber (){
        return roomNumber;
    }
    
    public void setFloorNumber(int floorNumber){
        this.floorNumber = floorNumber;
    }
    
    public int getFloorNumber (){
        return floorNumber;
    }
    
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    
    public String getRoomType (){
        return roomType;
    }
    
    public void setBedCount(int bedCount){
        this.bedCount = bedCount;
    }
    
    public int getBedCount (){
        return bedCount;
    }
    
    public void setPricePerNight(double pricePerNight ){
        this.pricePerNight = pricePerNight;
    }
    
    public double getPricePerNight (){
        return pricePerNight;
    }
    
    public void setRoomStatus(RoomStatus roomStatus){
        this.roomStatus = roomStatus;
    }
    
    public RoomStatus getRoomStatus (){
        return roomStatus;
    }
    
    public void setHasAC(boolean hasAC){
        this.hasAC = hasAC;
    }
    
    public boolean getHasAC (){
        return hasAC;
    }
    
    public void setHasWifi(boolean hasWifi){
        this.hasWifi = hasWifi;
    }
    
    public boolean getHasWifi (){
        return hasWifi;
    }
    
    public void setHasTV(boolean hasTV){
        this.hasTV = hasTV;
    }
    
    public boolean getHasTV (){
        return hasTV;
    }
    
    public void setHasBalcony(boolean hasBalcony){
        this.hasBalcony = hasBalcony;
    }
    
    public boolean getHasBalcony (){
        return hasBalcony;
    }
    
    @Override
    public String toString(){
        return  "Room Number: " + roomNumber + "\nFloor Number: " + floorNumber +"\nRoom Type: " + roomType + 
                "\nBed Count: " + bedCount +"\nPrice Per Night: " + pricePerNight +
                "\nRoom Status: " + roomStatus +"\nAC Status: " + hasAC + "\nWifi Status: " + hasWifi +"\nTV Status: " + hasTV + 
                "\nBalcony Status: " + hasBalcony;
    }
    
}
