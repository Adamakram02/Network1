package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            BufferedReader Vehicleplate = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Enter Vehicle Plate ID OR exit:");
                String vehiclePlateID = Vehicleplate.readLine().trim();
                if (vehiclePlateID.equalsIgnoreCase("exit")) {
                    break;
                }

                byte[] sendData = vehiclePlateID.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 2221);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if (response.equals("Vehicle is not found")) {
                    System.out.println(response);
                } else {
                    System.out.println("|  Vehicle plate ID  |  Make  |  Model  |  Year  |  Colour  |  Owner Name  |  Owner ID  |");
                    System.out.println(response);
                }
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
