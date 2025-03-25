public class GameMove implements Selectable, Viewable, Equitable {
    private Constants.GameConstants.Direction direction;
    private int distance;
    private String description;
    
    public GameMove(Constants.GameConstants.Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
        this.description = "Move "+ distance + " blocks " + direction.name();
    }   
    
    public Constants.GameConstants.Direction getDirection() {
        return direction;
    }
    
    public int getDistance() {
        return distance;
    }

    public void view(){
        System.out.println("(" + direction.getKey() + ") " + description);
    }

    public boolean equals(int key){
        return Integer.parseInt("" + this.direction.getKey()) == key;
    }
    
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        System.out.println("Let's " + this.description);
        if(v instanceof GreedGameBoard){
            GreedGameBoard board = (GreedGameBoard)v;
            //move the player insignia
            board.executeMove(direction, distance);
            return true;
        }
        return false;
    }
}