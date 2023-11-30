package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Client {
    public static void main(String[] args) {

        while (true) {
            try {
                    Socket socket=new Socket("localhost",2221);
                    System.out.print("Enter Vehicle Plate ID OR exit:");
                    BufferedReader Vehicleplate = new BufferedReader(new InputStreamReader(System.in));
                    String VehicleplateID=Vehicleplate.readLine();
                    if (VehicleplateID.toLowerCase().equalsIgnoreCase("exit")) {
                        break;
                    }
                    PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                    out.println(VehicleplateID);
                    BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String ss=in.readLine();
                    if(ss.equals("Vehicle is not found")){
                        System.out.println(ss);
                    }else{
                        System.out.println("|  Vehicle plate ID  |  Make  |  Model  |  Year  |  Colour  |  Owner Name  |  Owner ID  |");
                        System.out.println(ss);
                    }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}