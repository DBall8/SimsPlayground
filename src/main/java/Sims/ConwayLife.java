package Sims;

import gameEngine.Entity;

public class ConwayLife extends Entity
{
    private int width;
    private int height;
    private boolean isRunning = false;

    public ConwayLife(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void start(){ isRunning = true; }
    public void stop() { isRunning = false; }
    public boolean isOn(){ return isRunning; }


    @Override
    public void update()
    {
        System.out.println(isRunning ? "ON" : "OFF");
    }
}
