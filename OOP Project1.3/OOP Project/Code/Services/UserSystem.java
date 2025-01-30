package Services;
import Users.*;
import java.io.*;
import java.util.Scanner;



 

public class UserSystem {
    public Patient[] patient = new Patient[51];
    public Doctor[] doctor = new Doctor[11];
    public Staff[] staff = new Staff[16];
    public RoomSystem roomSystem = new RoomSystem();
    
    int patientID;
    Scanner sc = new Scanner(System.in);


    public void appointment(){
        
        String name;
        int age;
        String gender;
        String contactNumber;
        String address;
        String patientProblem;
        int doctorID;
        String roomType;
        String roomID = "";
        int staffID = 0;

        // Fetch patient ID from file
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\patientID.txt"));
            line = reader.readLine();
            patientID = Integer.parseInt(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(patientID >= 30){
            System.out.println("\033[1;31mSorry, the hospital is currently at full capacity. We cannot accept any new appointments at this time. Please check back later.\033[0m");
        }else{

            // Gather patient information
            System.out.print("\033[1mMaking an appointment\033[0m");

            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                System.out.print("\033[1m.\033[0m");
            }

            System.out.println("\n\033[1mPlease fill up these informations!\033[0m");
            System.out.print("\033[1mYour Full Name: \033[0m");
            name = sc.nextLine();
            
            System.out.print("\033[1mYour Age: \033[0m");
            age = sc.nextInt();
            sc.nextLine();
            
            System.out.print("\033[1mYour Gender: \033[0m");
            gender = sc.nextLine();
            
            System.out.print("\033[1mYour Contact Number: \033[0m");
            contactNumber = sc.nextLine();
            
            System.out.print("\033[1mYour Address: \033[0m");
            address = sc.nextLine();
            
            System.out.print("\033[1mYour Medical Issue: \033[0m");
            patientProblem = sc.nextLine();
            System.out.println();
            
            
            // Assign doctor and room
            System.out.println("\033[1m\033[4mAvailable doctors in our hospital:\033[0m");
            viewDoctorInfo();
            System.out.print("\033[1mSelect doctor by ID: \033[0m");
            doctorID = sc.nextInt();
            String buff = sc.nextLine();
            
            assignPatient(doctorID, patientID);
            
            System.out.println("\033[1mDo you want to admit yourself to the hospital?\033[0m");
            System.out.println("\033[1m1. Yes\033[0m");
            System.out.println("\033[1m2. No\033[0m");
            System.out.print("\033[1mInput: \033[0m");
            int admitChoice = sc.nextInt();
            buff = sc.nextLine();
            
            int icuNum = roomSystem.icuNUM();
            int otNum = roomSystem.otNUM();
            int roomNum = roomSystem.roomNUM();
            
            
            if (admitChoice == 1) {
                this.roomSystem.viewRoomInfo();
            
            
                System.out.print("\n\033[1mEnter room type (ICU/Operation Theater/Regular) or type 'E' for exit: \033[0m");
                roomType = sc.nextLine();


                while((roomType.equals("ICU") && icuNum <= 0) || (roomType.equals("Operation Theater") && otNum <= 0) || (roomType.equals("Regular") && roomNum <= 0)){
                    System.out.println("\033[1;31m\nUnfortunately, all rooms of the type '" + roomType + "' are currently booked. Please consider choosing another room type.\n\033[0m");
                    System.out.print("\033[1mEnter room type (ICU/Operation Theater/Regular) or type 'E' for exit: :\033[0m ");
                    roomType = sc.nextLine();
                }

                if(roomType.equals("E")){
                    roomType = "None";
                    staffID = 0;
                    roomID = "None";
                    roomType = "None";

                }else{
                    
                    if (roomType.equals("Regular")) {
                        int num = 0;
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\rRoom.txt"));
                            String line = reader.readLine();
                            num = Integer.parseInt(line);
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            
                        --num;
                        staffID = 20 - num;
                        roomID = "Regular" + (20 - num);
            
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\rRoom.txt", false));
                            String line = Integer.toString(num);
                            writer.write(line);
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (roomType.equals("Operation Theater")) {
                        int num = 0;
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\ot.txt"));
                            String line = reader.readLine();
                            num = Integer.parseInt(line);
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            
                        --num;
                        staffID = 20 + 7 - num;
                        roomID = "OT" + (7 - num);
            
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\ot.txt", false));
                            String line = Integer.toString(num);
                            writer.write(line);
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (roomType.equals("ICU")) {
                        int num = 0;
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\icu.txt"));
                            String line = reader.readLine();
                            num = Integer.parseInt(line);
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
            
                        --num;
                        staffID = 27 + 3 - num;
                        roomID = "ICU" + (3 - num);
            
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\RoomTextFiles\\icu.txt", false));
                            String line = Integer.toString(num);
                            writer.write(line);
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                
            } else {
                staffID = 0;
                roomID = "None";
                roomType = "None";
            }
            

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\costing.txt", true));
                String line = Integer.toString(patientID);
                writer.write(line + "\n");
                writer.write(roomType + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("\033[1mProcessing\033[0m");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                System.out.print("\033[1m.\033[0m");
            }
            System.out.println("\nCompleted!");
            System.out.println("\033[1;32m\nAppointment Successfully Confirmed. Please remember your Patient ID [" + patientID + "] for future reference.\n\033[0m");



            // Save patient information to file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\patientInfo.txt", true));
                String line;
                
                // Write patient details
                line = Integer.toString(patientID);
                writer.write(line + "\n");
                writer.write(name + "\n");
                line = Integer.toString(age);
                writer.write(line + "\n");
                writer.write(gender + "\n");
                writer.write(contactNumber + "\n");
                writer.write(address + "\n");
                writer.write(patientProblem + "\n");

                // Fetch and write doctor details
                String docDetails = "", line2;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\doctorInfo.txt"));
                    int k = 1;
                    while ((line2 = reader.readLine()) != null) {
                        if (k == doctorID) {
                            docDetails = line2;
                            break;
                        }
                        k++;
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writer.write(docDetails + "\n");

               
                writer.write(roomType + "\n");
                writer.write(roomID + "\n");

                
                String staffDetails = "None";
                if (staffID != 0) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\staffInfo.txt"));
                        int k = 1;
                        while ((line2 = reader.readLine()) != null) {
                            if (k == staffID) {
                                staffDetails = line2;
                                break;
                            }
                            k++;
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                writer.write(staffDetails + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Update patient ID
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\patientID.txt", false));
                String line = Integer.toString(patientID + 1);
                writer.write(line);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Store patient object
            patient[patientID] = new Patient(patientID, name, age, gender, patientProblem, contactNumber, address, doctorID, roomType, roomID, staffID);

        }
    }


    public void assignPatient(int doctorID, int patientID) {
        if (doctorID < 1 || doctorID > 10) {
            throw new IllegalArgumentException("Invalid doctor ID. It must be between 1 and 10.");
        }
    
        String filePath = "F:\\\\OOP Project\\\\Code\\\\TextFiles\\\\DoctorTextFiles\\\\d" + doctorID + ".txt";
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(Integer.toString(patientID) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void viewAssignedPatients(int doctorID) {
        if (doctorID < 1 || doctorID > 10) {
            throw new IllegalArgumentException("Invalid doctor ID. It must be between 1 and 10.");
        }
    
        System.out.println("\033[1;4m\nPatients info: \n\033[0m");
    
        String filePath = "F:\\\\OOP Project\\\\Code\\\\TextFiles\\\\DoctorTextFiles\\\\d" + doctorID + ".txt";
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int k = 1;
            while ((line = reader.readLine()) != null) {
                int patientID = Integer.parseInt(line);
                System.out.println("\033[1mPatient " + k + ":\033[0m");
                viewPatientInfoforDoc(patientID);
                k++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void viewPatientInfoforDoc(int ID){
        String id = Integer.toString(ID);
        try {
            String line, line2;
            int k = 1;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\patientInfo.txt"));
            while((line = reader.readLine()) != null){
                if(line.equals(id) && k == 1){
                    System.out.println("ID: " + id);
                    line2 = reader.readLine();
                    System.out.println("Name: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Age: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Gender: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Contact Number: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Address: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Patient Problem: " + line2);
                    line2 = reader.readLine();
                    line2 = reader.readLine();
                    line2 = reader.readLine();
                    System.out.println("Apppointed Room ID: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Appointed Room Assistent: ");
                    String[] details = line2.split(", ");
                    for (String detail : details) {
                        System.out.println(detail.trim()); 
                    }
                    System.out.println(""); 
                    break;
                }
                k = (k == 11)? 1 : k+1;    
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }



    public void viewPatientInfo(int ID){
        String id = Integer.toString(ID);
        try {
            String line, line2;
            int k = 1;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\patientInfo.txt"));
            while((line = reader.readLine()) != null){
                if(line.equals(id) && k == 1){
                    System.out.println("\033[1m\033[4mPatient Details:\033[0m");
                    System.out.println("ID: " + id);
                    line2 = reader.readLine();
                    System.out.println("Name: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Age: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Gender: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Contact Number: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Address: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Patient Problem: " + line2);
                    line2 = reader.readLine();
                    System.out.println("\u001B[1m\u001B[4mApppointed Doctor Details:\u001B[0m");
                    String[] details = line2.split(", ");
                    for (String detail : details) {
                        System.out.println(detail.trim()); 
                    }
                    System.out.println("\u001B[1m\u001B[4mApppointed Room Details:\u001B[0m");
                    line2 = reader.readLine();
                    System.out.println("Room Type: " + line2);
                    line2 = reader.readLine();
                    System.out.println("Room ID: " + line2);
                    line2 = reader.readLine();
                    System.out.println("\u001B[1m\u001B[4mAppointed Room Assistent:\u001B[0m");
                    details = line2.split(", ");
                    for (String detail : details) {
                        System.out.println(detail.trim()); 
                    }   
                    System.out.println("");
                    break;
                }
                k = (k == 11)? 1 : k+1;    
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }



    public void viewDoctorInfo(){
        try {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\doctorInfo.txt"));
        while((line = reader.readLine()) != null){
            System.out.println("\033[1m" + line + "\033[0m"); // Print each line in bold
        }
        reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewStaffInfo(){
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Projet\\Code\\TextFiles\\UserTextFiles\\staffInfo.txt"));
            while((line = reader.readLine()) != null){
                System.out.println("\033[1m" + line + "\033[0m");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAssignedRoom(int staffID){
        System.out.println("\033[1m\033[4mYour Info:\033[0m");
        try {
            String line; 
            int k = 1;
            BufferedReader reader = new BufferedReader(new FileReader("F:\\OOP Project\\Code\\TextFiles\\UserTextFiles\\staffInfo.txt"));
            while((line = reader.readLine()) != null){
                if(k == staffID){
                    String[] details = line.split(", ");
                    for (String detail : details) {
                        System.out.println(detail.trim()); 
                    }
                    break;
                }
                k++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("\033[1m\033[4m\nYour Assigned Room:\033[0m ");
        if(staffID <= 20){
            System.out.println("Regular" + staffID);
        }else if(staffID <= 27){
            System.out.println("OT" + (staffID - 20));
        }else{
            System.out.println("ICU" + (staffID - 27));
        }

    }

}
