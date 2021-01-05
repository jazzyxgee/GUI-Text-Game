package textGameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameController {

   private gameView view;
   private gameModel model;
    
   public gameController(gameView view, gameModel model) {
      
      this.view = view;
      this.model = model;
    
      this.view.addButtonListener(new ViewListener());
      this.view.addGameBtnListener(new ViewListener());
      this.view.addOption(new CharOptListener());
      this.view.addOptionsListener(new OptionsListener());
   }
   
   class ViewListener implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
        
         
         if(e.getSource().equals(view.startBtn)) {
            
            
            view.chooseACharacter();  
            
         }
         if(e.getSource().equals(view.startGameBtn)){
            
            view.createGameUI();
            
            view.forestUI();          
            model.setPlayerSetting("forest");
         
         }
         
      }

   }
   
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
            model.setWeaponType("Wand of Wisdom ");
            model.setSpecialGameItem("Book of Dreams");
            
         }
         
      }

   }
   
   class OptionsListener implements ActionListener {
      
      @Override
      public void actionPerformed(ActionEvent e) {
                 
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
