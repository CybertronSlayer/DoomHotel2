package cybertron.model;

public class Room {
    Integer stars;
    Integer capacity;
    Integer available;
    Integer number;

    Room(Integer stars, Integer capacity, Integer available,Integer number) {
        this.stars = stars;
        this.capacity = capacity;
        this.available = available;
        this.number = number;
    }

    Integer getRoomNumber(){
        return this.number;
    }
    void setRoomNumber(Integer roomNumber){
        this.number = number;
    }
}
