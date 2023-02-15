package LostCause.GameEngine;

import LostCause.GameFiles.Player;

import javax.swing.*;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;

    Player player = new Player();

    int waterfallSkeletonWeaponTaken = 0;
    int waterfallSkeletonTimesSearched = 0;
    int waterfallSkeletonAmuletTaken = 0;
    int goblinVillageEntranceGuardSilverRing = 0;
    int goblinVillageEntranceGuardBugged = 0;
    boolean waterfallZoneDiscovered = false;
    boolean goblinVillageEntranceDiscovered = false;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {

        player.hp = 15;
        player.weapon = "Fists";

    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition) {

            case "startingZone_2" -> startingZone_2();
            case "startingZone_3" -> startingZone_3();
            case "startingZone_4" -> startingZone_4();
            case "startingZone_5" -> startingZone_5();
            case "startingZone_6" -> startingZone_6();
            case "startingZone_7" -> startingZone_7();
            case "waterfallZone" -> waterfallZone();
            case "waterfallZone_2" -> waterfallZone_2();
            case "waterfallZone_2_WeaponTake" -> waterfallZone_2_WeaponTake();
            case "waterfallZone_2_SearchSkeleton_Success" -> waterfallZone_2_SearchSkeleton_Success();
            case "waterfallZone_2_SearchSkeleton_Failure" -> waterfallZone_2_SearchSkeleton_Failure();
            case "waterfallZone_3" -> waterfallZone_3();
            case "waterfallZone_3_DrinkWater" -> waterfallZone_3_DrinkWater();
            case "goblinVillageEntrance" -> goblinVillageEntrance();
            case "goblinVillageEntrance_2" -> goblinVillageEntrance_2();
            case "goblinVillageEntrance_2_ClimbGate" -> goblinVillageEntrance_2_ClimbGate();
            case "goblinVillageEntrance_2_ClimbGate_2" -> goblinVillageEntrance_2_ClimbGate_2();
            case "goblinVillageEntrance_3" -> goblinVillageEntrance_3();
            case "goblinVillageEntrance_4" -> goblinVillageEntrance_4();
            case "goblinVillageEntrance_5" -> goblinVillageEntrance_5();
            case "goblinVillageEntrance_6" -> goblinVillageEntrance_6();
            case "goblinVillageEntrance_6_GuardBugged" -> goblinVillageEntrance_6_GuardBugged();

        }
    }

    public void startingZone() {
        ui.mainTextArea.setText("You wake up to the noise of the waterfall in the distance.\n" +
                "The only vague memory you have is of your name, despite the aching body you try to get up...");

        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_2";


    }

    public void startingZone_2() {
        ui.mainTextArea.setText("With legs trembling you somehow manage to stand up.\n" +
                "No idea how you ended up in this place. However, you need to act...");


        ui.continueButton.setText("Look around");

        game.continuePosition = "startingZone_3";

    }

    public void startingZone_3() {
        ui.mainTextArea.setText("After looking around you determine that to your right there is a waterfall in the distance.");


        ui.continueButton.setText("Continue");

        game.continuePosition = "startingZone_4";

    }

    public void startingZone_4() {
        ui.mainTextArea.setText("Beside you there is a dead-end, fallen trees are blocking the southern route.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_5";
    }

    public void startingZone_5() {
        ui.mainTextArea.setText("To your left lies a narrow path, which gives you an eerie feeling.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_6";

    }

    public void startingZone_6() {
        ui.mainTextArea.setText("The northern direction introduces a road which leads deeper into the forest.");


        ui.continueButton.setText("Continue");
        game.continuePosition = "startingZone_7";


    }

    public void startingZone_7() {
        // TODO: add location names once discovered. Once you get to the end of waterfall, f.e., you no longer see "go west", rather "to / waterfall"
        ui.continueButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(true);
        ui.choiceOne.setVisible(true);
        ui.choiceTwo.setVisible(true);

        ui.image = new ImageIcon(".//res//crossroad.jpg");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.mainTextArea.setText("Where do you want to go?");


        ui.choiceOne.setText("Go north");
        if (waterfallZoneDiscovered) {
            ui.choiceTwo.setText("To waterfall");
        } else {
            ui.choiceTwo.setText("Go east");
        }
        ui.choiceThree.setText("Go south");
        if (goblinVillageEntranceDiscovered) {
            ui.choiceFour.setText("To Goblin Village Entrance");
        } else {
            ui.choiceFour.setText("Go west");
        }


        game.nextPositionOne = "fromStartingZoneNorth";
        game.nextPositionTwo = "waterfallZone";
        game.nextPositionThree = "fromStartingZoneSouth";
        game.nextPositionFour = "goblinVillageEntrance";

    }

    public void waterfallZone() {
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You enter a secluded area with a waterfall.");

        ui.image = new ImageIcon(".//res//waterfall.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);

        ui.continueButton.setText("Look around");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2() {
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);

        ui.mainTextArea.setText("Your eye catches a resting skeleton of a long-forgotten adventurer.\n" +
                "Even though the skeleton's been resting for quite some time, the equipment might prove useful.");

        if (waterfallSkeletonWeaponTaken == 0) {
            ui.choiceTwo.setText("Take weapon");
            game.nextPositionTwo = "waterfallZone_2_WeaponTake";
        } else {
            ui.choiceTwo.setText("");
            game.nextPositionTwo = "";
        }

        if (waterfallSkeletonAmuletTaken == 0 && waterfallSkeletonTimesSearched < 3) {
            int waterfallSkeletonAmuletChance = new java.util.Random().nextInt(3);
            ui.choiceThree.setText("Search skeleton");
            if (waterfallSkeletonAmuletChance == 2) {
                game.nextPositionThree = "waterfallZone_2_SearchSkeleton_Success";
            } else {
                game.nextPositionThree = "waterfallZone_2_SearchSkeleton_Failure";
            }
        } else {
            ui.choiceThree.setText("");
            game.nextPositionThree = "";
        }

        if (((waterfallSkeletonAmuletTaken == 1) || (waterfallSkeletonTimesSearched > 2)) && waterfallSkeletonWeaponTaken == 1) {
            ui.mainTextArea.setText("There is nothing left to loot from the skeleton's remains.");
        }

        ui.choiceFour.setText("Leave skeleton");
        game.nextPositionFour = "waterfallZone_3";
    }

    public void waterfallZone_2_WeaponTake() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a rusty iron long sword!");
        waterfallSkeletonWeaponTaken = 1;

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";

    }

    public void waterfallZone_2_SearchSkeleton_Success() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        ui.mainTextArea.setText("You have found a peculiar amulet!");
        waterfallSkeletonAmuletTaken = 1;

        ui.continueButton.setText("Continue");

        game.continuePosition = "waterfallZone_2";
    }

    public void waterfallZone_2_SearchSkeleton_Failure() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (waterfallSkeletonTimesSearched < 2) {
            ui.mainTextArea.setText("You have failed in searching the skeleton.");
        } else {
            ui.mainTextArea.setText("The skeleton has crumbled to dust and searching it is not possible anymore");
        }
        waterfallSkeletonTimesSearched += 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "waterfallZone_2";
    }

    public void waterfallZone_3() {
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceOne.setVisible(false);
        waterfallZoneDiscovered = true;

        ui.mainTextArea.setText("You step closer to the waterfall. \n" +
                "The sound of it makes you feel some sort of relief...");

        ui.choiceTwo.setText("Drink water");
        game.nextPositionTwo = "waterfallZone_3_DrinkWater";


        ui.choiceThree.setText("Meditate (save)");
        game.nextPositionThree = "waterfallZone_3_Meditate";


        ui.choiceFour.setText("Head back");
        game.nextPositionFour = "startingZone_7";


    }

    public void waterfallZone_3_DrinkWater() {
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        if (player.hp < 15) {
            ui.mainTextArea.setText("""
                    You take a sip of water and a rejuvenating effect rushes though your body

                    (you get healed by 3 HP)""");
        } else {
            ui.mainTextArea.setText("""
                    You take a sip of water, but it does not affect you in any possible way.

                    (current hp is maximum)""");
        }

        ui.continueButton.setText("Stop drinking");
        game.continuePosition = "waterfallZone_3";

    }

    public void goblinVillageEntrance() {
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
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("You are beginning to think that it is not the best idea that you've ever come up with.\n" +
                "Yet you try to climb up as if were born to do this.");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_2_ClimbGate_2";


    }

    public void goblinVillageEntrance_2_ClimbGate_2() {

        ui.mainTextArea.setText("""
                As your tired body refused to let you hold a better grip, you fall down...
                Your fall did sure get someone's attention.
                (you take 3 damage)""");

        player.hp -= 3;
        // add to label of hp
        ui.continueButton.setText("Try to get up");

        game.continuePosition = "goblinVillageEntrance_3";
    }

    public void goblinVillageEntrance_3() {
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
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("*After telling the goblin how you ended up like this, the goblin replied...*\n" +
                "Goblin guard: This is some gibberish story, 'uman. 'owever i can let you in, if you 'elp in a certain matter.");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_5";
    }

    public void goblinVillageEntrance_5() {
        ui.continueButtonPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

        ui.mainTextArea.setText("Goblin guard: You see.. I've recently lost me prized trinket - a silver ring which was meant for me wifey\n" +
                "Get that ring for me and I'll grant you passage to our village, 'uman. Look for it in the Great Forest!");

        ui.continueButton.setText("Continue");

        game.continuePosition = "goblinVillageEntrance_6";
    }

    public void goblinVillageEntrance_6() {
        ui.choiceButtonPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(false);
        ui.choiceTwo.setVisible(false);

        ui.mainTextArea.setText("""
                Goblin guard: Now begone!
                *The goblin hides his head and apparently decides to take a nap from the tiresome dialogue*
                Goblin guard:...I've important guard business to attend to.""");

        ui.image = new ImageIcon(".//res//goblinVillageEntranceNoGoblin.png");
        ui.imageLabel.setIcon(ui.image);
        ui.mainImagePanel.add(ui.imageLabel);


        if (goblinVillageEntranceGuardBugged < 6) {
            ui.choiceThree.setText("Draw the goblin's attention");
            game.nextPositionThree = "goblinVillageEntrance_6_GuardBugged";
        } else if (goblinVillageEntranceGuardBugged == 6) {
            ui.choiceThree.setText("See what happens...");
            game.nextPositionThree = "goblinVillageEntrance_6_GuardBugged";
        } else {
            ui.choiceThree.setText("");
            game.nextPositionThree = "";
        }

        ui.choiceFour.setText("Return to crossroad");
        game.nextPositionFour = "startingZone_7";
    }

    public void goblinVillageEntrance_6_GuardBugged() {
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(true);

        if (goblinVillageEntranceGuardBugged < 5) {
            ui.mainTextArea.setText("The goblin appears to be already sleeping and does not care.");
        } else if (goblinVillageEntranceGuardBugged == 5) {
            ui.mainTextArea.setText("Goblin guard: Oi, me going to shoot you in the knee! Stop that, 'uman!");
            ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);
        } else {
            ui.mainTextArea.setText("Goblin guard: You asked for it!\n" +
                    "*You get hit by the arrow and suffer 5 damage*");
            player.hp -= 5;
            ui.image = new ImageIcon(".//res//goblinVillageEntrance.png");
            ui.imageLabel.setIcon(ui.image);
            ui.mainImagePanel.add(ui.imageLabel);


        }

        goblinVillageEntranceGuardBugged += 1;

        ui.continueButton.setText("Continue");
        game.continuePosition = "goblinVillageEntrance_6";
    }
}
