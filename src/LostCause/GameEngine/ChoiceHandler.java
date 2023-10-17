package LostCause.GameEngine;

import javax.swing.*;
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
                //game.startingZone.startingZone_7();
                //game.greatWoodsEntranceCave.greatWoodsEntranceCave();
                game.startingZone.startingZone();
                //game.greatWoodsEntranceCaveLair.greatWoodsEntranceCaveLair();
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

            case "inventoryItemOne" -> {
                if (game.ui.inventoryItemOneButton.getBackground().equals(Color.green)) {
                    game.magicalChalice.chaliceHealing(game.story.player);
                    if (game.magicalChalice.healthRestoration + game.story.player.hp >= game.story.player.maxHP) {
                        game.story.player.hp = game.story.player.maxHP;
                    } else {
                        game.story.player.hp += game.magicalChalice.healthRestoration;
                    }
                    game.ui.healthNumberLabel.setText("" + game.story.player.hp);
                    game.ui.inventoryItemOneButton.setBackground(Color.DARK_GRAY);
                    game.story.magicalChaliceAvailability = false;
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

                    //System.out.println(game.itemInventory.contains(game.longSword));
                    if (game.itemInventory.contains(game.longSword)) {
                        game.ui.weaponLongSwordButton.setVisible(true);
                    }
                    // System.out.println(game.itemInventory.contains(game.leatherChestArmor));
                    if (game.itemInventory.contains(game.leatherChestArmor)) {
                        game.ui.armorBodyLeatherArmorButton.setVisible(true);
                    }

                    if (game.itemInventory.contains(game.amuletRingShell)) {
                        game.ui.shellAmuletButton.setVisible(true);
                    }

                    if (game.itemInventory.contains(game.magicalChalice)) {
                        game.ui.armorShieldBronzeShieldButton.setVisible(true);
                    }

                    if (game.itemInventory.contains(game.questItemSilverRing)) {
                        game.ui.questItemSilverRingButton.setVisible(true);
                    } else {
                        game.ui.questItemSilverRingButton.setVisible(false);
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
                    game.ui.frameOfMainTextPanelBottom.setVisible(false);
                    game.ui.frameOfMainTextPanelLeft.setVisible(false);
                    game.ui.frameOfMainTextPanelTop.setVisible(false);
                    game.ui.frameOfMainTextPanelRight.setVisible(false);
                    game.ui.inventoryPageMainButton.setText("Return back");
                    game.inventoryMainStatus = "opened";

                    //todo: introduce the buttons names through objects -> play with the length and adjust the right fonts
                    //game.ui.shellAmuletButton.setText(game.amuletRingShell.name);

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
                    game.ui.frameOfMainTextPanelBottom.setVisible(true);
                    game.ui.frameOfMainTextPanelLeft.setVisible(true);
                    game.ui.frameOfMainTextPanelTop.setVisible(true);
                    game.ui.frameOfMainTextPanelRight.setVisible(true);
                    game.ui.inventoryPageMainButton.setText("Inventory page");
                    game.inventoryMainStatus = "closed";
                }
            }

            // todo: solve cases where only button should remain green and others should be turned dark_gray
            case "weaponLongSword" -> {
                if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)){
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = game.longSword;
                    game.ui.weaponNameLabel.setText(game.story.player.weapon.name);
                    game.ui.weaponNameLabel.setToolTipText(game.longSword.getWeaponDescription());
                } else if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)) {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = game.longSword;
                    game.ui.weaponNameLabel.setText(game.story.player.weapon.name);
                    game.ui.weaponNameLabel.setToolTipText(game.longSword.getWeaponDescription());
                } else if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)) {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = game.longSword;
                    game.ui.weaponNameLabel.setText(game.story.player.weapon.name);
                    game.ui.weaponNameLabel.setToolTipText(game.longSword.getWeaponDescription());
                } else if (game.ui.weaponLongSwordButton.getBackground().equals(Color.green)) {
                    game.ui.weaponLongSwordButton.setBackground(Color.DARK_GRAY);
                    game.story.player.weapon = game.fists;
                    game.ui.weaponNameLabel.setText(game.story.player.weapon.name);
                    game.ui.weaponNameLabel.setToolTipText(game.fists.getWeaponDescription());
                }else {
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.story.player.weapon = game.longSword;
                    game.ui.weaponNameLabel.setText(game.story.player.weapon.name);
                    game.ui.weaponNameLabel.setToolTipText(game.longSword.getWeaponDescription());
                }

            }

            case "weaponStiletto" -> {
                game.ui.weaponStilettoButton.setBackground(Color.green);
                game.story.player.weapon.name = "Stiletto";
                game.ui.weaponNameLabel.setText("Stiletto");

            }

            case "leatherChestArmor" -> {
                if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)){
                    game.ui.weaponLongSwordButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorChest = game.leatherChestArmor;
                    game.ui.armorChestNameLabel.setText(game.story.player.armorChest.name);
                } else {
                    game.ui.armorBodyLeatherArmorButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorChest = game.leatherChestArmor;
                    game.ui.armorChestNameLabel.setText(game.story.player.armorChest.name);
                }
            }

            case "bronzeShield" -> {
                if (game.ui.armorShieldBronzeShieldButton.getBackground().equals(Color.green)){
                    game.ui.armorShieldBronzeShieldButton.setBackground(Color.DARK_GRAY);
                    //game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorShield = game.armorShieldBronzeShield;
                    game.ui.armorShieldNameLabel.setText(game.story.player.armorShield.name);
                } else {
                    game.ui.armorShieldBronzeShieldButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.armorShield = game.armorShieldBronzeShield;
                    game.ui.armorShieldNameLabel.setText(game.story.player.armorShield.name);
                }
            }

            case "shellAmulet" -> {
                if (game.ui.weaponStilettoButton.getBackground().equals(Color.green)){
                    game.ui.shellAmuletButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.amulet = game.amuletRingShell;
                    game.ui.amuletNameLabel.setText(game.story.player.amulet.name);
                    game.story.player.maxHP += game.amuletRingShell.healthIncrease;
                } else if (game.ui.shellAmuletButton.getBackground().equals(Color.green)) {
                    game.ui.shellAmuletButton.setBackground(Color.DARK_GRAY);
                    game.story.player.amulet = game.amuletRingEmpty;
                    game.ui.amuletNameLabel.setText(game.story.player.amulet.name);
                    game.story.player.maxHP -= game.amuletRingShell.healthIncrease;

                    if (game.story.player.hp > game.story.player.maxHP) {
                        game.story.player.hp = game.story.player.maxHP;
                    }

                    game.ui.healthNumberLabel.setText("" + game.story.player.maxHP);
                } else {
                    game.ui.shellAmuletButton.setBackground(Color.green);
                    game.ui.weaponStilettoButton.setBackground(Color.DARK_GRAY);
                    game.story.player.amulet = game.amuletRingShell;
                    game.ui.amuletNameLabel.setText(game.story.player.amulet.name);
                    game.story.player.maxHP += game.amuletRingShell.healthIncrease;
                }
            }
        }
    }

    private void equipHandler (JButton button) {
        if (button.getBackground().equals(Color.green)) {
            button.setBackground(Color.DARK_GRAY);

        }
    }
}
