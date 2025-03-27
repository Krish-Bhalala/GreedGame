// CLASS: Menu
//
// Author: Krish Bhalala
//
// REMARKS: This class represents a menu system for the game.
// It implements the Menuable interface.
//
//-----------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Menuable{
    private String message;                                 //message for the menu
    private ArrayList<MenuItem> menuItems;                  //list of all the meun items
    private Scanner scanner = new Scanner(System.in);       //user input for selecting the menu
    
    //CONSTRUCTOR
    public Menu(String message) {
        setMessage(message);
        menuItems = new ArrayList<MenuItem>();
        this.reset();
    }
    
    //ACCESSORS
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    } 
    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }
    
    //SETTERS
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    
    //Displays the menuItems
    @Override
    public void view() {
        System.out.println(message);
        for (MenuItem item : menuItems) {
            item.view();
        }
    }
    

    //------------------------------------------------------
    // nextState
    //
    // PURPOSE: computes the next state of the menu based on the user input
    // PARAMETERS:
    //     Viewable v : passed for defining selection display behaviour
    // Returns: The selected option from the list, or null if selection was invalid
    //------------------------------------------------------
    @Override
    public boolean nextState(Viewable v) {
        //wait for user input to input correct menu option
        System.out.print("Select a menu option number: ");
        int code = scanner.nextInt();

        //Ask user for input until correct input it given
        while(!this.isValidOption(code)){
            System.out.println("Invalid option {" + code + "}" + " Please try again.");
            System.out.print("Select a menu option number: ");
            code = scanner.nextInt();
        }

        //display what user entered
        System.out.println("You entered: " + code);

        //select that menu option
        return this.findAndSelect(code, v, this);
    }

    //VALIDATOR
    //Verifies if the selected Menu Option exist in menu or not
    public boolean isValidOption(int code){
        for(MenuItem item : menuItems){
            if(item.equals(code)){
                return true;
            }
        }
        return false;
    }
    
    //findAndSelect
    //Driver function to find and select a MenuItem in the list
    public boolean findAndSelect(int code, Viewable v, GameLogical gl){
        for(MenuItem item : menuItems){
            if(item.equals(code)){
                return item.select(v, gl);      //ask the option to select itself
            }
        }
        return false;           //if not found then return false
    }

    //reset the Menu
    @Override
    public void reset() {
        menuItems.clear();

        //by default every menu should have these 2 options
        addMenuItem(new QuitMenuItem());
        addMenuItem(new NewGameMenuItem());
    }

    //frees up the resources and streams
    public void cleanup(){
        scanner.close();
    }
}
