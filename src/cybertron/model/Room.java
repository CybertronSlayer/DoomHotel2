package cybertron.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Room {
    public Integer roomNumber;
    public UUID uuid;


    public Room(Integer roomNumber,UUID uuid){
        this.roomNumber = roomNumber;
        this.uuid = uuid;
    }

    public Room(Integer roomNumber){
        this.roomNumber = roomNumber;
    }

//    public Room(Integer roomNumber, LocalDate date, LocalDate exitingDate){
//        this.roomNumber = roomNumber;
//        this.startingDate = date;
//        this.exitingDate = exitingDate;

//    }



}