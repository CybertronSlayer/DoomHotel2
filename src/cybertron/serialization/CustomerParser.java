package cybertron.serialization;

import cybertron.model.Customer;
import cybertron.model.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerParser {

    static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\Data\\Customer.txt");

    public List<Customer> takeFromFile(){
        List<String> lines = getLines();
        List<Customer> customerList = new ArrayList<>();
        for (var line : lines){
            Customer customer = addDataToCustomerList(line);
            customerList.add(customer);
        }
        return customerList;
    }

    private Customer addDataToCustomerList(String line) {
        var attributes = line.split(" ");
        var firstName = attributes[0];
        var lastName = attributes[1];
        //Null phoneNumber check
        var phoneNumberStr = attributes[2];
        Long phoneNumber;
        if (phoneNumberStr.equals("null")){
            phoneNumber = null;
        }else{
            phoneNumber = Long.parseLong(phoneNumberStr);
        }
        // DANGER !
        if (attributes.length < 3) {
            return new Customer(firstName,lastName,phoneNumber,null);
        }

        var room = new ArrayList<Room>();

        if (attributes.length > 3){
            parseRooms(room, attributes);
        }

        return new Customer(firstName,lastName,phoneNumber,);
    }

    private void parseRooms(ArrayList<Room> room, String[] attributes) {
        for (int i = 3; i + 3 < attributes.length; i+=3){
            var a = attributes[i];
            var b = attributes[i + 1];
            var c = attributes[i + 2];
        }
    }

    protected List<Room> getRoomList(String[] attributes,String line) {
        // Null check <--
        if (attributes.length < 3) {
            return null;
        }
        // DANGER !
        var roomNumber = Integer.parseInt(attributes[3]);
        var startingDate = LocalDate.parse(attributes[4]);
        var exitingDate = LocalDate.parse(attributes[5]);



        Room room = new Room(roomNumber,startingDate,exitingDate);
        return List.of(room);
    }
//        for (int i = 3; i < attributes.length ; i++) {
//
////            for (var e : attributes) {
////                var roomNumber = attributes[i];
////                var startingDate = attributes[i+1];
////                var exitingDate = attributes[i+2];
////            }
//        }
//
//
//        List<Room> rooms = new ArrayList<>();
//        for (var room : rooms) {
//            var roomNumber = ;
//            var startingDate = ;
//            var exitingDate = ;
//        }



    protected List<String> getLines() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
