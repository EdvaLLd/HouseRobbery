package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Entity;

public class Fight {
    public static void fight(Entity e1, Entity e2) {
        while(e1.isConcious() && e2.isConcious())
        {
            e1.punch(e2);
            if(e2.isConcious()) e2.punch(e1);
        }
        Entity winner = (e1.isConcious()?e1:e2);
        System.out.println(winner.getRole() + " vann slagsmålet!");
    }
}
