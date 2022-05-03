package cybertron.serialization;

import cybertron.model.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RoomSerializer {

    public static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\src\\cybertron\\model\\Room.java");

    public void saveRoom(List<Room> roomList){
        List<String> lines = new ArrayList<>();
        for (Room room : roomList) {
            var line = toLine(room);
            lines.add(line);
        }
        saveToFile(lines);
    }


    protected String toLine(Room room) {
        var line = room.roomNumber + " " + room.startingDate + " " + room.exitingDate;
        return line;
    }

    protected void saveToFile(List<String> lines) {
        try {
            Files.write(path, lines);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
