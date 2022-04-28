package cybertron.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParseFiles {

    Path pathRooms = Path.of("C:\\Users\\Ilias\\IdeaProjects\\Hotel Of Doom\\info\\Rooms.txt");

    public void parseRooms(Path pathRooms) throws IOException {
        var lines = Files.readString(pathRooms);
        var split = lines.split("--------");
        System.out.println(split);

    }

}

class Room {
    Integer stars;
    Integer capacity;
    Integer available;

    Room(Integer stars, Integer capacity, Integer available){
        this.stars = stars;
        this.capacity = capacity;
        this.available = available;
    }
}
