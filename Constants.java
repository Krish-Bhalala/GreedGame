// CLASS: Constants
//
// Author: Krish Bhalala
//
// REMARKS: This class defines various constants used in the game,
//          including game-related constants and menu-related constants.
//
//-----------------------------------------

import java.util.Random;

public final class Constants {
    // GameConstants inner class
    public abstract static class GameConstants {
        // ASCII-related constants
        public static final int ASCII_OFFSET_ONE = (int)'1';
        public static final int ASCII_RANGE = 9;
        
        // Game board constants
        public static final String EMPTY_SPACE = " ";
        public static final String PLAYER_INSIGNIA = "@";

        // Direction enum for player movement
        public enum Direction {
            //ENUM(KEY,ROW_OFFSETS,COL_OFFSETS)
            NORTH('8', -1, 0),
            NORTHEAST('9', -1, 1),
            EAST('6', 0, 1),
            SOUTHEAST('3', 1, 1),
            SOUTH('2', 1, 0),
            SOUTHWEST('1', 1, -1),
            WEST('4', 0, -1),
            NORTHWEST('7', -1, -1);

            private final char key;
            private final int rowOffset;
            private final int colOffset;

            // Constructor for Direction enum
            Direction(char key, int rowOffset, int colOffset) {
                this.key = key;
                this.rowOffset = rowOffset;
                this.colOffset = colOffset;
            }

            // Getter methods for Direction enum
            public char getKey() { return key; }
            public int getRowOffset() { return rowOffset; }
            public int getColOffset() { return colOffset; }
        }

        // Color constants for console output
        public static final String[] COLORS = {
            "\u001B[31m", // Red
            "\u001B[32m", // Green
            "\u001B[33m", // Yellow
            "\u001B[34m", // Blue
            "\u001B[35m", // Purple
            "\u001B[36m"  // Cyan
        };
        public static final String RESET_COLOR = "\u001B[0m";

        // Random number generator
        public static final Random RANDOM = new Random();
    }

    // MenuConstants inner class
    public abstract static class MenuConstants {
        // Menu option constants
        public static final int BACK_TO_MENU = 5;
        public static final int QUIT = 0;
        public static final int BEGIN_NEW_GAME = 1;

        //------------------------------------------------------
        // isValid
        //
        // PURPOSE: Checks if the given code is a valid menu option
        // PARAMETERS:
        //     code - The menu option code to check
        // Returns: true if the code is valid, false otherwise
        //------------------------------------------------------
        public static boolean isValid(int code) {
            return code == BACK_TO_MENU || code == QUIT;
        }
    }
}