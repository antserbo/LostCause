package LostCause.GameEngine;

import javax.swing.*;

public class StartingZone extends Story {

    public StartingZone(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }


    public void startingZone() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nYou wake up to the noise of the waterfall in the distance.\n" +
                "The only vague memory you have is of your name,\n" +
                "despite the aching body you try to get up...");

        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_2";


    }

    public void startingZone_2() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone_2";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nWith legs trembling you somehow manage to stand up.\n" +
                "No idea how you ended up in this place. However, you need to act...");


        ui.continueButton.setText("Look around");

        game.continuePosition = "startingZone_3";

    }

    public void startingZone_3() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone_3";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nAfter looking around you determine \n" +
                "that to your right there is a waterfall in the distance.");


        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_4";

    }

    public void startingZone_4() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone_4";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nBeside you there is a dead-end,\n" +
                "fallen trees are blocking the southern route.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_5";
    }

    public void startingZone_5() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone_5";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nTo your left lies a narrow path,\n" +
                "which gives you an eerie feeling.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_6";

    }

    public void startingZone_6() {
        playerLocation = "startingZone";
        game.story.playerFightLocationHelper = "startingZone_6";
        worldMapLocationDeterminerHelper();
        ui.mainTextArea.setText("\nThe northern direction introduces a road \n" +
                "which leads deeper into the forest.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_7";


    }

    public void startingZone_7() {
        playerLocation = "startingZone";
        game.story.startingZoneDiscovered = true;
        game.story.playerFightLocationHelper = "startingZone_7";
        worldMapLocationDeterminerHelper();
        // TODO: add location names once discovered. Once you get to the end of waterfall, f.e., you no longer see "go west", rather "to / waterfall"
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(true);
        ui.choiceTwo.setVisible(true);

        ui.image = new ImageIcon(".//res//crossroad_inverted.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.mainTextArea.setText("\n\nWhere do you want to go?");

        if (game.story.greatWoodsEntranceDiscovered && game.story.greatWoodsEntranceCaveDiscovered) {
            ui.choiceOne.setText("To Great Woods Entrance");
            game.nextPositionOne = "greatWoodsEntrance_5";
        } else {
            ui.choiceOne.setText("Go north");
            game.nextPositionOne = "greatWoodsEntrance";
        }
        if (game.story.waterfallZoneDiscovered && game.story.waterfallSkeletonSearched) {
            ui.choiceTwo.setText("To waterfall");
            game.nextPositionTwo = "waterfallZone_3";
        } else if (game.story.waterfallZoneDiscovered) {
            ui.choiceTwo.setText("To waterfall");
            game.nextPositionTwo = "waterfallZone_2";
        } else {
            ui.choiceTwo.setText("Go east");
            game.nextPositionTwo = "waterfallZone";
        }
        if (game.story.goblinVillageEntranceDiscovered) {
            ui.choiceFour.setText("To Goblin Village Entrance");
            game.nextPositionFour = "goblinVillageEntrance_7";
        } else {
            ui.choiceFour.setText("Go west");
            game.nextPositionFour = "goblinVillageEntrance";
        }

        ui.choiceThree.setText("Go south");
        game.nextPositionThree = "startingZone_7_ToSouth";

    }

}
