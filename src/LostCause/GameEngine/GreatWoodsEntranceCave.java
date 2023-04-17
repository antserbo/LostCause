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

        ui.mainTextArea.setText("\n\nYou are entering a cave, yet have no idea what lies below...");
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


        ui.mainTextArea.setText("\nYou find yourself in a large cave with little light," +
                "\nwhich makes it hard to determine what awaits you." +
                "\nThe best strategy is to be vigilant and not run into any unnecessary trouble.");

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

            ui.mainTextArea.setText("\nUnfortunately you have been spotted the moment" +
                    "\nyou had been attempting to enter the cave." +
                    "\nBrace yourself, a wolf was lurking in the shadows and now stepped towards you.");

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
            ui.mainTextArea.setText("\n\nThis giant bat is a nuisance, you must tread carefully...");
            game.nextPositionTwo = "greatWoodsEntranceCave_4_ClimbTheRocks_Failure";
        } else {
            ui.mainTextArea.setText("\nHopefully there are not a lot of wolves in this cave..." +
                    "\nOtherwise it is going to be even more dangerous from now on." +
                    "\nYou walk to as it seems a bigger area of the cave.");
            game.nextPositionTwo = "greatWoodsEntranceCave_4_ClimbTheRocks";
        }

        ui.choiceTwo.setText("Climb the rocks");
        ui.choiceThree.setText("Proceed walking forth");
        ui.choiceFour.setText("Return to the woods");

        game.nextPositionThree = "greatWoodsEntranceCave_4_Proceed";
        game.nextPositionFour = "greatWoodsEntrance_5";

    }

    public void greatWoodsEntranceCave_4_ClimbTheRocks() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_ClimbTheRocks";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("\n\nYou carefully place your foot on the first rock and start climbing slowly, yet carefully.");
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
            ui.mainTextArea.setText("\nLooks like you managed to climb the wall" +
                    "\nand see a wolf in front of another entrance from the top");
        } else {
            ui.mainTextArea.setText("Looks like you managed to climb the wall" +
                    "\nand see another entrance from the top");
        }

        ui.continueButton.setText("Proceed");
        game.continuePosition = "greatWoodsEntranceCave_5";


    }

    public void greatWoodsEntranceCave_4_ClimbTheRocks_Failure() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_ClimbTheRocks_Failure";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCave_4_ClimbTheRocks_RanAwayFromBat == 1) {
            ui.mainTextArea.setText("\n\nYou decide to return and take down the giant bat...");
        } else {
            ui.mainTextArea.setText("\nYou were not careful enough and fall down, luckily without" +
                    "\ntaking any serious damage. However, you have disturbed" +
                    "\na giant bat, looks like you have to cut your way though...");
        }

        greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat = new MonsterGiantBat("greatWoodsEntranceCave_4_ClimbTheRocks_GiantBat");

        game.story.greatWoodsEntranceCave_4_ClimbTheRocks_BatEncountered = true;

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);

        //ui.image = new ImageIcon(".//res//great_woods.png"); //todo: change to bat
        //ui.imageLabel.setIcon(ui.image);


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
                dealingWithAwakenedWolf("\n\nYou attempt to take on the now awakened wolf...");
            } else {
                ui.mainTextArea.setText("\n\nYou tread lightly and notice a wolf sleeping in front of some dusty crates.\n" +
                        "\nThis allows you to plan your next strategy.");

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

                ui.mainTextArea.setText("\n\nYou managed to kill the sleeping wolf with ease.");
                game.story.greatWoodsEntranceCave_Proceed_SleepingWolfDefeated = 1;
                // todo: add image of the killed wolf

                ui.continueButton.setText("Continue");
                game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
            } else {
                ui.choiceButtonPanel.setVisible(true);
                ui.continueButtonPanel.setVisible(false);
                ui.choiceTwo.setVisible(true);

                game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = true;

                dealingWithAwakenedWolf("\n\nLooks like you failed and the wolf is ready to attack...");
            }
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);


            dealingWithAwakenedWolf("\n\nYou attempt to take on the now awakened wolf...");
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

                ui.mainTextArea.setText("\n\nYou managed to walk past the sleeping wolf.");
                // todo: add image of the killed wolf

                ui.continueButton.setText("Continue");
                game.continuePosition = "greatWoodsEntranceCave_4_Proceed_Crates";
            } else {
                ui.choiceButtonPanel.setVisible(true);
                ui.continueButtonPanel.setVisible(false);
                ui.choiceTwo.setVisible(true);

                game.story.greatWoodsEntranceCave_4_Proceed_SleepingWolfEncountered = true;

                dealingWithAwakenedWolf("\n\nLooks like you failed and the wolf is ready to attack...");
            }
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);


            dealingWithAwakenedWolf("\n\nYou attempt to take on the now awakened wolf...");
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

            ui.mainTextArea.setText("\n\nThere are two crates in front of you.");
            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked == 1) {
                ui.choiceTwo.setText("");
                game.nextPositionTwo = "";
            } else {
                ui.choiceTwo.setText("\n\nCheck the bigger crate");
                game.nextPositionTwo = "greatWoodsEntranceCave_4_Proceed_Crates_Bigger";
            }

            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked == 1) {
                ui.choiceThree.setText("");
                game.nextPositionThree = "";
            } else {
                ui.choiceThree.setText("\n\nCheck the lesser crate");
                game.nextPositionThree = "greatWoodsEntranceCave_4_Proceed_Crates_Lesser";
            }

            if (game.story.greatWoodsEntranceCave_4_Proceed_Crates_LesserChecked == 1 && game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked == 1) {
                ui.mainTextArea.setText("\n\nBoth crates have been already looted. Nothing interesting here.");
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

        ui.mainTextArea.setText("\nAn old battle-worn bronze shield lies at the bottom of the crate." +
                "\nThis will prove useful in the upcoming fights." +
                "\n(you receive a bronze shield)");

        game.itemInventory.add(game.armorShieldBronzeShield);

        game.story.greatWoodsEntranceCave_4_Proceed_Crates_BiggerChecked = 1;

    }

    public void greatWoodsEntranceCave_4_Proceed_Crates_Lesser() {
        playerLocation = "greatWoodsEntranceCave";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_4_Proceed_Crates_Lesser";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("\nYou carefully look inside the lesser crate and find a magical chalice" +
                "\nThis chalice can heal the player once and has to be replenished by defeating an enemy." +
                "\n(you receive a magical chalice, it can be found in your quick slot)");
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
        game.story.playerFightLocationHelper = "greatWoodsEntranceCave_5";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCave_WolfTwoDefeated == 0) {

            ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg"); // todo: add an image of a guarding wolf
            ui.imageLabel.setIcon(ui.image);

            greatWoodsEntranceCave_WolfTwo = new MonsterWolf("greatWoodsEntranceCave_WolfTwo");

            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceTwo.setVisible(true);

            ui.mainTextArea.setText("\n\nYou approach a wolf guarding what seems to be a lair." +
                    "\nHopefully this is the last wolf in your way...");


            ui.choiceTwo.setText("Examine foe");
            ui.choiceThree.setText("Start the battle");
            ui.choiceFour.setText("Run");

            game.nextPositionTwo = "examine_greatWoodsEntranceCave_WolfTwo";
            game.nextPositionThree = "fight_greatWoodsEntranceCave_WolfTwo";
            game.nextPositionFour = "greatWoodsEntranceCave_4";
        } else {

            ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg"); // todo: add an image of a defeated wolf
            ui.imageLabel.setIcon(ui.image);

            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceOne.setVisible(false);
            ui.choiceTwo.setVisible(true);

            ui.mainTextArea.setText("\n\nYou approach the entrance what seems to be a lair.\n" +
                    "\nThe dead wolf is lying right in front of it.");

            ui.choiceTwo.setText("Enter the cave lair");
            ui.choiceThree.setText("Go back to cave entrance");
            ui.choiceFour.setText("Go back to river");

            game.nextPositionTwo = "greatWoodsEntranceCaveLair";
            game.nextPositionThree = "greatWoodsEntrance_6_NarrowPath_4";
            game.nextPositionFour = "greatWoodsEntrance_5";
        }
    }


}
