package cybertron.serialization;

import cybertron.model.Customer;
import cybertron.model.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CustomerSerializer {

    static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\src\\cybertron\\model\\Customer.java");

    public void saveCustomer(List<Customer> customerList){
        List<String> lines = new ArrayList<>();
        for (Customer customer : customerList) {
            var line = toLine(customer);
            lines.add(line);
        }
        saveToFile(lines);
    }

    protected String toLine(Customer customer){

        return customer.firstName + " " + customer.lastName + " " + customer.phoneNumber
               + " " + findRoomList(customer) ;
    }

    private String findRoomList(Customer customer) {
        if (customer.roomList.isEmpty()){
            return "";
        }

        StringBuilder str = new StringBuilder();
        for (Room room : customer.roomList){
            str.append(room.roomNumber).append(" ").append(room.startingDate).append(" ").append(room.exitingDate).append(",");
        }
        str.deleteCharAt(str.length() -1 );
        return str.toString();
    }

    protected void saveToFile(List<String> lines){
        try{
            Files.write(path,lines);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
