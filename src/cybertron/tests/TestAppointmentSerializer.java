package cybertron.tests;

import cybertron.model.Appointment;
import cybertron.serialization.AppointmentSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAppointmentSerializer extends AppointmentSerializer {
    List<String> lines = new ArrayList<>();

    @Override
    protected void saveToFile(List<String> lines) {this.lines = lines;}

    @Test
    @DisplayName("Test a single appointment")
    void testASingleAppointment() {
        Appointment appointment = new Appointment(241, LocalDate.now(),LocalDate.now().plusDays(3), UUID.randomUUID());
        saveAppointments(List.of(appointment));

        assertEquals(1,lines.size());

        var line = lines.get(0);
        var expectedLine = appointment.roomNumber + " " + appointment.startingDate + " " + appointment.exitingDate + " " + appointment.uuid;

        assertEquals(expectedLine,line);
    }
}
