package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Burglar;
import se.edvard.houserobbery.model.Resident;

import java.util.Scanner;

public class RobberyGame {
    private boolean running = true;
    Resident resident = new Resident();
    Burglar burglar = new Burglar();
    Room currentRoom;
    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        currentRoom = houseSetup();
        while(running && resident.isConcious())
        {
            System.out.println(currentRoom.getRoomDescExtended());
            userInput = scanner.nextLine();
            System.out.println("\n\n\n");
            handleInput(userInput);
            System.out.println();
        }
    }

    public void moveToRoom(Room room)
    {
        currentRoom = room;
    }

    private void handleInput(String input)
    {
        switch (input)
        {
            case "avsluta" -> {running = false; return;}

        }
        currentRoom.command(input, resident, this);
    }

    //kalla på den här en gång för att göra huset (alla rum)
    private Room houseSetup()
    {
        Room entryRoom = new Room("Vardagsrum", "Ett litet vardagsrum i mitten av huset. Det finns en liten tv, men inte så mycket annat");
        entryRoom.addItem(new DecorativeItem("TV","Du kan inte kolla på TV nu"));

        Room room = new Room("Kök", "Köket, det ligger lite köksredskap utspridda");
        room.addItem(new Weapon("Stekpanna", 3));
        room.addItem(new DecorativeItem("Kökskniv", "Du vill inte mörda tjuven, försök hitta något mindre vasst"));
        entryRoom.addConnection(room);

        room = new Room("Sovrum", "Ditt sovrum, inget speciellt finns här.");
        room.addItem(new DecorativeItem("Säng","Du kan inte gå och lägga dig, du måste ta hand om tjuven först"));
        entryRoom.addConnection(room);

        room = new Room("Hall", "Hallen mellan ytterdörren och vardagsrummet");
        Room finalRoom = room;
        Item burglarFight = new Item("Inbrottstjuv") {
            @Override
            public ItemUse use(Resident r) {
                Fight.fight(resident, burglar);
                if(!burglar.isConcious())
                {
                    finalRoom.addItem(new DecorativeItem("Knockad inbrottstjuv", "Den avsvimmade inbrottstjuven, gå och ring polisen!"));
                    return this;
                }
                else
                {
                    System.out.println("Du förlorade slagmålet och tjuven snodde allt du ägde");
                }
                return null;
            }
        };
        room.addItem(burglarFight);
        room.addItem(new DecorativeItem("Ytterdörr","Du måste ta hand om tjuven"));
        entryRoom.addConnection(room);

        room = new Room("Kontor", "Ditt arbetskontor, det finns ett skrivbord med en telefon, en laptop och en massor av papper på");
        Item phone = new Item("Telefon") {
            @Override
            public ItemUse use(Resident r) {
                if(!burglar.isConcious())
                {
                    System.out.println("Du ringer till polisen och de kommer och arresterar inbrottstjuven");
                    running = false;
                }
                else
                {
                    System.out.println("Du vågar inte ringa polisen medan tjuven driver runt i huset");
                }
                return null;
            }
        };
        room.addItem(phone);
        room.addItem(new DecorativeItem("Laptop","Du kan inte arbeta nu, ta hand om tjuven först"));
        entryRoom.addConnection(room);

        return entryRoom;
    }
}
