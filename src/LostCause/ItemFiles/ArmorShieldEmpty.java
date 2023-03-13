package LostCause.ItemFiles;

public class ArmorShieldEmpty extends ArmorShield{

    public ArmorShieldEmpty(String itemID, String name) {
        super(itemID, name);
        type = "shield";

        healthIncrease = 0;
        defence = 0;
    }
}
