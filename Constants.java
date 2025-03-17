public final class Constants {
    public abstract static class GameConstants{
        public static final int ASCII_OFFSET_ZERO = 48;
        public static final int ASCII_RANGE = 10;
        public static final char PLAYER_TOKEN = '@';
    }
    public abstract static class MenuConstants{
        public static final int BACK_TO_MENU = 0;
        public static final int QUIT = 1;
        public static boolean isValid(int code){
            return code == BACK_TO_MENU || code == QUIT;
        }
    }
}



