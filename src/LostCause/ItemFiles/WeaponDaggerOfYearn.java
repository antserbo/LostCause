package LostCause.ItemFiles;

import LostCause.MonsterFiles.SuperMonster;

import java.util.concurrent.ThreadLocalRandom;

public class WeaponDaggerOfYearn extends Weapon{

    public WeaponDaggerOfYearn(String itemID, String name) {
        super(itemID, name);
        type = "weapon";

        weaponType = "one-handed sword";
        minDamage = 5;
        maxDamage = 11;

        hasPassive = true;
    }

    public int passiveAttack(SuperMonster superMonster) {
        int playerDamage;
        passiveAttackChance = new java.util.Random().nextInt(4);
        if (passiveAttackChance == 3) {
            int passiveDamage = (int) (superMonster.hp * 0.1);
            playerDamage = ThreadLocalRandom.current().nextInt(minDamage, maxDamage) + passiveDamage;
            System.out.println("this is an attack with passive");
        } else {
            playerDamage = ThreadLocalRandom.current().nextInt(minDamage, maxDamage);
            System.out.println("this is an attack with failed passive");
        }
        return playerDamage;
    }

    public String weaponMessage() {
        if (hasPassive) {
            if (passiveAttackChance == 3) {
                message = "You manage to inflict a bleeding attack while cutting your foe deep.";
            } else {
                message = "You cut the enemy with your dagger.";
            }
        } else {
            message = "You cut the enemy with your dagger.";
        }

        return message;
    }
}
