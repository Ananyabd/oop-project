package Rooms;

abstract public class Room {
    public String roomNumber;
    int totalRooms;
    String type;
    double costPerNight;
    public boolean ifAvailable;

    abstract public void viewInfo();

    
}
