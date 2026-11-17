package notifications;

public class StatisticsObserver implements NotificationObserver {

    private double totalDamage = 0;
    private int totalAttacks = 0;
    private String attackerName;
    private String attackType;
    
    @Override
    public void onAttack(String attackerName, String attackType, double damage) {
        this.attackerName = attackerName;
        this.attackType = attackType;
        this.totalDamage += damage;
        this.totalAttacks ++;
    }

    public void printStats() {
        if (this.totalAttacks > 0) {
            System.out.println("Ultimo attacco: " + this.attackerName + " (" + this.attackType + ")");
        } else {
            System.out.println("Nessun attacco effettuato");
        }
        System.out.println("Attacchi effettuati: " + this.totalAttacks);
        System.out.println("Danno totale inflitto: " + totalDamage);
    }
    
}
