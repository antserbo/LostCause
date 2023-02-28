package LostCause.ItemFiles;

public class ItemWeaponLongSword extends SuperItem{

    public String weaponType;
    public int minDamage;
    public int maxDamage;

    public ItemWeaponLongSword(String itemID) {
        super(itemID);
        name = "Long sword";
        type = "weapon";

        weaponType = "one-handed sword";
        minDamage = 3;
        maxDamage = 9;
    }
}
