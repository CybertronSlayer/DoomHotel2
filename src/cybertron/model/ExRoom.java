package cybertron.model;

public class ExRoom {
    Integer capacity;
    Integer number;

    public ExRoom(Integer capacity, Integer number){
        this.capacity = capacity;
        this.number = number;
    }

    public Integer getExRoomCapacity(){
        return capacity;
    }
}
