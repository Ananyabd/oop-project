import Services.BillingSystem;
import Services.Pharmacy;
import Services.RoomSystem;
import Services.UserSystem;
import java.util.Scanner;

public class HospitalManagementSystem {

    private static final String DOCTOR_PASSKEY = "doctor123"; 
    private static final String STAFF_PASSKEY = "staff123";   

    UserSystem userSystem = new UserSystem();
    RoomSystem roomSystem = new RoomSystem();
    BillingSystem billingSystem = new BillingSystem();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        HospitalManagementSystem HMS = new HospitalManagementSystem();

        System.out.println("\033[1mWelcome to the Hospital Management System!\033[0m");
        System.out.println("\033[1mPlease an option:\033[0m");
        System.out.println("\033[1m1. Patient\033[0m");
        System.out.println("\033[1m2. Doctor\033[0m");
        System.out.println("\033[1m3. Staff\033[0m");
        System.out.println("\033[1m4. Pharmacy\033[0m");
        System.out.println("\033[1m5. Exit\033[0m");

        int flag = 1;
        do { 
            System.out.print("\033[1mInput: \033[0m");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    patientMenu();
                    flag = 1;     
                    break;
                case 2:
                    doctorMenu();
                    flag = 1;
                    break;
                case 3:
                    staffMenu();
                    flag = 1;
                    break;
                case 4:
                    pharmacyMenu();
                    flag = 1;
                    break;
                case 5:
                    System.out.println("\u001B[1m\u001B[34mThank you for using the system. Have a great day! Exiting now...\u001B[0m");
                    System.out.println("");
                    flag = 1;
                    break;
                default:
                    System.out.println("\033[1;31mInvalid choice. Please try again.\033[0m");
                    flag = 0;
            }
        } while (flag == 0);

        sc.close();
    }

    public static void patientMenu(){

        HospitalManagementSystem HMS = new HospitalManagementSystem();

        int patientChoice;

        System.out.println("\033[1mPatient Menu:\033[0m");

        int flag = 0;
        do {  
            if (flag == 0) {
                System.out.println("\033[1m1. Make an Appointment\033[0m");
            } 
            System.out.println("\033[1m2. View Appointment Details\033[0m");
            System.out.println("\033[1m3. Generate Bill\033[0m");
            System.out.println("\033[1m4. Exit\033[0m");
            System.out.print("\033[1mInput: \033[0m");
            patientChoice = sc.nextInt();
            switch (patientChoice) {
                case 1:
                    HMS.userSystem.appointment(); 
                    flag = 1;
                    break;
                case 2:
                    System.out.print("\033[1mPlease submit your patient ID: \033[0m");
                    int ID = sc.nextInt();
                    System.out.println("\n\033[1mHere are your appointment details:\033[0m");
                    HMS.userSystem.viewPatientInfo(ID);
                    break;
                case 3:
                    int id, day;
                    System.out.print("\033[1mPlease Submit your patient ID: \033[0m");
                    id = sc.nextInt();
                    System.out.print("\033[1mPlease Submit your Stay Duration/ Visited times(to Doctor): \033[0m");
                    day = sc.nextInt();
                    HMS.billingSystem.billing(id, day);
                    break;
                case 4:
                    System.out.println("\u001B[1m\u001B[34mThank you for using the system. Have a great day! Exiting now...\u001B[0m");
                    System.out.println("");
                    flag = 4;
                    break;
                default:
                    System.out.println("\033[1;31mInvalid choice. Please try again!\033[0m");
            }
        } while (flag != 4);
    }

    public static void doctorMenu() {

        HospitalManagementSystem HMS = new HospitalManagementSystem();

        int doctorID, docChoice;

        System.out.println("\033[1mDoctor Menu:\033[0m");
        if(authenticateUser("doctor") == true){
            int flag = 0;
            do {  
                System.out.println("\033[1m1. Assigned Patients\033[0m");
                System.out.println("\033[1m2. Exit\033[0m");
                System.out.print("\033[1mInput: \033[0m");
                docChoice = sc.nextInt();
                switch (docChoice) {
                    case 1:
                        System.out.print("\033[1mPlease submit your doctor ID: \033[0m");
                        doctorID = sc.nextInt();
                        HMS.userSystem.viewAssignedPatients(doctorID);
                        flag = 0;
                        break;
                    case 2:
                        System.out.println("\u001B[1m\u001B[34mThank you for using the system. Have a great day! Exiting now...\u001B[0m");
                        System.out.println("");
                        flag = 1;
                        break;
                    default:
                        System.out.println("\033[1;31mInvalid choice. Please try again!\033[0m");
                }
            } while (flag == 0);
        }
    }

    public static void staffMenu() {

        HospitalManagementSystem HMS = new HospitalManagementSystem();

        int staffID, staffChoice;

        System.out.println("\033[1mStaff Members Menu:\033[0m");
        if(authenticateUser("staff") == true){

            int flag = 0;
            do {  
                System.out.println("\033[1m1. Assigned Room\033[0m");
                System.out.println("\033[1m2. Exit\033[0m");
                System.out.print("\033[1mInput: \033[0m");
                staffChoice = sc.nextInt();
                switch (staffChoice) {
                    case 1:
                        System.out.print("\033[1mPlease submit your staff ID: \033[0m");
                        staffID = sc.nextInt();
                        HMS.userSystem.viewAssignedRoom(staffID);
                        System.out.println("");
                        flag = 0;
                        break;
                    case 2:
                        System.out.println("\u001B[1m\u001B[34mThank you for using the system. Have a great day! Exiting now...\u001B[0m");
                        System.out.println("");
                        flag = 1;
                        break;
                    default:
                        System.out.println("\033[1;31mInvalid choice. Please try again!\033[0m");
                }
            } while (flag == 0);
        }
    }

    public static boolean  authenticateUser(String userType) {
        String passkey = userType.equals("doctor") ? DOCTOR_PASSKEY : STAFF_PASSKEY;
        String inputPasskey;
        boolean authenticated = false;
        int attempts = 0;

        while (!authenticated && attempts < 3) {
            System.out.print("Enter " + userType + " passkey: ");
            inputPasskey = sc.next();
            if (inputPasskey.equals(passkey)) {
                authenticated = true;
                System.out.println("Passkey accepted. Access granted to " + userType + " menu.");
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("\033[1;31mIncorrect passkey. Please try again.\033[0m");
                }
            }
        }

        if (!authenticated) {
            System.out.print("\033[1;31mToo many failed attempts. Exiting\033[0m");
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                System.out.print("\033[1;31m.\033[0m");
            }
            System.out.println("");
            System.out.println("");
            return false;
        }
        return true;
    }


    public static void pharmacyMenu(){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.buyMedicines();
    }
}
