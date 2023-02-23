package LostCause.GameEngine;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window, worldMapWindow;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, mainImagePanel,
            choiceButtonPanel, continueButtonPanel, equipmentIconPanel,
            utilityIconPanel, utilityLabelPanel, iconLabelPanel,
            worldMapPanel, inventoryPanelItemButtons, inventoryPanelPageButtons;
    JLabel titleNameLabel, imageLabel,
            weaponLabel, weaponNameLabel,
            armorHeadLabel, armorHeadNameLabel,
            armorChestLabel, armorChestNameLabel,
            armorShieldLabel, armorShieldNameLabel,
            necklaceLabel, necklaceNameLabel,
            ringLabel, ringNameLabel,
            healthLabel, healthNumberLabel,
            manaLabel, manaNumberLabel, // or this might be xp?
            goldLabel, goldNumberLabel,
            currentLocationLabel,
            characterLevelLabel;
    JButton startButton, choiceOne, choiceTwo, choiceThree, choiceFour, continueButton,
            characterButton, worldMapButton,
            inventoryButton, inventoryItemOneButton, inventoryItemTwoButton, inventoryItemThreeButton, inventoryItemFourButton,
            inventoryPagePrevButton, inventoryPageNextButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.ITALIC, 128);
    Font normalFont = new Font("Times New Roman", Font.ITALIC, 28); // initial font size 36
    Font iconFont = new Font("Times New Roman", Font.ITALIC, 24);
    ImageIcon image, armorHeadIcon, necklaceIcon, weaponIcon, armorChestIcon, armorShieldIcon, ringIcon,
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

        window.setVisible(true);

    }

    public void createWindow() {
        window = new JFrame();
        window.setLayout(null);
        window.setSize(1440, 900);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Lost Cause");
        window.getContentPane().setBackground(Color.black);
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
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(190,450,1000,200); // height was 200. // y was 500
        mainTextPanel.setBackground(Color.black);
        // TODO: I have solved an issue, so that the buttons don't disappear, yet i have to alter my ui, there is space on top 30 - 135 pixels, i have ~100 pixels
        // TODO: as a beginning solution, move the starting position of the image and utility/equipment panels to @80 pixels

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(190, 450, 1000, 200); // height was 400. // second edit 250, now 150, // y was 500
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        //mainTextArea.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); // set line wrap to false, if you want center to activate.
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
        image = new ImageIcon(".//res//crossroad.jpg");
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
        necklaceLabel = new JLabel();
        necklaceIcon = new ImageIcon(".//res//emerald-necklace64.png");
        necklaceLabel.setIcon(necklaceIcon);
        equipmentIconPanel.add(necklaceLabel);

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

        armorHeadNameLabel = new JLabel("Helm of embers"); // TODO: change to empty later!
        armorHeadNameLabel.setFont(iconFont);
        armorHeadNameLabel.setForeground(Color.white);
        armorHeadNameLabel.setToolTipText("This is your helmet."); // TODO: as a nice work-around, add this to show item stats!
        iconLabelPanel.add(armorHeadNameLabel);

        necklaceNameLabel = new JLabel("Health necklace");
        necklaceNameLabel.setFont(iconFont);
        necklaceNameLabel.setForeground(Color.white);
        necklaceNameLabel.setToolTipText("This is your necklace.");
        iconLabelPanel.add(necklaceNameLabel);

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


        // TODO: create side icons of map, character, inventory and show hp/mp (maybe)

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

        inventoryPanelPageButtons = new JPanel();
        inventoryPanelPageButtons.setBounds(450, 800, 500, 30);
        inventoryPanelPageButtons.setBackground(Color.black);
        inventoryPanelPageButtons.setLayout(new GridLayout(1, 2, 1, 0));

        // add buttons for items here

        inventoryItemOneButton = new JButton("itemOne");
        inventoryItemOneButton.setBackground(Color.black);
        inventoryItemOneButton.setForeground(Color.white);
        inventoryItemOneButton.setFont(normalFont);
        inventoryItemOneButton.setFocusPainted(false);
        inventoryItemOneButton.addActionListener(cHandler);
        inventoryItemOneButton.setActionCommand("inventoryItemOne");
        inventoryPanelItemButtons.add(inventoryItemOneButton);

        inventoryItemTwoButton = new JButton("itemTwo");
        inventoryItemTwoButton.setBackground(Color.black);
        inventoryItemTwoButton.setForeground(Color.white);
        inventoryItemTwoButton.setFont(normalFont);
        inventoryItemTwoButton.setFocusPainted(false);
        inventoryItemTwoButton.addActionListener(cHandler);
        inventoryItemTwoButton.setActionCommand("inventoryItemTwo");
        inventoryPanelItemButtons.add(inventoryItemTwoButton);

        inventoryItemThreeButton = new JButton("itemThree");
        inventoryItemThreeButton.setBackground(Color.black);
        inventoryItemThreeButton.setForeground(Color.white);
        inventoryItemThreeButton.setFont(normalFont);
        inventoryItemThreeButton.setFocusPainted(false);
        inventoryItemThreeButton.addActionListener(cHandler); // handler
        inventoryItemThreeButton.setActionCommand("inventoryItemThree");
        inventoryPanelItemButtons.add(inventoryItemThreeButton);

        inventoryItemFourButton = new JButton("itemFour");
        inventoryItemFourButton.setBackground(Color.black);
        inventoryItemFourButton.setForeground(Color.white);
        inventoryItemFourButton.setFont(normalFont);
        inventoryItemFourButton.setFocusPainted(false);
        inventoryItemFourButton.addActionListener(cHandler); // handler
        inventoryItemFourButton.setActionCommand("inventoryItemFour");
        inventoryPanelItemButtons.add(inventoryItemFourButton);



        // add buttons for page scrolling here

        inventoryPagePrevButton = new JButton("Prev");
        inventoryPagePrevButton.setBackground(Color.black);
        inventoryPagePrevButton.setForeground(Color.white);
        inventoryPagePrevButton.setFont(normalFont);
        inventoryPagePrevButton.setFocusPainted(false);
        inventoryPagePrevButton.addActionListener(cHandler); // handler
        inventoryPagePrevButton.setActionCommand("inventoryPagePrev");
        inventoryPanelPageButtons.add(inventoryPagePrevButton);

        inventoryPageNextButton = new JButton("Next");
        inventoryPageNextButton.setBackground(Color.black);
        inventoryPageNextButton.setForeground(Color.white);
        inventoryPageNextButton.setFont(normalFont);
        inventoryPageNextButton.setFocusPainted(false);
        inventoryPageNextButton.addActionListener(cHandler); // handler
        inventoryPageNextButton.setActionCommand("inventoryPageNext");

        inventoryPanelPageButtons.add(inventoryPagePrevButton);
        inventoryPanelPageButtons.add(inventoryPageNextButton);

        window.add(inventoryPanelItemButtons);
        window.add(inventoryPanelPageButtons);



    }

}
