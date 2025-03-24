public class GreedGameBoard extends GameBoard{
    private int playerRow;
    private int playerCol;

    public GreedGameBoard(int row, int col){
        super(row,col);
        if(row < 1 || col < 1) throw new IllegalArgumentException("Width and height must be greater than 0");
        reset();        //reset the game board values and player's position
    }

    //getters
    public int getPlayerRow(){
        return playerRow;
    }
    public int getPlayerCol(){
        return playerCol;
    }

    //checks whether the move location is valid
    public boolean isValidLocation(Constants.GameConstants.Direction direction, int distance){
        int dest_row = playerRow + (distance*direction.getRowOffset());
        int dest_col = playerCol + (distance*direction.getColOffset());

        if(dest_col<0 || dest_col>=getCols() || dest_row<0 || dest_row>=getRows()){
            return false;   //player is going out of board
        }
        return true;
    }

    public void setPlayerPosition(int row, int col) {
        setCharAt(playerRow, playerCol, Constants.GameConstants.EMPTY_SPACE);
        this.playerRow = row;
        this.playerCol = col;
        setCharAt(playerRow, playerCol, Constants.GameConstants.PLAYER_INSIGNIA);
    }
    
    public void executeMove(Constants.GameConstants.Direction direction, int distance) {
        if(!isValidLocation(direction, distance)) return;
        int curr_row_idx = getPlayerRow();
        int curr_col_idx = getPlayerCol();
        final int DEST_ROW_IDX = playerRow + (distance*direction.getRowOffset());
        final int DEST_COL_IDX = playerCol + (distance*direction.getColOffset());

        while(curr_row_idx>=0 && curr_col_idx>=0 && curr_row_idx<=DEST_ROW_IDX && curr_col_idx<=DEST_COL_IDX){
            setCharAt(curr_row_idx, curr_col_idx, Constants.GameConstants.EMPTY_SPACE);
            curr_row_idx += direction.getRowOffset();
            curr_col_idx += direction.getColOffset();
        }   

        //move the player
        setPlayerPosition(DEST_ROW_IDX, DEST_COL_IDX);
    }


    //prints the board
    public void view(){
        super.view();
    }

    @Override
    public void reset(){
        //reset the player position
        playerRow = getRows()/2;
        playerCol = getCols()/2;

        //fill the board with the random chars
        for (int i = 0; i < getRows(); i++){
            for (int j = 0; j < getCols(); j++){
                if(i == playerRow && j == playerCol){
                    setCharAt(i, j, Constants.GameConstants.PLAYER_INSIGNIA);
                }else{
                    char random_char = (char)(Math.random()*Constants.GameConstants.ASCII_RANGE + Constants.GameConstants.ASCII_OFFSET_ZERO);
                    setCharAt(i, j, random_char);
                }
            }
        }
    }
}

