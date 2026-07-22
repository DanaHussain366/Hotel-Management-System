/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestaurantOrderManagement_m4;

/**
 *
 * @author Dana Hussain
 * ID: 2241100226
 * section: 01A
 */

import RestaurantMenu_TableManagement_m3.FileHandler;
import RestaurantMenu_TableManagement_m3.MenuItem;
import RestaurantMenu_TableManagement_m3.RestaurantTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OrderFileHandler {

    private final String ORDER_FILE = "Restaurant_Orders.txt";

    
    public void saveOrders(ArrayList<RestaurantOrder> orders) {

        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter(ORDER_FILE));

            for (RestaurantOrder order : orders) {
                writer.println(order.toString());
            }

            writer.close();

            System.out.println("Orders saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving orders.");
        }
    }

   
    
    public ArrayList<RestaurantOrder> loadOrders() {

        ArrayList<RestaurantOrder> orders =
                new ArrayList<>();

        File file = new File(ORDER_FILE);

        if (!file.exists()) {

            System.out.println(
                    "No previous restaurant orders were found.");

            return orders;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length != 12) {

                    System.out.println(
                            "Invalid order information: " + line);

                    continue;
                }

                int orderId =
                        Integer.parseInt(data[0].trim());

                OrderType orderType =
                        OrderType.valueOf(data[1].trim());

                int roomNumber =
                        Integer.parseInt(data[2].trim());

                int tableId =
                        Integer.parseInt(data[3].trim());

                String guestName =
                        data[4].trim();

                int itemId =
                        Integer.parseInt(data[5].trim());

                String itemName =
                        data[6].trim();

                int quantity =
                        Integer.parseInt(data[7].trim());

                double pricePerItem =
                        Double.parseDouble(data[8].trim());

                /*
                 * data[9] is totalAmount.
                 * The constructor calculates it again,
                 * so we do not pass it.
                 */

                String orderDate =
                        data[10].trim();

                OrderStatus orderStatus =
                        OrderStatus.valueOf(data[11].trim());

                RestaurantOrder order =
                        new RestaurantOrder(
                                orderId,
                                orderType,
                                roomNumber,
                                tableId,
                                guestName,
                                itemId,
                                itemName,
                                quantity,
                                pricePerItem,
                                orderDate,
                                orderStatus
                        );

                orders.add(order);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error loading orders.");

        } catch (NumberFormatException e) {

            System.out.println(
                    "An invalid number was found in the order file.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "An invalid order type or status was found.");
        }

        return orders;
    }

    /*
     * Loads all menu items from Module 3.
     */
    public ArrayList<MenuItem> loadAllMenuItems() {

        FileHandler fileHandler = new FileHandler();

        return fileHandler.loadMenu();
    }

    
    public ArrayList<MenuItem> loadAvailableMenuItems() {

        FileHandler fileHandler = new FileHandler();

        ArrayList<MenuItem> allItems =
                fileHandler.loadMenu();

        ArrayList<MenuItem> availableItems =
                new ArrayList<>();

        for (MenuItem item : allItems) {

            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }

        return availableItems;
    }

    
    
    public MenuItem searchMenuItem(int itemId) {

        ArrayList<MenuItem> menuItems =
                loadAllMenuItems();

        for (MenuItem item : menuItems) {

            if (item.getItemID() == itemId) {
                return item;
            }
        }

        return null;
    }

    
    public ArrayList<RestaurantTable> loadAllTables() {

        FileHandler fileHandler = new FileHandler();

        return fileHandler.loadTables();
    }

    
    public ArrayList<RestaurantTable> loadAvailableTables() {

        FileHandler fileHandler = new FileHandler();

        ArrayList<RestaurantTable> allTables =
                fileHandler.loadTables();

        ArrayList<RestaurantTable> availableTables =
                new ArrayList<>();

        for (RestaurantTable table : allTables) {

            if (table.getStatus().equalsIgnoreCase("Available")) {
                availableTables.add(table);
            }
        }

        return availableTables;
    }

    
    
    public RestaurantTable searchTable(int tableId) {

        ArrayList<RestaurantTable> tables =
                loadAllTables();

        for (RestaurantTable table : tables) {

            if (table.getTableID() == tableId) {
                return table;
            }
        }

        return null;
    }

    
    
    public boolean updateTableStatus(
            int tableId,
            String newStatus) {

        FileHandler fileHandler = new FileHandler();

        ArrayList<RestaurantTable> tables =
                fileHandler.loadTables();

        for (RestaurantTable table : tables) {

            if (table.getTableID() == tableId) {

                table.setStatus(newStatus);
                fileHandler.saveTables(tables);

                return true;
            }
        }

        return false;
    }
}