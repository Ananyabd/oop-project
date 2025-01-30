package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BillingSystem {

    String roomType;

    public void billing(int patientID, int daysStayed) {
        String id = Integer.toString(patientID);     
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\costing.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(id)) {
                    line = reader.readLine();
                    roomType = line;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        generateBill(roomType, daysStayed);
    }

    public void generateBill(String roomType, int daysStayed) {
        int roomRent = 0;
        int doctorFee;

        if (daysStayed > 0) {
            doctorFee = 1200 + (500 * (daysStayed - 1));  
        } else {
            doctorFee = 1200;  
        }

        switch(roomType) {
            case "ICU":
                roomRent = 8500;
                break;
            case "Operation Theater":
                roomRent = 5000;
                break;
            case "Regular":
                roomRent = 2000;
                break;
            case "None":
                roomRent = 0;
                break;
            default:
                System.out.println("\u001B[31;1mInvalid room type.\u001B[0m"); // Red and bold
                return;
        }

        int totalRoomRent = roomRent * daysStayed;

        int totalBill = doctorFee + totalRoomRent;

        // Bolded print statements
        System.out.println("\n\u001B[1m\u001B[4mBilling Summary:\u001B[0m");
        System.out.println("\u001B[1mDoctor Fee: \u001B[0m" + doctorFee + " taka (1200 for the first day, 500 for subsequent days)");
        System.out.println("\u001B[1mRoom Rent (" + roomType + "): \u001B[0m" + totalRoomRent + " taka");
        System.out.println("\u001B[1mTotal Bill: \u001B[0m" + totalBill + " taka\n");
    }

}
