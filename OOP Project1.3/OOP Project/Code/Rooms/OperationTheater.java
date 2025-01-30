package Rooms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OperationTheater extends Room{
    public OperationTheater(){
        this.totalRooms = 8;
        this.type = "Operation Theater";
        this.costPerNight = 5000;
    }

    public void viewInfo(){
        int num = 0;
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\ot.txt"));
            line = reader.readLine();
            num = Integer.parseInt(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\033[1mType of Room:\033[0m " + type);
        System.out.println("\033[1mCost per night:\033[0m " + costPerNight);
        System.out.println("\033[1mAvailable Operation Theaters:\033[0m " + num);
    }
}
