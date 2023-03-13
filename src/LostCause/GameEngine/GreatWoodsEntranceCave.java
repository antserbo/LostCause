package LostCause.GameEngine;

import LostCause.MonsterFiles.MonsterGiantBat;
import LostCause.MonsterFiles.MonsterWolf;

import javax.swing.*;

public class GreatWoodsEntranceCave extends Story{

    public GreatWoodsEntranceCave(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void greatWoodsEntranceCave() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave";
        worldMapLocationDeterminerHelper();
        game.story.greatWoodsEntrance_5_RiverDrinks = 0;

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You are entering a cave, yet have no idea what lies below...");
        ui.image = new ImageIcon(); // todo: add an image of entering the cave
        ui.imageLabel.setIcon(ui.image);

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCave_2";

    }

    public void greatWoodsEntranceCave_2() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_2";
        worldMapLocationDeterminerHelper();

        ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg");
        ui.imageLabel.setIcon(ui.image);

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);


        ui.mainTextArea.setText("You find yourself in a large cave with little light, which makes it hard to determine what awaits you.\n" +
                "The best strategy is to be vigilant and not run into any unnecessary trouble.");

        ui.choiceThree.setText("Proceed further into the cave");
        ui.choiceFour.setText("Go back to the crossroad");

        game.nextPositionThree = "greatWoodsEntranceCave_3";
        game.nextPositionFour = "startingZone_7";
    }

    public void greatWoodsEntranceCave_3() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_3";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCave_WolfOneDefeated == 1) {
            ui.choiceButtonPanel.setVisible(false);
            ui.continueButtonPanel.setVisible(true);

            ui.mainTextArea.setText("You walk past the defeated wolf.");

            //ui.image = new ImageIcon(".//res//great_woods.png"); // change to defeated wolf
            //ui.imageLabel.setIcon(ui.image);

            game.continuePosition = "greatWoodsEntranceCave_4";
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceOne.setVisible(false);
            ui.choiceTwo.setVisible(true);

            ui.mainTextArea.setText("Unfortunately, you have been spotted the moment you had been attempting to enter the cave.\n" +
                    "Brace yourself, a wolf was lurking in the shadows and now stepped towards you.");

            greatWoodsEntranceCave_WolfOne = new MonsterWolf("greatWoodsEntranceCave_WolfOne");

            ui.choiceTwo.setText("Examine foe");
            ui.choiceThree.setText("Start the battle");
            ui.choiceFour.setText("Run");
            game.nextPositionTwo = "examine_greatWoodsEntranceCave_WolfOne";
            game.nextPositionThree = "fight_greatWoodsEntranceCave_WolfOne";
            game.nextPositionFour = "greatWoodsEntrance_6_NarrowPath_4";
        }

    }

    public void greatWoodsEntranceCave_4() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);

        //ui.image = new ImageIcon(".//res//great_woods.png"); // change to defeated wolf
        //ui.imageLabel.setIcon(ui.image);

        if (game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatEncountered) {
            game.story.greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat = 1;
            ui.mainTextArea.setText("This giant bat is a nuisance, you must tread carefully...");
        } else {
            ui.mainTextArea.setText("Hopefully there are not a lot of wolves in this cave... Otherwise it is going to be even more dangerous from now on.\n" +
                    "You walk to as it seems a bigger area of the cave, where you can choose on how to proceed.");
        }

        ui.choiceTwo.setText("Climb the rocks");
        ui.choiceThree.setText("Proceed walking forth");
        ui.choiceFour.setText("Return to the woods");

        game.nextPositionTwo = "greatWoodsEntranceCave_4_ClimbTheRocks";
        game.nextPositionThree = "greatWoodsEntranceCave_4_Proceed";
        game.nextPositionFour = "greatWoodsEntrance_5";

    }

    public void greatWoodsEntranceCave_4_ClimbTheRocks() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_ClimbTheRocks";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You carefully place your foot on the first rock and start climbing slowly, yet carefully.");
        ui.continueButton.setText("Continue");

        int greatWoodsEntranceCaveRockClimbChance = new java.util.Random().nextInt(2); // todo :change back to 2

        if (greatWoodsEntranceCaveRockClimbChance == 1 && game.story.greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat == 0) {
            game.continuePosition = "greatWoodsEntranceCave_4_ClimbTheRocks_Success";
        } else if (greatWoodsEntranceCaveRockClimbChance == 1 && game.story.greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat == 1) {
            game.continuePosition = "greatWoodsEntranceCave_4_ClimbTheRocks_Failure";
        } else {
            game.continuePosition = "greatWoodsEntranceCave_4_ClimbTheRocks_Failure";
        }


    }

    public void greatWoodsEntranceCave_4_ClimbTheRocks_Success() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_ClimbTheRocks_Success";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (greatWoodsEntranceCave_WolfTwoDefeated == 0) {
            ui.mainTextArea.setText("Looks like you managed to climb the wall and see a wolf in front of another entrance from the top");
        } else {
            ui.mainTextArea.setText("Looks like you managed to climb the wall and see another entrance from the top");
        }

        ui.continueButton.setText("Proceed");
        game.continuePosition = "greatWoodsEntranceCave_5";


    }

    public void greatWoodsEntranceCave_4_ClimbTheRocks_Failure() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_ClimbTheRocks_Failure";
        worldMapLocationDeterminerHelper();

        greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat = new MonsterGiantBat("greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat");

        game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatEncountered = true;

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);

        //ui.image = new ImageIcon(".//res//great_woods.png"); //todo: change to bat
        //ui.imageLabel.setIcon(ui.image);

        ui.mainTextArea.setText("You were not careful enough and fall down, luckily without taking any serious damage.\n" +
                "However, you have disturbed a giant bat, looks like you have to cut your way though...");


        ui.choiceTwo.setText("Examine foe");
        ui.choiceThree.setText("Start the battle");
        ui.choiceFour.setText("Run");

        game.nextPositionTwo = "examine_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat";
        game.nextPositionThree = "fight_greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat";
        game.nextPositionFour = "greatWoodsEntranceCave_4";

    }

    public void greatWoodsEntranceCave_4_Proceed() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated == 1) {

            ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg"); // todo: add an image of killed wolf
            ui.imageLabel.setIcon(ui.image);

            ui.choiceButtonPanel.setVisible(false);
            ui.continueButtonPanel.setVisible(true);

            ui.continueButton.setText("Continue");
            game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
        } else {

            ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg"); // todo: add an image of a sleeping wolf
            ui.imageLabel.setIcon(ui.image);

            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);

            if (game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered) {
                dealingWithAwakenedWolf("You attempt to take on the now awakened wolf...");
            } else {
                ui.mainTextArea.setText("You tread lightly and notice a wolf sleeping in front of some dusty crates.\n" +
                        "This allows you to plan your next strategy.");

                ui.choiceTwo.setText("Lay a killing blow on a sleeping wolf");
                ui.choiceThree.setText("Walk past the sleeping wolf");
                ui.choiceFour.setText("Go back");

                game.nextPositionTwo = "greatWoodsEntranceCave_4_Proceed_KillingBlow";
                game.nextPositionThree = "greatWoodsEntranceCave_4_Proceed_WalkPast";
                game.nextPositionFour = "greatWoodsEntranceCave_4";
            }
        }
    }

    public void greatWoodsEntranceCave_4_Proceed_KillingBlow() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_KillingBlow";
        worldMapLocationDeterminerHelper();

        if (!game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered) {
            int killingBlowChance = new java.util.Random().nextInt(3);
            if (killingBlowChance == 2) {
                ui.choiceButtonPanel.setVisible(false);
                ui.continueButtonPanel.setVisible(true);

                ui.mainTextArea.setText("You managed to kill the sleeping wolf with ease.");
                game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated = 1;
                // todo: add image of the killed wolf

                ui.continueButton.setText("Continue");
                game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
            } else {
                ui.choiceButtonPanel.setVisible(true);
                ui.continueButtonPanel.setVisible(false);
                ui.choiceTwo.setVisible(true);

                game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = true;

                dealingWithAwakenedWolf("Looks like you failed and the wolf is ready to attack...");
            }
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);


            dealingWithAwakenedWolf("You attempt to take on the now awakened wolf...");
            game.nextPositionFour = "greatWoodsEntranceCave_4";
        }
    }

    public void greatWoodsEntranceCave_4_Proceed_WalkPast() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_WalkPast";
        worldMapLocationDeterminerHelper();

        if (!game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered) {
            int walkPastChance = new java.util.Random().nextInt(2);
            if (walkPastChance == 1) {
                ui.choiceButtonPanel.setVisible(false);
                ui.continueButtonPanel.setVisible(true);

                ui.mainTextArea.setText("You managed to walk past the sleeping wolf.");
                // todo: add image of the killed wolf

                ui.continueButton.setText("Continue");
                game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
            } else {
                ui.choiceButtonPanel.setVisible(true);
                ui.continueButtonPanel.setVisible(false);
                ui.choiceTwo.setVisible(true);

                game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = true;

                dealingWithAwakenedWolf("Looks like you failed and the wolf is ready to attack...");
            }
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);


            dealingWithAwakenedWolf("You attempt to take on the now awakened wolf...");
            game.nextPositionFour = "greatWoodsEntranceCave_4";
        }

    }

    public void greatWoodsEntranceCave_4_Proceed_Crates() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_Crates";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceTwo.setVisible(true);

        if (game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated == 1) {

            ui.mainTextArea.setText("There are two crates in front of you.");
            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked == 1) {
                ui.choiceTwo.setText("");
                game.nextPositionTwo = "";
            } else {
                ui.choiceTwo.setText("Check the bigger crate");
                game.nextPositionTwo = "greatWoodsEntranceCave_4_Proceed_Crates_Bigger";
            }

            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked == 1) {
                ui.choiceThree.setText("");
                game.nextPositionThree = "";
            } else {
                ui.choiceThree.setText("Check the lesser crate");
                game.nextPositionThree = "greatWoodsEntranceCave_4_Proceed_Crates_Lesser";
            }

            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked == 1 && game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked == 1) {
                ui.mainTextArea.setText("Both crates have been already looted. Nothing interesting here.");
            }

            ui.choiceFour.setText("Walk away from the crates");
            game.nextPositionFour = "greatWoodsEntranceCave_5";

        } else {
            dealingWithAwakenedWolf("While moving silently to the crates, you accidentally hit a pile of rocks.\n" +
                    "Looks like the wolf is about to attack you.");

            game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = true;
        }
    }

    public void greatWoodsEntranceCave_4_Proceed_Crates_Bigger() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_Crates_Bigger";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("An old battle-worn bronze shield lies at the bottom of the crate.\n" +
                "This will prove useful in the upcoming fights.\n" +
                "(you receive a bronze shield)");

        game.itemInventory.add(game.armorShieldBronzeShield);

        game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked = 1;

    }

    public void greatWoodsEntranceCave_4_Proceed_Crates_Lesser() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_Crates_Lesser";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You carefully look inside the lesser crate and find a magical chalice\n" +
                "This chalice can heal the player once and has to be replenished by defeating an enemy.\n" +
                "(you receive a magical chalice, it can be found in your quick slot)");
        game.itemInventory.add(game.magicalChalice);

        if (game.itemInventory.contains(game.magicalChalice)) {
            ui.inventoryItemOneButton.setVisible(true);
        }

        game.story.greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked = 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
    }

    private void dealingWithAwakenedWolf(String message) {
        ui.mainTextArea.setText(message);
        greatWoodsEntranceCave_4_Proceed_SleepingWolf = new MonsterWolf("greatWoodsEntranceCave_4_Proceed_SleepingWolf");

        ui.choiceTwo.setText("Examine foe");
        ui.choiceThree.setText("Start the battle");
        ui.choiceFour.setText("Run");

        game.nextPositionTwo = "examine_greatWoodsEntranceCave_4_Proceed_SleepingWolf";
        game.nextPositionThree = "fight_greatWoodsEntranceCave_4_Proceed_SleepingWolf";
        game.nextPositionFour = "greatWoodsEntranceCave_4";
    }

    public void greatWoodsEntranceCave_5() {
        playerLocation = "greatWoodsEntranceCave";
        worldMapLocationDeterminerHelper();

        ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg"); // todo: add an image of a sleeping wolf
        ui.imageLabel.setIcon(ui.image);

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);


        ui.mainTextArea.setText("You find yourself in a large cave with little light, which makes it hard to determine what awaits you.\n" +
                "The best strategy is to be vigilant and not run into any unnecessary trouble.");

        ui.choiceThree.setText("Proceed further into the cave");
        ui.choiceFour.setText("Go back to the crossroad");

        game.nextPositionThree = "greatWoodsEntranceCave_3";
        game.nextPositionFour = "startingZone_7";
    }


}
