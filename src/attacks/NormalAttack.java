package attacks;

public class NormalAttack implements AttackStrategy {

    @Override
    public String getName() {
        return "Normale";
    }

    @Override
    public double attack(double baseDamage) {
        return baseDamage;
    }
    
}
