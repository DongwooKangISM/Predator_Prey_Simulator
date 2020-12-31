import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Predator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Predator extends Actor
{
    int speed = Greenfoot.getRandomNumber(5) + 1;
    int width = Greenfoot.getRandomNumber(20) + 2;
    int height = Greenfoot.getRandomNumber(20) + 2;
    int turnRate = Greenfoot.getRandomNumber(10) + 20; 
    double receivedHunger = PreyPopulation.preHung;
    double hunger = receivedHunger;
    double hungerDecrease;
    int receivedRep = PreyPopulation.preRep;
    int requiredRep = receivedRep;

    public Predator(Predator parent)
    {
        this();
        speed = parent.speed + Greenfoot.getRandomNumber(3) - 1;
        width = parent.width + Greenfoot.getRandomNumber(3) - 1;
        height = parent.height + Greenfoot.getRandomNumber(3) - 1;
        turnRate = parent.turnRate + Greenfoot.getRandomNumber(3) - 1;
        checking();
        int mutation = Greenfoot.getRandomNumber(PreyPopulation.preMut) + 1;
        if(mutation == 1)
        {
            speed = parent.speed + choosing(-5,5);
        }
        if(mutation == 2)
        {
            width = parent.width + choosing(-15,15);
        }
        if(mutation == 3)
        {
            height = parent.height + choosing(-15,15); 
        }
        if(mutation == 4)
        {
            turnRate = parent.turnRate + choosing(-15,15);
        }
        hungerDecrease = (((double)width + (double)height)/40) + ((double)speed/3);
        checking();
        picture(0, 0, width, height);
    }
    public Predator() 
    {
        picture(0,0,width,height);
        setRotation(Greenfoot.getRandomNumber(360));
        hungerDecrease = (((double)width + (double)height)/40) + ((double)speed/3);
        checking();
    }
    public void picture(int x, int y, int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width,height);
        image.setColor(Color.RED);
        image.fillRect(x,y,width,height);
        setImage(image);
    }
    public void movement()
    {
        move(speed);
        if(Greenfoot.getRandomNumber(turnRate) == 1)
           {
               setRotation(Greenfoot.getRandomNumber(360));
           }
    }
    public void act() 
    {
        movement();
        bounceOffWall();
        catchingPrey();
        death();
    }     
    public void bounceOffWall()
    {
        if (getY() == 0 || getY() == getWorld().getHeight()-1) 
        {
            setRotation(360-getRotation());
        }
        if (getX() == 0 || getX() == getWorld().getWidth()-1) 
        {
            setRotation(180-getRotation());
        }
    }
    public void catchingPrey()
    {
        int x = getX(); 
        int y = getY(); 
        if(isTouching(Prey.class))
        {
            removeTouching(Prey.class);
            hunger += 20;
            requiredRep -= 1;
        }
        if(hunger > receivedHunger)
        {
            hunger = receivedHunger;
        }
        if(requiredRep == 0)
        {
            getWorld().addObject(new Predator(this),x,y); 
            requiredRep = receivedRep;
        }
    }
    public void death()
    {
        hunger -= hungerDecrease;
        if(hunger < 1)
        {
            getWorld().removeObject(this);
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
        if(hungerDecrease <= 0)
        {
            hungerDecrease = 1;
        }
    }
}
    
  