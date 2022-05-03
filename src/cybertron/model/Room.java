package cybertron.model;

import java.time.LocalDate;

public class Room {
    public Integer roomNumber;
    public LocalDate startingDate;
    public LocalDate exitingDate;



    public Room(Integer roomNumber, LocalDate date, LocalDate exitingDate){
        this.roomNumber = roomNumber;
        this.startingDate = date;
        this.exitingDate = exitingDate;
    }




}