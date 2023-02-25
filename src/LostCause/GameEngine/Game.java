package LostCause.GameEngine;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    // todo: for interections with player in location classes use game.story.player! as an interesting item - scythe of peril (-1hp, +50% damage)

    StartingZone startingZone = new StartingZone(this, ui, vm);
    WaterfallZone waterfallZone = new WaterfallZone(this, ui, vm);
    GreatWoodsEntrance greatWoodsEntrance = new GreatWoodsEntrance(this, ui, vm);
    GoblinVillageEntrance goblinVillageEntrance = new GoblinVillageEntrance(this, ui, vm);

    String nextPositionOne, nextPositionTwo, nextPositionThree, nextPositionFour, continuePosition;
    String inventoryStatus, inventoryMainStatus;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();

    }
}
