package Sims;

import gameEngine.Entity;
import gameEngine.callback.Callback;
import gameEngine.userInput.KeyBinding;
import gameEngine.userInput.MouseBinding;
import gameEngine.userInput.UserInputHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class InputController extends Entity
{
    private MouseBinding leftButton;
    private MouseBinding rightButton;
    private KeyBinding spaceButton;
    private Board board;
    private ConwayLife life;

    public InputController(UserInputHandler inputHandler, Board board, ConwayLife life)
    {
        this.leftButton = inputHandler.createMouseListener(MouseButton.PRIMARY);
        this.rightButton = inputHandler.createMouseListener(MouseButton.SECONDARY);
        this.spaceButton = inputHandler.createKeyBinding(KeyCode.SPACE);
        this.board = board;

        this.spaceButton.setOnPressEvent(new Callback<Void>() {
            @Override
            public void run(Void parameter) {
                if (life.isOn())
                {
                    life.stop();
                }
                else
                {
                    life.start();
                }
            }
        });
    }

    @Override
    public void update() {
        if (leftButton.isClicked())
        {
            board.writePixelGlobalPos((int)leftButton.getMouseX(), (int)leftButton.getMouseY(), Color.BLACK);
        }

        if (rightButton.isClicked())
        {
            board.writePixelGlobalPos((int)leftButton.getMouseX(), (int)leftButton.getMouseY(), Color.WHITE);
        }
    }
}
