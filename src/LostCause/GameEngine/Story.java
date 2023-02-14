package LostCause.GameEngine;

import javax.swing.*;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;

    int waterfallSkeletonWeaponTaken = 0;
    int waterfallSkeletonTimesSearched = 0;
    int waterfallSkeletonAmuletTaken = 0;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {


    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition) {

            case "startingZone_2" -> startingZone_2();
            case "startingZone_3" -> startingZone_3();
            case "startingZone_4" -> startingZone_4();
            case "startingZone_5" -> startingZone_5();
            case "startingZone_6" -> startingZone_6();
            case "startingZone_7" -> startingZone_7();
            case "waterfallZone" -> waterfallZone();
            case "waterfallZone_2" -> waterfallZone_2();
            case "waterfallZone_2_WeaponTake" -> waterfallZone_2_WeaponTake();
            case "waterfallZone_2_SearchSkeleton_Success" -> waterfallZone_2_SearchSkeleton_Success();
            case "waterfallZone_2_SearchSkeleton_Failure" -> waterfallZone_2_SearchSkeleton_Failure();

        }
    }

    public void startingZone() {
        ui.mainTextArea.setText("You wake up to the noise of the waterfall in the distance.\n" +
                "The only vague memory you have is of your name, despite the aching body you try to get up...");

        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_2";


    }

    public void startingZone_2() {
        ui.mainTextArea.setText("With legs trembling you somehow manage to stand up.\n" +
                "No idea how you ended up in this place. However, you need to act...");


        ui.continueButton.setText("Look around");

        game.continuePosition = "startingZone_3";

    }

    public void startingZone_3() {
        ui.mainTextArea.setText("After looking around you determine that to your right there is a waterfall in the distance.");


        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_4";

    }

    public void startingZone_4() {
        ui.mainTextArea.setText("Beside you there is a dead-end, fallen trees are blocking the southern route.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_5";
    }

    public void startingZone_5() {
        ui.mainTextArea.setText("To your left lies a narrow path, which gives you an eerie feeling.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_6";

    }

    public void startingZone_6() {
        ui.mainTextArea.setText("The northern direction introduces a road which leads deeper into the forest.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_7";


    }

    public void startingZone_7() {
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);

        ui.mainTextArea.setText("Where do you want to go?");


        ui.choiceOne.setText("Go north");
        ui.choiceTwo.setText("Go east");
        ui.choiceThree.setText("Go south");
        ui.choiceFour.setText("Go west");

        game.nextPositionOne = "fromStartingZoneNorth";
        game.nextPositionTwo = "fromStartingZoneEast";
        game.nextPositionThree = "fromStartingZoneSouth";
        game.nextPositionFour = "waterfallZone";

    }

    public void waterfallZone() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You enter a secluded area with a waterfall.");

        ui.image = new ImageIcon(".//res//waterfall.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Look around");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2() {
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("Your eye catches a resting skeleton of a long-forgotten adventurer.\n" +
                "Even though the skeleton's been resting for quite some time, the equipment might prove useful.");

        if (waterfallSkeletonWeaponTaken == 0) {
            ui.choiceTwo.setText("Take weapon");
            game.nextPositionTwo = "waterfallZone_2_WeaponTake";
        } else {
            ui.choiceTwo.setText("");
            game.nextPositionTwo = "";
        }

        if (waterfallSkeletonAmuletTaken == 0 && waterfallSkeletonTimesSearched < 3) {
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

        if (((waterfallSkeletonAmuletTaken == 1) || (waterfallSkeletonTimesSearched > 2)) && waterfallSkeletonWeaponTaken == 1) {
            ui.mainTextArea.setText("There is nothing left to loot from the skeleton's remains.");
        }

        ui.choiceFour.setText("Leave skeleton");
        game.nextPositionFour = "waterfallZone_3";
    }

    public void waterfallZone_2_WeaponTake() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a rusty iron long sword!");
        waterfallSkeletonWeaponTaken = 1;

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2_SearchSkeleton_Success() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a peculiar amulet!");
        waterfallSkeletonAmuletTaken = 1;

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";
    }

    public void waterfallZone_2_SearchSkeleton_Failure() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (waterfallSkeletonTimesSearched < 2) {
            ui.mainTextArea.setText("You have failed in searching the skeleton.");
        } else {
            ui.mainTextArea.setText("The skeleton has crumbled to dust and searching it is not possible anymore");
        }
        waterfallSkeletonTimesSearched += 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "waterfallZone_2";
    }


    public void waterfallZone_3() {

    }
}
