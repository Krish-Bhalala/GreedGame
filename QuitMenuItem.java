public class QuitMenuItem extends MenuItem {
    public QuitMenuItem(int menuCode, String message) {
        super(menuCode, message);
    }

    public boolean select(Viewable v, GameLogical gl) {
        //quit the game
        return false;
    }
}
