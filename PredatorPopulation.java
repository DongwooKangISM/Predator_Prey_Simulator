import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PredatorPopulation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PredatorPopulation extends World
{
    /**
     * Constructor for objects of class PredatorPopulation.
     * 
     */
    public PredatorPopulation()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }   
    public void act()
    {
        if(Greenfoot.isKeyDown("Enter")) Greenfoot.setWorld(new PreyPopulation());
    }
}
