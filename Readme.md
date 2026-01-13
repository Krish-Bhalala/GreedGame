# Greed Game

A terminal-based implementation of the classic "Greed" game, where you navigate a board to collect numbers and maximize your score.

![Game Start](assets/game_start.png)
*Welcome to the Greed Game! Set up your player and get ready to play.*

## How to Play

To play the game, use this command in your terminal:

```bash
make play
```

This will automatically compile the source files and launch the application.

### Game Modes

| Mode | Description |
| :--- | :--- |
| **Computer Mode** | Watch the CPU play with random but valid moves until no more moves are available. |
| **Human Mode (Easy)** | Play yourself with helpful hints showing all valid moves available to you. |
| **Human Mode (Regular)** | The ultimate challenge. No hints: you must calculate your own moves. |

### Gameplay Mechanics
- **Objective**: Collect as many numbers as possible.
- **Movement**: Move in any of the 8 cardinal/diagonal directions.
- **Distance**: The number you land on determines how far you must move in that direction (if you land on a 5, your next move must be exactly 5 spaces).
- **Restrictions**: You cannot move through empty spaces or outside the board boundaries.

![Game Play](assets/game_play.png)
*Navigating the board. The colored numbers represent valid values you can collect.*

## Architecture and Design

The project follows a clean, object-oriented design using interfaces and abstract classes to separate concerns between game logic, board representation, and player interaction.

### Class Hierarchy
The following diagram illustrates the relationship between the various components of the game:

```mermaid
classDiagram
    class Viewable {
        <<interface>>
        +view()
    }
    class Selectable {
        <<interface>>
        +select(Viewable, GameLogical)
    }
    class RunnableGame {
        <<interface>>
        +run()
    }
    class GameLogical {
        <<interface>>
        +nextState(Viewable)
        +reset()
    }
    class Boardable {
        <<interface>>
        +setCellAt(int, int, String)
        +getCellAt(int, int)
    }
    
    Viewable <|-- GameLogical
    Viewable <|-- Boardable
    Viewable <|-- Player
    GameLogical <|-- Menuable
    
    class Game {
        <<abstract>>
        -GameLogic game
        -GameBoard board
        -Menu menu
        +run()
    }
    RunnableGame <|.. Game
    
    class GameBoard {
        <<abstract>>
        -String[][] board
        +view()
        +reset()*
    }
    Boardable <|.. GameBoard
    
    class GameLogic {
        <<abstract>>
        +nextState(Viewable)*
        +reset()*
        +view()*
    }
    GameLogical <|.. GameLogic
    
    Game <|-- GreedGame
    GameBoard <|-- GreedGameBoard
    GameLogic <|-- GreedGameLogic
    
    GreedGameLogic o-- Player
    
    class Player {
        <<interface>>
        +chooseSelection(List~Selectable~)
    }
    Player <|.. HumanPlayer
    Player <|.. CPUPlayer
    
    Selectable <|.. GameMove
    GameMove <|-- GreedGameMove
    Selectable <|.. BackToMenuOption
    
    class Menu {
        -List~MenuItem~ items
    }
    GameLogical <|.. Menu
```

### Data Flow
This diagram shows how the main game loop coordinates between the menu, game logic, and player input:

```mermaid
graph TD
    Start[GreedGame.main] --> Init[Initialize Components]
    Init --> GameRun[Game.run Loop]
    
    subgraph MenuPhase [Menu Phase]
        MenuView[Menu.view]
        MenuNext[Menu.nextState]
        MenuSelect[MenuItem.select]
        GameRun --> MenuView
        MenuView --> MenuNext
        MenuNext --> MenuSelect
    end
    
    subgraph GamePhase [Game Phase]
        GameView[GameLogic.view / Board.view]
        GameNext[GameLogic.nextState]
        PlayerChoose[Player.chooseSelection]
        MoveSelect[Selectable.select]
        BoardUpdate[Board.executeMove]
        GameView --> GameNext
        GameNext --> PlayerChoose
        PlayerChoose --> MoveSelect
        MoveSelect --> BoardUpdate
        BoardUpdate --> GameView
    end
    
    MenuSelect -- "Start Game" --> GamePhase
    MoveSelect -- "Return to Menu" --> MenuPhase
```

## End of Game
The game ends when there are no more valid moves available for the player in any direction.

![Game Over](assets/game_over.png)
*Game over screen showing the final state and score.*

## Development Details

### Features
- **Colorized UI**: Numbers on the board are colorized for better visibility and a modern feel.
- **Flexible Architecture**: The core logic is decoupled from the specific Greed game implementation, allowing for easy expansion.
- **Dual Play Modes**: Supports both human players and an automated CPU player.
