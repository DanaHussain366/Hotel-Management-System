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

import java.util.ArrayList;

public class TableManager {
    
    private ArrayList<RestaurantTable> tableList;
    
    public TableManager(){
        tableList = new ArrayList<>();
    }
    
    public void addTable (RestaurantTable table){
        tableList.add(table);
    }
    
    public ArrayList<RestaurantTable> getAllTables() {
        return tableList;
    }
    
    public RestaurantTable searchTable(int tableID){
        
        for (RestaurantTable table : tableList){
            if (table.getTableID() == tableID){
                return table;
            }
        }
        
        return null;
    }
    
    public boolean deleteTable(int tableID){
        RestaurantTable table = searchTable(tableID);
        
        if (table != null){
            tableList.remove(table);
            return true;
        }
        
        return false;
    }
    
    public boolean updateTable(int tableID, int tableNumber, int seatingCapacity, String status){
        RestaurantTable table = searchTable(tableID);
        
        if (table != null){
            table.setTableNumber(tableNumber);
            table.setSeatingCapacity(seatingCapacity);
            table.setStatus(status);
            
            return true;
        }
        
        return false;
    }
    
}
