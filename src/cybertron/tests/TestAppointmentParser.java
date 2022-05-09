package cybertron.tests;

import cybertron.serialization.AppointmentParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAppointmentParser extends AppointmentParser {

    List<String> lines = new ArrayList<>();

    @Override
    protected List<String> getLines() {return lines;}


    @Test
    @DisplayName("Test a single appointment")
    void testASingleAppointment() {
        Integer roomNumber = 241;
        LocalDate startingDate = LocalDate.now();
        LocalDate exitingDate = LocalDate.now().plusDays(3);
        UUID uuid = UUID.randomUUID();
        lines.add(roomNumber + " " + startingDate + " " + exitingDate + " " +uuid);

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = roomNumber + " " + startingDate + " " + exitingDate + " " +uuid;

        assertEquals(line,expectedLine);
    }

    @Test
    @DisplayName("Test two appointments")
    void testTwoAppointments() {
        Integer roomNumber1 = 241;
        LocalDate startingDate1 = LocalDate.now();
        LocalDate exitingDate1 = LocalDate.now().plusDays(3);
        UUID uuid1 = UUID.randomUUID();
        lines.add(roomNumber1 + " " + startingDate1 + " " + exitingDate1 + " " +uuid1);

        Integer roomNumber2 = 244;
        LocalDate startingDate2 = LocalDate.now();
        LocalDate exitingDate2 = LocalDate.now().plusDays(5);
        UUID uuid2 = UUID.randomUUID();
        lines.add(roomNumber2 + " " + startingDate2 + " " + exitingDate2 + " " +uuid2);

        assertEquals(2,lines.size());

        var line1 = lines.get(0);
        var expectedLine1 = roomNumber1 + " " + startingDate1 + " " + exitingDate1 + " " +uuid1;

        var line2 = lines.get(1);
        var expectedLine2 = roomNumber2 + " " + startingDate2 + " " + exitingDate2 + " " +uuid2;

        assertEquals(line1,expectedLine1);
        assertEquals(line2,expectedLine2);
    }
}
