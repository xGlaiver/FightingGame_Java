package notifications;

public class StatisticsObserver implements NotificationObserver {

    private double totalDamage = 0;
    private int totalAttacks = 0;
    
    @Override
    public void onAttack(String attackerName, String attackType, double damage) {
        this.totalDamage += damage;
        this.totalAttacks ++;
    }

    public void printStats() {
        System.out.println("Attacchi effettuati: " + this.totalAttacks);
        System.out.println("Danno totale inflitto: " + totalDamage);
    }
    
}
