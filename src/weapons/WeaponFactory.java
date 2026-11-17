package weapons;

public class WeaponFactory {


    public static Weapon createWeapon(String type) {

        if (type.equalsIgnoreCase("sword")) {
            return new Sword();
        }

        if (type.equalsIgnoreCase("bow")) {
            return new Bow();
        }

        if (type.equalsIgnoreCase("magicstaff")) {
            return new MagicStaff();
        }

        return null;
    }
}
    

