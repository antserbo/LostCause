package LostCause.GameEngine;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }

    public void showTitleScreen() {
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.utilityIconPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.continueButtonPanel.setVisible(false);
        ui.equipmentIconPanel.setVisible(false);
        ui.iconLabelPanel.setVisible(false);
        ui.utilityLabelPanel.setVisible(false);
        ui.mainImagePanel.setVisible(false);
        ui.inventoryPanelItemButtons.setVisible(false);
        ui.inventoryPanelPageButton.setVisible(false);
    }

    public void showGameScreen() {
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.utilityIconPanel.setVisible(true);
        ui.continueButtonPanel.setVisible(true);
        ui.equipmentIconPanel.setVisible(true);
        ui.iconLabelPanel.setVisible(true);
        ui.mainImagePanel.setVisible(true);
        ui.utilityLabelPanel.setVisible(true);
        ui.inventoryPanelItemButtons.setVisible(false);
        ui.inventoryPanelPageButton.setVisible(false);

        ui.frameOfMainTextPanelTop.setVisible(true);
        ui.frameOfMainTextPanelRight.setVisible(true);
        ui.frameOfMainTextPanelBottom.setVisible(true);
        ui.frameOfMainTextPanelLeft.setVisible(true);
    }

}
