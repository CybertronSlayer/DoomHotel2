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
    @Override
    protected List<String> getLines() {return lines;}


    @Test
    @DisplayName("Test one customer with one room")
    void testOneCustomerWithOneRoom() {
        var firstName = "Ioannis";
        var lastName = "Tzortzinis";
        Long phoneNumber = 694477834L;
        var roomNumber = 241;
        var startingDate = LocalDate.now();
        var exitingDate = LocalDate.now().plusDays(3);
        lines = (List.of(firstName + " " + lastName + " " + phoneNumber + " " + roomNumber + " " + startingDate + " " + exitingDate));

        List<Customer> customerList = takeFromFile();
        Customer customer = customerList.get(0);

        List<Room> roomList = getRoomList();

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " " + ;

        assertEquals(line,expectedLine);



    }
}
