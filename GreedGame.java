public class GreedGame extends Game {
    private static final int BOARD_ROWS = 20;
    private static final int BOARD_COLS = 80;

    /**
     * Constructs a new Greed game with all required components
     */
    public GreedGame(GreedGameBoard board, GreedGameLogic gameLogic, Menu menu) {
        super(gameLogic, board, menu);
    }

    public static void main(String[] args) {
        // Create the game board
        GreedGameBoard board = new GreedGameBoard(BOARD_ROWS, BOARD_COLS);

        // Create game logic with the board
        GreedGameLogic gameLogic = new GreedGameLogic(board);

        // Create menu with welcome message
        Menu menu = new Menu("Welcome to Greed!",false);

        GreedGame game = new GreedGame(board,gameLogic,menu);
        game.run();
    }
}