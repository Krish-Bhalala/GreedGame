import java.util.List;

public interface Player {
    Selectable chooseSelection(List<Selectable> options, Viewable gameState);
}