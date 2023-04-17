package LostCause.GameEngine;

import javax.swing.*;

public class GoblinVillageEntrance extends Story{

    public GoblinVillageEntrance(Game g, UI userInterface, VisibilityManager vManager) {
        super(g, userInterface, vManager);
    }

    public void goblinVillageEntrance() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You have been following the narrow path to the west for almost an hour.\n" +
                "The eerie feeling is intensifying, more and more strange noises are surrounding you. ");

        ui.image = new ImageIcon(".//res//narrowForestPath.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_2";

    }

    public void goblinVillageEntrance_2() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("You approach a primitive gate made out of wood.\n" +
                "The design is not the best, ugly to be frank, but it sure looks sturdy enough.");

        ui.image = new ImageIcon(".//res//goblinVillageEntranceNoGoblin.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.choiceTwo.setText("Knock the gate");
        game.nextPositionTwo = "goblinVillageEntrance_3";
        ui.choiceThree.setText("Try to climb the gate");
        game.nextPositionThree = "goblinVillageEntrance_2_ClimbGate";
        ui.choiceFour.setText("Return to crossroad");
        game.nextPositionFour = "startingZone_7";

        game.continuePosition = "goblinVillageEntrance_3";

    }

    public void goblinVillageEntrance_2_ClimbGate() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You are beginning to think that it is not the best idea that you've ever come up with.\n" +
                "Yet you try to climb up as if were born to do this.");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_2_ClimbGate_2";


    }

    public void goblinVillageEntrance_2_ClimbGate_2() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("""
                As your tired body refused to let you hold a better grip, you fall down...
                Your fall did sure get someone's attention.
                (you take 3 damage)""");

        game.story.player.hp -= 3;
        ui.healthNumberLabel.setText("" + game.story.player.hp);
        ui.continueButton.setText("Try to get up");

        game.continuePosition = "goblinVillageEntrance_3";
    }

    public void goblinVillageEntrance_3() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Goblin guard: Oi, who goes 'ere? What do you want, 'uman? Speak business or me shoot you in the knee! \n" +
                "*The goblin was holding its bow while waiting for a reply.*");

        ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_4";
    }

    public void goblinVillageEntrance_4() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("*After telling the goblin how you ended up like this, the goblin replied...*\n" +
                "Goblin guard: This is some gibberish story, 'uman. 'owever i can let you in, if you 'elp in a certain matter.");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_5";
    }

    public void goblinVillageEntrance_5() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Goblin guard: You see.. I've recently lost me prized trinket - a silver ring which was meant for me wifey\n" +
                "Get that ring for me and I'll grant you passage to our village, 'uman. Look for it in the Great Forest!");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_6";
    }

    public void goblinVillageEntrance_6() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("""
                Goblin guard: Now begone!
                *The goblin hides his head and apparently decides to take a nap from the tiresome dialogue*
                Goblin guard:...I've important guard business to attend to.""");

        ui.image = new ImageIcon(".//res//goblinVillageEntranceNoGoblin.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);


        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_7";
    }

    public void goblinVillageEntrance_7() {
        playerLocation = "goblinVillageEntrance";
        game.story.goblinVillageEntranceDiscovered = true;
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("""
                The gate is empty, apparently the goblin guard has fallen asleep...""");

        ui.image = new ImageIcon(".//res//goblinVillageEntranceNoGoblin.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        if (game.story.goblinVillageEntranceGuardSilverRingDiscovered) {
            ui.choiceTwo.setVisible(true);
            ui.choiceTwo.setText("Show the silver ring");
            game.nextPositionTwo = "goblinVillageEntrance_8_SilverRingDialogue";
        }
        if (game.story.goblinVillageEntranceGuardBugged < 4) {
            ui.choiceThree.setText("Draw the goblin's attention");
            game.nextPositionThree = "goblinVillageEntrance_7_GuardBugged";
        } else if (game.story.goblinVillageEntranceGuardBugged == 4) {
            ui.choiceThree.setText("See what happens...");
            game.nextPositionThree = "goblinVillageEntrance_7_GuardBugged";
        } else {
            ui.choiceThree.setText("");
            game.nextPositionThree = "";
        }

        ui.choiceFour.setText("Return to crossroad");
        game.nextPositionFour = "startingZone_7";

    }

    public void goblinVillageEntrance_7_GuardBugged() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (game.story.goblinVillageEntranceGuardBugged < 3) {
            ui.mainTextArea.setText("The goblin appears to be already sleeping and does not care.");
        } else if (game.story.goblinVillageEntranceGuardBugged == 3) {
            ui.mainTextArea.setText("Goblin guard: Oi, me going to shoot you in the knee! Stop that, 'uman!");
            ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);
        } else {
            ui.mainTextArea.setText("Goblin guard: You asked for it!\n" +
                    "*You get hit by the arrow and suffer 5 damage*");
            game.story.player.hp -= 5;
            ui.healthNumberLabel.setText("" + game.story.player.hp);
            ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);


        }

        game.story.goblinVillageEntranceGuardBugged += 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_7";
    }

    public void goblinVillageEntrance_8_SilverRingDialogue() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("Goblin guard: Well, it's about time you've gotten back, 'uman! Do I think what I really think it is!?\n" +
                "Blimey! It sure is me lost ring!");

        ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_8_SilverRingDialogue_2";

        game.itemInventory.remove(game.questItemSilverRing);

    }

    public void goblinVillageEntrance_8_SilverRingDialogue_2() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Goblin guard: Now then, a deal is a deal and I promised to grant you passage to our village, 'uman.\n" +
                "Don't stray away and get yourself lost in the slums, nasty place... Eugh!");

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_8_SilverRingDialogue_3";
    }

    public void goblinVillageEntrance_8_SilverRingDialogue_3() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("Goblin guard: If you feel pretty confident in yourself, you might as well talk to our chief Bizwalk.\n" +
                "He might provide you with some interesting tasks in your spare time");

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_8_SilverRingDialogue_4";
    }

    public void goblinVillageEntrance_8_SilverRingDialogue_4() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("""
                Goblin guard: Ai, before you depart, I want you to 'ave this leather armor, that I got me 'ands on some time ago.
                You sure 'ave earned your right to wear it. Now off with you, guarding requires keeping me eyes open all the time.
                (you receive a piece of leather chest armor)""");
        game.itemInventory.add(game.leatherChestArmor);

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_8_SilverRingDialogue_5";
    }

    public void goblinVillageEntrance_8_SilverRingDialogue_5() {
        playerLocation = "goblinVillageEntrance";
        worldMapLocationDeterminerHelper();

        ui.mainTextArea.setText("The goblin opens the gate for you and then disappears behind some sort of boxes, apparently willing to take a nap again...");

        ui.continueButton.setText("Continue");
        //game.continuePosition = "goblinVillageMainSquare";
        game.continuePosition = "startingZone_7";
    }
}
