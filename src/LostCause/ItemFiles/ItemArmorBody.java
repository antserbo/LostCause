package LostCause.ItemFiles;

public class ItemArmorBody extends SuperItem{

    public String armorType;
    public int healthIncrease;
    public int defence;

    public ItemArmorBody(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";
    }
}
