package LostCause.MonsterFiles;

import java.util.concurrent.ThreadLocalRandom;
import LostCause.GameEngine.Player;

public class MonsterWolfMatriarch extends SuperMonster{

    int specialAttackChance;

    public MonsterWolfMatriarch (String objectID) {
        name = "Wolf matriarch";
        hp = 30;
        attack = 5;
        messages = new String[]{"The wolf matriarch rushes forward and bites you.", "The wolf matriarch attacks you with its claws."};
        this.objectID = objectID;
        hasSpecialAttack = true;

        specialAttackExamine = "Howl of the matriarch.\n(The matriarch has a 20% chance to deal 120% of it's damage.)";


        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }

    public int attack(Player player) {
        specialAttackChance = new java.util.Random().nextInt(5);
        //System.out.println("in attack chance is " + specialAttackChance);
        int attackDamage;
        int totalPlayerDefence = player.armorHead.defence + player.armorChest.defence + player.armorShield.defence + player.amulet.defence + player.ring.defence;
        if (specialAttackChance == 4) {
            attackDamage = (int) (attack * 1.2);
        } else {
            if (attack - totalPlayerDefence < 1) {
                attackDamage = 0;
            } else {
                attackDamage = ThreadLocalRandom.current().nextInt(0, attack - totalPlayerDefence);
            }
        }
        return attackDamage;
    }

    public String message() {
        //System.out.println("in message chance is " + specialAttackChance);
        if (specialAttackChance == 4) {
            attackMessage = "The wolf matriarch howls and then attacks you with greater damage";
        } else {
            attackMessage = messages[new java.util.Random().nextInt(messages.length)];
        }
        return attackMessage;
    }
}
