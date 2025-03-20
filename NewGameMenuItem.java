public class NewGameMenuItem extends MenuItem{
    public NewGameMenuItem() {
        super(Constants.MenuConstants.BEGIN_NEW_GAME, "Start New Game");
    }

    public boolean select(Viewable v, GameLogical gl) {
        if(gl instanceof Menu){
            ((Menu)gl).removeMenuItem(this);
            //add the back to menu option to the current menu
            ((Menu)gl).addMenuItem(new BackMenuItem());
        }
        return true;
    }
}
