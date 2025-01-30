package Users;

public class Doctor extends User{
    
    int[] assignedPatiendID = new int[40];

    public Doctor(int ID, String name, String contactNumber){
        this.ID = ID;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void viewInfo(){
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Contact Number: " + this.contactNumber);
    }

    public static void main(String[] args) {
 
    }
}
