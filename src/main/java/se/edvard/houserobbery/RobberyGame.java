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
        while(running)
        {
            userInput = scanner.nextLine();
            handleInput(userInput);
        }
    }

    public void moveToRoom(Room room)
    {

    }

    private void handleInput(String input)
    {
        switch (input)
        {
            case "exit" -> running = false;

        }
        currentRoom.command(input, resident, burglar, this);
    }
}
