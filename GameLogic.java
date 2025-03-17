public class GameLogic implements GameLogical {
    private GameStats stats;

    public GameLogic() {
        stats = new GameStats();
    }

    public boolean nextState(Viewable v){
        //responsible for generating all possible options for the player to choose from for that turn, then selecting the chosen option.
        //return of false implies there is no next state
        return false;
    }
    public void reset(){
        stats.resetScore();
    }
    public void view(){
        stats.view();
    }
}
