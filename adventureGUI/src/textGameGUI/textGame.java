package textGameGUI;

/*Text game GUI developed using MVC model. 
 *Name: Jasmine Guevara
 *Course: CST338-40
 *Date: 12/18/2020 
 **/ 


public class textGame {

   public static void main(String[] args) {
      
      gameView view = new gameView();
      gameModel model = new gameModel();
      
      gameController controller = new gameController(view, model);
      
      view.setVisible(true);
   }

}
