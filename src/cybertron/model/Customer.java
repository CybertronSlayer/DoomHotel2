package cybertron.model;

import java.util.List;

public class Customer {
    public String firstName;
    public String lastName;
    public Long phoneNumber;
    public List<Room> roomList;

    //FirstName & LastName & PhoneNumber & RoomList
    public Customer(String firstName,String lastName,Long phoneNumber,List<Room> roomList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.roomList = roomList;
    }

    //FirstName & LastName & PhoneNumber
    public Customer(String firstName, String lastName,Long phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        roomList = null;
    }

    //FirstName & LastName
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        phoneNumber = null;
        roomList = null;
    }
}
