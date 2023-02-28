package LostCause.ItemFiles;

public class ItemArmorBodyLeatherChestArmor extends SuperItem{

    public String armorType;
    public int healthIncrease;
    public int defence;

    public ItemArmorBodyLeatherChestArmor(String itemID) {
        super(itemID);
        name = "Leather chest armor";
        type = "weapon";

        armorType = "chest armor";
        healthIncrease = 3;
        defence = 2;
    }
}
