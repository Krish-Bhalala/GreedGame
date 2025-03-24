public abstract class MenuItem implements Selectable, Viewable, Equitable{
    private String description;
    private int menuCode;

    public MenuItem(int menuCode, String description){
        this.menuCode = menuCode;
        this.description = "" + menuCode + " : " + description;
    }

    public abstract boolean select(Viewable v, GameLogical gl);

    public boolean equals(int key){
        return this.menuCode == key;
    }
    // public boolean equals(MenuItem item){
    //     return this.menuCode == item.menuCode;
    // }
    
    public void view(){
        System.out.println(description);
    }

    public String getDescription() {
        return description;
    }
    
    public int getSelectionKey() {
        return menuCode;
    }
}