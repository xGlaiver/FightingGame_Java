import weapons.Weapon;
import weapons.WeaponFactory;

public class Main {

    public static void main(String[] args) {

        
        Weapon[] weapons = {
            WeaponFactory.createWeapon("Spada"),
            WeaponFactory.createWeapon("Arco"),
            WeaponFactory.createWeapon("Bastone Magico")
        };

        int scelta = (int) (Math.random() * weapons.length);

        
        Weapon weapon = weapons[scelta];

        System.out.println("Arma scelta: " + weapon.getName());
        System.out.println("Danno iniziale: " + weapon.getDamage());

    }
}
    
