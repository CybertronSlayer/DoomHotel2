package cybertron.serializer;

import cybertron.model.ExRoom;
import cybertron.model.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseRooms {

    Path pathRooms = Path.of("C:\\Users\\Ilias\\IdeaProjects\\Hotel Of Doom\\Data\\ExRooms");

    public void parseRooms(Path pathRooms) throws IOException {

        List<ExRoom> exRoomsCap1 = new ArrayList<>();
        List<ExRoom> exRoomsCap2 = new ArrayList<>();
        List<ExRoom> exRoomsCap4 = new ArrayList<>();

        var lines = Files.readAllLines(pathRooms);

        Integer capacityNumber = 0;
        for (var line : lines){  //13
            if (line.startsWith("Capacity: ")){
                capacityNumber = Integer.parseInt( line.substring(10) );
            }
            if (line.startsWith("Room Number: ")) {
                var roomNumber = Integer.parseInt( line.substring(13) );
                ExRoom exRoom = new ExRoom(capacityNumber,roomNumber);
                if (capacityNumber.equals(1)){
                    exRoomsCap1.add(exRoom);
                }
                else if (capacityNumber.equals(2)){
                    exRoomsCap2.add(exRoom);
                }
                else if (capacityNumber.equals(4)){
                    exRoomsCap4.add(exRoom);
                }
            }
        }




    }

}

