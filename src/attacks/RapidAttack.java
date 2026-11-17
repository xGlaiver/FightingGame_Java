package attacks;

public class RapidAttack implements AttackStrategy {

    @Override
    public String getName() {
        return "Rapido";
    }

    @Override
    public double attack(double baseDamage) {
        return (baseDamage * 0.8);
    }
    
}
