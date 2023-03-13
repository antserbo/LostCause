package LostCause.MonsterFiles;

import LostCause.GameEngine.Player;

import java.util.concurrent.ThreadLocalRandom;

public class SuperMonster {

    public String name;
    public int hp;
    public int attack;
    public String attackMessage;
    public String objectID;
    public boolean specialAttack;
    String [] messages;

    public int attack(Player player) {
        int attackDamage;
        int totalPlayerDefence = player.armorHead.defence + player.armorChest.defence + player.armorShield.defence + player.amulet.defence + player.ring.defence;
        if (attack - totalPlayerDefence < 1) {
            attackDamage = 0;
        } else {
            attackDamage = ThreadLocalRandom.current().nextInt(0, attack - totalPlayerDefence);
        }
        return attackDamage;
    }

    public String message() {
        return messages[new java.util.Random().nextInt(messages.length)];
    }
}
