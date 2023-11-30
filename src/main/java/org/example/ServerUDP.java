package org.example;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class ServerUDP {
    public static void main(String[] args) {
        Map<String, Carinformation> cars = new HashMap<>();
        cars.put("B001", new Carinformation("Seat", "Ibiza", "2009", "Orange", "SAed", "9087654"));
        cars.put("B002", new Carinformation("Hyundai", "Kona", "2019", "White", "Sami", "8750888"));
        cars.put("A001", new Carinformation("VW", "Polo", "2005", "black", "Noora", "3467892"));
        cars.put("C002", new Carinformation("Audi", "A6", "2020", "silver", "Hiba", "0956784"));
        cars.put("C003", new Carinformation("BMW", "X7", "2022", "brown", "Noah", "9076045"));

        try {
            DatagramSocket socket = new DatagramSocket(2221);
            System.out.println("ServerUDP running");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String vehiclePlateID = new String(receivePacket.getData(), 0, receivePacket.getLength());
                vehiclePlateID = vehiclePlateID.toUpperCase();
                Carinformation carInfo = cars.get(vehiclePlateID);
                System.out.println("Client request: " + vehiclePlateID);
                if (carInfo == null) {
                    String notFoundMessage = "Vehicle is not found";
                    DatagramPacket responsePacket = new DatagramPacket(notFoundMessage.getBytes(),
                            notFoundMessage.length(), receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(responsePacket);
                } else {
                    String carInfoString = "|        " + vehiclePlateID + "        |  " + carInfo.toString();
                    DatagramPacket responsePacket = new DatagramPacket(carInfoString.getBytes(),
                            carInfoString.length(), receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(responsePacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
