/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantManagement;

/**
 *
 * @author Lolwah Al Ansari
 * ID: 2241100454
 * Section: 01A
 */
public class RestaurantTable {
    
    private int tableID;
    private int tableNumber;
    private int seatingCapacity;
    private String status;
    
    public RestaurantTable(int tableID, int tableNumber, int seatingCapacity, String status){
        this.tableID = tableID;
        this.tableNumber = tableNumber;
        this.seatingCapacity = seatingCapacity;
        this.status = status; 
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" + "tableID=" + tableID + ", tableNumber=" + tableNumber + ", seatingCapacity=" + seatingCapacity + ", status=" + status + '}';
    }
    
}
