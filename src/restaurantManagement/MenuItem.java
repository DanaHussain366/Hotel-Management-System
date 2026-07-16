/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantManagement;

/**
 *
 * @author Lolwah Al Ansari
 * Section: 01A
 */
public class MenuItem {
    
    private int itemID;
    private String itemName;
    private String category;
    private double price;
    private int preparationTime;
    private boolean available;
    
    public MenuItem(int itemID, String itemName, String category, double price, int preparationTime, boolean available){
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.preparationTime = preparationTime;
        this.available = available;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "itemID=" + itemID + ", itemName=" + itemName + ", category=" + category + ", price=" + price + ", preparationTime=" + preparationTime + ", available=" + available + '}';
    }
    
}
