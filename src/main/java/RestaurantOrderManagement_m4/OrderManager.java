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



import java.util.ArrayList;

public class OrderManager {

    private ArrayList<RestaurantOrder> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(RestaurantOrder order) {

        if (order != null && searchOrder(order.getOrderId()) == null) {
            orders.add(order);
        }
    }

    public RestaurantOrder searchOrder(int orderId) {

        for (RestaurantOrder order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    public boolean updateOrderStatus(
            int orderId,
            OrderStatus newStatus) {

        RestaurantOrder order = searchOrder(orderId);

        if (order != null) {

            order.setOrderStatus(newStatus);
            return true;
        }

        return false;
    }

    public boolean cancelOrder(int orderId) {

        RestaurantOrder order = searchOrder(orderId);

        if (order != null) {

            order.setOrderStatus(OrderStatus.CANCELLED);
            return true;
        }

        return false;
    }

    public boolean updateOrder(
            int orderId,
            OrderType orderType,
            int roomNumber,
            int tableId,
            String guestName,
            int itemId,
            String itemName,
            int quantity,
            double pricePerItem,
            String orderDate) {

        RestaurantOrder order = searchOrder(orderId);

        if (order == null) {
            return false;
        }

        order.setOrderType(orderType);
        order.setRoomNumber(roomNumber);
        order.setTableId(tableId);
        order.setGuestName(guestName);
        order.setItemId(itemId);
        order.setItemName(itemName);
        order.setQuantity(quantity);
        order.setPricePerItem(pricePerItem);
        order.setOrderDate(orderDate);

        return true;
    }

    public ArrayList<RestaurantOrder> searchByGuestName(
            String guestName) {

        ArrayList<RestaurantOrder> results = new ArrayList<>();

        for (RestaurantOrder order : orders) {

            if (order.getGuestName().equalsIgnoreCase(guestName)) {
                results.add(order);
            }
        }

        return results;
    }

    public ArrayList<RestaurantOrder> searchByRoomNumber(
            int roomNumber) {

        ArrayList<RestaurantOrder> results = new ArrayList<>();

        for (RestaurantOrder order : orders) {

            if (order.getRoomNumber() == roomNumber) {
                results.add(order);
            }
        }

        return results;
    }

    public ArrayList<RestaurantOrder> searchByTableId(
            int tableId) {

        ArrayList<RestaurantOrder> results = new ArrayList<>();

        for (RestaurantOrder order : orders) {

            if (order.getTableId() == tableId) {
                results.add(order);
            }
        }

        return results;
    }

    public ArrayList<RestaurantOrder> searchByStatus(
            OrderStatus status) {

        ArrayList<RestaurantOrder> results = new ArrayList<>();

        for (RestaurantOrder order : orders) {

            if (order.getOrderStatus() == status) {
                results.add(order);
            }
        }

        return results;
    }

    public int generateOrderId() {

        int largestId = 1000;

        for (RestaurantOrder order : orders) {

            if (order.getOrderId() > largestId) {
                largestId = order.getOrderId();
            }
        }

        return largestId + 1;
    }

    public int countOrdersByStatus(OrderStatus status) {

        int count = 0;

        for (RestaurantOrder order : orders) {

            if (order.getOrderStatus() == status) {
                count++;
            }
        }

        return count;
    }

    public double calculateCompletedSales() {

        double totalSales = 0;

        for (RestaurantOrder order : orders) {

            if (order.getOrderStatus() == OrderStatus.COMPLETED) {
                totalSales += order.getTotalAmount();
            }
        }

        return totalSales;
    }

    public ArrayList<RestaurantOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<RestaurantOrder> orders) {

        if (orders == null) {
            this.orders = new ArrayList<>();
        } else {
            this.orders = orders;
        }
    }

    public void clearOrders() {
        orders.clear();
    }
}