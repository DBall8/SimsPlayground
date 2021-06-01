import Sims.Board;
import Sims.ConwayLife;
import Sims.InputController;
import gameEngine.GameEngine;

public class main extends GameEngine
{
    final static int SCREEN_WIDTH = 800;
    final static int SCREEN_HEIGHT = 800;
    final static int BOARD_WIDTH = 8;
    final static int BOARD_HEIGHT = 8;

    Board board;
    InputController inputController;
    ConwayLife life;

    @Override
    protected void onInitialize()
    {
        // Code here is called before anything is initialized
        setWindowWidth(SCREEN_WIDTH);
        setWindowHeight(SCREEN_HEIGHT);
    }

    @Override
    protected void onStart()
    {
        // Code here is called before the window is displayed.
        board = new Board(SCREEN_WIDTH, SCREEN_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT);
        life = new ConwayLife(BOARD_WIDTH, BOARD_HEIGHT);
        inputController = new InputController(getUserInputHandler(), board, life);

        addEntity(board);
        addEntity(life);
        addEntity(inputController);
    }

    @Override
    protected void onUpdateStart()
    {
        // Code here is called on every frame of the game, before entities are moved and drawn
    }

    @Override
    protected void onUpdateFinish()
    {
        // Code here is called on every frame of the game, after entities are moved and drawn
    }
}
