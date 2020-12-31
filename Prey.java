import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Prey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prey extends Actor
{
    int speed = Greenfoot.getRandomNumber(5) + 1;
    int width = Greenfoot.getRandomNumber(15) + 2;
    int height = Greenfoot.getRandomNumber(15) + 2;
    int turnRate = Greenfoot.getRandomNumber(10) + 15; 
    int receivedMut;
    int receivedRep = MyWorld.preyRep;
    int requiredRep = receivedRep;
    
    public Prey(Prey parent)
    {
        this();
        speed = parent.speed + Greenfoot.getRandomNumber(3) - 1;
        width = parent.width + Greenfoot.getRandomNumber(3) - 1;
        height = parent.height + Greenfoot.getRandomNumber(3) - 1;
        turnRate = parent.turnRate + Greenfoot.getRandomNumber(3) - 1;
        checking();
        int mutation = Greenfoot.getRandomNumber(MyWorld.preyMut) + 1;
        if(mutation == 1)
        {
            speed = parent.speed + choosing(-4,4);      
        }
        if(mutation == 2)
        {
            width = parent.width + choosing(-5,5); 
        }
        if(mutation == 3)
        {
            height = parent.height + choosing(-5,5);
        }
        if(mutation == 4)
        {
            turnRate = parent.turnRate + choosing(-15,15);
        }
        checking();
        picture(0, 0, width, height);
    }
    public Prey() 
    {
        picture(0,0,width,height);
        setRotation(Greenfoot.getRandomNumber(360));// Add your action code here.
    }
    public void picture(int x, int y, int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(Color.BLACK);
        image.fillRect(x,y,width,height);
        setImage(image);
    }
    public void act() 
    {
        movement();
        bounceoffwall();
        reproduction();
    }    
    public void movement()
    {
        move(speed);
        if(turnRate <= 0)
        {
            turnRate = 5;
        } 
        if(Greenfoot.getRandomNumber(turnRate) == 1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
    }
    public void bounceoffwall()
    {
        if (getY() == 0 || getY() == getWorld().getHeight()-1) 
        {
            setRotation(360-getRotation());
        }
        if (getX()==0 || getX() == getWorld().getWidth()-1) 
        {
            setRotation(180-getRotation());
        }
    }
    public void reproduction()
    {
        int x = getX(); 
        int y = getY(); 
        if(isTouching(Plant.class))
        {
            removeTouching(Plant.class);
            requiredRep -= 1;
        }
        if(requiredRep == 0)
        {
            requiredRep = receivedRep;
            getWorld().addObject(new Prey(this),x,y); 
        }
    }
    public int choosing(int first, int end)
    {
        int []nums = new int[] {first,end};
        int choice = nums[Greenfoot.getRandomNumber(nums.length)];
        return choice;
    }
    public void checking()
    {
        if(speed <= 0)
        {
            speed = 1;
        }    
        if(width <= 0)
        {
            width = 2;
        }     
        if(height <= 0)
        {
            height = 2;
        } 
        if(turnRate <= 0)
        {
            turnRate = 5;
        } 
    }
    /*public void addedToWorld(World world)
    {
        MyWorld myworld = (MyWorld) getWorld();
        int receivedMut = myworld.getPreyMut();
    }*/
    /*public int getMutation()
    {
        
        return receivedMut; 
    }*/
}
