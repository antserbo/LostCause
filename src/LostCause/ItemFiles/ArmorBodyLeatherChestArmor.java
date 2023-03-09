package LostCause.ItemFiles;

public class ArmorBodyLeatherChestArmor extends ArmorBody {

    public ArmorBodyLeatherChestArmor(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";

        armorType = "chest armor";
        healthIncrease = 3;
        defence = 2;
    }
}
