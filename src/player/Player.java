package player;

import attacks.AttackStrategy;

public class Player {
    private String name;
    private double lifePoints;
    private AttackStrategy strategy;
    private double baseDamage;

    public Player(String name, double lifePoints, AttackStrategy strategy, double baseDamage) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.strategy = strategy;
        this.baseDamage = baseDamage;
    }

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public AttackStrategy getStrategy() {
        return this.strategy;
    }

    public double getLifePoint() {
        return this.lifePoints;
    }

    public String getName() {
        return this.name;
    }

    public double attack() {
        return this.strategy.attack(this.baseDamage);
    }

    public void receiveDamage(double damage) {
        this.lifePoints -= damage;
    }

    public boolean isAlive() {
        return getLifePoint() > 0;
    }


}
