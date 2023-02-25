package LostCause.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {

    Game game;

    public ChoiceHandler(Game g) {
        game = g;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String yourChoice = event.getActionCommand();

        switch (yourChoice) {
            case "start" -> {
                game.vm.showGameScreen();
                //game.story.greatWoodsEntrance_4();
                game.startingZone.startingZone_7();
            }
            case "map" -> game.ui.createWorldMap(game);
            case "continue" -> game.story.selectPosition(game.continuePosition);
            case "c1" -> game.story.selectPosition(game.nextPositionOne);
            case "c2" -> game.story.selectPosition(game.nextPositionTwo);
            case "c3" -> game.story.selectPosition(game.nextPositionThree);
            case "c4" -> game.story.selectPosition(game.nextPositionFour);
            case "inventory" -> {
                // also call the inventory function that is going to make sure that the #pages == #items
                if (game.inventoryStatus.equals("closed") && game.ui.choiceButtonPanel.isVisible()) {
                    game.ui.choiceButtonPanel.setVisible(false);
                    game.ui.inventoryPanelItemButtons.setVisible(true);
                    game.ui.inventoryPanelPageButton.setVisible(true);
                    game.inventoryStatus = "opened";
                } else if (game.inventoryStatus.equals("opened") && !game.ui.choiceButtonPanel.isVisible()) {
                    game.ui.choiceButtonPanel.setVisible(true);
                    game.ui.inventoryPanelItemButtons.setVisible(false);
                    game.ui.inventoryPanelPageButton.setVisible(false);
                    game.inventoryStatus = "closed";
                }
            }

            // todo: check what should be done here. also check whether continueButtonPanel or choiceButtonPanel are active, so that inventory does not break the UI
            case "inventoryPageMain" -> {
                System.out.println("Hi my beloved");
                if (game.inventoryMainStatus.equals("closed") && game.inventoryStatus.equals("opened")) {
                    System.out.println("we are legion");
                    game.ui.inventoryPanelItemButtons.setVisible(false);
                    game.ui.inventoryPanelPageButton.setVisible(true);
                    game.ui.utilityLabelPanel.setVisible(false);
                    game.ui.utilityIconPanel.setVisible(false);
                    game.ui.inventoryWindowPanel.setVisible(true);
                    game.ui.mainImagePanel.setVisible(false);
                    game.ui.equipmentIconPanel.setVisible(false);
                    game.ui.iconLabelPanel.setVisible(false);
                    game.ui.mainTextPanel.setVisible(false);
                    game.ui.inventoryPageMainButton.setText("Return back");
                    game.inventoryMainStatus = "opened";
                } else if (game.inventoryMainStatus.equals("opened") && game.inventoryStatus.equals("opened")) {
                    System.out.println("we are great");
                    game.ui.inventoryPanelItemButtons.setVisible(true);
                    game.ui.inventoryPanelPageButton.setVisible(true);
                    game.ui.utilityLabelPanel.setVisible(true);
                    game.ui.utilityIconPanel.setVisible(true);
                    game.ui.inventoryWindowPanel.setVisible(false);
                    game.ui.mainImagePanel.setVisible(true);
                    game.ui.equipmentIconPanel.setVisible(true);
                    game.ui.iconLabelPanel.setVisible(true);
                    game.ui.mainTextPanel.setVisible(true);
                    game.ui.inventoryPageMainButton.setText("Inventory page");
                    game.inventoryMainStatus = "closed";
                }
            }

        }
    }
}
