package cybertron.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Room {
    public Integer roomNumber;
    public LocalDate startingDate;
    public LocalDate exitingDate;

    public List<UUID> uuid;



    public Room(Integer roomNumber, LocalDate date, LocalDate exitingDate){
        this.roomNumber = roomNumber;
        this.startingDate = date;
        this.exitingDate = exitingDate;
    }

    public Room(Integer roomNumber,List<UUID> uuid){
        this.roomNumber = roomNumber;
        this.uuid = uuid;
    }



}