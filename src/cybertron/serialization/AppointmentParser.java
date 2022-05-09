package cybertron.serialization;

import cybertron.model.Appointment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppointmentParser {

    static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\Data\\Appointements.txt");

    public List<Appointment> takeFromFile(){
        List<String> lines = getLines();
        List<Appointment> appointmentList = getAppointments(lines);
        return appointmentList;
    }

    private List<Appointment> getAppointments(List<String> lines) {
        List<Appointment> appointmentList = new ArrayList<>();
        for (var line : lines){
            var attributes = line.split(" ");
            var roomNumber = Integer.parseInt(attributes[0]);
            var startingDate = LocalDate.parse(attributes[1]);
            var exitingDate = LocalDate.parse(attributes[2]);
            var uuid = UUID.fromString(attributes[3]);

            Appointment appointment = new Appointment(roomNumber,startingDate,exitingDate,uuid);
            appointmentList.add(appointment);
        }
        return appointmentList;
    }

    protected List<String> getLines() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
