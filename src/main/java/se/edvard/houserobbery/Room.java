package se.edvard.houserobbery;

import se.edvard.houserobbery.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    //alla objekt (weapon, decorative item, item) som finns i rummet
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private String roomName;
    private String roomDesc;
    //till vilka rum man kan gå från det här rummet
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

    //tar det användaren skrev in och kollar om det matchar namnet på något av objekten/kopplingarna i rummet
    public void command(String command, Resident r, RobberyGame game)
    {
        for (Item item : itemsInRoom)
        {
            if(command.equalsIgnoreCase(item.getName()))
            {
                //kör itemens use-metod och tar bort det som returneras från rummet, vilket antingen är itemen eller null
                removeItem((Item)(item.use(r)));
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
        String string = roomDesc + "\n";
        if(!itemsInRoom.isEmpty())
        {
            string += "\nI rummet finns det: ";
        }
        for (Item i: itemsInRoom)
        {
            string += "\n" + i.getName();
        }
        if(!itemsInRoom.isEmpty())
        {
            string +=  "\n";
        }
        if(!connections.isEmpty())
        {
            string += "\nHärifrån kan du gå till: ";
        }
        for (String key : connections.keySet()) {
            string += "\n" + connections.get(key).getRoomName();
        }

        return string;
    }

    public void addItem(Item i)
    {
        itemsInRoom.add(i);
    }

    public void removeItem(Item i)
    {
        itemsInRoom.remove(i);
    }

    //lägger till en tvåvägskoppling mellan det här rummet och ett annat
    public void addConnection(Room room)
    {
        if(room != this)
        {
            connections.put(room.getRoomName(), room);
            room.addOneWayConnection(this);
        }
    }
    public void addOneWayConnection(Room room)
    {
        connections.put(room.getRoomName(), room);
    }
}
