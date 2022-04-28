package cybertron;

import cybertron.serializer.ParseRooms;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\Ilias\\IdeaProjects\\Hotel Of Doom\\Data\\ExRooms"); {
        }
        ParseRooms parseRooms = new ParseRooms();
        parseRooms.parseRooms(path);


    }
}
