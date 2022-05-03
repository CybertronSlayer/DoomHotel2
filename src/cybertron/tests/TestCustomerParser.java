package cybertron.tests;

import cybertron.model.Customer;
import cybertron.model.Room;
import cybertron.serialization.CustomerParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCustomerParser extends CustomerParser {

    List<String> lines = new ArrayList<>();
    private List<Room> rooms;

    @Override
    protected List<String> getLines() {return lines;}

    @Override
    protected List<Room> getRoomList() {
        return rooms;
    }


    @Test
    @DisplayName("One customer with no room")
    void oneCustomerWithNoRoom() {
        var firstName = "Ioannis";
        var lastName = "Tzortzinis";
        Long phoneNumber = 694477834L;
        lines = (List.of(firstName + " " + lastName + " " + phoneNumber + " "));
        List<Customer> customerList = takeFromFile();
        Customer customer = customerList.get(0);

        assertEquals(firstName, customer.firstName);
        assertEquals(lastName, customer.lastName);
        assertEquals(phoneNumber, customer.phoneNumber);
    }

    @Test
    @DisplayName("One customer with null phone and no room")
    void oneCustomerWithNullPhoneAndNoRoom() {
        var firstName = "Ioannis";
        var lastName = "Tzortzinis";
        Long phoneNumber = null;
        lines = (List.of(firstName + " " + lastName + " " + null + " "));
        List<Customer> customerList = takeFromFile();
        Customer customer = customerList.get(0);

        assertEquals(firstName, customer.firstName);
        assertEquals(lastName, customer.lastName);
        assertNull(customer.phoneNumber);
    }


    @Test
    @DisplayName("Test one customer with one room")
    void testOneCustomerWithOneRoom() {
        var firstName = "Ioannis";
        var lastName = "Tzortzinis";
        Long phoneNumber = 694477834L;
        var roomNumber = 241;
        var startingDate = LocalDate.now();
        var exitingDate = LocalDate.now().plusDays(3);
        Room room = new Room(roomNumber,startingDate,exitingDate);
        rooms = List.of(room);

        String line = firstName + " " + lastName + " " + phoneNumber + " " + roomNumber + " " + startingDate + " " + exitingDate;
        lines = (List.of(line));


        List<Customer> customerList = takeFromFile();
        Customer customer = customerList.get(0);

        //List<Room> roomList = getRoomList();

        assertEquals(1,lines.size());

        //var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " "  ;
        //assertEquals(line,expectedLine);

        assertEquals(firstName, customer.firstName);
        assertEquals(lastName, customer.lastName);
        assertEquals(phoneNumber, customer.phoneNumber);
        assertEquals(1,customer.roomList.size());

    }
}
