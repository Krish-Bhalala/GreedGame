import java.util.List;
import java.util.Scanner;

/**
 * HumanPlayer represents a human player that interacts with the game via console input.
 * It implements the Player interface
 */
public class HumanPlayer implements Player {
    private Scanner scanner;
    
    //Constructor
    public HumanPlayer() {
        //initializes a new Scanner to read from System.in
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Allows the human player to choose a selection from the available options
     * by displaying the options and reading input from the console.
     * 
     * @param options List of selectable options available to the player
     * @param gameState The current viewable state of the game
     * @return The selected option from the list, or null if selection was invalid
     */
    @Override
    public Selectable chooseSelection(List<Selectable> options, Viewable gameState) {
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

    //if the move selected is from the valid move list
    public Selectable findSelectedMove(List<Selectable> options, int key){
        for (Selectable option : options) {
            if(option instanceof Equitable && ((Equitable)option).equals(key)){
                return option;
            }
        } 
        return null;
    }
    
    /**
     * Clean up resources when the player is no longer needed.
     * This method could be called when the game is shutting down.
     */
    public void close() {
        if(scanner != null) scanner.close();
    }
}