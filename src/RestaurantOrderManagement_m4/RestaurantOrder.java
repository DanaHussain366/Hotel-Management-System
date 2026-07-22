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
public class RestaurantOrder {
    
    private int orderId;
    private OrderType orderType;
    private int roomNumber;
    private int tableId;
    private String guestName;
    private int itemId;
    private String itemName;
    private int quantity;
    private double pricePerItem;
    private double totalAmount;
    private String orderDate;
    private OrderStatus orderStatus;
    
    public RestaurantOrder(int orderId, OrderType orderType, int roomNumber, int tableId, String guestName, int itemId, String itemName, int quantity, double pricePerItem, String orderDate, OrderStatus orderStatus){
    
        this.orderId = orderId;
        this.orderType = orderType;
        this.roomNumber = roomNumber;
        this.tableId = tableId;
        this.guestName = guestName;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalAmount = pricePerItem * quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        
}
    
    
    
    public int getOrderId(){
        return orderId;
    }
    
    public void setOrderId(int orderId){
         this.orderId = orderId;
        
    }
        
    public OrderType getOrderType(){
        return orderType;
    }
    
    public void setOrderType( OrderType orderType){
         this.orderType = orderType;
        
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
    public void setRoomNumber(int roomNumber){
         this.roomNumber = roomNumber;
        
    }
    
    
    public int getTableId(){
        return tableId;
    }
    
    public void setTableId(int tableId){
         this.tableId = tableId;
        
    }
    
    
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
     public void calculateTotal() {
        totalAmount = pricePerItem * quantity;
    }
     
     
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
        calculateTotal();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

   

    @Override
    public String toString() {
        return orderId + "," + orderType + "," + roomNumber + "," + tableId + "," + guestName + "," + itemId + "," + 
                itemName + "," + quantity + "," + pricePerItem + "," + totalAmount + "," + orderDate + "," +  orderStatus;
    }
    
    
    
     /*"=======================\nDate: "+ orderDate + "\nOrder ID: " + orderId + ", Order Type is " + orderType + "\nOrder Status: " + orderStatus +
                "\nGuest Name: " + guestName + ", Room number: " + roomNumber +
                ", Table ID: " + tableId + "\n======Order Details======\n" + itemId + ": " +  itemName + "  " +
                pricePerItem + " $ "+ "\nQuantity: " + quantity + "\nTotal Amount: " + totalAmount;*/
}
