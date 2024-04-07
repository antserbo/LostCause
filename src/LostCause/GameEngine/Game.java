package LostCause.GameEngine;

import LostCause.ItemFiles.*;

import java.util.ArrayList;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    // todo: for interactions with player in location classes use game.story.player! as an interesting item - scythe of peril (-1hp, +50% damage)
    // todo: try to add a special attack every 3 rounds, keep in mind about the action points

    // todo: create music object for title screen! everything is already set.
    Music startMusicObj = new Music("C:\\Users\\FuVuC\\Desktop\\baba\\BIG FANTASY RPG MUSIC BUNDLE\\Themes\\Main_Theme\\Main_Theme_FULL_TRACK.wav");
    Music startingZoneMusicObj = new Music("C:\\Users\\FuVuC\\Desktop\\baba\\BIG FANTASY RPG MUSIC BUNDLE\\Exploration-Landscapes\\Peaceful_Valley\\Peaceful_Valley_LONG_LOOP.wav");
    Music waterFallZoneMusicObj = new Music("C:\\Users\\FuVuC\\Desktop\\baba\\BIG FANTASY RPG MUSIC BUNDLE\\Exploration-Landscapes\\Peaceful_Valley\\Peaceful_Valley_LONG_LOOP_AMBIENT_ONLY.wav");

    StartingZone startingZone = new StartingZone(this, ui, vm);
    WaterfallZone waterfallZone = new WaterfallZone(this, ui, vm);
    GreatWoodsEntrance greatWoodsEntrance = new GreatWoodsEntrance(this, ui, vm);
    GoblinVillageEntrance goblinVillageEntrance = new GoblinVillageEntrance(this, ui, vm);
    GreatWoodsEntranceCave greatWoodsEntranceCave = new GreatWoodsEntranceCave(this, ui, vm);
    GreatWoodsEntranceCaveLair greatWoodsEntranceCaveLair = new GreatWoodsEntranceCaveLair(this, ui, vm);

    String nextPositionOne, nextPositionTwo, nextPositionThree, nextPositionFour, continuePosition;
    String inventoryStatus, inventoryMainStatus;

    ArrayList<SuperItem> itemInventory = new ArrayList<>();

    WeaponFists fists = new WeaponFists("fists", "Fists");
    WeaponLongSword longSword = new WeaponLongSword("longSwordOne", "Long sword");
    WeaponDaggerOfYearn daggerOfYearn = new WeaponDaggerOfYearn("daggerOfYearn", "Dagger of yearn");

    ArmorBodyHeadEmpty armorBodyHeadEmpty = new ArmorBodyHeadEmpty("emptyHead", "");

    ArmorBodyTornShirt tornShirt = new ArmorBodyTornShirt("tornShirt", "Torn shirt");
    ArmorBodyLeatherChestArmor leatherChestArmor = new ArmorBodyLeatherChestArmor("leatherChestArmor", "Leather chest");

    ArmorShieldEmpty armorShieldEmpty = new ArmorShieldEmpty("emptyShield", "");
    ArmorShieldBronzeShield armorShieldBronzeShield = new ArmorShieldBronzeShield("bronzeShieldArmor", "Bronze shield");

    AmuletRingEmpty amuletRingEmpty = new AmuletRingEmpty("emptyAmulet", "");
    AmuletRingShell amuletRingShell = new AmuletRingShell("shellAmulet", "Shell amulet");

    QuestItemSilverRing questItemSilverRing = new QuestItemSilverRing("silverRing", "Silver ring");

    ActiveItemMagicalChalice magicalChalice = new ActiveItemMagicalChalice("magicalChalice", "Magical chalice");


    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
        startMusicObj.play();

    }
}
