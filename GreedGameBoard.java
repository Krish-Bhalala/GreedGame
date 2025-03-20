public class GreedGameBoard extends GameBoard{
    private int playerRow;
    private int playerCol;
    private static final char PLAYER_INSIGNIA = '@';
    private static final char EMPTY_SPACE = ' ';

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
                    setCharAt(i, j, PLAYER_INSIGNIA);
                }else{
                    char random_char = (char)(Math.random()*Constants.GameConstants.ASCII_RANGE + Constants.GameConstants.ASCII_OFFSET_ZERO);
                    setCharAt(i, j, random_char);
                }
            }
        }
    }
}

