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
            case "start":
                game.vm.showGameScreen();
                // game.story.startingZone();
                game.story.waterfallZone();
                break;
            case "map":
                game.ui.createWorldMap(game);
                break;
            case "continue":
                game.story.selectPosition(game.continuePosition);
                break;
            case "c1":
                game.story.selectPosition(game.nextPositionOne);
                break;
            case "c2":
                game.story.selectPosition(game.nextPositionTwo);
                break;
            case "c3":
                game.story.selectPosition(game.nextPositionThree);
                break;
            case "c4":
                game.story.selectPosition(game.nextPositionFour);
                break;

        }
    }
}
