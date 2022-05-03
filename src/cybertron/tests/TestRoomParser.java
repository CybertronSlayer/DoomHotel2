package cybertron.tests;

import cybertron.model.Room;
import cybertron.serialization.RoomParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingPermission;

import static org.junit.jupiter.api.Assertions.*;

public class TestRoomParser extends RoomParser {

    List<String> lines = new ArrayList<>();

    @Override
    protected List<String> getLines() {
        return lines;
    }

//    @Override
//    public List<Room> takeFromFile() {
//        return super.takeFromFile();
//    }

    @Test
    @DisplayName("Test one Room - Line")
    void testOneRoomLine() {
        var roomNumber = 241;
        var startingDate = LocalDate.now();
        var exitingDate = LocalDate.now().plusDays(3);
        //lines.add(roomNumber + " " + startingDate + " " + exitingDate);
        lines = List.of(roomNumber + " " + startingDate + " " + exitingDate);

        List<Room> allRooms = takeFromFile();

        assertEquals(1,lines.size());

        var line = lines.get(0);
        Room room = allRooms.get(0);
        var expectedLine = room.roomNumber + " " + room.startingDate + " " + room.exitingDate;

        assertEquals(line,expectedLine);

    }

    @Test
    @DisplayName("Test Two Rooms")
    void testTwoRooms() {
        var roomNumber = 241;
        var startingDate = LocalDate.now();
        var exitingDate = LocalDate.now().plusDays(3);

        var roomNumber2 = 241;
        var startingDate2 = LocalDate.now();
        var exitingDate2 = LocalDate.now().plusDays(3);

        //lines.add(roomNumber + " " + startingDate + " " + exitingDate);
        lines = List.of(roomNumber + " " + startingDate + " " + exitingDate,roomNumber2 + " " + startingDate2 + " " + exitingDate2);

        List<Room> allRooms = takeFromFile();

        assertEquals(2,lines.size());

        var line = lines.get(0);
        Room room = allRooms.get(0);
        var expectedLine = room.roomNumber + " " + room.startingDate + " " + room.exitingDate;

        assertEquals(line,expectedLine);

        var line2 = lines.get(1);
        Room room2 = allRooms.get(1);
        var expectedLine2 = room2.roomNumber + " " + room2.startingDate + " " + room2.exitingDate;

        assertEquals(line2,expectedLine2);
    }

    @Test
    @DisplayName("Test Zero Rooms")
    void testZeroRooms() {

        List<Room> allRooms = takeFromFile();

        assertEquals(0,lines.size());


    }

}
