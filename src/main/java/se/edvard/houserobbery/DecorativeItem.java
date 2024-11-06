package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Resident;

public class DecorativeItem extends Item{
    String desc;

    public DecorativeItem(String name, String desc) {
        super(name);
        this.desc = desc;
    }

    public void description()
    {
        System.out.println(desc);
    }

    @Override
    public ItemUse use(Resident r) {
        description();
        return null;
    }
}
