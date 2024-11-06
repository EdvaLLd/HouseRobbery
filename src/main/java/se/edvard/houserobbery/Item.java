package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Resident;

public class Item {
    private String name;

    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void use(Resident r)
    {

    }
}
