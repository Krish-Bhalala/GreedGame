// CLASS: QuitMenuItem
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a menu item specifically for quiting the game
//
//-----------------------------------------

public class QuitMenuItem extends MenuItem {
    //CONSTRUCTOR
    public QuitMenuItem() {
        super(Constants.MenuConstants.QUIT, "Quit the game");
    }

    //SELECTOR
    //behaviour of game when this menu item is selected by user
    public boolean select(Viewable v, GameLogical gl) {
        //quits the game
        System.out.println("Thank You for playing the game. Goodbye!");
        System.exit(0);
        return false;   //fallback for the exit failure
    }
}
