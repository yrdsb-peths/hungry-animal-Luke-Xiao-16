import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * The main character of the game
 * @author (Luke Xiao) 
 * @version (11.29.2022)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("Left"))
        {
            //move(-1);
            setLocation(getX()-2,getY());
        }
        
        else if (Greenfoot.isKeyDown("Right"))
        {
            //move(1);
            setLocation(getX()+2,getY());
        }
        
        else if (Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(),getY()-2);
        }
        
        else if (Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(),getY()+2);
        }
        
        //Remove apple if elephant touches (eats) it
        eat();
    }
    
    public void eat() // The elephant eats the apple then the game spawns a new one
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.score();
        }
    }
}
