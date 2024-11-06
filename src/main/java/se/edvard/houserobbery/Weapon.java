package se.edvard.houserobbery;

import se.edvard.houserobbery.model.Resident;

public class Weapon extends Item{
    int damage;


    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage()
    {
        return damage;
    }

    @Override
    public ItemUse use(Resident r) {
        r.addWeapon(this);
        return this;
    }
}
