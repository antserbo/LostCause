package LostCause.GameEngine;

import LostCause.ItemFiles.ItemArmorBodyLeatherChestArmor;
import LostCause.ItemFiles.ItemWeaponLongSword;
import LostCause.ItemFiles.SuperItem;

import java.util.ArrayList;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    // todo: for interections with player in location classes use game.story.player! as an interesting item - scythe of peril (-1hp, +50% damage)

    StartingZone startingZone = new StartingZone(this, ui, vm);
    WaterfallZone waterfallZone = new WaterfallZone(this, ui, vm);
    GreatWoodsEntrance greatWoodsEntrance = new GreatWoodsEntrance(this, ui, vm);
    GoblinVillageEntrance goblinVillageEntrance = new GoblinVillageEntrance(this, ui, vm);
    GreatWoodsEntranceCave greatWoodsEntranceCave = new GreatWoodsEntranceCave(this, ui, vm);

    String nextPositionOne, nextPositionTwo, nextPositionThree, nextPositionFour, continuePosition;
    String inventoryStatus, inventoryMainStatus;

    ArrayList<SuperItem> itemInventory = new ArrayList<>();
    ItemWeaponLongSword longSword = new ItemWeaponLongSword("longSwordOne");
    ItemWeaponLongSword ass = new ItemWeaponLongSword("longSwordTwo");

    ItemArmorBodyLeatherChestArmor leatherChestArmor = new ItemArmorBodyLeatherChestArmor("leatherChestArmor");


    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();

    }
}
