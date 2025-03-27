// CLASS: Equitable
//
// Author: Krish Bhalala
//
// REMARKS: This interface defines a custom equals method for comparing an object by integer key.
//
//-----------------------------------------

public interface Equitable {
    //------------------------------------------------------
    // equals
    //
    // PURPOSE: Compares the object with a given integer key
    // PARAMETERS:
    //     key - The integer key to compare with
    // Returns: true if the object is equal to the key, false otherwise
    //------------------------------------------------------
    public boolean equals(int key);
}

