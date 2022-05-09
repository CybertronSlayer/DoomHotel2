package cybertron.util;

import cybertron.model.Appointment;
import cybertron.model.Customer;
import cybertron.serialization.AppointmentParser;
import cybertron.serialization.AppointmentSerializer;
import cybertron.serialization.CustomerSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Console {

    static Scanner sc = new Scanner(System.in);




    public static String getInput(String msg) {
        System.out.println(msg);
        return sc.next();
    }

    public Customer takeCustomerData(){
        var firstName = getInput("First Name: ");
        var lastName = getInput("Last Name: ");
        var phoneNumber = Long.parseLong(getInput("Phone Number: "));
        var appointmentList = takeAppointmentListData();

        Customer customer = new Customer(firstName,lastName,phoneNumber,appointmentList);
        return customer;
    }

    private List<Appointment> takeAppointmentListData() {
        var sumOfRooms = Integer.parseInt(getInput("How many rooms: "));
        List<Appointment> appointmentList = new ArrayList<>();
        for (int i = 0; i < sumOfRooms; i++) {
            var roomNumber = Integer.parseInt(getInput("Room Number: "));
            var startingDate = LocalDate.parse(getInput("Starting Date: "));
            var exitingDate = LocalDate.parse(getInput("Exiting Date: "));
            var uuid = UUID.randomUUID();
            Appointment appointment = new Appointment(roomNumber,startingDate,exitingDate,uuid);
            appointmentList.add(appointment);
        }
        return appointmentList;
    }


    public void ask(){
        var input = getInput("Bookings / NewBooking");
        switch (input.toLowerCase()){
            case "bookings" -> { seeBookings(); }
            case "newbooking" -> { newBooking(); }
        }
    }

    private void newBooking() {

        var customer = takeCustomerData();
        CustomerSerializer customerSerializer = new CustomerSerializer();
        customerSerializer.saveCustomer(List.of(customer));

        AppointmentSerializer appointmentSerializer = new AppointmentSerializer();
        appointmentSerializer.saveAppointments( takeAppointmentListData() );
    }

    private void seeBookings() {
        AppointmentParser appointmentParser = new AppointmentParser();
        var appointmentList = appointmentParser.takeFromFile();
        System.out.println(appointmentList);
    }


    void test() {
        var personsMultitude = getInput("Αριθμός ατόμων: ");
        var stars = getInput("*: ");

        if(stars.equals(1)){

        }
    }
}
