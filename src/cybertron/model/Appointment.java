package cybertron.model;

import java.time.LocalDate;
import java.util.UUID;

public class Appointment {
    public Integer roomNumber;
    public LocalDate startingDate;
    public LocalDate exitingDate;
    public UUID uuid;

    public Appointment(Integer roomNumber, LocalDate startingDate, LocalDate exitingDate, UUID uuid){
        this.roomNumber = roomNumber;
        this.startingDate = startingDate;
        this.exitingDate = exitingDate;
        this.uuid = uuid;
    }

    public Appointment(UUID uuid){
        this.uuid = uuid;
    }
}
