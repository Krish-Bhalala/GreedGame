// CLASS: Player
//
// Author: Krish Bhalala
//
// REMARKS: This interface defines behaviour of different kinds of players (eg- Human, CPU, etc)
//
//-----------------------------------------

import java.util.List;


public interface Player extends Viewable{
    //------------------------------------------------------
    // chooseSelection
    //
    // PURPOSE: Player should be resposible for choosing their move for any game
    // PARAMETERS:
    //     options - a list of all selectable moves from any state of the game
    //     gameState - current state of the game
    // Returns: Selectable (the move selected by the player)
    //------------------------------------------------------
    public Selectable chooseSelection(List<Selectable> options);

    //------------------------------------------------------
    // view
    //
    // PURPOSE: print the player's info
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public abstract void view();
}