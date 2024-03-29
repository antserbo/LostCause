package LostCause.GameEngine;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window, worldMapWindow;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, mainImagePanel,
            frameOfMainTextPanelTop, frameOfMainTextPanelRight, frameOfMainTextPanelBottom, frameOfMainTextPanelLeft,
            choiceButtonPanel, continueButtonPanel, equipmentIconPanel,
            utilityIconPanel, utilityLabelPanel, iconLabelPanel,
            worldMapPanel, inventoryPanelItemButtons, inventoryPanelPageButton,
            inventoryWindowPanel, inventoryWeaponPanel, inventoryArmorBodyPanel, inventoryArmorShieldPanel, inventoryAmuletRingPanel, inventoryItemPanel, inventoryQuestItemPanel;
    JLabel titleNameLabel, imageLabel,
            weaponLabel, weaponNameLabel,
            armorHeadLabel, armorHeadNameLabel,
            armorChestLabel, armorChestNameLabel,
            armorShieldLabel, armorShieldNameLabel,
            amuletLabel, amuletNameLabel,
            ringLabel, ringNameLabel,
            healthLabel, healthNumberLabel,
            manaLabel, manaNumberLabel, // or this might be xp?
            goldLabel, goldNumberLabel,
            currentLocationLabel,
            characterLevelLabel,
            inventoryWeaponTypeLabel, inventoryArmorBodyTypeLabel, inventoryArmorShieldTypeLabel, inventoryAmuletRingTypeLabel, inventoryItemTypeLabel, inventoryQuestItemLabel;
    JButton startButton, choiceOne, choiceTwo, choiceThree, choiceFour, continueButton,
            characterButton, worldMapButton,
            inventoryButton, inventoryItemOneButton, inventoryItemTwoButton, inventoryItemThreeButton, inventoryItemFourButton,
            inventoryPageMainButton,
            weaponLongSwordButton, weaponStilettoButton,
            armorBodyLeatherArmorButton,
            armorShieldBronzeShieldButton,
            shellAmuletButton,
            questItemSilverRingButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.ITALIC, 128);
    Font normalFont = new Font("Times New Roman", Font.ITALIC, 28); // initial font size 36
    Font iconFont = new Font("Times New Roman", Font.ITALIC, 24);
    ImageIcon image, armorHeadIcon, amuletIcon, weaponIcon, armorChestIcon, armorShieldIcon, ringIcon,
            healthIcon, manaIcon, goldIcon, characterIcon, worldMapIcon, inventoryIcon;

    public void createUI(ChoiceHandler cHandler) {

        createWindow();

        createTitleScreen();

        createTextPanelArea();

        createImagePanelLAbel();

        createStart(cHandler);

        createChoices(cHandler);

        createContinue(cHandler);

        createEquipmentIcons();

        createIconLabels();

        createUtilityIcons(cHandler);

        createUtilityLabels();

        createInventoryUI(cHandler);

        createInventoryWindowUI(cHandler);

        window.setVisible(true);

    }

    public void createWindow() {
        window = new JFrame();
        window.setLayout(null);
        window.setSize(1440, 900);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Lost Cause");
        window.getContentPane().setBackground(Color.black);
        window.setLocationRelativeTo(null);
        /*window.setUndecorated(true); in order to get rid of borders
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);*/
    }

    private void createTitleScreen() {
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(415, 200, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Lost Cause");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        window.add(titleNamePanel);
        titleNamePanel.add(titleNameLabel);
    }

    private void createTextPanelArea() {

        frameOfMainTextPanelTop = new JPanel();
        frameOfMainTextPanelTop.setBounds(185,450,1010,1); // height was 200. // y was 500
        frameOfMainTextPanelTop.setBackground(Color.white);
        frameOfMainTextPanelTop.setVisible(false);
        window.add(frameOfMainTextPanelTop);


        frameOfMainTextPanelRight = new JPanel();
        frameOfMainTextPanelRight.setBounds(1195,450,1,202); // height was 200. // y was 500
        frameOfMainTextPanelRight.setBackground(Color.white);
        frameOfMainTextPanelRight.setVisible(false);
        window.add(frameOfMainTextPanelRight);


        frameOfMainTextPanelBottom = new JPanel();
        frameOfMainTextPanelBottom.setBounds(185,650,1010,1); // height was 200. // y was 500
        frameOfMainTextPanelBottom.setBackground(Color.white);
        frameOfMainTextPanelBottom.setVisible(false);
        window.add(frameOfMainTextPanelBottom);


        frameOfMainTextPanelLeft = new JPanel();
        frameOfMainTextPanelLeft.setBounds(185,450,1,202); // height was 200. // y was 500
        frameOfMainTextPanelLeft.setBackground(Color.white);
        frameOfMainTextPanelLeft.setVisible(false);
        window.add(frameOfMainTextPanelLeft);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(190,450,1000,200); // height was 200. // y was 500
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(190, 450, 1000, 200); // height was 400. // second edit 250, now 150, // y was 500
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setAlignmentX(JTextField.CENTER_ALIGNMENT); // this is in-par with setLineWrap
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(false); // set line wrap to false, if you want center to activate.
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        window.add(mainTextPanel);
        mainTextPanel.add(mainTextArea);

    }

    private void createImagePanelLAbel() {
        mainImagePanel = new JPanel();
        mainImagePanel.setBounds(413, 50, 600,400); // was 100
        mainImagePanel.setBackground(Color.black);

        window.add(mainImagePanel);

        imageLabel = new JLabel();
        image = new ImageIcon(".//res//crossroad_inverted.png");
        imageLabel.setIcon(image);
        mainImagePanel.add(imageLabel);
    }

    public void createStart(ChoiceHandler cHandler) {

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(610, 600, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setFont(normalFont);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

    }

    public void createChoices(ChoiceHandler cHandler) {

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(450, 650, 500, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1, 0, 1));

        window.add(choiceButtonPanel);

        choiceOne = new JButton("choiceOne");
        choiceOne.setBackground(Color.black);
        choiceOne.setForeground(Color.white);
        choiceOne.setFont(normalFont);
        choiceOne.setFocusPainted(false);
        choiceOne.addActionListener(cHandler);
        choiceOne.setActionCommand("c1");
        choiceButtonPanel.add(choiceOne);

        choiceTwo = new JButton("choiceTwo");
        choiceTwo.setBackground(Color.black);
        choiceTwo.setForeground(Color.white);
        choiceTwo.setFont(normalFont);
        choiceTwo.setFocusPainted(false);
        choiceTwo.addActionListener(cHandler);
        choiceTwo.setActionCommand("c2");
        choiceButtonPanel.add(choiceTwo);

        choiceThree = new JButton("choiceThree");
        choiceThree.setBackground(Color.black);
        choiceThree.setForeground(Color.white);
        choiceThree.setFont(normalFont);
        choiceThree.setFocusPainted(false);
        choiceThree.addActionListener(cHandler);
        choiceThree.setActionCommand("c3");
        choiceButtonPanel.add(choiceThree);

        choiceFour = new JButton("choiceFour");
        choiceFour.setBackground(Color.black);
        choiceFour.setForeground(Color.white);
        choiceFour.setFont(normalFont);
        choiceFour.setFocusPainted(false);
        choiceFour.addActionListener(cHandler);
        choiceFour.setActionCommand("c4");
        choiceButtonPanel.add(choiceFour);

        choiceButtonPanel.setVisible(false);

    }

    public void createContinue(ChoiceHandler cHandler) {

        continueButtonPanel = new JPanel();
        continueButtonPanel.setBounds(450, 750, 500, 100);
        continueButtonPanel.setBackground(Color.black);


        window.add(continueButtonPanel);

        continueButton = new JButton("Continue");
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(cHandler);
        continueButton.setActionCommand("continue");

        continueButtonPanel.add(continueButton);

        continueButtonPanel.setVisible(true);
    }

    public void createEquipmentIcons() {

        equipmentIconPanel = new JPanel();
        equipmentIconPanel.setBounds(1060, 50, 64,395);
        equipmentIconPanel.setBackground(Color.black);
        equipmentIconPanel.setLayout(new GridLayout(6, 1, 0, 0));

        window.add(equipmentIconPanel);

        // add icon helmet
        armorHeadLabel = new JLabel();
        armorHeadIcon = new ImageIcon(".//res//warlock-hood64.png");
        armorHeadLabel.setIcon(armorHeadIcon);
        equipmentIconPanel.add(armorHeadLabel);

        // add icon necklace
        amuletLabel = new JLabel();
        amuletIcon = new ImageIcon(".//res//emerald-necklace64.png");
        amuletLabel.setIcon(amuletIcon);
        equipmentIconPanel.add(amuletLabel);

        // add icon weapon
        weaponLabel = new JLabel();
        weaponIcon = new ImageIcon(".//res//broadsword64.png");
        weaponLabel.setIcon(weaponIcon);
        equipmentIconPanel.add(weaponLabel);

        // add icon chestplate
        armorChestLabel = new JLabel();
        armorChestIcon = new ImageIcon(".//res//heart-armor64.png");
        armorChestLabel.setIcon(armorChestIcon);
        equipmentIconPanel.add(armorChestLabel);

        // add icon shield
        armorShieldLabel = new JLabel();
        armorShieldIcon = new ImageIcon(".//res//shield64.png");
        armorShieldLabel.setIcon(armorShieldIcon);
        equipmentIconPanel.add(armorShieldLabel);

        // add icon ring
        ringLabel = new JLabel();
        ringIcon = new ImageIcon(".//res//globe-ring64.png");
        ringLabel.setIcon(ringIcon);
        equipmentIconPanel.add(ringLabel);


    }

    public void createIconLabels() {

        iconLabelPanel = new JPanel();
        iconLabelPanel.setBounds(1130, 50, 280,395);
        iconLabelPanel.setBackground(Color.black);
        iconLabelPanel.setLayout(new GridLayout(6, 1));

        armorHeadNameLabel = new JLabel("Helm of embers");
        armorHeadNameLabel.setFont(iconFont);
        armorHeadNameLabel.setForeground(Color.white);
        armorHeadNameLabel.setToolTipText("This is your helmet.");
        iconLabelPanel.add(armorHeadNameLabel);

        amuletNameLabel = new JLabel("Health necklace");
        amuletNameLabel.setFont(iconFont);
        amuletNameLabel.setForeground(Color.white);
        amuletNameLabel.setToolTipText("This is your necklace.");
        iconLabelPanel.add(amuletNameLabel);

        weaponNameLabel = new JLabel("Ultima Godsword");
        weaponNameLabel.setFont(iconFont);
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setToolTipText("<html>" + "Damage: <font color=red>30</font>" + "<br>" + "Class: Two Handed Sword" + "</html>");
        iconLabelPanel.add(weaponNameLabel);


        armorChestNameLabel = new JLabel("Hardened plate");
        armorChestNameLabel.setFont(iconFont);
        armorChestNameLabel.setForeground(Color.white);
        armorChestNameLabel.setToolTipText("This is your body armor.");
        iconLabelPanel.add(armorChestNameLabel);

        armorShieldNameLabel = new JLabel("Spiked shield");
        armorShieldNameLabel.setFont(iconFont);
        armorShieldNameLabel.setForeground(Color.white);
        armorShieldNameLabel.setToolTipText("This is your shield.");
        iconLabelPanel.add(armorShieldNameLabel);

        ringNameLabel = new JLabel("Devotion ring");
        ringNameLabel.setFont(iconFont);
        ringNameLabel.setForeground(Color.white);
        ringNameLabel.setToolTipText("This is your ring.");
        iconLabelPanel.add(ringNameLabel);


        window.add(iconLabelPanel);

    }

    public void createUtilityIcons(ChoiceHandler cHandler) {

        utilityIconPanel = new JPanel();
        utilityIconPanel.setBounds(300, 50, 64,395); // initial value x = 100
        utilityIconPanel.setBackground(Color.black);
        utilityIconPanel.setLayout(new GridLayout(6, 1, 0, 0));

        window.add(utilityIconPanel);

        // add icon hp
        healthLabel = new JLabel();
        healthIcon = new ImageIcon(".//res//hearts64.png");
        healthLabel.setIcon(healthIcon);
        utilityIconPanel.add(healthLabel);

        // add icon mp
        manaLabel = new JLabel();
        manaIcon = new ImageIcon(".//res//spell-book64.png");
        manaLabel.setIcon(manaIcon);
        utilityIconPanel.add(manaLabel);

        // add icon coin
        goldLabel = new JLabel();
        goldIcon = new ImageIcon(".//res//crown-coin64.png");
        goldLabel.setIcon(goldIcon);
        utilityIconPanel.add(goldLabel);

        // add character button

        characterIcon = new ImageIcon(".//res//character64.png");
        characterButton = new JButton(characterIcon);
        characterButton.setFocusPainted(false);
        utilityIconPanel.add(characterButton);

        // add map button

        worldMapIcon = new ImageIcon(".//res//treasure-map64.png");
        worldMapButton = new JButton(worldMapIcon);
        worldMapButton.setFocusPainted(false);
        worldMapButton.addActionListener(cHandler);
        worldMapButton.setActionCommand("map");
        utilityIconPanel.add(worldMapButton);

        // add inventory button

        inventoryIcon = new ImageIcon(".//res//swap-bag64.png");
        inventoryButton = new JButton(inventoryIcon);
        inventoryButton.setFocusPainted(false);
        inventoryButton.setFocusable(true);
        inventoryButton.addActionListener(cHandler);
        inventoryButton.setActionCommand("inventory");
        utilityIconPanel.add(inventoryButton);

    }

    public void createUtilityLabels () {
        utilityLabelPanel = new JPanel();
        utilityLabelPanel.setBounds(85, 50, 200,395); // initial value 100, 105, 200,395
        utilityLabelPanel.setBackground(Color.black);
        utilityLabelPanel.setLayout(new GridLayout(6, 1, 0, 0));

        window.add(utilityLabelPanel);

        // add hp number label
        healthNumberLabel = new JLabel("", SwingConstants.RIGHT);
        healthNumberLabel.setFont(iconFont);
        healthNumberLabel.setForeground(Color.white);
        healthNumberLabel.setToolTipText("This is your HP number.");
        utilityLabelPanel.add(healthNumberLabel);

        // add mana number label
        manaNumberLabel = new JLabel("0", SwingConstants.RIGHT);
        manaNumberLabel.setFont(iconFont);
        manaNumberLabel.setForeground(Color.white);
        manaNumberLabel.setToolTipText("This is your mana number.");
        utilityLabelPanel.add(manaNumberLabel);

        // add gold number label
        goldNumberLabel = new JLabel("69", SwingConstants.RIGHT);
        goldNumberLabel.setFont(iconFont);
        goldNumberLabel.setForeground(Color.white);
        goldNumberLabel.setToolTipText("This is your gold amount.");
        utilityLabelPanel.add(goldNumberLabel);

        // add character level label
        characterLevelLabel = new JLabel("1", SwingConstants.RIGHT);
        characterLevelLabel.setFont(iconFont);
        characterLevelLabel.setForeground(Color.white);
        characterLevelLabel.setToolTipText("This is your character level.");
        utilityLabelPanel.add(characterLevelLabel);

        // add current location label
        currentLocationLabel = new JLabel("Undiscovered", SwingConstants.RIGHT);
        currentLocationLabel.setFont(iconFont);
        currentLocationLabel.setForeground(Color.white);
        currentLocationLabel.setToolTipText("");
        utilityLabelPanel.add(currentLocationLabel);
    }

    public void createWorldMap(Game game) {

        worldMapWindow = new JFrame();
        worldMapWindow.setSize(960, 960);
        worldMapWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        worldMapWindow.setTitle("World Map of \"Lost Cause\"");
        worldMapWindow.getContentPane().setBackground(Color.black);
        worldMapWindow.setAlwaysOnTop(true);

        worldMapPanel = new JPanel();
        worldMapPanel.setLayout(new GridLayout(8, 5));


        worldMapWindow.add(worldMapPanel);


        // add the current location name to the map


        worldMapWindow.setVisible(true);

        // we can manipulate, it is working. the game object is not empty!
        game.ui.ringNameLabel.setText("Devotion ring (e)");
    }

    public void createInventoryUI (ChoiceHandler cHandler) { // item handler here

        inventoryPanelItemButtons = new JPanel();
        inventoryPanelItemButtons.setBounds(450, 650, 500, 150);
        inventoryPanelItemButtons.setBackground(Color.black);
        inventoryPanelItemButtons.setLayout(new GridLayout(4, 1, 0, 1));

        inventoryPanelPageButton = new JPanel();
        inventoryPanelPageButton.setBounds(450, 800, 500, 30);
        inventoryPanelPageButton.setBackground(Color.black);
        inventoryPanelPageButton.setLayout(new GridLayout(1, 1, 0, 0));

        // todo, if i click it, then my chalice is used and in order to be able to use it again, i have to win to set the variable to zero
        // basically, the magical chalice is replenished by killing a monster
        inventoryItemOneButton = new JButton("Magical chalice");
        inventoryItemOneButton.setBackground(Color.green);
        inventoryItemOneButton.setForeground(Color.white);
        inventoryItemOneButton.setFont(normalFont);
        inventoryItemOneButton.setFocusPainted(false);
        inventoryItemOneButton.addActionListener(cHandler);
        inventoryItemOneButton.setActionCommand("inventoryItemOne");
        inventoryItemOneButton.setVisible(false);
        inventoryItemOneButton.setToolTipText("<html> Heals <font color=red>20 %</font> of your max hp </html>");
        inventoryPanelItemButtons.add(inventoryItemOneButton);

        inventoryItemTwoButton = new JButton("itemTwo");
        inventoryItemTwoButton.setBackground(Color.black);
        inventoryItemTwoButton.setForeground(Color.white);
        inventoryItemTwoButton.setFont(normalFont);
        inventoryItemTwoButton.setFocusPainted(false);
        inventoryItemTwoButton.addActionListener(cHandler);
        inventoryItemTwoButton.setActionCommand("inventoryItemTwo");
        inventoryItemTwoButton.setVisible(false);
        inventoryPanelItemButtons.add(inventoryItemTwoButton);

        inventoryItemThreeButton = new JButton("itemThree");
        inventoryItemThreeButton.setBackground(Color.black);
        inventoryItemThreeButton.setForeground(Color.white);
        inventoryItemThreeButton.setFont(normalFont);
        inventoryItemThreeButton.setFocusPainted(false);
        inventoryItemThreeButton.addActionListener(cHandler); // handler
        inventoryItemThreeButton.setActionCommand("inventoryItemThree");
        inventoryItemThreeButton.setVisible(false);
        inventoryPanelItemButtons.add(inventoryItemThreeButton);

        inventoryItemFourButton = new JButton("itemFour");
        inventoryItemFourButton.setBackground(Color.black);
        inventoryItemFourButton.setForeground(Color.white);
        inventoryItemFourButton.setFont(normalFont);
        inventoryItemFourButton.setFocusPainted(false);
        inventoryItemFourButton.addActionListener(cHandler); // handler
        inventoryItemFourButton.setActionCommand("inventoryItemFour");
        inventoryItemFourButton.setVisible(false);
        inventoryPanelItemButtons.add(inventoryItemFourButton);

        // add button for inventory page here

        inventoryPageMainButton = new JButton("Inventory page");
        inventoryPageMainButton.setBackground(Color.black);
        inventoryPageMainButton.setForeground(Color.white);
        inventoryPageMainButton.setFont(normalFont);
        inventoryPageMainButton.setFocusPainted(false);
        inventoryPageMainButton.addActionListener(cHandler); // handler
        inventoryPageMainButton.setActionCommand("inventoryPageMain");
        inventoryPanelPageButton.add(inventoryPageMainButton);

        inventoryPanelPageButton.add(inventoryPageMainButton);

        window.add(inventoryPanelItemButtons);
        window.add(inventoryPanelPageButton);



    }

    public void createInventoryWindowUI (ChoiceHandler cHandler) {
        inventoryWindowPanel = new JPanel();
        inventoryWindowPanel.setBounds(50, 30, 1320, 30);
        inventoryWindowPanel.setBackground(Color.black);
        inventoryWindowPanel.setLayout(new GridLayout(1, 5, 0, 0));
        inventoryWindowPanel.setVisible(false);

        window.add(inventoryWindowPanel);

        createInventoryWindowUIWeaponPanelLabel();
        createInventoryWindowUIArmorBodyPanelLabel();
        createInventoryWindowUIArmorShieldPanelLabel();
        createInventoryWindowUIAmuletRingPanelLabel();
        createInventoryWindowUIItemPanelLabel();
        createInventoryWindowUIQuestItemPanelLabel();


        createInventoryWindowUIWeaponButtons(cHandler);
        createInventoryWindowUIArmorBodyButtons(cHandler);
        createInventoryWindowUIAmuletRingButtons(cHandler);
        createInventoryWindowUIArmorShieldButtons(cHandler);
        createInventoryWindowUIQuestItemButtons(cHandler);

    }

    public void createInventoryWindowUIWeaponPanelLabel() {
        inventoryWeaponPanel = new JPanel();
        inventoryWeaponPanel.setBounds(50, 70, 220, 720);
        inventoryWeaponPanel.setBackground(Color.black);
        window.add(inventoryWeaponPanel);

        inventoryWeaponTypeLabel = new JLabel("Weapon stash", SwingConstants.CENTER);
        inventoryWeaponTypeLabel.setBounds(50, 30, 220, 30);
        inventoryWeaponTypeLabel.setBackground(Color.black);
        inventoryWeaponTypeLabel.setForeground(Color.white);
        inventoryWeaponTypeLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryWeaponTypeLabel);

        inventoryWeaponPanel.setVisible(false);
        inventoryWeaponTypeLabel.setVisible(false);
    }

    public void createInventoryWindowUIArmorBodyPanelLabel() {
        inventoryArmorBodyPanel = new JPanel();
        inventoryArmorBodyPanel.setBounds(270, 70, 220, 720);
        inventoryArmorBodyPanel.setBackground(Color.black);
        window.add(inventoryArmorBodyPanel);

        inventoryArmorBodyTypeLabel = new JLabel("Body armor", SwingConstants.CENTER);
        inventoryArmorBodyTypeLabel.setBounds(270, 30, 220, 30);
        inventoryArmorBodyTypeLabel.setBackground(Color.black);
        inventoryArmorBodyTypeLabel.setForeground(Color.white);
        inventoryArmorBodyTypeLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryArmorBodyTypeLabel);

        inventoryArmorBodyPanel.setVisible(false);
        inventoryArmorBodyTypeLabel.setVisible(false);
    }

    public void createInventoryWindowUIArmorShieldPanelLabel() {
        inventoryArmorShieldPanel = new JPanel();
        inventoryArmorShieldPanel.setBounds(490, 70, 220, 720);
        inventoryArmorShieldPanel.setBackground(Color.black);
        window.add(inventoryArmorShieldPanel);

        inventoryArmorShieldTypeLabel = new JLabel("Shield stash", SwingConstants.CENTER);
        inventoryArmorShieldTypeLabel.setBounds(490, 70, 220, 30);
        inventoryArmorShieldTypeLabel.setBackground(Color.black);
        inventoryArmorShieldTypeLabel.setForeground(Color.white);
        inventoryArmorShieldTypeLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryArmorShieldTypeLabel);

        inventoryArmorShieldPanel.setVisible(false);
        inventoryArmorShieldTypeLabel.setVisible(false);
    }

    public void createInventoryWindowUIAmuletRingPanelLabel() {
        inventoryAmuletRingPanel= new JPanel();
        inventoryAmuletRingPanel.setBounds(710, 70, 220, 720);
        inventoryAmuletRingPanel.setBackground(Color.black);
        window.add(inventoryAmuletRingPanel);

        inventoryAmuletRingTypeLabel = new JLabel("Amulets & rings", SwingConstants.CENTER);
        inventoryAmuletRingTypeLabel.setBounds(710, 30, 220, 30);
        inventoryAmuletRingTypeLabel.setBackground(Color.black);
        inventoryAmuletRingTypeLabel.setForeground(Color.white);
        inventoryAmuletRingTypeLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryAmuletRingTypeLabel);

        inventoryAmuletRingPanel.setVisible(false);
        inventoryAmuletRingTypeLabel.setVisible(false);
    }

    public void createInventoryWindowUIItemPanelLabel() {
        inventoryItemPanel = new JPanel();
        inventoryItemPanel.setBounds(930, 70, 220, 720);
        inventoryItemPanel.setBackground(Color.black);
        window.add(inventoryItemPanel);

        inventoryItemTypeLabel = new JLabel("Items", SwingConstants.CENTER);
        inventoryItemTypeLabel.setBounds(930, 30, 220, 30);
        inventoryItemTypeLabel.setBackground(Color.black);
        inventoryItemTypeLabel.setForeground(Color.white);
        inventoryItemTypeLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryItemTypeLabel);

        inventoryItemPanel.setVisible(false);
        inventoryItemTypeLabel.setVisible(false);
    }

    public void createInventoryWindowUIQuestItemPanelLabel() {
        inventoryQuestItemPanel = new JPanel();
        inventoryQuestItemPanel.setBounds(1150, 70, 220, 720);
        inventoryQuestItemPanel.setBackground(Color.black);
        window.add(inventoryQuestItemPanel);

        inventoryQuestItemLabel = new JLabel("Quest items", SwingConstants.CENTER);
        inventoryQuestItemLabel.setBounds(1150, 30, 220, 30);
        inventoryQuestItemLabel.setBackground(Color.black);
        inventoryQuestItemLabel.setForeground(Color.white);
        inventoryQuestItemLabel.setFont(normalFont);

        inventoryWindowPanel.add(inventoryQuestItemLabel);


        inventoryQuestItemPanel.setVisible(false);
        inventoryQuestItemLabel.setVisible(false);
    }

    public void createInventoryWindowUIWeaponButtons (ChoiceHandler cHandler) { //todo: add weapon buttons here
        weaponLongSwordButton = new JButton("Long sword");
        fontAdjuster(weaponLongSwordButton);
        weaponLongSwordButton.setBackground(Color.DARK_GRAY);
        weaponLongSwordButton.setForeground(Color.white);
        weaponLongSwordButton.setFocusPainted(false);
        weaponLongSwordButton.addActionListener(cHandler); // handler
        weaponLongSwordButton.setActionCommand("weaponLongSword");
        weaponLongSwordButton.setVisible(false);
        inventoryWeaponPanel.add(weaponLongSwordButton);

        weaponStilettoButton = new JButton("Stiletto");
        fontAdjuster(weaponStilettoButton);
        weaponStilettoButton.setBackground(Color.DARK_GRAY);
        weaponStilettoButton.setForeground(Color.white);
        weaponStilettoButton.setFocusPainted(false);
        weaponStilettoButton.addActionListener(cHandler); // handler
        weaponStilettoButton.setActionCommand("weaponStiletto");
        weaponStilettoButton.setVisible(false);
        inventoryWeaponPanel.add(weaponStilettoButton);

    }

    public void createInventoryWindowUIArmorBodyButtons(ChoiceHandler cHandler) {
        armorBodyLeatherArmorButton = new JButton("Leather chest armor");
        fontAdjuster(armorBodyLeatherArmorButton);
        armorBodyLeatherArmorButton.setBackground(Color.DARK_GRAY);
        armorBodyLeatherArmorButton.setForeground(Color.white);
        armorBodyLeatherArmorButton.setFocusPainted(false);
        armorBodyLeatherArmorButton.addActionListener(cHandler); // handler
        armorBodyLeatherArmorButton.setActionCommand("leatherChestArmor");
        armorBodyLeatherArmorButton.setVisible(false);
        inventoryArmorBodyPanel.add(armorBodyLeatherArmorButton);
    }

    public void createInventoryWindowUIArmorShieldButtons(ChoiceHandler cHandler) {
        armorShieldBronzeShieldButton = new JButton("Bronze shield");
        fontAdjuster(armorShieldBronzeShieldButton);
        armorShieldBronzeShieldButton.setBackground(Color.DARK_GRAY);
        armorShieldBronzeShieldButton.setForeground(Color.white);
        armorShieldBronzeShieldButton.setFocusPainted(false);
        armorShieldBronzeShieldButton.addActionListener(cHandler);
        armorShieldBronzeShieldButton.setActionCommand("bronzeShield");
        armorShieldBronzeShieldButton.setVisible(false);
        inventoryArmorShieldPanel.add(armorShieldBronzeShieldButton);

    }

    public void createInventoryWindowUIAmuletRingButtons (ChoiceHandler cHandler) {
        shellAmuletButton = new JButton("Shell amulet");
        fontAdjuster(shellAmuletButton);
        shellAmuletButton.setBackground(Color.DARK_GRAY);
        shellAmuletButton.setForeground(Color.white);
        shellAmuletButton.setFocusPainted(false);
        shellAmuletButton.addActionListener(cHandler);
        shellAmuletButton.setActionCommand("shellAmulet");
        shellAmuletButton.setVisible(false);
        inventoryAmuletRingPanel.add(shellAmuletButton);
    }

    public void createInventoryWindowUIQuestItemButtons (ChoiceHandler cHandler) {
        questItemSilverRingButton = new JButton("Silver ring");
        fontAdjuster(questItemSilverRingButton);
        questItemSilverRingButton.setBackground(Color.DARK_GRAY);
        questItemSilverRingButton.setForeground(Color.white);
        questItemSilverRingButton.setFocusPainted(false);
        questItemSilverRingButton.addActionListener(cHandler);
        questItemSilverRingButton.setActionCommand("silverRing");
        questItemSilverRingButton.setVisible(false);
        inventoryQuestItemPanel.add(questItemSilverRingButton);
    }

    private void fontAdjuster (JButton button) {
        if (button.getText().length() > 19) {
            button.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        } else if (button.getText().length() > 15) {
            button.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        } else {
            button.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        }
    }

}
