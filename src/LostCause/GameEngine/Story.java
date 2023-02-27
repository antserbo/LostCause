package LostCause.GameEngine;

import LostCause.ItemFiles.ItemWeaponLongSword;
import LostCause.ItemFiles.SuperItem;
import LostCause.MonsterFiles.SuperMonster;

import java.util.ArrayList;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;

    Player player = new Player();
    SuperMonster greatWoodsEntrance_4_Wolf;
    SuperMonster greatWoodsEntrance_6_NarrowPath_2_Wolf;


    // todo: all variables except for playerLocation should be *game.story._*
    String playerLocation = "";
    int waterfallSkeletonWeaponTaken = 0;
    int waterfallSkeletonTimesSearched = 0;
    int waterfallSkeletonAmuletTaken = 0;
    int goblinVillageEntranceGuardBugged = 0;
    int greatWoodsEntrance_4_WolfDefeated = 0;
    int greatWoodsEntrance_6_NarrowPath_2_WolfDefeated = 0;
    int greatWoodsEntrance_5_RiverDrinks = 0;
    boolean startingZoneDiscovered = false;
    boolean waterfallSkeletonSearched = false;
    boolean waterfallZoneDiscovered = false;
    boolean goblinVillageEntranceDiscovered = false;
    boolean goblinVillageEntranceGuardSilverRingDiscovered = false;
    boolean greatWoodsEntranceDiscovered = false;
    boolean greatWoodsEntranceToCaveDiscovered = false;
    boolean greatWoodsEntrance_6_Discovered = false;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup() {

        player.hp = 15;
        player.mp = 0;
        player.gold = 0;
        ui.healthNumberLabel.setText("" + player.hp);
        ui.manaNumberLabel.setText("" + player.mp);
        ui.goldNumberLabel.setText("" + player.gold);
        player.weapon = "Fists";
        ui.weaponNameLabel.setText(player.weapon);
        game.inventoryStatus = "closed";
        game.inventoryMainStatus = "closed";


    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition) {

            case "startingZone_2" -> game.startingZone.startingZone_2();
            case "startingZone_3" -> game.startingZone.startingZone_3();
            case "startingZone_4" -> game.startingZone.startingZone_4();
            case "startingZone_5" -> game.startingZone.startingZone_5();
            case "startingZone_6" -> game.startingZone.startingZone_6();
            case "startingZone_7" -> game.startingZone.startingZone_7();

            case "startingZone_7_ToSouth" -> startingZone_7_ToSouth();

            case "waterfallZone" -> game.waterfallZone.waterfallZone();
            case "waterfallZone_2" -> game.waterfallZone.waterfallZone_2();
            case "waterfallZone_2_WeaponTake" -> game.waterfallZone.waterfallZone_2_WeaponTake();
            case "waterfallZone_2_SearchSkeleton_Success" -> game.waterfallZone.waterfallZone_2_SearchSkeleton_Success();
            case "waterfallZone_2_SearchSkeleton_Failure" -> game.waterfallZone.waterfallZone_2_SearchSkeleton_Failure();
            case "waterfallZone_3" -> game.waterfallZone.waterfallZone_3();
            case "waterfallZone_3_DrinkWater" -> game.waterfallZone.waterfallZone_3_DrinkWater();

            case "goblinVillageEntrance" -> game.goblinVillageEntrance.goblinVillageEntrance();
            case "goblinVillageEntrance_2" -> game.goblinVillageEntrance.goblinVillageEntrance_2();
            case "goblinVillageEntrance_2_ClimbGate" -> game.goblinVillageEntrance.goblinVillageEntrance_2_ClimbGate();
            case "goblinVillageEntrance_2_ClimbGate_2" -> game.goblinVillageEntrance.goblinVillageEntrance_2_ClimbGate_2();
            case "goblinVillageEntrance_3" -> game.goblinVillageEntrance.goblinVillageEntrance_3();
            case "goblinVillageEntrance_4" -> game.goblinVillageEntrance.goblinVillageEntrance_4();
            case "goblinVillageEntrance_5" -> game.goblinVillageEntrance.goblinVillageEntrance_5();
            case "goblinVillageEntrance_6" -> game.goblinVillageEntrance.goblinVillageEntrance_6();
            case "goblinVillageEntrance_7" -> game.goblinVillageEntrance.goblinVillageEntrance_7();
            case "goblinVillageEntrance_7_GuardBugged" -> game.goblinVillageEntrance.goblinVillageEntrance_7_GuardBugged();
            case "goblinVillageEntrance_8_SilverRingDialogue" -> game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue();
            case "goblinVillageEntrance_8_SilverRingDialogue_2" -> game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_2();
            case "goblinVillageEntrance_8_SilverRingDialogue_3" -> game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_3();
            case "goblinVillageEntrance_8_SilverRingDialogue_4" -> game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_4();
            case "goblinVillageEntrance_8_SilverRingDialogue_5" -> game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_5();

            case "greatWoodsEntrance" -> game.greatWoodsEntrance.greatWoodsEntrance();
            case "greatWoodsEntrance_2" -> game.greatWoodsEntrance.greatWoodsEntrance_2();
            case "greatWoodsEntrance_3" -> game.greatWoodsEntrance.greatWoodsEntrance_3();
            case "greatWoodsEntrance_4" -> game.greatWoodsEntrance.greatWoodsEntrance_4();
            case "greatWoodsEntrance_5" -> game.greatWoodsEntrance.greatWoodsEntrance_5();
            case "greatWoodsEntrance_5_River" -> game.greatWoodsEntrance.greatWoodsEntrance_5_River();
            case "greatWoodsEntrance_6" -> game.greatWoodsEntrance.greatWoodsEntrance_6();
            case "greatWoodsEntrance_7" -> game.greatWoodsEntrance.greatWoodsEntrance_7();
            case "greatWoodsEntrance_8" -> game.greatWoodsEntrance.greatWoodsEntrance_8();
            case "greatWoodsEntrance_9" -> game.greatWoodsEntrance.greatWoodsEntrance_9();

            case "greatWoodsEntrance_6_NarrowPath" -> game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath();
            case "greatWoodsEntrance_6_NarrowPath_2" -> game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2();
            case "greatWoodsEntrance_6_NarrowPath_3" -> game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_3();
            case "greatWoodsEntrance_6_NarrowPath_4" -> game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_4();


            case "fight_greatWoodsEntrance_4_Wolf" -> fight(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "startingZone_7");
            case "examine_greatWoodsEntrance_4_Wolf" -> examine(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "greatWoodsEntrance_4");
            case "playerAttack_greatWoodsEntrance_4_Wolf" -> playerAttack(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf);
            case "monsterAttack_greatWoodsEntrance_4_Wolf" -> monsterAttack(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf);
            case "win_greatWoodsEntrance_4_Wolf" -> win(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "greatWoodsEntrance_5", "", 5);

            case "fight_greatWoodsEntrance_6_NarrowPath_2_Wolf" -> fight(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_6");
            case "examine_greatWoodsEntrance_6_NarrowPath_2_Wolf" -> examine(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_6_NarrowPath_2");
            case "playerAttack_greatWoodsEntrance_6_NarrowPath_2_Wolf" -> playerAttack(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf);
            case "monsterAttack_greatWoodsEntrance_6_NarrowPath_2_Wolf" -> monsterAttack(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf);
            case "win_greatWoodsEntrance_6_NarrowPath_2_Wolf" -> win(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_6_NarrowPath_3", "ass", 4);

            case "lose" -> lose();
            case "toTitle" -> toTitle();

        }
    }

    public void startingZone_7_ToSouth() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);
        ui.mainTextArea.setText("You can't go there, the path is blocked...\n");

        ui.continueButton.setText("Get back to crossroad");

        game.continuePosition = "startingZone_7";
    }

    public void greatWoodsEntrance_9() { // todo: we are entering the main area of Great Woods. change later.

    }


    public void worldMapLocationDeterminerHelper() {
        // todo: implement further locations and add to every location_function playerLocation and this helper()

        if (game.story.startingZoneDiscovered && playerLocation.equals("startingZone")) {
            ui.currentLocationLabel.setText("Crossroad");
            ui.currentLocationLabel.setToolTipText("Beginning of your journey");
        } else if (game.story.goblinVillageEntranceDiscovered && playerLocation.equals("goblinVillageEntrance")) {
            ui.currentLocationLabel.setText("GVE");
            ui.currentLocationLabel.setToolTipText("Goblin Village Entrance");
        } else if (game.story.waterfallZoneDiscovered && playerLocation.equals("waterfallZone")) {
            ui.currentLocationLabel.setText("Waterfall");
            ui.currentLocationLabel.setToolTipText("You can heal and save here");
        } else if (game.story.greatWoodsEntranceDiscovered && playerLocation.equals("greatWoodsEntrance")) {
            ui.currentLocationLabel.setText("GWE");
            ui.currentLocationLabel.setToolTipText("Great Woods Entrance");
        } else {
            ui.currentLocationLabel.setText("Undiscovered");
            ui.currentLocationLabel.setToolTipText("Location yet to be discovered");
        }
    }

    public void examine(SuperMonster monster, String fromExamineTo) {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You examine the " + monster.name + " closely.\n" +
                "Attack: " + monster.attack +
                "\nHealth: " + monster.hp);

        ui.continueButton.setText("Continue");
        game.continuePosition = fromExamineTo;

    }

    public void fight(SuperMonster monster, String whereToRun) {
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText(monster.name + ": " + monster.hp + " HP" + "\nWhat do you intend to do?");


        ui.choiceThree.setText("Attack");
        ui.choiceFour.setText("Flee from battle");

        game.nextPositionThree = "playerAttack_" + monster.objectID;
        game.nextPositionFour = whereToRun;
    }

    public void playerAttack(SuperMonster monster) {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        // todo: set the min and max hit, as well as implement the hit bounds from player's attributes.

        int playerDamage = new java.util.Random().nextInt(10); // todo change to current_weapon

        ui.mainTextArea.setText("You attacked the " + monster.name + " and dealt " + playerDamage + " damage.");

        monster.hp -= playerDamage;

        ui.continueButton.setText("Continue");

        // todo: create a big-ass checker for all the monsters that you're dealing with
        // todo: make sure that this is needed... how do you solve the win()?

        if (monster.hp > 0) {
            game.continuePosition = "monsterAttack_" + monster.objectID;
        } else {
            game.continuePosition = "win_" + monster.objectID;
        }
    }

    public void monsterAttack(SuperMonster monster) {

        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText(monster.attackMessage + "\nThe " + monster.name + " dealt " + monsterDamage + " damage.");

        player.hp -= monsterDamage;
        ui.healthNumberLabel.setText("" + player.hp);

        ui.continueButton.setText("Continue");

        if (player.hp > 0) {
            game.continuePosition = "fight_" + monster.objectID;
        } else {
            game.continuePosition = "lose";
        }

    }

    public void win(SuperMonster monster, String continueNextPosition, String loot, Integer coins) {
        // todo: somehow make the fifth argument "int monsterDefeated" work, so that we don't have to implement an extra if block...

        if ((!loot.isEmpty()) && ((coins != 0))) {
            ui.mainTextArea.setText("You have defeated the " + monster.name + "!\n" +
                    "The " + monster.name + " has dropped a " + loot + " and " + coins + " coins.");
        } else if ((loot.isEmpty()) && ((coins != 0))) {
            ui.mainTextArea.setText("You have defeated the " + monster.name + "!\n" +
                    "The " + monster.name + " has dropped " + coins + " coins.");
        } else if (!loot.isEmpty()) {
            ui.mainTextArea.setText("You have defeated the " + monster.name + "!\n" +
                    "The " + monster.name + " has dropped " + coins + " coins.");
        } else {
            ui.mainTextArea.setText("You have defeated the " + monster.name + "!\n" +
                    "The " + monster.name + " has dropped nothing.");
        }


        if (monster.objectID.equals("greatWoodsEntrance_4_Wolf")) {
            game.story.greatWoodsEntrance_4_WolfDefeated = 1;
        } else if (monster.objectID.equals("greatWoodsEntrance_6_NarrowPath_2_Wolf")) {
            game.story.greatWoodsEntrance_6_NarrowPath_2_WolfDefeated = 1;
        }

        ui.continueButton.setText("Continue");

        game.continuePosition = "" + continueNextPosition;

    }

    public void lose() {

        ui.healthNumberLabel.setText("" + player.hp);
        ui.mainTextArea.setText("You are dead! \n\n<GAME OVER>");

        ui.continueButton.setText("To the title screen");

        game.continuePosition = "toTitle";
    }

    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }

}
