public class BackMenuItem extends MenuItem{
    public BackMenuItem() {
        super(Constants.MenuConstants.BACK_TO_MENU, "Back to Main Menu");
    }

    public boolean select(Viewable v, GameLogical gl) {
        //remove the BackMenuItem from the current menu, since there should be no back to menu option in main menu
        if(gl instanceof Menu){
            ((Menu)gl).removeMenuItem(this);
        }
        return false;
    }
}