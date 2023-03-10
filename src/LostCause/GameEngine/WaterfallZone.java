package LostCause.GameEngine;

import javax.swing.*;

public class WaterfallZone extends Story{

    public WaterfallZone(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void waterfallZone() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You enter a secluded area with a waterfall.");

        ui.image = new ImageIcon(".//res//waterfall.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Look around");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("Your eye catches a resting skeleton of a long-forgotten adventurer.\n" +
                "Even though the skeleton's been resting for quite some time, the equipment might prove useful.");

        if (game.story.waterfallSkeletonWeaponTaken == 0) {
            ui.choiceTwo.setText("Take weapon");
            game.nextPositionTwo = "waterfallZone_2_WeaponTake";
        } else {
            ui.choiceTwo.setText("");
            game.nextPositionTwo = "";
        }

        if (game.story.waterfallSkeletonAmuletTaken == 0 && game.story.waterfallSkeletonTimesSearched < 3) {
            int waterfallSkeletonAmuletChance = new java.util.Random().nextInt(3);
            ui.choiceThree.setText("Search skeleton");
            if (waterfallSkeletonAmuletChance == 2) {
                game.nextPositionThree = "waterfallZone_2_SearchSkeleton_Success";
            } else {
                game.nextPositionThree = "waterfallZone_2_SearchSkeleton_Failure";
            }
        } else {
            ui.choiceThree.setText("");
            game.nextPositionThree = "";
        }

        if (((game.story.waterfallSkeletonAmuletTaken == 1) || (game.story.waterfallSkeletonTimesSearched > 2)) && game.story.waterfallSkeletonWeaponTaken == 1) {
            ui.mainTextArea.setText("There is nothing left to loot from the skeleton's remains.");
            game.story.waterfallSkeletonSearched = true;
        }

        ui.choiceFour.setText("Leave skeleton");
        game.nextPositionFour = "waterfallZone_3";
    }

    public void waterfallZone_2_WeaponTake() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a rusty iron long sword!");
        game.story.waterfallSkeletonWeaponTaken = 1;
        game.itemInventory.add(game.longSword); // adding long sword to player's inventory

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2_SearchSkeleton_Success() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a peculiar amulet!");
        game.story.waterfallSkeletonAmuletTaken = 1;
        game.itemInventory.add(game.amuletRingShell);

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";
    }

    public void waterfallZone_2_SearchSkeleton_Failure() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (game.story.waterfallSkeletonTimesSearched < 2) {
            ui.mainTextArea.setText("You have failed in searching the skeleton.");
        } else {
            ui.mainTextArea.setText("The skeleton has crumbled to dust and searching it is not possible anymore");
        }
        game.story.waterfallSkeletonTimesSearched += 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "waterfallZone_2";
    }

    public void waterfallZone_3() {
        playerLocation = "waterfallZone";
        game.story.waterfallZoneDiscovered = true;
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("You step closer to the waterfall. \n" +
                "The sound of it makes you feel some sort of relief...");

        ui.choiceTwo.setText("Drink water");
        game.nextPositionTwo = "waterfallZone_3_DrinkWater";


        ui.choiceThree.setText("Meditate (save)");
        game.nextPositionThree = "waterfallZone_3_Meditate";


        ui.choiceFour.setText("Head back");
        game.nextPositionFour = "startingZone_7";


    }

    public void waterfallZone_3_DrinkWater() {
        playerLocation = "waterfallZone";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        game.story.healing(3, "You take a sip of water and a rejuvenating effect rushes though your body");

        ui.continueButton.setText("Stop drinking");
        game.continuePosition = "waterfallZone_3";

    }

    public void waterfallZone_3_Meditate() {
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Progress has been saved.");
        System.out.println(game.story.greatWoodsEntrance_6_NarrowPath_2_WolfDefeated);
        System.out.println(game.story.waterfallSkeletonWeaponTaken);

        ui.continueButton.setText("Continue your journey");
        game.continuePosition = "waterfallZone_3";


    }

}
