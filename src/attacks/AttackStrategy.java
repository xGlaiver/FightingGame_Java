package attacks;

public interface AttackStrategy {
    public String getName();
    public double attack(double baseDamage);
}
