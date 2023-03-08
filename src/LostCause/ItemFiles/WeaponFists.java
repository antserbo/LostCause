package LostCause.ItemFiles;

public class WeaponFists extends Weapon{

    public WeaponFists(String itemID, String name) {
        super(itemID, name);
        type = "weapon";

        weaponType = "fists";
        minDamage = 0;
        maxDamage = 4;
    }
}
