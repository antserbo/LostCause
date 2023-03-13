package LostCause.GameEngine;

import LostCause.ItemFiles.AmuletRing;
import LostCause.ItemFiles.ArmorBody;
import LostCause.ItemFiles.ArmorShield;
import LostCause.ItemFiles.Weapon;

public class Player {

    public int hp;
    public int maxHP;
    public int mp = 0;
    public int gold = 0;
    public Weapon weapon;
    public ArmorBody armorChest;
    public ArmorBody armorHead;
    public ArmorShield armorShield;
    public AmuletRing amulet;
    public AmuletRing ring;

    // todo: add an attack message for every weapon respectively (example: you whip out your longsword and slash the foe)

    // todo: idea for game: armor can increase player's HP cap...
}
