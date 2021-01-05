package textGameGUI;

/*Text game GUI developed using MVC model. 
 *Name: Jasmine Guevara
 *Course: CST338-40
 *Date: 12/18/2020 
 **/ 

/*Description: A text game GUI that takes the user on a quest to find
 *a magical orb. The game operates with JButtons, updates using
 *JPanels, JTextArea, and JLabels to display the changes to the user's screen.
 *
 *The view updates the user's screen, the model does the game calculations,
 *and the controller coordinates between both of them to update changes.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class textGame {

   public static void main(String[] args) {
      
      gameView view = new gameView();
      gameModel model = new gameModel();
      
      gameController controller = new gameController(view, model);
      
      view.setVisible(true);
   }

}

class gameController {

   private gameView view;
   private gameModel model;
    
   public gameController(gameView view, gameModel model) {
      
      this.view = view;
      this.model = model;
    
      //add actionlisteners to buttons
      this.view.addButtonListener(new ViewListener());
      this.view.addGameBtnListener(new ViewListener());
      this.view.addOption(new CharOptListener());
      this.view.addOptionsListener(new OptionsListener());
   }
   
   class ViewListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
    
         /*if user clicks button to "Begin Journey" on the title screen, 
          it will take them to the chooseACharacter screen*/
         if(e.getSource().equals(view.startBtn)) {

            view.chooseACharacter();  
         }
         
         /*if user clicks Continue.. the game will start
          The player will be taken to the forest.*/
         if(e.getSource().equals(view.startGameBtn)){
            
            view.createGameUI();
            
            view.forestUI();          
            model.setPlayerSetting("forest");
         }        
      }
   }
   
   /*this is for the Choose A Character screen, user needs to click on a
   character name to choose then user needs to click continue. */
   class CharOptListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {

         if(e.getSource().equals(view.charOptionA)) {
            
            model.setHitpointsLevel(30);
            model.setWeaponType("Staff of Fire");
            model.setSpecialGameItem("Magic Mirror");
            
         }
         if(e.getSource().equals(view.charOptionB)) {
            
            model.setHitpointsLevel(50);
            model.setWeaponType("Diamond Bow");
            model.setSpecialGameItem("Lucky Rat");
            
         }
         if(e.getSource().equals(view.charOptionC)) {
            
            model.setHitpointsLevel(25);
            model.setWeaponType("Wand of Wisdom");
            model.setSpecialGameItem("Book of Dreams");
            
         }
      }
   }
 
   //this is for the user game option, the three buttons on the screen.
   class OptionsListener implements ActionListener {
      
      @Override
      public void actionPerformed(ActionEvent e) {
                 
         //depending on the player's setting, the view will change,
         //along with the choices the player can make on the buttons.
         switch(model.getPlayerSetting()) {
         
         case "forest":
            
            if(e.getSource().equals(view.optionA)) {
                  
               model.setPlayerSetting("castle");
               view.castleScene();
            }
            if(e.getSource().equals(view.optionB)) {

               model.poisonDamage();              
               model.setPlayerSetting("swamp");
               view.swampScene();
            }
            if(e.getSource().equals(view.optionC)) {
               
               model.setPlayerSetting("cave");
               view.caveEntrance();              
            }
            
            break;
              
         case "castle":
         
            if(e.getSource().equals(view.optionA)) {
               
               view.forestUI();          
               model.setPlayerSetting("forest");
            }
            
            if(e.getSource().equals(view.optionB)) {
               
            }
            
            if(e.getSource().equals(view.optionC)) {
               
            }
            
            break;
            
         case "swamp":
            
            if(e.getSource().equals(view.optionA)) {
              
               view.forestUI();          
               model.setPlayerSetting("forest");
            }      
            if(e.getSource().equals(view.optionB)) {

            }         
            if(e.getSource().equals(view.optionC)) {

            }
            
            break;
        
         case "cave":
            
            if(e.getSource().equals(view.optionA)) {
              
               view.caveSouth();
               model.setPlayerSetting("south");
            }
            
            if(e.getSource().equals(view.optionB)) {

               view.caveEast();
               model.setPlayerSetting("east");
            }
            
            if(e.getSource().equals(view.optionC)) {
               
               view.caveWest();
               model.setPlayerSetting("west");
               
            }
            
            break;
            
         case "south":
            
            if(e.getSource().equals(view.optionA)) {
               
               model.setSpecialGameItem("Eternal Orb ");
               view.winnerScreen();
               model.setPlayerSetting("winner");
            }
            
            if(e.getSource().equals(view.optionB)) {

               System.exit(0);
            }
            
            if(e.getSource().equals(view.optionC)) {
               
            }
            
            break;
            
         case "west":
            
            if(e.getSource().equals(view.optionA)) {
              
               view.caveEntrance();
               model.setPlayerSetting("cave");
               
            }
            
            if(e.getSource().equals(view.optionB)) {
               
            }
            
            if(e.getSource().equals(view.optionC)) {
               
            }
            
            break;
            
         case "east":
            
            if(e.getSource().equals(view.optionA)) {
               
              //fight
               if(model.bearAlive == true) {
                    model.bearDamage();
                    model.attackBear();
               }

               view.caveEast();
               model.setPlayerSetting("east");
            }
            
            if(e.getSource().equals(view.optionB)) {
               
               view.caveEntrance();
               model.setPlayerSetting("cave");
            }
            
            if(e.getSource().equals(view.optionC)) {

               view.caveEntrance();
               model.setPlayerSetting("cave");
            }
            
            break;

            case "winner":
            
            if(e.getSource().equals(view.optionA)) {
              
              System.exit(0);
            }
            
            if(e.getSource().equals(view.optionB)) {

            }
            
            if(e.getSource().equals(view.optionC)) {
               
            }
            
            break;
            
            case "gameover":
               
               if(e.getSource().equals(view.optionA)) {
                 
                  System.exit(0);
               }
               
               if(e.getSource().equals(view.optionB)) {

               }
               
               if(e.getSource().equals(view.optionC)) {
                  
               }
               
               break;
               
         }

         //if the character's heath is lower than or equal to 0, game over.
         if(model.alive == false) {
            
            view.gameOverScreen();
            model.setPlayerSetting("gameover");         
         }   
      }
   }
}

