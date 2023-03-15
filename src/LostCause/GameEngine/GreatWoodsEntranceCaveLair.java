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

        ui.mainTextArea.setText("You go through the wide crevice, which leads to a cave lair.");
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

        ui.mainTextArea.setText("Yet not so big as the previous area, the lair is still spacious.\n" +
                "A dim light is shining somewhere from above which lets you determine your surroundings.");
        ui.image = new ImageIcon(); // todo: add an image of the cave lair
        ui.imageLabel.setIcon(ui.image);

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_3";
    }

    public void greatWoodsEntranceCaveLair_3() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_3";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Considering the previous encounters, you remain vigilant and try to be as silent as possible.\n" +
                "Taking each step with caution.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_4";
    }

    public void greatWoodsEntranceCaveLair_4() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_4";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Dead silence is in the air, yet you cannot let your guard down. \n" +
                "A number of scattered human bones lie near where you're standing, which makes you feel uneasy, as you may not be alone in this very moment.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_5";
    }

    public void greatWoodsEntranceCaveLair_5() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_5";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("You sense that something is watching you...\n" +
                "By turning your head around you notice two yellow eyes following your movement in the darkest corner.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntranceCaveLair_6";
    }

    public void greatWoodsEntranceCaveLair_6() {
        playerLocation = "greatWoodsEntranceCaveLair";
        game.story.playerFightLocationHelper = "greatWoodsEntranceCaveLair_6";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntranceCaveLair_WolfMatriarchDefeated == 1) {
            ui.mainTextArea.setText("The wolf matriarch lays slain in front of you.\n" +
                    "It seems the cave is finally safe now");
        } else {

            greatWoodsEntranceCaveLair_WolfMatriarch = new MonsterWolfMatriarch("greatWoodsEntranceCaveLair_WolfMatriarch");

            if (game.story.greatWoodsEntranceCaveLair_WolfMatriarchEncountered) {
                ui.mainTextArea.setText("The wolf matriarch has been waiting for your return...");
            } else {
                ui.mainTextArea.setText("Trying to remain calm you see a wolf matriarch coming out of the shadows, it seems that a furious battle is ahead...");
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
