public class Main {
    public static void main(String[] args) {
        //Create a new game
        GameLogic logic = new GameLogic();
        GameBoard board = new GameBoard(80,20);
        Menu menu = new Menu("Welcome to Greed!", false);

        Game game = new GreedGame(logic, board, menu);
        //Run the game
        game.run();
    }
}
