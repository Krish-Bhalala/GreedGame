// CLASS: BackToMenuOption
//
// Author: Krish Bhalala
//
// REMARKS: This class represents an option to go back to the main menu in a game.
//          It implements Selectable, Viewable, and Equitable interfaces.
//
//-----------------------------------------

public class BackToMenuOption implements Selectable, Viewable, Equitable {
    // Class variables
    int key;                // The key associated with this option
    String description;     // The description of this option

    //------------------------------------------------------
    // BackToMenuOption
    //
    // PURPOSE: Constructor to initialize the BackToMenuOption
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public BackToMenuOption() {
        key = Constants.MenuConstants.BACK_TO_MENU;
        description = "Back to Main Menu";
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE: Handles the selection of the back to menu option
    // PARAMETERS:
    //     v - A Viewable object to print the final score
    // Returns: boolean - always false to indicate not continuing
    //------------------------------------------------------
    public boolean select(Viewable v, GameLogical gl) {
        // Display the final score before terminating the game
        System.out.println();
        v.view();
        
        // Inform the user about going back to menu
        System.out.println("Ok, going back to menu");
        System.out.println("--------------------------------------------------------------------------\n");
        
        return false;
    }

    //------------------------------------------------------
    // equals
    //
    // PURPOSE: Checks if the given key matches this option's key
    // PARAMETERS:
    //     key - The key to compare with this option's key
    // Returns: boolean - true if keys match, false otherwise
    //------------------------------------------------------
    public boolean equals(int key) {
        return this.key == key;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays this option
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public void view() {
        System.out.println("(" + key + ") " + description);
    }
}
