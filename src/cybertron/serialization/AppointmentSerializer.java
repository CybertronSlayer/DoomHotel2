package cybertron.serialization;

import cybertron.model.Appointment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AppointmentSerializer {

    static Path path = Path.of("C:\\Users\\Iwann\\Desktop\\DoomHotel2\\Data\\Appointments.txt");

    public void saveAppointments(List<Appointment> appointmentList){
        List<String> lines = new ArrayList<>();
        for (var appointment : appointmentList){
            var line = toLine(appointment);
            lines.add(line);
        }
        saveToFile(lines);
    }

    protected void saveToFile(List<String> lines) {
        try {
            Files.write(path,lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String toLine(Appointment appointment) {
        return appointment.roomNumber + " " + appointment.startingDate + " " + appointment.exitingDate + " " + appointment.uuid.toString();
    }

}
