// CLASS: GameLogical
//
// Author: Krish Bhalala
//
// REMARKS: This interface defines the behaviour of any game
//
//-----------------------------------------
public interface GameLogical extends Viewable {
    //Methods
    boolean nextState(Viewable v);//return of false implies there is no next state
    void reset();
}
