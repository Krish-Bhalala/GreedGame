import java.util.List;
import java.util.Random;

public class CPUPlayer implements Player {
    private String name;
    private Random random;

    public CPUPlayer(String name) {
        this.name = name;
        this.random = new Random();
    }

    @Override
    public Selectable chooseSelection(List<Selectable> possibleMoves,  Viewable gameState) {
        // Select a random move from the list
        if (possibleMoves.isEmpty()) {
            throw new IllegalStateException("No moves available");
        }

        //select a random move from 1 to 9 except the BACK_TO_MENU move which is at last of the possibleMoves list
        return possibleMoves.get(random.nextInt(possibleMoves.size() - 1));
    }

    @Override
    public String getName() {
        return name;
    }
}