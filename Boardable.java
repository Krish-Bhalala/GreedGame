// CLASS: Boardable
//
// Author: Krish Bhalala
//
// REMARKS: This interface defines methods for a board-like structure
//          that can be viewed and manipulated. It extends the Viewable interface.
//
//-----------------------------------------

public interface Boardable extends Viewable {
    // Methods
    
    //------------------------------------------------------
    // setCellAt
    //
    // PURPOSE: Sets the content of a cell at a specific position on the board
    // PARAMETERS:
    //     row - The row number of the cell
    //     col - The column number of the cell
    //     c - The content to set in the cell
    // Returns: None
    //------------------------------------------------------
    void setCellAt(int row, int col, String c);

    //------------------------------------------------------
    // getCellAt
    //
    // PURPOSE: Gets the content of a cell at a specific position on the board
    // PARAMETERS:
    //     row - The row number of the cell
    //     col - The column number of the cell
    // Returns: The content of the cell as a String
    //------------------------------------------------------
    String getCellAt(int row, int col);

    //------------------------------------------------------
    // getRows
    //
    // PURPOSE: Gets the number of rows in the board
    // PARAMETERS: None
    // Returns: The number of rows as an int
    //------------------------------------------------------
    int getRows();

    //------------------------------------------------------
    // getCols
    //
    // PURPOSE: Gets the number of columns in the board
    // PARAMETERS: None
    // Returns: The number of columns as an int
    //------------------------------------------------------
    int getCols();

    //------------------------------------------------------
    // reset
    //
    // PURPOSE: Resets the board to its initial state
    // PARAMETERS: None
    // Returns: None
    //------------------------------------------------------
    public void reset();
}
