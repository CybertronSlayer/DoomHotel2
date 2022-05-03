package cybertron.serialization;

import cybertron.model.Room;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class RoomParser {

    static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\Data\\Rooms.txt");

//    List<Room> roomList = new ArrayList<>();

    public List<Room> takeFromFile(){
        List<String> lines = getLines();
        List<Room> roomList = new ArrayList<>();
        for (var line : lines){
            if (line.isEmpty()){
                continue;
            }
            addDataToRoomList(line,roomList);
        }
        return roomList;
    }

    private void addDataToRoomList(String line,List<Room> roomList) {
        var attributes = line.split(" ");
        var roomNumber = Integer.parseInt(attributes[0]);
//              Dumb Local time parser -_-
//        LocalDate.parse(attributes[1]);//  <--FAIL
//        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalDate startingDate =  LocalDate.parse(attributes[1]); //,formatter);
        LocalDate expiringDate = LocalDate.parse(attributes[2]);//,formatter);

        Room room = new Room(roomNumber,startingDate,expiringDate);
        roomList.add(room);
    }

    protected List<String> getLines() {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
