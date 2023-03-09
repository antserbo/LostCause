package LostCause.ItemFiles;

public class ArmorBody extends SuperItem{

    public String armorType;
    public int healthIncrease;
    public int defence;

    public ArmorBody(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";
    }
}
