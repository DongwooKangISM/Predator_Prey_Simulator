import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Actor
{
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Plant()
    {
        picture();
    }
    public void picture()
    {
        GreenfootImage image = new  GreenfootImage(5, 5);
        image.setColor(Color.GREEN);
        image.drawOval(0, 0, 5, 5);
        image.fillOval(0, 0, 5, 5);
        this.setImage(image);
    }
}
