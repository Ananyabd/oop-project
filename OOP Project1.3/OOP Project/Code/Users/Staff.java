package Users;

public class Staff extends User{

    public String type;

    public Staff(int ID, String name, int age, String contactNumber, String type){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.type = type;
    }

    public void viewInfo(){
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Gender: " + this.type);
    }

    public static void main(String[] args) {
 
    }
}
