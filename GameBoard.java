public class GameBoard implements Boardable{
    private char[][] board;
    private int width;
    private int height;
    private int[] playerPosition;

    public GameBoard(int w, int h){
        if(w < 1 || h < 1) throw new IllegalArgumentException("Width and height must be greater than 0");
        width = w;
        height = h;
        playerPosition = new int[2];
        playerPosition[0] = width/2;
        playerPosition[1] = height/2;

        board = new char[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(i == playerPosition[1] && j == playerPosition[0]) 
                    board[i][j] = Constants.GameConstants.PLAYER_TOKEN;
                else
                    board[i][j] = (char)(Math.random()*Constants.GameConstants.ASCII_RANGE + Constants.GameConstants.ASCII_OFFSET_ZERO);
            }
        }
    }

    public void view(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void reset(){
        playerPosition = new int[2];
        playerPosition[0] = width/2;
        playerPosition[1] = height/2;

        board = new char[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(i == playerPosition[1] && j == playerPosition[0]) 
                    board[i][j] = Constants.GameConstants.PLAYER_TOKEN;
                else
                    board[i][j] = (char)(Math.random()*Constants.GameConstants.ASCII_RANGE + Constants.GameConstants.ASCII_OFFSET_ZERO);
            }
        }
    }
}
