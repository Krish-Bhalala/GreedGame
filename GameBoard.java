// CLASS: GameBoard
//
// Author: Krish Bhalala
//
// REMARKS: This abstract class implements the Boardable interface and provides
// basic functionality for a game board.
//
//-----------------------------------------

public abstract class GameBoard implements Boardable {
    // Class variables
    private String[][] board; // 2D array to represent the game board
    private int rows; // Number of rows in the board
    private int cols; // Number of columns in the board
    
    //------------------------------------------------------
    // GameBoard
    //
    // PURPOSE: Constructor to initialize a base game board
    // PARAMETERS:
    //     rows - Number of rows for the board
    //     cols - Number of columns for the board
    // Returns: None
    //------------------------------------------------------
    public GameBoard(int rows, int cols) {
        if(rows < 1 || cols < 1) {      //board should atleast contain 1 cell
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];        //initialise an empty board
    }
    
    //------------------------------------------------------
    // setCellAt
    //
    // PURPOSE: Sets the content of a specific cell on the board
    // PARAMETERS:
    //     row - The row of the cell
    //     col - The column of the cell
    //     c - The content to set in the cell
    // Returns: None
    //------------------------------------------------------
    @Override
    public void setCellAt(int row, int col, String c) {
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        this.board[row][col] = c;
    }
    
    //------------------------------------------------------
    // getCellAt
    //
    // PURPOSE: Gets the content of a specific cell on the board
    // PARAMETERS:
    //     row - The row of the cell
    //     col - The column of the cell
    // Returns: The content of the specified cell
    //------------------------------------------------------
    @Override
    public String getCellAt(int row, int col) {
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        return this.board[row][col];
    }
    
    //GETTERS
    @Override
    public int getRows() {
        return this.rows;
    }
    @Override
    public int getCols() {
        return this.cols;
    }
    
    //------------------------------------------------------
    // view
    //
    // PURPOSE: Displays the current state of the game board
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    @Override
    public void view() {
        //System.out.println();
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                String cellContent = this.board[i][j];      // Get the cell content
                if (!cellContent.equals(Constants.GameConstants.PLAYER_INSIGNIA) && !cellContent.equals(Constants.GameConstants.EMPTY_SPACE)) { 
                    // Only colorize numbers
                    String randomColor = Constants.GameConstants.COLORS[Constants.GameConstants.RANDOM.nextInt(Constants.GameConstants.COLORS.length)]; // Pick color based on number
                    System.out.print(randomColor + cellContent + Constants.GameConstants.RESET_COLOR + ""); // Print colored number
                } else {
                    System.out.print(cellContent); // Print player insignia and spaces without color
                }
            }
            System.out.println();
        }
    }
    
    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Resets the content of the game board according to the specific game 
    // NOTE: Must be overided
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    @Override
    public abstract void reset();
}