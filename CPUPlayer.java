// CLASS: CPUPlayer
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a CPU player in the game.
//          It implements the Player interface.
//
//-----------------------------------------

import java.util.List;
import java.util.Random;

public class CPUPlayer implements Player {
    // Class variables
    private String name;  // Name of the CPU player
    private Random random;  // Random number generator for move selection

    //------------------------------------------------------
    // CPUPlayer
    //
    // PURPOSE: Constructor to initialize a CPU player
    // PARAMETERS:
    //     name - The name of the CPU player
    // Returns: None
    //------------------------------------------------------
    public CPUPlayer(String name) {
        this.name = name;
        this.random = new Random();
    }

    //------------------------------------------------------
    // chooseSelection
    //
    // PURPOSE: Selects a random move for the CPU player
    // PARAMETERS:
    //     possibleMoves - List of possible moves to choose from
    //     gameState - Current state of the game (not used in this implementation)
    // Returns: A randomly selected Selectable move
    //------------------------------------------------------
    @Override
    public Selectable chooseSelection(List<Selectable> possibleMoves) {
        // Check if there are any moves available
        if (possibleMoves.isEmpty()) {
            throw new IllegalStateException("No moves available");
        }

        // Select a random move from 1 to 9, excluding the BACK_TO_MENU move
        return possibleMoves.get(random.nextInt(possibleMoves.size() - 1));
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: prints the name of the player
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public void view(){
        System.out.println(name);
    }
}