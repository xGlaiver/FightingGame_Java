package player;

import java.util.ArrayList;
import java.util.List;

import attacks.AttackStrategy;
import notifications.NotificationObserver;
import weapons.Weapon;

public class Player {
    private String name;
    private double lifePoints;
    private AttackStrategy strategy;
    private Weapon weapon;
    private List<NotificationObserver> observers = new ArrayList<>();

    public Player(String name, double lifePoints, AttackStrategy strategy, Weapon weapon) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.strategy = strategy;
        this.weapon = weapon;
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
        double damage = this.strategy.attack(this.weapon.getDamage());
        notifyObservers(damage);
        return damage;
    }

    public void receiveDamage(double damage) {
        this.lifePoints -= damage;
    }

    public boolean isAlive() {
        return getLifePoint() > 0;
    }

    private void notifyObservers(double damage) {
        for(NotificationObserver observer : observers) {
            observer.onAttack(this.name, this.strategy.getName(), damage);
        }
    }

    public void addObserver(NotificationObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        this.observers.remove(observer);
    }
}
