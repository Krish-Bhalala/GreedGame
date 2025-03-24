public abstract class GameBoard implements Boardable {
    private char[][] board;
    private int rows;
    private int cols;
    
    public GameBoard(int rows, int cols) {
        if(rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
    }
    
    @Override
    public void setCharAt(int row, int col, char c) {
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        this.board[row][col] = c;
    }
    
    @Override
    public char getCharAt(int row, int col) {
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        return this.board[row][col];
    }
    
    @Override
    public int getRows() {
        return this.rows;
    }
    
    @Override
    public int getCols() {
        return this.cols;
    }
    
    @Override
    public void view() {
        System.out.println();
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                System.out.print(this.board[i][j]);
                //System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    @Override
    public abstract void reset();
}