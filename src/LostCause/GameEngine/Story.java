package LostCause.GameEngine;

import LostCause.ItemFiles.SuperItem;
import LostCause.MonsterFiles.SuperMonster;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;

    boolean isMusicPlaying = false;

    Player player = new Player();
    SuperMonster greatWoodsEntrance_4_Wolf;
    SuperMonster greatWoodsEntrance_6_NarrowPath_2_Wolf;
    SuperMonster greatWoodsEntranceCave_WolfOne;
    SuperMonster greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat;
    SuperMonster greatWoodsEntranceCave_4_Proceed_SleepingWolf;
    SuperMonster greatWoodsEntranceCave_WolfTwo;
    SuperMonster greatWoodsEntranceCaveLair_WolfMatriarch;


    // todo: all variables except for playerLocation should be *game.story._*
    String playerLocation = "";
    String playerFightLocationHelper;

    int playerAttackRound = 1;
    int monsterAttackRound;

    int waterfallSkeletonWeaponTaken = 0;
    int waterfallSkeletonTimesSearched = 0;
    int waterfallSkeletonAmuletTaken = 0;

    int goblinVillageEntranceGuardBugged = 0;
    boolean goblinVillageEntranceGuardSilverRingDiscovered = false;

    boolean greatWoodsEntrance_4_WolfEncountered = false;
    int greatWoodsEntrance_4_WolfDefeated = 0;
    int greatWoodsEntrance_6_NarrowPath_2_WolfDefeated = 0;
    int greatWoodsEntrance_5_RiverDrinks = 0;

    int greatWoodsEntranceCave_WolfOneDefeated = 0;
    int greatWoodsEntranceCave_WolfTwoDefeated = 0;
    int greatWoodsEntranceCave_4_ClimbTheRocks_BatDefeated = 0;
    int greatWoodsEntranceCave_Proceed_SleepingWolfDefeated = 0;
    int greatWoodsEntranceCaveLair_WolfMatriarchDefeated = 0;


    // Discover-location-variables
    boolean startingZoneDiscovered = false;
    boolean waterfallSkeletonSearched = false;
    boolean waterfallZoneDiscovered = false;
    boolean goblinVillageEntranceDiscovered = false;
    boolean greatWoodsEntranceDiscovered = false;
    boolean greatWoodsEntranceCaveDiscovered = false;
    boolean greatWoodsEntrance_5_Discovered = false;

    int greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat = 0;
    boolean greatWoodsEntranceCave_4_ClimbTheRocks_BatEncountered = false;
    boolean greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = false;
    boolean greatWoodsEntranceCaveLair_WolfMatriarchEncountered = false;
    int greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked = 0;
    int greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked = 0;
    boolean magicalChaliceAvailability = true;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup() {

        player.hp = 15;
        player.maxHP = 15;
        ui.healthNumberLabel.setText("" + player.hp);
        ui.manaNumberLabel.setText("" + player.mp);
        ui.goldNumberLabel.setText("" + player.gold);
        player.armorHead = game.armorBodyHeadEmpty;
        ui.armorHeadNameLabel.setText(player.armorHead.name);
        player.armorChest = game.tornShirt;
        ui.armorChestNameLabel.setText(player.armorChest.name);
        player.armorShield = game.armorShieldEmpty;
        ui.armorShieldNameLabel.setText(player.armorShield.name);
        player.weapon = game.fists;
        ui.weaponNameLabel.setToolTipText(game.fists.getWeaponDescription());
        ui.weaponNameLabel.setText(player.weapon.name);
        player.amulet = game.amuletRingEmpty;
        ui.amuletNameLabel.setText(player.amulet.name);
        player.ring = game.amuletRingEmpty;
        ui.ringNameLabel.setText(player.ring.name);


        player.weapon = game.daggerOfYearn; // todo: this is for testing fights fast
        ui.weaponNameLabel.setToolTipText(game.fists.getWeaponDescription()); // todo: this is for testing fights fast
        ui.weaponNameLabel.setText(player.weapon.name); // todo: this is for testing fights fast

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
            case "waterfallZone_2_SearchSkeleton_Success" ->
                    game.waterfallZone.waterfallZone_2_SearchSkeleton_Success();
            case "waterfallZone_2_SearchSkeleton_Failure" ->
                    game.waterfallZone.waterfallZone_2_SearchSkeleton_Failure();
            case "waterfallZone_3" -> game.waterfallZone.waterfallZone_3();
            case "waterfallZone_3_DrinkWater" -> game.waterfallZone.waterfallZone_3_DrinkWater();
            case "waterfallZone_3_Meditate" -> game.waterfallZone.waterfallZone_3_Meditate();

            case "goblinVillageEntrance" -> game.goblinVillageEntrance.goblinVillageEntrance();
            case "goblinVillageEntrance_2" -> game.goblinVillageEntrance.goblinVillageEntrance_2();
            case "goblinVillageEntrance_2_ClimbGate" -> game.goblinVillageEntrance.goblinVillageEntrance_2_ClimbGate();
            case "goblinVillageEntrance_2_ClimbGate_2" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_2_ClimbGate_2();
            case "goblinVillageEntrance_3" -> game.goblinVillageEntrance.goblinVillageEntrance_3();
            case "goblinVillageEntrance_4" -> game.goblinVillageEntrance.goblinVillageEntrance_4();
            case "goblinVillageEntrance_5" -> game.goblinVillageEntrance.goblinVillageEntrance_5();
            case "goblinVillageEntrance_6" -> game.goblinVillageEntrance.goblinVillageEntrance_6();
            case "goblinVillageEntrance_7" -> game.goblinVillageEntrance.goblinVillageEntrance_7();
            case "goblinVillageEntrance_7_GuardBugged" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_7_GuardBugged();
            case "goblinVillageEntrance_8_SilverRingDialogue" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue();
            case "goblinVillageEntrance_8_SilverRingDialogue_2" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_2();
            case "goblinVillageEntrance_8_SilverRingDialogue_3" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_3();
            case "goblinVillageEntrance_8_SilverRingDialogue_4" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_4();
            case "goblinVillageEntrance_8_SilverRingDialogue_5" ->
                    game.goblinVillageEntrance.goblinVillageEntrance_8_SilverRingDialogue_5();

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

            case "greatWoodsEntranceCave" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave();
            case "greatWoodsEntranceCave_2" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave_2();
            case "greatWoodsEntranceCave_3" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave_3();
            case "greatWoodsEntranceCave_4" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave_4();

            case "greatWoodsEntranceCave_4_ClimbTheRocks" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks();
            case "greatWoodsEntranceCave_4_ClimbTheRocks_Success" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_Success();
            case "greatWoodsEntranceCave_4_ClimbTheRocks_Failure" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_Failure();

            case "greatWoodsEntranceCave_4_Proceed" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed();
            case "greatWoodsEntranceCave_4_Proceed_KillingBlow" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_KillingBlow();
            case "greatWoodsEntranceCave_4_Proceed_WalkPast" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_WalkPast();
            case "greatWoodsEntranceCave_4_Proceed_Crates" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_Crates();

            case "greatWoodsEntranceCave_4_Proceed_Crates_Bigger" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_Crates_Bigger();
            case "greatWoodsEntranceCave_4_Proceed_Crates_Lesser" ->
                    game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_Crates_Lesser();

            case "greatWoodsEntranceCave_5" -> game.greatWoodsEntranceCave.greatWoodsEntranceCave_5();

            case "greatWoodsEntranceCaveLair" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair();
            case "greatWoodsEntranceCaveLair_2" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_2();
            case "greatWoodsEntranceCaveLair_3" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_3();
            case "greatWoodsEntranceCaveLair_4" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_4();
            case "greatWoodsEntranceCaveLair_5" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_5();
            case "greatWoodsEntranceCaveLair_6" -> game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_6();


            case "fight_greatWoodsEntrance_4_Wolf" ->
                    fight(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "startingZone_7");
            case "examine_greatWoodsEntrance_4_Wolf" ->
                    examine(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "greatWoodsEntrance_4");
            case "playerAttack_greatWoodsEntrance_4_Wolf" ->
                    playerAttack(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf);
            case "monsterAttack_greatWoodsEntrance_4_Wolf" ->
                    monsterAttack(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf);
            case "win_greatWoodsEntrance_4_Wolf" ->
                    win(game.greatWoodsEntrance.greatWoodsEntrance_4_Wolf, "greatWoodsEntrance_5", null, 5);

            case "fight_greatWoodsEntrance_6_NarrowPath_2_Wolf" ->
                    fight(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_5");
            case "examine_greatWoodsEntrance_6_NarrowPath_2_Wolf" ->
                    examine(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_6_NarrowPath_2");
            case "playerAttack_greatWoodsEntrance_6_NarrowPath_2_Wolf" ->
                    playerAttack(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf);
            case "monsterAttack_greatWoodsEntrance_6_NarrowPath_2_Wolf" ->
                    monsterAttack(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf);
            case "win_greatWoodsEntrance_6_NarrowPath_2_Wolf" ->
                    win(game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_2_Wolf, "greatWoodsEntrance_6_NarrowPath_3", null, 4);

            case "fight_greatWoodsEntranceCave_WolfOne" ->
                    fight(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfOne, "greatWoodsEntranceCave_2");
            case "examine_greatWoodsEntranceCave_WolfOne" ->
                    examine(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfOne, "greatWoodsEntranceCave_3");
            case "playerAttack_greatWoodsEntranceCave_WolfOne" ->
                    playerAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfOne);
            case "monsterAttack_greatWoodsEntranceCave_WolfOne" ->
                    monsterAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfOne);
            case "win_greatWoodsEntranceCave_WolfOne" ->
                    win(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfOne, "greatWoodsEntranceCave_4", null, 7);

            case "fight_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" ->
                    fight(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat, "greatWoodsEntranceCave_4");
            case "examine_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" ->
                    examine(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat, "greatWoodsEntranceCave_4_ClimbTheRocks_Failure");
            case "playerAttack_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" ->
                    playerAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat);
            case "monsterAttack_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" ->
                    monsterAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat);
            case "win_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" ->
                    win(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat, "greatWoodsEntranceCave_4", null, 2);

            case "fight_greatWoodsEntranceCave_4_Proceed_SleepingWolf" ->
                    fight(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_SleepingWolf, "greatWoodsEntranceCave_4");
            case "examine_greatWoodsEntranceCave_4_Proceed_SleepingWolf" ->
                    examine(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_SleepingWolf, "greatWoodsEntranceCave_4_Proceed_KillingBlow");
            case "playerAttack_greatWoodsEntranceCave_4_Proceed_SleepingWolf" ->
                    playerAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_SleepingWolf);
            case "monsterAttack_greatWoodsEntranceCave_4_Proceed_SleepingWolf" ->
                    monsterAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_SleepingWolf);
            case "win_greatWoodsEntranceCave_4_Proceed_SleepingWolf" ->
                    win(game.greatWoodsEntranceCave.greatWoodsEntranceCave_4_Proceed_SleepingWolf, "greatWoodsEntranceCave_4_Proceed_Crates", null, 4);

            case "fight_greatWoodsEntranceCave_WolfTwo" ->
                    fight(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfTwo, "greatWoodsEntranceCave_4");
            case "examine_greatWoodsEntranceCave_WolfTwo" ->
                    examine(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfTwo, "greatWoodsEntranceCave_5");
            case "playerAttack_greatWoodsEntranceCave_WolfTwo" ->
                    playerAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfTwo);
            case "monsterAttack_greatWoodsEntranceCave_WolfTwo" ->
                    monsterAttack(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfTwo);
            case "win_greatWoodsEntranceCave_WolfTwo" ->
                    win(game.greatWoodsEntranceCave.greatWoodsEntranceCave_WolfTwo, "greatWoodsEntranceCave_5", null, 3);

            case "fight_greatWoodsEntranceCaveLair_WolfMatriarch" ->
                    fight(game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_WolfMatriarch, "greatWoodsEntranceCave_5");
            case "examine_greatWoodsEntranceCaveLair_WolfMatriarch" ->
                    examine(game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_WolfMatriarch, "greatWoodsEntranceCaveLair_6");
            case "playerAttack_greatWoodsEntranceCaveLair_WolfMatriarch" ->
                    playerAttack(game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_WolfMatriarch);
            case "monsterAttack_greatWoodsEntranceCaveLair_WolfMatriarch" ->
                    monsterAttack(game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_WolfMatriarch);
            case "win_greatWoodsEntranceCaveLair_WolfMatriarch" ->
                    win(game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair_WolfMatriarch, "greatWoodsEntranceCave_5", game.questItemSilverRing, 13);


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

        fightLocationHelper();
        musicMachine();

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
        } else if (game.story.greatWoodsEntranceCaveDiscovered && playerLocation.equals("greatWoodsEntranceCave")) {
            ui.currentLocationLabel.setText("GWE Cave");
            ui.currentLocationLabel.setToolTipText("Great Woods Entrance Cave");
        } else {
            ui.currentLocationLabel.setText("Undiscovered");
            ui.currentLocationLabel.setToolTipText("Location yet to be discovered");
        }
    }

    public void fightLocationHelper() {
        //todo:  populate this function. Function description: if player runs off, the the round counter resets.
        if (game.story.playerFightLocationHelper.equals("startingZone_7") && game.story.greatWoodsEntrance_4_WolfDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntrance_6") && game.story.greatWoodsEntrance_6_NarrowPath_2_WolfDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntranceCave_2") && game.story.greatWoodsEntranceCave_WolfOneDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntranceCave_4") && game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntranceCave_4") && game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntranceCave_4") && game.story.greatWoodsEntranceCave_WolfTwoDefeated == 0) {
            game.story.playerAttackRound = 1;
        } else if (game.story.playerFightLocationHelper.equals("greatWoodsEntranceCave_5") && game.story.greatWoodsEntranceCaveLair_WolfMatriarchDefeated == 0) {
            game.story.playerAttackRound = 1;
        }

    }

    public void healing(int healingAmount, String healingMessage) {

        if (player.hp <= player.maxHP - healingAmount) {
            player.hp += healingAmount;
            ui.mainTextArea.setText(healingMessage + "\n" +
                    "(you get healed by " + healingAmount + " HP)");
            ui.healthNumberLabel.setText("" + player.hp);
        } else if (player.hp < player.maxHP) {
            int currentHP = player.hp;
            player.hp = player.maxHP;
            int differenceHP = player.hp - currentHP;
            ui.mainTextArea.setText(healingMessage + "\n" +
                    "(you get healed by " + differenceHP + " HP)");
            ui.healthNumberLabel.setText("" + player.hp);
        } else {
            ui.mainTextArea.setText("\nYou take a sip of water, but it has no effect" +
                    "\n(current hp is maximum)");
        }

    }

    public void examine(SuperMonster monster, String fromExamineTo) {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (monster.hasSpecialAttack) {
            ui.mainTextArea.setText("\nYou examine the " + monster.name.toLowerCase() + " closely.\n" +
                    "Attack: " + monster.attack + ".   Health: " + monster.hp + "." +
                    "\nSpecial attack: " + monster.specialAttackExamine);

        } else {
            ui.mainTextArea.setText("\nYou examine the " + monster.name.toLowerCase() + " closely.\n" +
                    "Attack: " + monster.attack + ".   Health: " + monster.hp + ".");

        }
        ui.continueButton.setText("Continue");
        game.continuePosition = fromExamineTo;

    }

    public void fight(SuperMonster monster, String whereToRun) {
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        if (playerAttackRound == 1) {
            ui.mainTextArea.setText("\n\nWhat do you intend to do?");
        } else {
            ui.mainTextArea.setText("\n\n" + monster.name + ": " + monster.hp + " HP" + "\nWhat do you intend to do?");
        }

        ui.choiceThree.setText("Attack");
        ui.choiceFour.setText("Flee from battle");

        game.nextPositionThree = "playerAttack_" + monster.objectID;
        game.nextPositionFour = whereToRun;
    }

    public void playerAttack(SuperMonster monster) {
        playerRoundCounter();
        System.out.println("player attack: playerAttackRound = " + playerAttackRound);

        // todo: try to implement a counter of a round, so that magical chalice can be used once in a fight, chalice_counter = 0
        // todo: also implement a special attack, which is available every 3rd round, also other counter, round_counter = 0
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        int playerDamage;
        if (player.weapon.hasPassive) {
            if (playerAttackRound % 2 == 0) {
                playerDamage = player.weapon.attack();
                ui.mainTextArea.setText("\n\n" + player.weapon.weaponMessage() + "\nYou deal " + playerDamage + " damage to the " + monster.name.toLowerCase() + ".");
            } else {
                playerDamage = player.weapon.passiveAttack(monster);
                ui.mainTextArea.setText("\n\n" + player.weapon.weaponMessagePassive() + "\nYou deal " + playerDamage + " damage to the " + monster.name.toLowerCase() + ".");
            }
        } else {
            playerDamage = player.weapon.attack();
            ui.mainTextArea.setText("\n\n" + player.weapon.weaponMessage() + "\nYou deal " + playerDamage + " damage to the " + monster.name.toLowerCase() + ".");
        }

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
        monsterRoundCounter();
        System.out.println("monster attack: monsterAttackRound = " + monsterAttackRound);

        int monsterDamage = monster.attack(player);

        ui.mainTextArea.setText("\n\n" + monster.message() + "\nThe " + monster.name + " dealt " + monsterDamage + " damage.");

        player.hp -= monsterDamage;
        ui.healthNumberLabel.setText("" + player.hp);

        ui.continueButton.setText("Continue");

        if (player.hp > 0) {
            game.continuePosition = "fight_" + monster.objectID;
        } else {
            game.continuePosition = "lose";
        }

    }

    private void playerRoundCounter() {
        if (playerAttackRound >= 1 && playerAttackRound <= 100) {
            monsterAttackRound = playerAttackRound;
        }
    }

    private void monsterRoundCounter() {
        if (monsterAttackRound >= 1 && monsterAttackRound <= 100) {
            playerAttackRound = monsterAttackRound;
        }

        playerAttackRound += 1;
    }

    public void win(SuperMonster monster, String continueNextPosition, SuperItem loot, Integer coins) {
        // todo: somehow make the fifth argument "int monsterDefeated" work, so that we don't have to implement an extra if block...
        // todo: add an image for each defeated enemy...

        if ((loot != null) && ((coins != 0))) {
            ui.mainTextArea.setText("\n\nYou have defeated the " + monster.name.toLowerCase() + "!\n" +
                    "The " + monster.name.toLowerCase() + " has dropped a " + loot.name + " and " + coins + " coins.");
        } else if ((loot == null) && ((coins != 0))) {
            ui.mainTextArea.setText("\n\nYou have defeated the " + monster.name.toLowerCase() + "!\n" +
                    "The " + monster.name.toLowerCase() + " has dropped " + coins + " coins.");
        } else if (loot != null) {
            ui.mainTextArea.setText("\n\nYou have defeated the " + monster.name.toLowerCase() + "!\n" +
                    "The " + monster.name.toLowerCase() + " has dropped a " + loot.name);
        } else {
            ui.mainTextArea.setText("\n\nYou have defeated the " + monster.name.toLowerCase() + "!\n" +
                    "The " + monster.name.toLowerCase() + " has dropped nothing.");
        }


        switch (monster.objectID) {
            case "greatWoodsEntrance_4_Wolf" -> {
                game.story.greatWoodsEntrance_4_WolfDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntrance_6_NarrowPath_2_Wolf" -> {
                game.story.greatWoodsEntrance_6_NarrowPath_2_WolfDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntranceCave_WolfOne" -> {
                game.story.greatWoodsEntranceCave_WolfOneDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat" -> {
                game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatDefeated = 1;
                game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatEncountered = false;
                game.story.greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat = 0;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntranceCave_4_Proceed_SleepingWolf" -> {
                game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntranceCave_WolfTwo" -> {
                game.story.greatWoodsEntranceCave_WolfTwoDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
            }
            case "greatWoodsEntranceCaveLair_WolfMatriarch" -> {
                game.story.greatWoodsEntranceCaveLair_WolfMatriarchDefeated = 1;
                playerAttackRound = 1;
                game.ui.inventoryItemOneButton.setBackground(Color.green);
                game.itemInventory.add(game.questItemSilverRing);
                game.story.goblinVillageEntranceGuardSilverRingDiscovered = true;
            }
        }

        ui.continueButton.setText("Continue");

        game.continuePosition = continueNextPosition;

    }

    public void lose() {

        ui.healthNumberLabel.setText("" + player.hp);
        ui.mainTextArea.setText("\nYou are dead! \n<GAME OVER>");

        ui.continueButton.setText("To the title screen");

        game.continuePosition = "toTitle";
    }

    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }

    public void musicMachine() {

        System.out.println(playerLocation);

        //todo: make sure that nextposition and continue are inter-connected, so music could flow normally.

        //todo: check the paths and then stop the location audio from where the player is coming!

        if (playerLocation.contains("waterfallZone")) {

            game.startingZoneMusicObj.fadeOutMusic(() -> {

                game.startingZoneMusicObj.stop();

                game.startingZoneMusicObj.resetPosition();

                game.waterFallZoneMusicObj.isActiveClip();

            });


        } else if (playerLocation.contains("startingZone")) {

            game.startMusicObj.fadeOutMusic(() -> {

                game.startMusicObj.stop();
                game.startMusicObj.normalizeMusic();
                game.startMusicObj.resetPosition(); // TODO: refine these lines, I guess you can withdraw those if written inside the fadeout
            });


            game.waterFallZoneMusicObj.fadeOutMusic(() -> {

                game.waterFallZoneMusicObj.stop();
                game.waterFallZoneMusicObj.resetPosition();

                game.startingZoneMusicObj.isActiveClip();

            });

        }

        /*if (isMusicPlaying) {
            if (playerLocation.contains("waterfallZone")) {
                game.startMusicObj.stop();
                game.startMusicObj.resetPosition();
                game.waterFallZoneMusicObj.play();
            } else if (playerLocation.contains("startingZone")) {
                game.startMusicObj.stop();
                game.startingZoneMusicObj.resetPosition();
                game.startingZoneMusicObj.play();
            }
        } else {
            game.waterFallZoneMusicObj.stop();
            isMusicPlaying = true;
        }*/

        /*if (playerLocation.contains("startingZone") && !isMusicPlaying) {
            startingZoneMusicObj.play();
            isMusicPlaying = true;
        } else {
            startingZoneMusicObj.stop();
            waterFallZoneMusicObj.play();
        }*/

        /*if (playerLocation.contains("waterfallZone") && isMusicPlaying) {
            startingZoneMusicObj.stop();
            waterFallZoneMusicObj.play();
        } else if(playerLocation.contains("greatWoodsEntrance")) {
            startingZoneMusicObj.stop();
            waterFallZoneMusicObj.stop();
        }*/

    }

}

