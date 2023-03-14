package LostCause.ItemFiles;

public class WeaponLongSword extends Weapon{

    public WeaponLongSword(String itemID, String name) {
        super(itemID, name);
        type = "weapon";

        weaponType = "one-handed sword";
        minDamage = 3;
        maxDamage = 9;

        hasPassive = false;
    }

    public String weaponMessage() {
        return "You swing your long sword.";
    }

}
