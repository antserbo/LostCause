package LostCause.ItemFiles;

public class Weapon extends SuperItem{

    public String weaponType;
    public int minDamage;
    public int maxDamage;
    public String message;

    public Weapon(String itemID, String name) {
        super(itemID, name);
        type = "weapon";


    }
}
