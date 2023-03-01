package LostCause.GameEngine;

import LostCause.MonsterFiles.MonsterWolf;

import javax.swing.*;

public class GreatWoodsEntrance extends Story{

    public GreatWoodsEntrance(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void greatWoodsEntrance() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (greatWoodsEntrance_6_Discovered) {
            ui.mainTextArea.setText("You decide to increase your tempo.\n" +
                    "Some time later you walk past the killed wolf.");

            ui.continueButton.setText("Continue");
            game.continuePosition = "greatWoodsEntrance_5";
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
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("This is the first time you have ever seen something so wild, but yet calming.\n" +
                "It feels like the Great Woods is a world of its own, with its own laws and time.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_3";
    }

    public void greatWoodsEntrance_3() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Tales of this place have been passed through dozens of generations.\n" +
                "The almighty nature is to be feared, yet praised for its beauty.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_4";
    }

    public void greatWoodsEntrance_4() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        if (game.story.greatWoodsEntrance_4_WolfDefeated == 1) {
            ui.choiceButtonPanel.setVisible(false);
            ui.continueButtonPanel.setVisible(true);

            ui.mainTextArea.setText("You walk past the defeated wolf.");

            ui.image = new ImageIcon(".//res//great_woods.png"); // change to defeated wolf
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);

            game.continuePosition = "greatWoodsEntrance_5";
        } else {
            ui.choiceButtonPanel.setVisible(true);
            ui.continueButtonPanel.setVisible(false);
            ui.choiceOne.setVisible(false);

            ui.mainTextArea.setText("You ponder for quite a while...\n" +
                    "When all of a sudden you are startled by a hungry wolf.");
            greatWoodsEntrance_4_Wolf = new MonsterWolf("greatWoodsEntrance_4_Wolf");

            // todo: maybe add an option where the player can examine the foe they're fighting, so you could predict the max hit.

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
    }

    public void greatWoodsEntrance_5() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("You traverse deeper into the Great Woods and see a small river to the right.\n" +
                "The water looks so clear, it must be coming right from that mountain with its top covered in snow");

        game.story.greatWoodsEntrance_6_Discovered = true;

        ui.image = new ImageIcon(".//res//great_woods.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        if (game.story.greatWoodsEntrance_5_RiverDrinks < 2) { // TODO: take a look, maybe you don't want that... so you could heal later
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
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        // todo: review this function for later, because the player's base hp might increase over time.
        if (game.story.greatWoodsEntrance_5_RiverDrinks < 2) {
            game.story.greatWoodsEntrance_5_RiverDrinks += 1;
            if (game.story.player.hp <= 10) {
                game.story.player.hp += 5;
                ui.mainTextArea.setText("""
                        You drink water from the river and feel better.

                        (you get healed by 5 HP)""");

                ui.healthNumberLabel.setText("" + game.story.player.hp);
            } else if (game.story.player.hp < 15) {
                int currentHP = game.story.player.hp;
                game.story.player.hp = 15;
                int differenceHP = game.story.player.hp - currentHP;

                // TODO : display the right amount of heal when you're less than 3hp away from max hp (done*)
                ui.mainTextArea.setText("You drink the river's water and feel better.\n\n" +
                        "(you get healed by " + differenceHP + " HP)");
                ui.healthNumberLabel.setText("" + game.story.player.hp);
            } else {
                ui.mainTextArea.setText("""
                        You drink water from the river, but feel no effect.

                        (current hp is maximum)""");
            }
        } else {
            ui.mainTextArea.setText("You have already drunk several times, your stomach is full...");
        }

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_5";
    }


    public void greatWoodsEntrance_6() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(true);
        ui.continueButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You follow the road and then see a narrow path to the left from the road.");

        ui.choiceTwo.setText("Continue walking the road");

        if (game.story.greatWoodsEntranceToCaveDiscovered) {
            ui.choiceThree.setText("Go to cave");
            game.nextPositionThree = "greatWoodsEntrance_Cave";
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
        game.story.greatWoodsEntranceDiscovered = true;
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("However, negative thoughts should not crawl into your head, as you are sure destined for something great.\n" +
                "Taking several deep breaths in a row puts your mind at ease and you continue through this never-ending forest.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_7"; // todo: check for zone check to *GreatWoodsMainArea*

    }

    public void greatWoodsEntrance_6_NarrowPath() {
        playerLocation = "greatWoodsEntrance";
        worldMapLocationDeterminerHelper();

        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);
        // todo: add an image of a narrow path that you're walking to the cave.

        ui.mainTextArea.setText("The narrow path does not really allow you to see much in front of you due to constant turns.\n" +
                "For a reason you sharpen your senses, as you await danger lurking not far.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_6_NarrowPath_2";

    }

    public void greatWoodsEntrance_6_NarrowPath_2() { // todo: edit the working image and also check for other stuff if needed
        playerLocation = "greatWoodsEntrance";
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

            // todo: check the presence of .add by labels to panels, because i don't need it, only set. it's already in the UI class


            ui.choiceTwo.setText("Examine foe");
            ui.choiceThree.setText("Start the battle");
            ui.choiceFour.setText("Run");
            game.nextPositionTwo = "examine_greatWoodsEntrance_6_NarrowPath_2_Wolf";
            game.nextPositionThree = "fight_greatWoodsEntrance_6_NarrowPath_2_Wolf";
            game.nextPositionFour = "startingZone_7";
        }

    }

    public void greatWoodsEntrance_6_NarrowPath_3() {
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Hopefully no more surprise attacks on this narrow path.");

        ui.continueButton.setText("Continue");
        game.continuePosition = "greatWoodsEntrance_6_NarrowPath_4";
    }

    public void greatWoodsEntrance_6_NarrowPath_4() {
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
