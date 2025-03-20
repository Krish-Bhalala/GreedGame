public interface Boardable extends Viewable {
    //Methods
    void setCharAt(int row, int col, char c);
    char getCharAt(int row, int col);
    int getRows();
    int getCols();
    public void reset();
}
