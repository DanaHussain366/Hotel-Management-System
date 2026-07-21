/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestaurantMenu_TableManagement_m3;

/**
 *
 * @author Lolwah Al Ansari
 * ID: 2241100454
 * Section: 01A
 */

import java.util.ArrayList;

public class MenuManager {
    
    private ArrayList<MenuItem> menuList;
    
    public MenuManager(){
        menuList = new ArrayList<>();
    }
    
    public void addMenuItem(MenuItem item){
        menuList.add(item);
    }
    
     public MenuItem searchItem(int id) {
        for (MenuItem item : menuList){
            if (item.getItemID() == id) {
                return item;
            }
        }
    return null;
    }
    
    public boolean updateMenuItem(int itemID, String itemName, String category, double price, int preparationTime, boolean available){
        MenuItem item = searchItem(itemID);
        
        if (item != null){
            item.setItemName(itemName);
            item.setCategory(category);
            item.setPrice(price);
            item.setPreparationTime(preparationTime);
            item.setAvailable(available);
            
            return true;
        }
        
        return false;
    }
    
     public boolean deleteMenuItem(int itemID){
        MenuItem item = searchItem(itemID);
        
        if (item != null){
            menuList.remove(item);
            return true;
        }
        
        return false;
    }
    
    public void removeItem(int index) {
        if (index >= 0 && index < menuList.size()) {
            menuList.remove(index);
        }
    }
    

    public ArrayList<MenuItem> getAllMenuItems(){
        return menuList;
    }
    
}
