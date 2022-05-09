package cybertron.model;

import java.util.List;
import java.util.UUID;

public class Customer {
    public String firstName;
    public String lastName;
    public Long phoneNumber;
    public List<Appointment> appointmentList;

    public Customer(String firstName, String lastName, Long phoneNumber, List<Appointment> appointmentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.appointmentList = appointmentList;
    }

    public Customer(String firstName, String lastName, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.appointmentList = null;
    }
}

