package Sims;

import gameEngine.Entity;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board extends Entity
{
    final static float BRUSH_SIZE = 10;
    int width;
    int height;
    int pixelWidth;
    int pixelHeight;
    int visualWidth;
    int visualHeight;

    GraphicsContext gc;

    public Board(int width, int height, int resolutionX, int resolutionY)
    {
        pixelWidth = Math.round(width / (float)resolutionX);
        pixelHeight = Math.round(height / (float)resolutionY);
        this.width = resolutionX;
        this.height = resolutionY;
        this.visualWidth = resolutionX * pixelWidth;
        this.visualHeight = resolutionY * pixelHeight;

        Canvas canvas = new Canvas(width, height);
        addVisual(canvas);

        gc = canvas.getGraphicsContext2D();
    }


    @Override
    public void update()
    {
    }

    public void writePixel(int x, int y, Color color)
    {
        if (x < 0 || x > width) return;
        if (y < 0 || y > height) return;

        int actualX = x * pixelWidth;
        int actualY = y * pixelHeight;

        gc.setFill(color);
        gc.fillRect(actualX, actualY, pixelWidth, pixelHeight);
    }

    public void writePixelGlobalPos(int x, int y, Color color)
    {
        if (x < 0 || x > visualWidth) return;
        if (y < 0 || y > visualHeight) return;

        int actualX = Math.round(x * width / visualWidth) * pixelWidth;
        int actualY = Math.round(y * height / visualHeight) * pixelHeight;

        gc.setFill(color);
        gc.fillRect(actualX, actualY, pixelWidth, pixelHeight);
    }

    public int getVisualWidth(){ return visualWidth; }
    public int getVisualHeight(){ return visualHeight; }
    public int getBoardWidth(){ return width; }
    public int getBoardHeight(){ return height; }
}
