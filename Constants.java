public final class Constants {
    public abstract static class GameConstants{
        public static final int ASCII_OFFSET_ZERO = 48;
        public static final int ASCII_RANGE = 10;
        public static final char PLAYER_TOKEN = '@';
        public static final char EMPTY_SPACE = ' ';
        public static final char PLAYER_INSIGNIA = '@';

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

            Direction(char key, int rowOffset, int colOffset) {
                this.key = key;
                this.rowOffset = rowOffset;
                this.colOffset = colOffset;
            }

            public char getKey() { return key; }
            public int getRowOffset() { return rowOffset; }
            public int getColOffset() { return colOffset; }
        }
    }
    public abstract static class MenuConstants{
        public static final int BACK_TO_MENU = 5;
        public static final int QUIT = 0;
        public static final int BEGIN_NEW_GAME = 1;
        public static boolean isValid(int code){
            return code == BACK_TO_MENU || code == QUIT;
        }
    }
}



