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

    public void punch(Entity toPunch)
    {
        toPunch.takeHit(weapon != null? this.damage + weapon.getDamage() : this.damage);
    }

    public void takeHit(int damage)
    {
        health -= damage;
    }

    public boolean isConcious()
    {
        return health > 0;
    }

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
