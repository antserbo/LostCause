package LostCause.GameEngine;

import LostCause.MonsterFiles.MonsterWolf;

import javax.swing.*;

public class GreatWoodsEntranceCave extends Story{

    public GreatWoodsEntranceCave(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void greatWoodsEntranceCave() {
        playerLocation = "greatWoodsEntranceCave";
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
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);

        ui.mainTextArea.setText("You walk past the defeated wolf.");

        //ui.image = new ImageIcon(".//res//great_woods.png"); // change to defeated wolf
        //ui.imageLabel.setIcon(ui.image);

        ui.mainTextArea.setText("Hopefully there are not a lot of wolves in this cave... Otherwise it is going to be even more dangerous from now on.\n" +
                "You walk to as it seems a bigger area of the cave, where you can choose on how to proceed.");

        ui.choiceTwo.setText("Climb the rocks");
        ui.choiceThree.setText("Proceed walking forth");
        ui.choiceFour.setText("Return to the woods");

        game.nextPositionTwo = "greatWoodsEntranceCave";
        game.nextPositionThree = "";
        game.nextPositionFour = "greatWoodsEntrance_5";

    }

    public void greatWoodsEntranceCave_5() {



    }


}
