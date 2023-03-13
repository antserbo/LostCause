package LostCause.ItemFiles;

import LostCause.GameEngine.Player;

public class ActiveItemMagicalChalice extends SuperItem {

    public int healthRestoration;

    public ActiveItemMagicalChalice(String itemID, String name) {
        super(itemID, name);
        type = "active item";

    }

    public void chaliceHealing(Player player) {
        healthRestoration = (int) (player.maxHP * 0.4);
    }
}
