package attacks;

public class HeavyAttack implements AttackStrategy {

    @Override
    public String getName() {
        return "Pesante";
    }

    @Override
    public double attack(double baseDamage) {
        return baseDamage * 1.5;
    }
    
}
