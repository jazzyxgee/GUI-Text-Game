package textGameGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import textGameGUI.gameController.ViewListener;

public class gameView extends JFrame {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   public JPanel gamePanel, titleScreen, btnPanel, gameTextPanel, playerBtns,
   statusBar, playerCharBtns;
   public JLabel title, healthPoints, healthNumLabel, weaponLabel, 
   weaponTypeLabel, specialItem, specialItemType;
   public JButton startBtn, startGameBtn, optionA, optionB, optionC,
   charOptionA, charOptionB, charOptionC;
   public JTextArea gameTextArea, statusBarText;
   
   

   //actually loads up the title screen/main menu
   public gameView(){
      
      super(); //constructor
      setTitle("The Far Far Away");
      setLayout(new BorderLayout()); 
      
      //set up main game panel
      gamePanel = new JPanel();
      gamePanel.setBackground(Color.black);
      
      //set up the game text area
      titleScreen = new JPanel();
      titleScreen.setBackground(Color.black);
      
      title = new JLabel ("The Far Far Away");
      title.setForeground(Color.red);
      title.setFont(new Font("Book Antiqua", Font.PLAIN, 90));
      
      titleScreen.add(title);
      
      startBtn = new JButton("Begin Journey");
      startBtn.setBackground(Color.red);
      startBtn.setBounds(300, 300, 200, 100);
      
      
      startGameBtn = new JButton("Continue...");
      startGameBtn.setBackground(Color.red);
      startGameBtn.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
       
      charOptionA = new JButton("Crystal");
      charOptionB = new JButton("Nocturnal");
      charOptionC = new JButton("Sypha");
      
      optionA = new JButton("Option A");
      optionB = new JButton("Option B");
      optionC = new JButton("Option C");
      
      //add to this JFrame
      add(gamePanel);
      add(startBtn);
      add(titleScreen, BorderLayout.CENTER);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(800, 600);
      
   }
   
   public void createGameUI() {

      playerCharBtns.setVisible(false);
      gameTextPanel.setVisible(false);
      
      //set up the game text area
      gameTextPanel = new JPanel();
      gameTextPanel.setBackground(Color.black);
      gameTextPanel.setLayout(new GridLayout(1,1));
      
      gameTextArea = new JTextArea ("This is the main text game area. "
            + "The game progresses forward here."
            + " \nThe user will pick from options below.");
      gameTextArea.setForeground(Color.white);
      gameTextArea.setBackground(Color.black);
      gameTextArea.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      gameTextPanel.add(gameTextArea);
      
      statusBar = new JPanel();
      //x,y,width, height
      statusBar.setBounds(100,250,600,50);
      statusBar.setBackground(Color.red);
      statusBar.setLayout(new GridLayout(1,5));
      
      healthPoints  = new JLabel("Health:");
      healthPoints.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
      healthNumLabel = new JLabel();
      
      weaponLabel = new JLabel("Weapon: ");
      weaponLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
      weaponTypeLabel = new JLabel();
      
      specialItem = new JLabel("Special Item: ");
      specialItem.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
      specialItemType = new JLabel();
      
      statusBar.add(healthPoints);
      statusBar.add(healthNumLabel);
      statusBar.add(weaponLabel);
      statusBar.add(weaponTypeLabel);
      statusBar.add(specialItem);
      statusBar.add(specialItemType);
      
      playerBtns = new JPanel();
      playerBtns.setBounds(150, 300, 500, 150);
      playerBtns.setLayout(new GridLayout(3,1));
      
      //add to this JFrame
      add(statusBar);
      gamePanel.add(gameTextPanel, BorderLayout.CENTER);
      add(playerBtns);
      add(gamePanel);
      
      //creating player option buttons   
      optionA.setBackground(Color.black);
      optionA.setForeground(Color.white);
      optionA.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerBtns.add(optionA);
      
      
      optionB.setBackground(Color.black);
      optionB.setForeground(Color.white);
      optionB.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerBtns.add(optionB);
      
      
      optionC.setBackground(Color.black);
      optionC.setForeground(Color.white);
      optionC.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerBtns.add(optionC);
      
   
      characterInfo();
      
   }

   //button listener for start menu
   void addButtonListener(ActionListener listenForButton) {
      
      startBtn.addActionListener(listenForButton);
 
   }
   
   void addOptionsListener(ActionListener listenForButton) {
      
      optionA.addActionListener(listenForButton);
      optionB.addActionListener(listenForButton);
      optionC.addActionListener(listenForButton);
      
   }
   
   public void characterInfo() {
      
      healthNumLabel.setText(" " + gameModel.hitpointsLevel);
      weaponTypeLabel.setText(gameModel.weaponType);
      specialItemType.setText(gameModel.specialGameItem);
      
   }
   
