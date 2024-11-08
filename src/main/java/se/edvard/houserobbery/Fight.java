package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Entity;

public class Fight {
    //statisk metod som gör så entiteterna slåss tills en av dem svimmar
    public static void fight(Entity e1, Entity e2) {
        while(e1.isConscious() && e2.isConscious())
        {
            e1.punch(e2);
            if(e2.isConscious()) e2.punch(e1);
        }
        Entity winner = (e1.isConscious()?e1:e2);
        System.out.println(winner.getRole() + " vann slagsmålet!");
    }
}
