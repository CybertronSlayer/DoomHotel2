package cybertron;

import cybertron.input.ParseFiles;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\\\Users\\\\Ilias\\\\IdeaProjects\\\\Hotel Of Doom\\\\info\\\\Rooms.txt"); {
        }
        ParseFiles parseFiles = new ParseFiles();
        parseFiles.parseRooms(path);


    }
}
