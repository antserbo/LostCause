package LostCause.ItemFiles;

public class AmuletRing extends SuperItem {

    public String armorType;
    public int healthIncrease;
    public int damageIncrease;
    public int defence;

    public AmuletRing (String itemID, String name) {
        super(itemID, name);
        type = "amulets & rings";
    }
}
