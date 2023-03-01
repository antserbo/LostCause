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

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You are entering a cave, yet have no idea what lies below...");
        ui.image = new ImageIcon(); // todo: add an image of entering the cave
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCave_2";

    }

    public void greatWoodsEntranceCave_2() {
        playerLocation = "greatWoodsEntranceCave";
        worldMapLocationDeterminerHelper();

        ui.image = new ImageIcon(".//res//greatWoodsEntranceCave.jpg");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

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

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

    }


}
