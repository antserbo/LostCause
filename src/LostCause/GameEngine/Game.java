package LostCause.GameEngine;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPositionOne, nextPositionTwo, nextPositionThree, nextPositionFour, continuePosition;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();


    }
}
