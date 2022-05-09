package cybertron.tests;

import cybertron.model.Room;
import cybertron.serialization.RoomParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
    @DisplayName("Test one Room without Uuid")
    void testOneRoomLineWithoutUuid() {
        Integer roomNumber = 241;
        //lines.add(roomNumber + " " + startingDate + " " + exitingDate);
        lines = List.of(roomNumber.toString());


        List<Room> allRooms = takeFromFile();

        assertEquals(1,lines.size());

        var line = lines.get(0);
        Room room = allRooms.get(0);
        String expectedLine = room.roomNumber.toString();

        assertEquals(line,expectedLine);

    }

    @Test
    @DisplayName("Test one room with uuid")
    void testOneRoomWithUuid() {
        Integer roomNumber = 241;
        UUID uuid = UUID.randomUUID();
        lines = List.of(roomNumber.toString() + " " + uuid);


        List<Room> allRooms = takeFromFile();

        assertEquals(1,lines.size());

        var line = lines.get(0);
        Room room = allRooms.get(0);
        String expectedLine = room.roomNumber.toString() + room.uuid;

        assertEquals(line,expectedLine);

    }

    @Test
    @DisplayName("Test Two Rooms With Two Uuids")
    void testTwoRooms() {
        var roomNumber = 241;
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        var roomNumber2 = 242;

        lines = List.of(roomNumber + " " + uuid1 + " " + uuid2,roomNumber2 + " " + uuid1 + " " + uuid2);

        List<Room> allRooms = takeFromFile();

        assertEquals(2,lines.size());

        var line = lines.get(0);
        Room room = allRooms.get(0);
        var expectedLine = room.roomNumber + " " + room.uuid + " " + room.uuid;

        assertEquals(line,expectedLine);

        var line2 = lines.get(1);
        Room room2 = allRooms.get(1);
        var expectedLine2 = room2.roomNumber + " " + room2.uuid + " " + room2.uuid;

        assertEquals(line2,expectedLine2);
    }

    @Test
    @DisplayName("Test Zero Rooms")
    void testZeroRooms() {

        List<Room> allRooms = takeFromFile();

        assertEquals(0,lines.size());


    }

}
