// CLASS: NewGameMenuItem
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a menu item specifically for starting a new game. 
//
//-----------------------------------------
public class NewGameMenuItem extends MenuItem{
    //CONSTRUCTOR
    public NewGameMenuItem() {
        super(Constants.MenuConstants.BEGIN_NEW_GAME, "Start New Game");
    }

    //SELCTOR
    //changes the state of the game from not playing to playing
    public boolean select(Viewable v, GameLogical gl) {
        gl.reset();         //reset the game 
        return true;        //switch to game mode
    }
}
