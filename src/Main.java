import attacks.AttackStrategy;
import attacks.HeavyAttack;
import attacks.NormalAttack;
import attacks.RapidAttack;
import notifications.StatisticsObserver;
import player.Player;
import weapons.Weapon;
import weapons.WeaponFactory;

public class Main {

    public static void main(String[] args) {

        String[] weaponTypes = {"Spada", "Arco", "Bastone Magico"};

        Weapon weapon1 = WeaponFactory.createWeapon(weaponTypes[(int) (Math.random() * weaponTypes.length)]);
        Weapon weapon2 = WeaponFactory.createWeapon(weaponTypes[(int) (Math.random() * weaponTypes.length)]);

        Player player1 = new Player("Marco", 100, new NormalAttack(), weapon1);
        Player player2 = new Player("Mariano", 100, new NormalAttack(), weapon2);

        System.out.println(player1.getName() + " usa " + weapon1.getName() + " (danno base " + weapon1.getDamage() + ")");
        System.out.println(player2.getName() + " usa " + weapon2.getName() + " (danno base " + weapon2.getDamage() + ")");

        StatisticsObserver stats1 = new StatisticsObserver();
        StatisticsObserver stats2 = new StatisticsObserver();
        player1.addObserver(stats1);
        player2.addObserver(stats2);

        AttackStrategy[] strategies = {new NormalAttack(), new HeavyAttack(), new RapidAttack()};

        System.out.println("\n=== INIZIO COMBATTIMENTO ===");
        Player attacker = player1;
        Player defender = player2;
        int turn = 1;

        while (player1.isAlive() && player2.isAlive()) {
            attacker.setStrategy(strategies[(int) (Math.random() * strategies.length)]);

            double damage = attacker.attack();
            defender.receiveDamage(damage);

            System.out.printf("Turno %d: %s attacca (%s) e infligge %.1f danni -> %s ha %.1f HP%n",
                    turn, attacker.getName(), attacker.getStrategy().getName(), damage,
                    defender.getName(), Math.max(0, defender.getLifePoint()));

            Player temp = attacker;
            attacker = defender;
            defender = temp;
            turn++;
        }

        Player winner = player1.isAlive() ? player1 : player2;
        System.out.println("\n=== FINE COMBATTIMENTO ===");
        System.out.println("Vincitore: " + winner.getName());

        System.out.println("\n--- Statistiche " + player1.getName() + " ---");
        stats1.printStats();
        System.out.println("\n--- Statistiche " + player2.getName() + " ---");
        stats2.printStats();
    }
}
    
