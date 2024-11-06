package se.edvard.houserobbery.model;

public abstract class Entity {
    private String role;
    private int damage;
    private int health;

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
    public int getDamage()
    {
        return damage;
    }
    public int getHealth()
    {
        return health;
    }

    public void punch(Entity toPunch)
    {
        toPunch.takeHit(this.damage);
    }

    public void takeHit(int damage)
    {
        health -= damage;
    }

    public boolean isConcious()
    {
        return health > 0;
    }

    public void addDamage(int damage)
    {
        //tänker att jag struntar i den här och kör med weapon istället
    }
}
