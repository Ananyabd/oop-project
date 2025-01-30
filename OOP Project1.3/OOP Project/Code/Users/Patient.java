package Users;

public class Patient extends User{
    String patientProblem;
    int appointedDoctorID;
    String appointedRoomType;
    String appointedRoomID;
    int appointedStaffID;

    
    public Patient(int ID, String name, int age, String gender, String patientProblem, String contactNumber, String address, int appointedDoctorID, String appointedRoomType, String appointedRoomID, int appointedStaffID){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.patientProblem = patientProblem;
        this.appointedDoctorID = appointedDoctorID;
        this.appointedRoomType = appointedRoomType;
        this.appointedRoomID = appointedRoomID;
        this.appointedStaffID = appointedStaffID;
    }

    public void viewInfo(){
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age); 
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Address: " + this.address);
        System.out.println("Patient Problem: " + this.patientProblem);
        System.out.println("Apppointed Doctor ID: " + this.appointedDoctorID);
        System.out.println("Apppointed Room Type: " + this.appointedRoomType);
        System.out.println("Apppointed Room ID: " + this.appointedRoomID);
        System.out.println("Apppointed Staff ID: " + this.appointedStaffID);

    }

    public static void main(String[] args) {
 
    }
}
