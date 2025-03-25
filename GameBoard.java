public abstract class GameBoard implements Boardable {
    private String[][] board;
    private int rows;
    private int cols;
    
    public GameBoard(int rows, int cols) {
        if(rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];
    }
    
    @Override
    public void setCellAt(int row, int col, String c) {
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new IllegalArgumentException("Invalid row or column");
        }
        this.board[row][col] = c;
    }
    
    @Override
    public String getCellAt(int row, int col) {
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
        //System.out.println();
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                String cellContent = this.board[i][j]; // Get the cell content
                if (!cellContent.equals(Constants.GameConstants.PLAYER_INSIGNIA) && !cellContent.equals(Constants.GameConstants.EMPTY_SPACE)) { // Only colorize numbers
                    String randomColor = Constants.GameConstants.COLORS[Constants.GameConstants.RANDOM.nextInt(Constants.GameConstants.COLORS.length)]; // Pick color based on number
                    System.out.print(randomColor + cellContent + Constants.GameConstants.RESET_COLOR + ""); // Print colored number
                } else {
                    System.out.print(cellContent); // Print player insignia and spaces without color
                }
            }
            System.out.println();
        }
    }
    
    @Override
    public abstract void reset();
}