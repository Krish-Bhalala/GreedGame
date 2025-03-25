import java.util.ArrayList;
import java.util.List;

public class GreedGameLogic extends GameLogic {
    private GreedGameBoard board;
    private GameStats stats;
    private List<Selectable> currentMoves;
    private Player player;
    private boolean gameOver;
    
    public GreedGameLogic(GreedGameBoard board) {
        this.board = board;
        this.stats = new GameStats();
        //this.player = new HumanPlayer("I'm A Human Student Studying COMP2150 with Oliver");
        this.player = new CPUPlayer("I'm A CPU Player NOT Studying COMP2150 with Oliver");
        this.currentMoves = new ArrayList<>();
        this.gameOver = false;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Generates a list of all possible moves from the current position
     * @return List of valid game moves
     */
    public List<GameMove> generatePossibleMoves() {
        List<GameMove> moves = new ArrayList<>();
        int playerRow = board.getPlayerRow();
        int playerCol = board.getPlayerCol();
        
        // Check all 8 directions
        for (Constants.GameConstants.Direction dir : Constants.GameConstants.Direction.values()) {
            //calculate the coordinates of the next move
            int newRow = playerRow + dir.getRowOffset();
            int newCol = playerCol + dir.getColOffset();
            
            //check if the adjacent position is valid
            if (newRow >= 0 && newRow < board.getRows() && 
                newCol >= 0 && newCol < board.getCols()) {
                
                String cellValue = board.getCellAt(newRow, newCol);
                try{
                    int distance = Integer.valueOf(cellValue);
                    
                    // Check if this move is valid
                    if (distance >= 1 && distance <= 9 && board.isValidLocation(dir, distance)) {
                        moves.add(new GameMove(dir, distance));
                    }
                }catch(Exception e){
                    //skip
                }
            }
        }
        
        
        return moves;
    }
    
    /**
     * Advances the game to the next state
     * @param v Viewable component to update
     * @return true if in game mode, false otherwise
     */
    @Override
    public boolean nextState(Viewable v) {
        // Clear previous moves
        currentMoves.clear();
        
        // Generate all possible moves
        List<GameMove> possibleMoves = generatePossibleMoves();
        
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
        
        // Display available moves
        System.out.println("Available moves:");
        for (Selectable move : currentMoves) {
            if(move instanceof Viewable){
                ((Viewable)move).view();
            }
        }
        
        // Let the player choose a move
        Selectable selectedMove = player.chooseSelection(currentMoves, board);
        
        // Apply the selected move
        boolean continueGame = true;
        if (selectedMove != null) {
            continueGame = selectedMove.select(board, this);
            
            // If the selected move was a game move, update score
            if (selectedMove instanceof GameMove) {
                GameMove gameMove = (GameMove) selectedMove;
                stats.incrementScore(gameMove.getDistance());
            }
        }
        
        return continueGame;
    }
    
    /**
     * Resets the game to its initial state
     */
    @Override
    public void reset() {
        // Reset the board
        board.reset();
        
        // Reset the score
        stats.resetScore();
        
        // Clear current moves
        currentMoves.clear();
        
        // Reset game over flag
        gameOver = false;
    }

    public void view(){
        System.out.print("Game stats: ");
        this.stats.view();
        System.out.println();
    }
}
