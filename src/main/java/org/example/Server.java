package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) {
        Map<String,Carinformation>Cars=new HashMap<>();
        Cars.put("B001", new Carinformation("Seat", "Ibiza", "2009", "Orange","SAed","9087654"));
        Cars.put("B002", new Carinformation("Hyundai", "Kona", "2019", "White","Sami","8750888"));
        Cars.put("A001", new Carinformation("VW", "Polo", "2005", "black","Noora","3467892"));
        Cars.put("C002", new Carinformation("Audi", "A6", "2020", "silver","Hiba","0956784"));
        Cars.put("C003", new Carinformation("BMW", "X7", "2022", "brown","Noah","9076045"));
        try {
            ServerSocket serverSocket=new ServerSocket(2221);
            System.out.println("ServerTCP running");
            boolean connectonflag=true;
            while (true){
                Socket socket=serverSocket.accept();
                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                if(connectonflag){
                    System.out.println("Conniction done");
                    connectonflag=false;
                }
                try(BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                    String VehicleplateID=in.readLine().toUpperCase();
                    Carinformation carInfo = Cars.get(VehicleplateID);
                    System.out.println("Client request: " + VehicleplateID);
                    if(carInfo==null){
                        out.println("Vehicle is not found"+"\n");
                    }else{
                        out.println("|        " + VehicleplateID + "        |  " + carInfo.toString() + "\n");
                    }
                }catch (Exception ee){
                    System.out.println("Clinte is exit");
                }
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}