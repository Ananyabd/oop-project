package Services;
import Rooms.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoomSystem {
    ICU icu = new ICU();
    OperationTheater ot = new OperationTheater();
    RegularRoom rRoom = new RegularRoom();

    public void viewRoomInfo(){
        RoomSystem roomSystem = new RoomSystem();
        System.out.println("\033[1mTypes of Rooms Available in the Hospital:\n\033[0m");

        System.out.print("\033[1m1. \033[0m");
        roomSystem.rRoom.viewInfo();
        System.out.println("");
        System.out.print("\033[1m2. \033[0m");
        roomSystem.ot.viewInfo();
        System.out.println("");
        System.out.print("\033[1m3. \033[0m");
        roomSystem.icu.viewInfo();

    }


    public int icuNUM(){
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
        return num;
    }

    public int otNUM(){
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
        return num;
    }

    public int roomNUM(){
        int num = 0;
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\rRoom.txt"));
            line = reader.readLine();
            num = Integer.parseInt(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

  
}


