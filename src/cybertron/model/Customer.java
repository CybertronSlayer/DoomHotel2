package cybertron.model;

public class Customer {
    String firstName;
    String lastName;
    Long phoneNumber;

    Customer(String firstName,String lastName,Long phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
