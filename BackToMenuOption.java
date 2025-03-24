public class BackToMenuOption implements Selectable, Viewable, Equitable{
    int key;
    String description;

    public BackToMenuOption() {
        key = Constants.MenuConstants.BACK_TO_MENU;
        description = "Back to Main Menu";
    }

    public boolean select(Viewable v, GameLogical gl) {
        //switch to non game mode
        return false;
    }

    public boolean equals(int key){
        return this.key == key;
    }

    public void view(){
        System.out.println("" + key + " : " + description);
    }
}