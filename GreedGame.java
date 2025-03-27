//-----------------------------------------
// NAME	: Krish Bhalala
// STUDENT NUMBER : 797497
// COURSE : COMP 215
// INSTRUCTOR : Oliver
// ASSIGNMENT : assignment
//
// REMARKS: This program implements the Greed game, initializing the game component
// and starting the game loop
//
//-----------------------------------------

import java.util.Scanner;

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
        GreedGameLogic gameLogic = new GreedGameLogic();

        // Create menu with welcome message
        Menu menu = new Menu("Welcome to Greed Game!");

        // Create a greed game
        Game game = new GreedGame(board,gameLogic,menu);

        //run the greed game
        game.run();
    
    }
}