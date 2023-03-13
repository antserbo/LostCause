package LostCause.ItemFiles;

public class ArmorShield extends SuperItem{

    public int healthIncrease;
    public int defence;

    public ArmorShield(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";
    }
}
