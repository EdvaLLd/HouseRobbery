package se.edvard.houserobbery;

public abstract class Item implements ItemUse {
    private final String name;

    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
