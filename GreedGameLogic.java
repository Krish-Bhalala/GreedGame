// CLASS: GreedGameLogic
//
// Author: Krish Bhalala
//
// REMARKS: This class defines the game logic specific to greed game
//
//-----------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreedGameLogic extends GameLogic {
    private GameStats stats;                    //current score/stats of the player
    private List<Selectable> currentMoves;      //all possible valid moves from a given state
    private Player player;                      //current player
    private boolean gameOver;                   
    private boolean isEasyMode = false;         //Used for turning the move hints on
    
    //CONSTRUCTOR
    public GreedGameLogic() {
        this.stats = new GameStats();
        this.currentMoves = new ArrayList<>();
        this.gameOver = false;
        this.reset();               //populates the instances data members with default value
    }
    
    //getters
    public boolean isGameOver() {
        return gameOver;
    }
    
    // generatePossibleMoves
    //
    // PURPOSE: Generates a list of all possible moves from the current position
    // PARAMETERS:
    //     Viewable v - Current state of the game (specifically greed game board)
    // Returns: List of all the valid game moves
    //------------------------------------------------------
    public List<GameMove> generatePossibleMoves(Viewable v) {
        GreedGameBoard board = null;
        if(v instanceof GreedGameBoard){
            board = (GreedGameBoard)v;
        }else{
            return null;            //since this is greed game this should have greed game board only
        }

        //initialise the curr coordinates and move list
        List<GameMove> moves = new ArrayList<>();
        int playerRow = board.getPlayerRow();
        int playerCol = board.getPlayerCol();
        
        // Validate all 8 directional moves
        for (Constants.GameConstants.Direction dir : Constants.GameConstants.Direction.values()) {
            //calculate the coordinates of the idx for distance of the move
            int newRow = playerRow + dir.getRowOffset();
            int newCol = playerCol + dir.getColOffset();
            
            //check if that  distance idx is valid
            if (newRow >= 0 && newRow < board.getRows() && 
                newCol >= 0 && newCol < board.getCols()) {
                
                //find the distance to travel
                String cellValue = board.getCellAt(newRow, newCol);         
                try{
                    int distance = Integer.valueOf(cellValue);              
                    
                    // Check if this move is valid
                    if (distance >= 1 && distance <= 9 && board.isValidLocation(dir, distance)) {
                        moves.add(new GreedGameMove(dir, distance));        //add it to the valid move list
                    }
                }catch(Exception e){
                    continue; //skip that move
                }
            }
        }
        
        return moves; 
    }
    

    // nextState
    //
    // PURPOSE: Advances the game to the next state
    // PARAMETERS:
    //     Viewable v - Viewable component specifically the greed game board
    // Returns: true if in game mode, false otherwise
    //------------------------------------------------------
    @Override
    public boolean nextState(Viewable v) {
        // Clear previous moves
        currentMoves.clear();
        
        // Generate all possible moves from current state
        List<GameMove> possibleMoves = generatePossibleMoves(v);
        
        // Check if game is over
        if (possibleMoves.isEmpty()) {
            System.out.println("Game Over! No more valid moves.");
            System.out.println("Final Score: " + stats.getScore());
            gameOver = true;
            return false; // Return to menu
        }
        
        // Add all possible moves to current moves
        currentMoves.addAll(possibleMoves);
        
        // Add return to menu option
        // Make sure that BackToMenuOption always stays at the end of the list
        currentMoves.add(new BackToMenuOption());
        
        // Display available moves if a Human Player is playing in easy mode
        if(isEasyMode && this.player instanceof HumanPlayer){
            System.out.println("Available moves:");
            for (Selectable move : currentMoves) {
                if(move instanceof Viewable){
                    ((Viewable)move).view();
                }
            }
        }else{
            System.out.println("Press " + Constants.MenuConstants.BACK_TO_MENU + " to return back to menu");
        }
        
        // Ask the player to choose a move
        Selectable selectedMove = player.chooseSelection(currentMoves);
        
        // Execute the selected move
        boolean continueGame = true;
        if (selectedMove != null) {
            continueGame = selectedMove.select(v, this);        //select the move
            
            // If the selected move was a game move, update score
            if (selectedMove instanceof GreedGameMove) {
                GreedGameMove gameMove = (GreedGameMove) selectedMove;
                stats.incrementScore(gameMove.getDistance());
            }
        }
        
        return continueGame;
    }
    
    //Resets the game to its initial state
    @Override
    public void reset() {
        stats.resetScore();     // Reset the score
        
        currentMoves.clear();   // Clear current moves

        //reset the player to HumanPlayer or CPUPlayer based on user input
        System.out.println();
        System.out.println("-------------------------------");
        System.out.print("Are you Playing As Human? [Y/N] => ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next().toUpperCase();
        if(response.equals("Y")){
            this.player = new HumanPlayer("I'm A Human Student Studying OOPs with Oliver");
            System.out.print("Want to Play in Easy Mode? [Y/N] => ");
            response = scanner.next().toUpperCase();
            if(response.equals("Y")){
                isEasyMode = true;
            }else{
                isEasyMode = false;
            }
        }else{
            this.player = new CPUPlayer("I'm A CPU Player NOT Studying OOPs with Oliver");
        }

        //display whose playing
        System.out.print("Get ready to play: ");
        this.player.view();
        
        // Reset game over flag
        gameOver = false;
    }

    //Displays the game stats
    public void view(){
        System.out.print("Game stats: ");
        this.stats.view();
        System.out.println();
    }
}
