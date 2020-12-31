import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static int preyPop, preyMut, preyRep;
    int plantCounter = 1;
    int gameEnd = 60;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        preyPop = Integer.parseInt(Greenfoot.ask("How many population at the start?"));
        preyMut = Integer.parseInt(Greenfoot.ask("How much mutation rate?"));
        preyRep = Integer.parseInt(Greenfoot.ask("How much reproduction?"));
        for (int i = 0; i < 100; i++)
        {
            setUp(new Plant());
        }
        for (int i = 0; i < preyPop; i++)
        {
            setUp(new Prey());
        }
        for (int i = 0; i < PreyPopulation.prePop; i++)
        {
            setUp(new Predator());
        }
    }
    private void setUp(Actor object)
    {   
        int x = Greenfoot.getRandomNumber(600); 
        int y = Greenfoot.getRandomNumber(400); 
        addObject(object,x,y); 
    }
    public void act()
    {
        plantCheck();
        checkExtinct();
    }
    public void plantCheck()
    {
        plantCounter -= 1;
        if(plantCounter == 0)
        {
            setUp(new Plant());
            plantCounter = 1;
        }
    }
    public void checkExtinct()
    {
        if(getObjects(Predator.class).isEmpty())
        {
            Greenfoot.setWorld(new GameOver());   
        }
        if(getObjects(Prey.class).isEmpty())
        {
            Greenfoot.setWorld(new GameOver());
        }
    }
}
