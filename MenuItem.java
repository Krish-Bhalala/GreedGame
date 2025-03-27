// CLASS: MenuItem
//
// Author: Krish Bhalala
//
// REMARKS: This class groups the menuItems of the menu. All the menu item should be selectable,viewable and compareable based on their code
//
//-----------------------------------------
public abstract class MenuItem implements Selectable, Viewable, Equitable{
    private String description;         //message to display
    private int menuCode;               //code for indexing and accessing

    //CONSTRUCTOR
    public MenuItem(int menuCode, String description){
        this.menuCode = menuCode;
        this.description = description;
    }

    //SELECTOR
    //defines behaviour for selecting this menu option
    public abstract boolean select(Viewable v, GameLogical gl);

    //COMPARATOR
    //defines behaviour for searching this menu option based on its key
    public boolean equals(int key){
        return this.menuCode == key;
    }
    
    //VIEWER
    //defines behaviour for its printing
    public void view(){
        System.out.println("" + menuCode + " : " + description);
    }
    
    //GETTERS
    public int getSelectionKey() {
        return menuCode;
    }
}