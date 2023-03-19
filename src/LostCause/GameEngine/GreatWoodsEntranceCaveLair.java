package LostCause.GameEngine;

import LostCause.MonsterFiles.MonsterWolfMatriarch;

import javax.swing.*;

public class GreatWoodsEntranceCaveLair extends Story {

    public GreatWoodsEntranceCaveLair(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void greatWoodsEntranceCaveLair() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("\n\nYou go through the wide crevice, which leads to a cave lair.");
        ui.image = new ImageIcon(); // todo: add an image of entering the cave lair
        ui.imageLabel.setIcon(ui.image);

        if (game.story.greatWoodsEntranceCaveLair_WolfMatriarchEncountered) {
            game.continuePosition = "greatWoodsEntranceCaveLair_6";
        } else {
            game.continuePosition = "greatWoodsEntranceCaveLair_2";
        }

        ui.continueButton.setText("Continue");


    }

    public void greatWoodsEntranceCaveLair_2() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_2";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("\nYet not so big as the previous area, the lair is still spacious." +
                "\nA dim light is shining somewhere from above" +
                "\nwhich lets you determine your surroundings.");
        ui.image = new ImageIcon(); // todo: add an image of the cave lair
        ui.imageLabel.setIcon(ui.image);

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_3";
    }

    public void greatWoodsEntranceCaveLair_3() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_3";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("\nConsidering the previous encounters," +
                "\nyou remain vigilant and try to be as silent as possible." +
                "\nTaking each step with caution.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_4";
    }

    public void greatWoodsEntranceCaveLair_4() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_4";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("\nDead silence is in the air, yet you cannot let your guard down." +
                "\nA number of scattered human bones lie near where you're standing," +
                "\nThis makes you feel even more uneasy, as you may not be alone...");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_5";
    }

    public void greatWoodsEntranceCaveLair_5() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_5";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("\nYou sense that something is watching you." +
                "\nBy turning your head around you notice that" +
                "\ntwo yellow eyes have been following your movement in the darkest corner.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_6";
    }

    public void greatWoodsEntranceCaveLair_6() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_6";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCaveLair_WolfMatriarchDefeated == 1) {
            ui.mainTextArea.setText("\n\nThe wolf matriarch lays slain in front of you.\n" +
                    "It seems the cave is finally safe now");
        } else {

            greatWoodsEntranceCaveLair_WolfMatriarch = new MonsterWolfMatriarch("greatWoodsEntranceCaveLair_WolfMatriarch");

            if (game.story.greatWoodsEntranceCaveLair_WolfMatriarchEncountered) {
                ui.mainTextArea.setText("\n\nThe wolf matriarch has been waiting for your return...");
            } else {
                ui.mainTextArea.setText("\nTrying to remain calm you see a wolf matriarch coming out of the shadows,\n" +
                        "it seems that a furious battle is ahead...");
            }

            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);

            ui.choiceOne.setVisible(false);
            ui.choiceTwo.setVisible(true);
            ui.choiceThree.setVisible(true);
            ui.choiceFour.setVisible(true);

            ui.choiceTwo.setText("Examine the " + greatWoodsEntranceCaveLair_WolfMatriarch.name.toLowerCase());
            ui.choiceThree.setText("Fight the " + greatWoodsEntranceCaveLair_WolfMatriarch.name.toLowerCase());
            ui.choiceFour.setText("Run");

            game.nextPositionTwo = "examine_greatWoodsEntranceCaveLair_WolfMatriarch";
            game.nextPositionThree = "fight_greatWoodsEntranceCaveLair_WolfMatriarch";
            game.nextPositionFour = "greatWoodsEntranceCave_5";

            game.story.greatWoodsEntranceCaveLair_WolfMatriarchEncountered = true;

        }

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_7";
    }
}
