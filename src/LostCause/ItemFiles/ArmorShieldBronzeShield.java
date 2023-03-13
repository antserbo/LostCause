package LostCause.ItemFiles;

public class ArmorShieldBronzeShield extends ArmorShield{

    public ArmorShieldBronzeShield(String itemID, String name) {
        super(itemID, name);
        type = "shield";

        healthIncrease = 0;
        defence = 2;
    }
}