class gameModel {
   
   public static int hitpointsLevel;
   public boolean alive = true;
   public static boolean bearAlive = true;
   public static String weaponType;
   public static String specialGameItem;
   public String playerSetting;
   public static int bearHpLevel = 30;

   public gameModel(){

      characterSetup();
   }
   
   //default character set up if user doesn't choose a character
   //used to store the character's info for the status bar
   public void characterSetup() {
      
      hitpointsLevel = 20;
      weaponType = "Bow";
      specialGameItem = "Amethyst Amulet";
   }

   //Getters and setters
   public static int getHitpointsLevel() {
      return hitpointsLevel;
   }

   public void setHitpointsLevel(int hitpointsLevel) {
      gameModel.hitpointsLevel = hitpointsLevel;
   }

   public static String getWeaponType() {
      return weaponType;
   }

   public void setWeaponType(String weaponType) {
      gameModel.weaponType = weaponType;
   }

   public static String getSpecialGameItem() {
      return specialGameItem;
   }

   public void setSpecialGameItem(String specialGameItem) {
      gameModel.specialGameItem = specialGameItem;
   }
   
   public String getPlayerSetting() {
      return playerSetting;
   }

   public void setPlayerSetting(String playerSetting) {
      this.playerSetting = playerSetting;
   }

   public static int getBearHpLevel() {
      return bearHpLevel;
   }

   public static void setBearHpLevel(int bearHpLevel) {
      gameModel.bearHpLevel = bearHpLevel;
   }
   
   //Game calculations happening below
   
   //when user enters swamp, they get poison damage every time they re-enter
   public void poisonDamage() {
      
      int randomNum = new Random().nextInt(5) + 1;
      alive = true;
      setHitpointsLevel(hitpointsLevel - randomNum);
      
      if(hitpointsLevel <= 0) {
         
         alive = false;
         hitpointsLevel = 0;
      }
   }
   
   //when user clicks button to fight, the bear also causes health damage
   public void bearDamage() {
      
      int randomNum = new Random().nextInt(2) + 1;
      alive = true;
      setHitpointsLevel(hitpointsLevel - randomNum);
      
      if(hitpointsLevel <= 0) {
         
         alive = false;
         hitpointsLevel = 0;
      }
   }

   //when user clicks button to fight, the user causes damage to the bear
   public void attackBear() {
      
      int randomNum = new Random().nextInt(10);
      bearAlive = true;
      setBearHpLevel(bearHpLevel - randomNum);
      
      if(bearHpLevel <= 0) {
         
         bearHpLevel = 0;
         bearAlive = false;
      }
   }
}

class gameView extends JFrame {

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
   
   //loads up the title screen/main menu, starts up the game
   public gameView(){
      
      super(); //constructor
      setTitle("The Far Far Away");
      setLayout(new BorderLayout()); 
      
      //set up main game panel, title screen panel, and title screen text
      gamePanel = new JPanel();
      gamePanel.setBackground(Color.black);
  
      titleScreen = new JPanel();
      titleScreen.setBackground(Color.black);
      
      title = new JLabel ("The Far Far Away");
      title.setForeground(Color.red);
      title.setFont(new Font("Book Antiqua", Font.PLAIN, 90));
      
      titleScreen.add(title);
      
      //create new JButtons for game
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
   
   //create the actual game interface where players gets to play
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
      statusBar.setBounds(100,250,600,50); //x,y,width, height
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

   //button listener for start title screen/main menu
   void addButtonListener(ActionListener listenForButton) {
      
      startBtn.addActionListener(listenForButton);
   }
   
   //button listener for game options
   void addOptionsListener(ActionListener listenForButton) {
      
      optionA.addActionListener(listenForButton);
      optionB.addActionListener(listenForButton);
      optionC.addActionListener(listenForButton);
   }
   
   //display character information on status bar
   public void characterInfo() {
      
      healthNumLabel.setText(" " + gameModel.hitpointsLevel);
      weaponTypeLabel.setText(gameModel.weaponType);
      specialItemType.setText(gameModel.specialGameItem);
   }
   
   //shows 3 character option for user to choose from
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
   
   //buttons for the 3 characters.
   void addOption(ActionListener listenForButton) {
      
      charOptionA.addActionListener(listenForButton);
      charOptionB.addActionListener(listenForButton);
      charOptionC.addActionListener(listenForButton);
   }
   
   //add listener to Continue.. button, to progress the game
   void addGameBtnListener(ActionListener listenForButton) {
      
      startGameBtn.addActionListener(listenForButton);   
   }
 
   /*Game UI methods below -- updating gameTextArea with new info and changing
    button options. The screen updates with the help of the controller*/
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
