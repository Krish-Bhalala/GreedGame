// CLASS: GameMove
//
// Author: Krish Bhalala
//
// REMARKS: This class keeps track of basic properties of game moves that any game could have
//
//-----------------------------------------
public abstract class GameMove implements Selectable, Viewable, Equitable {
    private String description;         // Description of the move

    //CONSTRUCTOR
    public GameMove(String description){
        this.description = description;
    }

    //Display the move description
    public void view(){
        System.out.println(description);
    }

    //SELECTOR
    public abstract boolean select(Viewable v, GameLogical gl);

    //COMPARATOR
    //To compare/search based on some key
    public abstract boolean equals(int key);

}
