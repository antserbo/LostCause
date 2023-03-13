package LostCause.ItemFiles;

public class ArmorBodyHeadEmpty extends ArmorBody{

    public ArmorBodyHeadEmpty(String itemID, String name) {
        super(itemID, name);
        type = "armorBody";

        armorType = "head armor";
        healthIncrease = 0;
        defence = 0;
    }
}
