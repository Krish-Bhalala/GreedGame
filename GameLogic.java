public abstract class GameLogic implements GameLogical {

    public abstract boolean nextState(Viewable v);
    
    public abstract void reset();

    public abstract void view();
}
