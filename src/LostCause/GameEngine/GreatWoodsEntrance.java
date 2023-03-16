package LostCause.GameEngine;

import LostCause.MonsterFiles.MonsterWolf;

import javax.swing.*;

public class GreatWoodsEntrance extends Story{

    public GreatWoodsEntrance(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void greatWoodsEntrance() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (game.story.greatWoodsEntrance_5_Discovered) {
            ui.mainTextArea.setText("You decide to increase your tempo.\n" +
                    "Some time later you walk past the killed wolf.");

            ui.continueButton.setText("Continue");
            game.continuePosition = "greatWoodsEntrance_5";
        } else if (game.story.greatWoodsEntrance_4_WolfEncountered) {
            ui.mainTextArea.setText("You enter the woods and get back on the right path.");

            ui.continueButton.setText("Continue");
            game.continuePosition = "greatWoodsEntrance_4";
        } else {

            ui.mainTextArea.setText("You enter the Great Woods and behold a breathtaking scenery...\n" +
                    "The gigantic trees must be thousands of years old!");

            ui.image = new ImageIcon(".//res//great_woods.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);

            ui.continueButton.setText("Continue");
            game.continuePosition = "greatWoodsEntrance_2";
        }

    }

    public void greatWoodsEntrance_2() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_2";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("This is the first time you have ever seen something so wild, but yet calming.\n" +
                "It feels like the Great Woods is a world of its own, with its own laws and time.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_3";
    }

    public void greatWoodsEntrance_3() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_3";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Tales of this place have been passed through dozens of generations.\n" +
                "The almighty nature is to be feared, yet praised for its beauty.\n" +
                "You ponder for quite a while");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_4";
    }

    public void greatWoodsEntrance_4() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_4";
        worldMapLocationDeterminerHelper();
        game.story.playerFightLocationHelper = "greatWoodsEntrance_4";

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("All of a sudden you are startled by a hungry wolf.");


        greatWoodsEntrance_4_Wolf = new MonsterWolf("greatWoodsEntrance_4_Wolf");

        game.story.greatWoodsEntrance_4_WolfEncountered = true;

        ui.image = new ImageIcon(".//res//great_woods_entrance_with_wolf.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.choiceTwo.setText("Examine foe");
        ui.choiceThree.setText("Start the battle");
        ui.choiceFour.setText("Run");
        game.nextPositionTwo = "examine_greatWoodsEntrance_4_Wolf";
        game.nextPositionThree = "fight_greatWoodsEntrance_4_Wolf";
        game.nextPositionFour = "startingZone_7";

    }

    public void greatWoodsEntrance_5() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_5";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("You traverse deeper into the Great Woods and see a small river to the right.\n" +
                "The water looks so clear, it must be coming right from that mountain with its top covered in snow");

        game.story.greatWoodsEntrance_5_Discovered = true;

        ui.image = new ImageIcon(".//res//great_woods.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        if (game.story.greatWoodsEntrance_5_RiverDrinks < 2) {
            ui.choiceThree.setText("Drink from the river");
            game.nextPositionThree = "greatWoodsEntrance_5_River";
        } else {
            ui.choiceThree.setText("");
            game.nextPositionThree = "";
        }
        ui.choiceFour.setText("Continue your journey");
        game.nextPositionFour = "greatWoodsEntrance_6";

    }


    public void greatWoodsEntrance_5_River() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_5_River";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (game.story.greatWoodsEntrance_5_RiverDrinks < 2) {
            game.story.greatWoodsEntrance_5_RiverDrinks += 1;
            game.story.healing(5, "You drink water from the river and feel better.");
        } else {
            ui.mainTextArea.setText("You have already drunk several times, your stomach is full...");
        }

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_5";
    }


    public void greatWoodsEntrance_6() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_6";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You follow the road and then see a narrow path to the left from the road.");

        ui.choiceTwo.setText("Continue walking the road");

        if (game.story.greatWoodsEntranceToCaveDiscovered) {
            ui.choiceThree.setText("Go to cave");
            game.nextPositionThree = "greatWoodsEntranceCave";
        } else {
            ui.choiceThree.setText("Take the narrow path");
            game.nextPositionThree = "greatWoodsEntrance_6_NarrowPath";
        }

        ui.choiceFour.setText("Return to crossroad");

        game.nextPositionTwo = "greatWoodsEntrance_7";
        game.nextPositionFour = "startingZone_7";

    }

    public void greatWoodsEntrance_7() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_7";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You walk the road and constantly look at the humongous trees.\n" +
                "These trees must have seen a lot and you feel your insignificance in this very moment.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_8";

    }

    public void greatWoodsEntrance_8() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_8";
        game.story.greatWoodsEntranceDiscovered = true;
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("However, negative thoughts should not crawl into your head, as you are sure destined for something great.\n" +
                "Taking several deep breaths in a row puts your mind at ease and you continue through this never-ending forest.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_7"; // todo: check for zone check to *GreatWoodsMainArea*

    }

    public void greatWoodsEntrance_6_NarrowPath() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_6_NarrowPath";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);
        // todo: add an image of a narrow path that you're walking to the cave.

        ui.mainTextArea.setText("The narrow path does not really allow you to see much in front of you due to constant turns.\n" +
                "For a reason you sharpen your senses, as you await danger lurking not far.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_6_NarrowPath_2";

    }

    public void greatWoodsEntrance_6_NarrowPath_2() { // todo: add the wolf/defeated wolf image and also check for other stuff if needed
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_6_NarrowPath_2";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntrance_6_NarrowPath_2_WolfDefeated == 1) {
            ui.choiceButtonPanel.setVisible(false);
            ui.continueButtonPanel.setVisible(true);

            ui.mainTextArea.setText("You walk past the defeated wolf.");

            ui.image = new ImageIcon(".//res//great_woods.png"); // change to defeated wolf
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);

            game.continuePosition = "greatWoodsEntrance_6_NarrowPath_3";
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceOne.setVisible(false);

            ui.mainTextArea.setText("Fortunately, this was for the best...");
            greatWoodsEntrance_6_NarrowPath_2_Wolf = new MonsterWolf("greatWoodsEntrance_6_NarrowPath_2_Wolf");

            ui.image = new ImageIcon(".//res//great_woods_entrance_with_wolf.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);

            ui.choiceTwo.setText("Examine foe");
            ui.choiceThree.setText("Start the battle");
            ui.choiceFour.setText("Run");
            game.nextPositionTwo = "examine_greatWoodsEntrance_6_NarrowPath_2_Wolf";
            game.nextPositionThree = "fight_greatWoodsEntrance_6_NarrowPath_2_Wolf";
            game.nextPositionFour = "greatWoodsEntrance_5";
        }

    }

    public void greatWoodsEntrance_6_NarrowPath_3() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_6_NarrowPath_3";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Hopefully no more surprise attacks on this narrow path.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_6_NarrowPath_4";
    }

    public void greatWoodsEntrance_6_NarrowPath_4() {
        playerLocation = "greatWoodsEntrance";
        game.story.playerFightLocationHelper = "greatWoodsEntrance_6_NarrowPath_4";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("After a while the path ends and you see a cave entrance in front of you.");
        //todo: add an image of a cave that you're about to enter.

        ui.choiceThree.setText("Enter the cave (might be dangerous!)");
        ui.choiceFour.setText("Return to crossroad");

        game.story.greatWoodsEntranceToCaveDiscovered = true;

        game.nextPositionThree = "greatWoodsEntranceCave";
        game.nextPositionFour = "startingZone_7";
    }
}
