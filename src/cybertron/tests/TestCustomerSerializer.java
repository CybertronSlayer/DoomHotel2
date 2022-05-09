package cybertron.tests;

import cybertron.model.Appointment;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestCustomerSerializer extends CustomerSerializer {

    private List<String> lines;

    @Override
    protected void saveToFile(List<String> lines) {this.lines = lines;}


    @Test
    @DisplayName("Test a single customer")
    void testASingleCustomer() {
        Appointment appointment = new Appointment(UUID.randomUUID());
//        List<UUID> uuidList = new ArrayList<>();
//        uuidList.add(appointment.uuid);

        var customer = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(appointment));
        saveCustomer(List.of(customer));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " " + customer.appointmentList.get(0).uuid;
        assertEquals(line,expectedLine);


    }

    @Test
    @DisplayName("Test two customers")
    void testTwoCustomers() {
        //Room room1 = new Room(241,LocalDate.now(),LocalDate.now().plusDays(2));
        //Room room2 = new Room(412, LocalDate.now(),LocalDate.now().plusDays(4));
        Appointment appointement1 = new Appointment(UUID.randomUUID());
        Appointment appointement2 = new Appointment(UUID.randomUUID());

        var customer1 = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(appointement1));
        var customer2 = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(appointement2));
        saveCustomer(List.of(customer1,customer2));

        assertEquals(2,lines.size());

        var line = lines.get(0);
        var expectedLine = customer1.firstName + " " + customer1.lastName + " " + customer1.phoneNumber + " " + findUuid(customer1);
        assertEquals(line,expectedLine);

        var line2 = lines.get(1);
        var expectedLine2 = customer1.firstName + " " + customer1.lastName + " " + customer1.phoneNumber + " " + findUuid(customer2);
        assertEquals(line2,expectedLine2);
    }

    @Test
    @DisplayName("Test 0 Customers")
    void test0Customers() {

        Customer customer = null;
        Assertions.assertThrows(NullPointerException.class, () -> saveCustomer(List.of(customer)));
    }



    @Test
    @DisplayName("Test One customer with Two uuids")
    void testOneCustomerWithTwoUuid() {
//        Room room1 = new Room(241,LocalDate.now(),LocalDate.now().plusDays(2));
//        Room room2 = new Room(412, LocalDate.now(),LocalDate.now().plusDays(4));
        Appointment appointement1 = new Appointment(UUID.randomUUID());
        Appointment appointement2 = new Appointment(UUID.randomUUID());
        var customer = new Customer("Ioannis","Tzortzinis",6944668887L,List.of(appointement1,appointement2));
        saveCustomer(List.of(customer));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = customer.firstName + " " + customer.lastName + " " + customer.phoneNumber + " " + findUuid(customer);;
        assertEquals(line,expectedLine);

    }

//    private String findCustomerRoomList(Customer customer) {
//        if (customer.roomList.isEmpty()){
//            return "";
//        }
//        StringBuilder str1 = new StringBuilder();
//
//        for (Room room : customer.roomList) {
//            str1.append(room.roomNumber).append(" ")
//                    .append(room.startingDate).append(" ")
//                    .append(room.exitingDate).append(",");
//        }
//        str1.deleteCharAt(str1.length() - 1);
//
//        return str1.toString();
//    }


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
