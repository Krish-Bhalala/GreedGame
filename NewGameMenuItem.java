public class NewGameMenuItem extends MenuItem{
    public NewGameMenuItem() {
        super(Constants.MenuConstants.BEGIN_NEW_GAME, "Start New Game");
    }

    public boolean select(Viewable v, GameLogical gl) {
        //switch to game mode
        return true;
    }
}
