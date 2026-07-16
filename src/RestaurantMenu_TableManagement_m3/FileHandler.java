/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestaurantMenu_TableManagement_m3;

/**
 *
 * @author Lolwah Al Ansari
 * Section: 01A
 */

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    
    private final String MENU_FILE = "Restaurant_Menu.txt";
    private final String TABLE_FILE = "Restaurant_Tables.txt";
    private final String USER_FILE = "Users.txt";
    
    public void saveMenu(ArrayList<MenuItem> menuList){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(MENU_FILE));
            
            for (MenuItem item : menuList){
                writer.println(
                    item.getItemID() + "," +
                    item.getItemName() + "," +
                    item.getCategory() + "," +
                    item.getPrice() + "," +
                    item.getPreparationTime() + "," +
                    item.isAvailable()
                );
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Error saving menu.");
        }
    }
    
    public ArrayList<MenuItem> loadMenu(){
        
        ArrayList<MenuItem> menuList = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE));
            String line;
            
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                
                MenuItem item = new MenuItem(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Double.parseDouble(data[3]),
                    Integer.parseInt(data[4]),
                    Boolean.parseBoolean(data[5])
                );
                
                menuList.add(item);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Menu file not found.");
        }
        return menuList;
    }
    
    public void saveTables(ArrayList<RestaurantTable> tableList){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(TABLE_FILE));
            
            for (RestaurantTable table : tableList){
                writer.println(
                    table.getTableID() + "," +
                    table.getTableNumber() + "," +
                    table.getSeatingCapacity() + "," +
                    table.getStatus()
                );
            }
            writer.close();
        } catch(IOException e){
            System.out.println("Error saving tables.");
        }
    }
    
    public ArrayList<RestaurantTable> loadTables(){
        
        ArrayList<RestaurantTable> tableList = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(TABLE_FILE));
            String line;
            
            while((line=reader.readLine())!=null){
                String[] data=line.split(",");
                
                RestaurantTable table=new RestaurantTable(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    data[3]
                );
                tableList.add(table);
            }
            reader.close();
        } catch(IOException e){
            System.out.println("Table file not found.");
        }
        return tableList;
    }
    
    public void saveUsers(ArrayList<User> userList){
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE));
            
            for (User user : userList){
                writer.println(
                    user.getUsername() + "," +
                    user.getPassword() + "," +
                    user.getRole()
                );
        }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving users.");
        }
    }
    
    public ArrayList<User> loadUsers(){
        
        ArrayList<User> userList = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                
                User user = new User(
                    data[0],
                    data[1],
                    data[2]
                );
                userList.add(user);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("User file not found.");
        }
        return userList;
    }
    
}
