package LostCause.GameEngine;

import java.awt.*;
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
                //game.greatWoodsEntrance.greatWoodsEntrance_6_NarrowPath_4();
                //game.startingZone.startingZone7();
                game.greatWoodsEntranceCave.greatWoodsEntranceCave();
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

                if (game.inventoryMainStatus.equals("closed") && game.inventoryStatus.equals("opened")) {

                    game.ui.inventoryWindowPanel.setVisible(true);
                    game.ui.inventoryWeaponPanel.setVisible(true);
                    game.ui.inventoryWeaponTypeLabel.setVisible(true);
                    game.ui.inventoryArmorBodyPanel.setVisible(true);
                    game.ui.inventoryArmorBodyTypeLabel.setVisible(true);
                    game.ui.inventoryArmorShieldPanel.setVisible(true);
                    game.ui.inventoryArmorShieldTypeLabel.setVisible(true);
                    game.ui.inventoryAmuletRingPanel.setVisible(true);
                    game.ui.inventoryAmuletRingTypeLabel.setVisible(true);
                    game.ui.inventoryItemPanel.setVisible(true);
                    game.ui.inventoryItemTypeLabel.setVisible(true);
                    game.ui.inventoryQuestItemPanel.setVisible(true);
                    game.ui.inventoryQuestItemLabel.setVisible(true);

                    System.out.println(game.itemInventory.contains(game.longSword));
                    System.out.println(game.itemInventory.contains(game.ass));
                    if (game.itemInventory.contains(game.longSword)) {
                        game.ui.weaponLongSwordButton.setVisible(true);
                    }
                    System.out.println(game.itemInventory.contains(game.leatherChestArmor));
                    if (game.itemInventory.contains(game.leatherChestArmor)) {
                        game.ui.armorBodyLeatherArmorButton.setVisible(true);
                    }

                    /*if (game.story.goblinSkeletonWeaponTaken == 1) {
                        game.ui.weaponStilettoButton.setVisible(true);
                    }*/

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

                    game.ui.inventoryWindowPanel.setVisible(false);
                    game.ui.inventoryWeaponPanel.setVisible(false);
                    game.ui.inventoryWeaponTypeLabel.setVisible(false);
                    game.ui.inventoryArmorBodyPanel.setVisible(false);
                    game.ui.inventoryArmorBodyTypeLabel.setVisible(false);
                    game.ui.inventoryArmorShieldPanel.setVisible(false);
                    game.ui.inventoryArmorShieldTypeLabel.setVisible(false);
                    game.ui.inventoryAmuletRingPanel.setVisible(false);
                    game.ui.inventoryAmuletRingTypeLabel.setVisible(false);
                    game.ui.inventoryItemPanel.setVisible(false);
                    game.ui.inventoryItemTypeLabel.setVisible(false);
                    game.ui.inventoryQuestItemPanel.setVisible(false);
                    game.ui.inventoryQuestItemLabel.setVisible(false);

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

            // todo: solve cases where only button should remain green and others should be turned dark_gray
            case "weaponLongSword" -> {
                if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)){
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = "Long Sword";
                    game.ui.weaponNameLabel.setText("Long sword");
                } else if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)) {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = "Long Sword";
                    game.ui.weaponNameLabel.setText("Long sword");
                } else if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)) {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = "Long Sword";
                    game.ui.weaponNameLabel.setText("Long sword");
                } else {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.story.player.weapon = game.longSword.name;
                    game.ui.weaponNameLabel.setText(game.longSword.name);
                    game.ui.weaponNameLabel.setToolTipText(
                            "<html>Damage: <font color=red>" + game.longSword.minDamage + "-" + game.longSword.maxDamage +
                                    "</font><br>Class: " + game.longSword.weaponType + "</html>");
                }

            }

            case "weaponStiletto" -> {
                game.ui.weaponStilettoButton.setBackground(Color.green);
                game.story.player.weapon = "Stiletto";
                game.ui.weaponNameLabel.setText("Stiletto");

            }

            case "leatherChestArmor" -> {
                if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)){
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorChest = game.leatherChestArmor.name;
                    game.ui.armorChestNameLabel.setText(game.leatherChestArmor.name);
                } else {
                    game.ui.armorBodyLeatherArmorButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorChest = game.leatherChestArmor.name;
                    game.ui.armorChestNameLabel.setText(game.leatherChestArmor.name);
                }
            }
        }
    }
}
