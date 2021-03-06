package cybertron.tests;

import cybertron.model.Room;
import cybertron.serialization.RoomSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestRoomSerializer extends RoomSerializer{

    private List<String> lines;

    @Override
    protected void saveToFile(List<String> lines) {
        this.lines = lines;
    }

    @Test
    @DisplayName("Test a single room")
    void testASingleRoom() {
        Room room = new Room(21, LocalDate.now(),LocalDate.now().plusDays(2));
        saveRoom(List.of(room));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = room.roomNumber + " " + room.startingDate + " " + room.exitingDate;

        assertEquals(line,expectedLine);

    }

    @Test
    @DisplayName("Test two rooms")
    void testTwoRooms() {
        Room room1 = new Room(21, LocalDate.now(),LocalDate.now().plusDays(2));
        Room room2 = new Room(21, LocalDate.now(),LocalDate.now().plusDays(4));
        saveRoom(List.of(room1,room2));

        assertEquals(2,lines.size());

        var line = lines.get(0);
        var expectedLine = room1.roomNumber + " " + room1.startingDate + " " + room1.exitingDate;

        assertEquals(line,expectedLine);

        var line2 = lines.get(1);
        var expectedLine2 = room2.roomNumber + " " + room2.startingDate + " " + room2.exitingDate;

        assertEquals(line2,expectedLine2);
    }

    @Test
    @DisplayName("Test zero rooms")
    void testZeroRooms() {
        Room room = null;
        assertThrows(NullPointerException.class, () -> saveRoom(List.of(room)));


    }
}
