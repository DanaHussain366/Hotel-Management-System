/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RoomManagement;

/**
 * Jana Salem 2241100402
 */

import java.io.*;
import java.util.Scanner;

public class RoomFiles {

    private RoomManager manager;

    public RoomFiles(RoomManager manager) {
        this.manager = manager;
    }

    public void saveRooms() {

        try {

            PrintWriter writer = new PrintWriter("rooms.txt");

            for (Room r : manager.getRooms()) {

                writer.println(
                        r.getRoomNumber() + "," +
                        r.getFloorNumber() + "," +
                        r.getRoomType() + "," +
                        r.getBedCount() + "," +
                        r.getPricePerNight() + "," +
                        r.getRoomStatus() + "," +
                        r.getHasAC() + "," +
                        r.getHasWifi() + "," +
                        r.getHasTV() + "," +
                        r.getHasBalcony());

            }

            writer.close();

            System.out.println("Rooms saved successfully.");

        }

        catch (IOException e) {

            System.out.println("Error. Couldn't save rooms.");

        }

    }
    
        public void loadRooms() {

        try {

            Scanner input = new Scanner(new File("rooms.txt"));

            manager.getRooms().clear();

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] data = line.split(",");

                int roomNumber = Integer.parseInt(data[0]);
                int floorNumber = Integer.parseInt(data[1]);
                String roomType = data[2];
                int bedCount = Integer.parseInt(data[3]);
                double pricePerNight = Double.parseDouble(data[4]);
                RoomStatus roomStatus = RoomStatus.valueOf(data[5]);
                boolean hasAC = Boolean.parseBoolean(data[6]);
                boolean hasWifi = Boolean.parseBoolean(data[7]);
                boolean hasTV = Boolean.parseBoolean(data[8]);
                boolean hasBalcony = Boolean.parseBoolean(data[9]);

                Room room = new Room(
                        roomNumber,
                        floorNumber,
                        roomType,
                        bedCount,
                        pricePerNight,
                        roomStatus,
                        hasAC,
                        hasWifi,
                        hasTV,
                        hasBalcony);

                manager.addRoom(room);

            }

            input.close();

            System.out.println("Rooms loaded successfully.");

        }

        catch (IOException e) {

            System.out.println("Error. Couldn't load rooms.");

        }

    }

}
    