   public void chooseACharacter() {
      
      titleScreen.setVisible(false);
      startBtn.setVisible(false);

      playerCharBtns = new JPanel();
      playerCharBtns.setBounds(80, 300, 650, 150);
      playerCharBtns.setLayout(new GridLayout(1,4));
     
      gameTextPanel = new JPanel();
      gameTextPanel.setBackground(Color.black);
      gameTextPanel.setLayout(new GridLayout(1,1));
      
      gameTextArea = new JTextArea ("Please choose a character...");
      gameTextArea.setForeground(Color.white);
      gameTextArea.setBackground(Color.black);
      gameTextArea.setFont(new Font("Book Antiqua", Font.PLAIN,40));
      gameTextPanel.add(gameTextArea);
      
      charOptionA.setBackground(Color.black);
      charOptionA.setForeground(Color.white);
      charOptionA.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerCharBtns.add(charOptionA);

      charOptionB.setBackground(Color.black);
      charOptionB.setForeground(Color.white);
      charOptionB.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerCharBtns.add(charOptionB);

      charOptionC.setBackground(Color.black);
      charOptionC.setForeground(Color.white);
      charOptionC.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
      playerCharBtns.add(charOptionC);

      playerCharBtns.add(startGameBtn);
      
      add(playerCharBtns);
      add(gamePanel);
      add(gameTextPanel);
      
   }
   
   void addOption(ActionListener listenForButton) {
      
      charOptionA.addActionListener(listenForButton);
      charOptionB.addActionListener(listenForButton);
      charOptionC.addActionListener(listenForButton);
      
   }
   
   void addGameBtnListener(ActionListener listenForButton) {
      
      startGameBtn.addActionListener(listenForButton);
      
   }
 
   //Game UI methods below
   public void forestUI() {

      gameTextArea.setText("You are in the forest. You are on a trip in the "
            + "wilderness, \n the far far away, trying to find a magical orb."
            + "\n Where would you like to go?");
      optionA.setText("Go to castle in the mountains. ");
      optionB.setText("Go to the swamp.");
      optionC.setText("Go to the cave in the distance.");
        
   }
   
   public void castleScene() {
      
      gameTextArea.setText("You were kidnapped by the owners! "
            + "You are now their butler. ");
      optionA.setText("Click to start over.");
      optionB.setText(" ");
      optionC.setText(" ");
      
   }
   
   public void swampScene() {
      
      gameTextArea.setText("You are the swamp, but it looks like a dead end."
            + "\n Unfortunately, you touched something poisonous."
            + "\n You receive some damage to your health.");
      optionA.setText("Click to go back.");
      optionB.setText(" ");
      optionC.setText(" ");
      
      healthNumLabel.setText(" " + gameModel.hitpointsLevel);
      
   }
   
   public void caveEntrance() {
      
      gameTextArea.setText("You are in the cave. The cave splits into "
            + "\n three paths. ");
      optionA.setText("Walk south.");
      optionB.setText("Walk east.");
      optionC.setText("Walk west.");
     
      
   }
   
   public void caveSouth() {
      
      gameTextArea.setText("You are walking down the dark cave. \n"
            + "You see a light at the end of the cave. \n"
            + "As you get closer, you find a chest. \n");
      optionA.setText("Open the chest.");
      optionB.setText("Forget this trip! I'm leaving.");
      optionC.setText("");
      
   }
   
   public void caveEast() {

      if(gameModel.bearAlive == false) {
         
         optionC.setText("");
         
         
      }
      
      gameTextArea.setText("You encounter a bear! Do you want to leave \n"
            + "or fight the bear?"
            + "\n"
            + "\n"
            + "BEAR HEALTH:" + gameModel.bearHpLevel);
      
      
      optionA.setText("FIGHT!");
      optionB.setText("Leave.");
      optionC.setText("");
      

      
      
      healthNumLabel.setText(" " + gameModel.hitpointsLevel);
      
   }
   
   public void caveWest() {
      
      
      gameTextArea.setText("You keep walking down the path. It is so dark,"
            + "\n and it is getting smaller and smaller."
            + "\n Looks like you have to go back. ");
      optionA.setText("Go back.");
      optionB.setText("");
      optionC.setText("");
      
   }
   
   public void winnerScreen() {
      
      specialItemType.setText(gameModel.specialGameItem);
      
      gameTextArea.setText("YOU FOUND THE ORB! You can go back to your home! ");
      optionA.setText("Exit");
      optionB.setText("");
      optionC.setText("");
      
   }
   
   public void gameOverScreen() {
      
      gameTextArea.setText("G A M E O V E R ");
      optionA.setText("Exit");
      optionB.setText("");
      optionC.setText("");
      
   }
   
}
