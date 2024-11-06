package se.edvard.houserobbery;

import se.edvard.houserobbery.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private String roomName;
    private String roomDesc;
    private HashMap<String, Room> connections = new HashMap<>();

    public Room(String roomName, String roomDesc)
    {
        this.roomName = roomName;
        this.roomDesc = roomDesc;
    }

    public String getRoomName()
    {
        return roomName;
    }
    public String getRoomDesc()
    {
        return roomDesc;
    }

    public void command(String command, Resident r, Burglar b, RobberyGame game)
    {
        for (Item item : itemsInRoom)
        {
            if(command.equalsIgnoreCase(item.getName()))
            {
                item.use(r);
                break;
            }
        }
        for (String key : connections.keySet()) {
            if(command.equalsIgnoreCase(connections.get(key).getRoomName()))
            {
                game.moveToRoom(connections.get(key));
            }
        }

    }

    //returnerar beskrivningen av alla connections och items
    public String getRoomDescExtended()
    {
        String string = roomDesc;
        if(itemsInRoom.size() > 0)
        {
            string += "\nI rummet finns det: ";
        }
        for (Item i: itemsInRoom)
        {
            string += "\n" + i.getName();
        }
        if(connections.size() > 0)
        {
            string += "\nHärifrån kan du gå till: ";
        }
        for (String key : connections.keySet()) {
            string += "\n" + connections.get(key).getRoomDesc();
        }

        return string;
    }

    public void addConnection(Room room)
    {
        connections.put(room.getRoomName(), room);
        room.addConnection(this);
    }
}
