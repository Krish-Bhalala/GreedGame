// CLASS: GameStats
//
// Author: Krish Bhalala
//
// REMARKS: This class keeps track of game score.
//          It implements the Viewable interface.
//
//-----------------------------------------

public class GameStats implements Viewable {
    // Class variable
    private int score;  // Current score of the game
    
    //------------------------------------------------------
    // GameStats
    //
    // PURPOSE: Constructor to initialize game stats
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public GameStats() {
        score = 0;
    }
    
    //------------------------------------------------------
    // incrementScore
    //
    // PURPOSE: Increases the current score by a given amount
    // PARAMETERS:
    //     points - The number of points to add to the score
    // Returns: None
    //------------------------------------------------------
    public void incrementScore(int points) {
        score += points;
    }
    
    // Getters
    public int getScore() {
        return score;
    }
    
    //------------------------------------------------------
    // resetScore
    //
    // PURPOSE: Resets the score to zero
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public void resetScore() {
        score = 0;
    }
    
    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays the current score
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    @Override
    public void view() {
        System.out.print(" Score: " + score + " ");
    }
}
