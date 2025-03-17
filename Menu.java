import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Menuable{
    private String message;
    private ArrayList<MenuItem> menuItems;
    private boolean inGameMode;
    private Scanner scanner = new Scanner(System.in);
    
    public Menu(String message, boolean inGameMode) {
        setMessage(message);
        menuItems = new ArrayList<MenuItem>();
        addMenuItem(new QuitMenuItem(Constants.MenuConstants.QUIT,"Quit the current game"));
        //addMenuItem(new MenuItem(Constants.MenuConstants.BACK_TO_MENU, "Return to the main menu"));
        this.inGameMode = inGameMode;
    }
    
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    } 
    
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public void view() {
        System.out.println(message);
        for (MenuItem item : menuItems) {
            item.print();
        }
    }
    
    @Override
    public boolean nextState(Viewable v) {
        
        //wait for user input to input correct menu option
        
        System.out.print("Select a menu option number: ");
        int code = scanner.nextInt();
        while(!this.isValidOption(code)){
            System.out.println("Invalid option {" + code + "}" + " Please try again.");
            System.out.print("Select a menu option number: ");
            code = scanner.nextInt();
        }
        System.out.println("You entered: " + code);

        //select that menu option
        return this.select(code, v, this);
    }

    public boolean isValidOption(int code){
        for(MenuItem item : menuItems){
            if(item.equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public boolean select(int code, Viewable v, GameLogical gl){
        for(MenuItem item : menuItems){
            if(item.equals(code)){
                return item.select(v, gl);
            }
        }
        return false;
    }

    @Override
    public void reset() {
        menuItems.clear();
        addMenuItem(new QuitMenuItem(Constants.MenuConstants.QUIT,"Quit the current game"));
        inGameMode = true;
    }

    public void cleanup(){
        scanner.close();
    }
}
