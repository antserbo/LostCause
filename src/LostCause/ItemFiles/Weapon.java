package LostCause.ItemFiles;

import LostCause.MonsterFiles.SuperMonster;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon extends SuperItem{

    public String weaponType;
    public int minDamage;
    public int maxDamage;
    public String message;
    public boolean hasPassive;
    int passiveAttackChance;

    public Weapon(String itemID, String name) {
        super(itemID, name);
        type = "weapon";

    }

    public int attack() {
        return ThreadLocalRandom.current().nextInt(minDamage, maxDamage);
    }

    public int passiveAttack(SuperMonster superMonster) {
        return 0;
    }

    public String weaponMessage() {
        return message;
    }
}
