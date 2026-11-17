package weapons;

public class WeaponFactory {


    public static Weapon createWeapon(String type) {

        if (type.equalsIgnoreCase("Spada")) {
            return new Sword();
        }

        if (type.equalsIgnoreCase("Arco")) {
            return new Bow();
        }

        if (type.equalsIgnoreCase("Bastone Magico")) {
            return new MagicStaff();
        }
        
        System.out.println("Arma non valida");
        return null;
    }
}
    

