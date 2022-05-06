package cybertron.model;

import java.time.LocalDate;
import java.util.UUID;

public class Appointment {

    Integer roomNumber;
    LocalDate startingDate;
    LocalDate exitingDate;
    UUID uuid;

    public Appointment(Integer roomNumber, LocalDate startingDate, LocalDate exitingDate, UUID uuid){
        this.roomNumber = roomNumber;
        this.startingDate = startingDate;
        this.exitingDate = exitingDate;
        this.uuid = uuid;
    }

}
