package textGameGUI;

import java.util.Random;

public class gameModel {
   
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
   
   //Game mechanics 
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

   public void poisonDamage() {
      
      int randomNum = new Random().nextInt(5) + 1;
      alive = true;
      setHitpointsLevel(hitpointsLevel - randomNum);
      
      if(hitpointsLevel <= 0) {
         
         alive = false;
         hitpointsLevel = 0;
         
      }
      
      
   }
   
   public void bearDamage() {
      
      int randomNum = new Random().nextInt(2) + 1;
      alive = true;
      setHitpointsLevel(hitpointsLevel - randomNum);
      
      if(hitpointsLevel <= 0) {
         
         alive = false;
         hitpointsLevel = 0;
         
      }
      
      
   }

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
