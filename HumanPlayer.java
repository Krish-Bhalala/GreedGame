// CLASS: HumanPlayer
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a human player that interacts with the game via console input.
//          It implements the Player interface.
//
//-----------------------------------------

import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    // Class variables
    private String name;  // Name of the human player
    private Scanner scanner;  // Scanner for reading user input
    
    //------------------------------------------------------
    // HumanPlayer
    //
    // PURPOSE: Constructor to initialize a human player
    // PARAMETERS:
    //     name - The name of the human player
    // Returns: None
    //------------------------------------------------------
    public HumanPlayer(String name) {
        this.name = name;
        //initializes a new Scanner to read from System.in
        this.scanner = new Scanner(System.in);
    }

    // Getter for player name
    public String getName(){
        return name;
    }
    
    //------------------------------------------------------
    // chooseSelection
    //
    // PURPOSE: Allows the human player to choose a selection from available options
    // PARAMETERS:
    //     options - List of selectable options available to the player
    //     gameState - The current viewable state of the game
    // Returns: The selected option from the list, or null if selection was invalid
    //------------------------------------------------------
    @Override
    public Selectable chooseSelection(List<Selectable> options) {
        Selectable move = null;
        while(null == move){
            System.out.print("Enter your choice: ");
        
            // Read player input
            String input = scanner.nextLine().trim();
            
            // Handle empty input
            if (input.isEmpty()) {
                System.out.println("Invalid selection. Please add something, plizzz :)");
                return null;
            }

            char selection = input.charAt(0);
            int selection_key = (int)selection - '0';
            
            // Find the corresponding selectable option
            move = findSelectedMove(options, selection_key);
            if(move != null){
                return move;
            }
            
            // If we got here, the selection was invalid
            System.out.println("Invalid selection. That move is not allowed");
        }
        return null;
    }

    //------------------------------------------------------
    // findSelectedMove
    //
    // PURPOSE: Finds the selected move from the list of valid moves
    // PARAMETERS:
    //     options - List of selectable options
    //     key - The key representing the selected move
    // Returns: The selected Selectable object if found, null otherwise
    //------------------------------------------------------
    public Selectable findSelectedMove(List<Selectable> options, int key){
        for (Selectable option : options) {
            if(option instanceof Equitable && ((Equitable)option).equals(key)){
                return option;
            }
        } 
        return null;
    }
    
    
    //------------------------------------------------------
    // close
    //
    // PURPOSE: Cleans up resources when the player is no longer needed
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public void close() {
        if(scanner != null) scanner.close();
    }

    //prints the name of the player
    public void view(){
        System.out.println(name);
    }
}
