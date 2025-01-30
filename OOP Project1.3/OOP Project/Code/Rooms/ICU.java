package Rooms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ICU extends Room{
    public ICU(){
        this.totalRooms = 3;
        this.type = "ICU";
        this.costPerNight = 8500;
    }

    public void viewInfo(){
        int num = 0;
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\icu.txt"));
            line = reader.readLine();
            num = Integer.parseInt(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\033[1mType of Room:\033[0m " + type);
        System.out.println("\033[1mCost per night:\033[0m " + costPerNight);
        System.out.println("\033[1mAvailable ICU rooms:\033[0m " + num);
    }

   

   
}
