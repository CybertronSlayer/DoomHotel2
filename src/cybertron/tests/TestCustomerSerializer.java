package cybertron.tests;

import cybertron.model.Customer;
import cybertron.model.Room;
import cybertron.serialization.CustomerSerializer;
import cybertron.serialization.RoomSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCustomerSerializer extends CustomerSerializer {

    private List<String> lines;

    @Override
    protected void saveToFile(List<String> lines) {this.lines = lines;}


    @Test
    @DisplayName("Test a single customer")
    void testASingleCustomer() {
        Room room = new Room(241,LocalDate.now(),LocalDate.now().plusDays(2));

        var customer = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(room));
        saveCustomer(List.of(customer));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " " + findCustomerRoomList(customer);;
        assertEquals(line,expectedLine);


    }

    @Test
    @DisplayName("Test two customers")
    void testTwoCustomers() {
        Room room1 = new Room(241,LocalDate.now(),LocalDate.now().plusDays(2));
        Room room2 = new Room(412, LocalDate.now(),LocalDate.now().plusDays(4));
        var customer1 = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(room1));
        var customer2 = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(room2));
        saveCustomer(List.of(customer1,customer2));

        assertEquals(2,lines.size());

        var line = lines.get(0);
        var expectedLine = customer1.firstName + " " + customer1.lastName + " " + customer1.phoneNumber + " " + findCustomerRoomList(customer1);
        assertEquals(line,expectedLine);

        var line2 = lines.get(1);
        var expectedLine2 = customer1.firstName + " " + customer1.lastName + " " + customer1.phoneNumber + " " + findCustomerRoomList(customer2);
        assertEquals(line2,expectedLine2);
    }

    @Test
    @DisplayName("Test 0 Customers")
    void test0Customers() {

        Customer customer = null;
        Assertions.assertThrows(NullPointerException.class, () -> saveCustomer(List.of(customer)));
    }



    @Test
    @DisplayName("Test One customer with Two rooms")
    void testOneCustomerWithTwoRooms() {
        Room room1 = new Room(241,LocalDate.now(),LocalDate.now().plusDays(2));
        Room room2 = new Room(412, LocalDate.now(),LocalDate.now().plusDays(4));
        var customer = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(room1,room2));
        saveCustomer(List.of(customer));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " " + findCustomerRoomList(customer);;
        assertEquals(line,expectedLine);

    }

    private String findCustomerRoomList(Customer customer) {
        if (customer.roomList.isEmpty()){
            return "";
        }
        StringBuilder str1 = new StringBuilder();

        for (Room room : customer.roomList) {
            str1.append(room.roomNumber).append(" ")
                    .append(room.startingDate).append(" ")
                    .append(room.exitingDate).append(",");
        }
        str1.deleteCharAt(str1.length() - 1);

        return str1.toString();
    }


//    private String findCustomerRoomList(Room room) {
//        StringBuilder str = new StringBuilder();
//
//        str.append(room.roomNumber).append(" ")
//                .append(room.startingDate).append(" ")
//                .append(room.exitingDate);
//
//        return str.toString();
//    }
}
