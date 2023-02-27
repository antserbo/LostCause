package LostCause.ItemFiles;

public class ItemWeaponLongSword extends SuperItem{

    public String itemID;
    String weaponType;
    int minDamage;
    int maxDamage;

    public ItemWeaponLongSword(String itemID) {
        super(itemID);
        name = "Long sword";
        type = "weapon";

        weaponType = "one-handed sword";
        minDamage = 3;
        maxDamage = 9;

    }
}
