// CLASS: GameLogic
//
// Author: Krish Bhalala
//
// REMARKS: This class keeps track of game statistics, specifically the score.
//          It implements the Viewable interface.
//
//-----------------------------------------
public abstract class GameLogic implements GameLogical {

    //Computes the next state of the game
    public abstract boolean nextState(Viewable v);
    
    //Resets the state of the game
    public abstract void reset();

    //Display's the game's state
    public abstract void view();

}
