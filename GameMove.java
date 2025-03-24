public class GameMove implements Selectable, Viewable, Equitable {
    private Constants.GameConstants.Direction direction;
    private int distance;
    private String description;
    
    public GameMove(Constants.GameConstants.Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
        this.description = direction.getKey() + ") Move "+ distance + " blocks " + direction.name();
    }   
    
    public Constants.GameConstants.Direction getDirection() {
        return direction;
    }
    
    public int getDistance() {
        return distance;
    }

    public void view(){
        System.out.println(description);
    }

    public boolean equals(int key){
        return Integer.parseInt("" + this.direction.getKey()) == key;
    }
    
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        if(v instanceof GreedGameBoard){
            GreedGameBoard board = (GreedGameBoard)v;
            //move the player insignia
            board.executeMove(direction, distance);

            //update the score is done in greed game logic
            return true;
        }
        return false;
    }
}