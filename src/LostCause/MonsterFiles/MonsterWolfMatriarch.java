package LostCause.MonsterFiles;

import java.util.concurrent.ThreadLocalRandom;
import LostCause.GameEngine.Player;

public class MonsterWolfMatriarch extends SuperMonster{

    public MonsterWolfMatriarch (String objectID) {
        name = "Wolf";
        hp = 30;
        attack = 5;
        messages = new String[]{"The wolf matriarch rushes forward and bites you.", "The wolf matriarch attacks you with its claws."};
        attackMessage = messages[new java.util.Random().nextInt(messages.length)];
        this.objectID = objectID;
        specialAttack = true;

        // todo: maybe later apply bleed, that will damage the player every 3rd round.
    }

    public int attack(Player player) {
        int specialAttackChance = new java.util.Random().nextInt(5);
        int attackDamage;
        int totalPlayerDefence = player.armorHead.defence + player.armorChest.defence + player.armorShield.defence + player.amulet.defence + player.ring.defence;
        if (specialAttackChance == 4) {
            attackMessage = "The wolf matriarch howls and then attacks you with greater damage";
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
}
