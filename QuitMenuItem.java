public class QuitMenuItem extends MenuItem {
    public QuitMenuItem() {
        super(Constants.MenuConstants.QUIT, "Quit the game");
    }

    public boolean select(Viewable v, GameLogical gl) {
        //quit the game
        System.out.println("Thank You for playing the game. Goodbye!");
        System.exit(0);
        return false;   //fallback for the exit failure
    }
}
