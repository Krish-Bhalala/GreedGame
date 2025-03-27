// CLASS: GameMove
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a move in the game, implementing Selectable, Viewable, and Equitable interfaces.
//
//-----------------------------------------
public class GreedGameMove extends GameMove{
    // Class variables
    private Constants.GameConstants.Direction direction;  // Direction of the move
    private int distance;  // Distance of the move
    
    
    //------------------------------------------------------
    // GameMove
    //
    // PURPOSE: Constructor to initialize a game move
    // PARAMETERS:
    //     direction - The direction of the move
    //     distance - The distance of the move
    // Returns: None
    //------------------------------------------------------
    public GreedGameMove(Constants.GameConstants.Direction direction, int distance) {
        super("Move "+ distance + " blocks " + direction.name());
        this.direction = direction;
        this.distance = distance;
    }   
    
    // Getter for direction
    public Constants.GameConstants.Direction getDirection() {
        return direction;
    }
    
    // Getter for distance
    public int getDistance() {
        return distance;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays the move information
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    @Override
    public void view(){
        System.out.print("(" + direction.getKey() + ") ");
        super.view();
    }

    //------------------------------------------------------
    // equals
    //
    // PURPOSE: Checks if the given key matches this move's direction key
    // PARAMETERS:
    //     key - The key to compare
    // Returns: true if keys match, false otherwise
    //------------------------------------------------------
    public boolean equals(int key){
        return Integer.parseInt("" + this.direction.getKey()) == key;
    }
    
    //------------------------------------------------------
    // select
    //
    // PURPOSE: Executes the move on the game board
    // PARAMETERS:
    //     v - The Viewable object (expected to be a GreedGameBoard)
    // Returns: true if the move was executed, false otherwise
    //------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        System.out.print("Let's ");
        super.view();
        System.out.println();
        if(v instanceof GreedGameBoard){
            GreedGameBoard board = (GreedGameBoard)v;
            //move the player insignia
            board.executeMove(direction, distance);
            return true;
        }
        return false;
    }
}
