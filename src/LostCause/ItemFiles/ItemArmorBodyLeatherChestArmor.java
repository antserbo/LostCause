package LostCause.ItemFiles;

public class ItemArmorBodyLeatherChestArmor extends ItemArmorBody{

    public ItemArmorBodyLeatherChestArmor(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";

        armorType = "chest armor";
        healthIncrease = 3;
        defence = 2;
    }
}
