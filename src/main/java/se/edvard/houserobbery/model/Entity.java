package se.edvard.houserobbery.model;

import se.edvard.houserobbery.Weapon;

public abstract class Entity {

    private final String role;
    private final int damage;
    private int health;
    private Weapon weapon = null;

    public Entity(String role, int damage, int health)
    {
        this.role = role;
        this.damage = damage;
        this.health = health;
    }
    public String getRole()
    {
        return role;
    }

    public int getHealth()
    {
        return health;
    }

    //om den här entityn har ett vapen så läggs dess skada till på skadan
    public void punch(Entity toPunch)
    {
        toPunch.takeHit(weapon != null ? this.damage + weapon.getDamage() : this.damage);
    }

    public void takeHit(int damage)
    {
        health -= damage;
    }

    public boolean isConscious()
    {
        return health > 0;
    }

    //om man har ett vapen så byts det ut (annan print) och vapnet equippas
    public void addWeapon(Weapon w)
    {
        if(weapon != null)
        {
            System.out.println("Du bytte " + weapon.getName() + " ("+weapon.getDamage()+" atk) mot " + w + " ("+w.getDamage()+" atk)");
        }
        else {
            System.out.println("Du tog upp " + w.getName() + " ("+w.getDamage()+" atk)");
        }
        weapon = w;
    }
}
