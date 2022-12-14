import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * The main character of the game
 * @author (Luke Xiao) 
 * @version (11.29.2022)
 */
public class Elephant extends Actor
{
    GreenfootSound ElephantSound = new GreenfootSound("Elephant.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    String facing = "right"; // Elephant's direction
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Elephant()
    {
        for(int i=0; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/E/"+ i +".png");
            idleRight[i].scale(75,75);
        }
        
        for(int i=0; i<idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/E/"+ i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(75,75);
        }
        
        // Timer
        animationTimer.mark();
        
        // Initial elephant image
        setImage(idleRight[0]);
    }
    
    // Elephant animation
    int imageIndex = 0;
    public void ElephantAnimation()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
            
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("left"))
        {
            //move(-1);
            setLocation(getX()-2,getY());
            facing = "left";
        }
        
        else if (Greenfoot.isKeyDown("right"))
        {
            //move(1);
            setLocation(getX()+2,getY());
            facing = "right";
        }
        
        else if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-2);
        }
        
        else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+2);
        }
        
        // Remove apple if elephant touches (eats) it
        eat();
        
        // Elephant animation
        ElephantAnimation();
    }
    
    public void eat() // The elephant eats the apple then the game spawns a new one
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.score();
            ElephantSound.play();
        }
    }
}
//hi
