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
            /*case "inventory" -> {
                // also call the inventory function that is going to make sure that the #pages == #items
                if (game.inventoryStatus.equals("closed")) {
                    game.ui.choiceButtonPanel.setVisible(false);
                    game.ui.inventoryPanelItemButtons.setVisible(true);
                    game.ui.inventoryPanelPageButtons.setVisible(true);
                    game.inventoryStatus = "opened";
                } else if (game.inventoryStatus.equals("opened")) {
                    game.ui.choiceButtonPanel.setVisible(true);
                    game.ui.inventoryPanelItemButtons.setVisible(false);
                    game.ui.inventoryPanelPageButtons.setVisible(false);
                    game.inventoryStatus = "closed";
                };
            }*/

        }
    }
}
