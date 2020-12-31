import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreyPopulation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreyPopulation extends World
{
    public static int prePop, preMut, preHung, preRep;
    /**
     * Constructor for objects of class PreyPopulation.
     * 
     */
    public PreyPopulation()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prePop = Integer.parseInt(Greenfoot.ask("How many population at the start?"));
        preMut = Integer.parseInt(Greenfoot.ask("How much mutation rate?"));
        preHung = Integer.parseInt(Greenfoot.ask("How much hunger?"));
        preRep = Integer.parseInt(Greenfoot.ask("How much reproduction?"));
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("Enter")) Greenfoot.setWorld(new MyWorld());
    }
}

