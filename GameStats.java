public class GameStats implements Viewable {
    private int score;
    
    public GameStats() {
        score = 0;
    }
    
    public void incrementScore(int points) {
        score += points;
    }
    
    public int getScore() {
        return score;
    }
    
    public void resetScore() {
        score = 0;
    }
    
    @Override
    public void view() {
        System.out.print(" Score: " + score + " ");
    }
}