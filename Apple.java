import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * Food object for the elephant
 * @author (Luke Xiao) 
 * @version (11.30.2022)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY()+1;
        setLocation(x,y);
        
        // Remove apple and display "Game Over" if an apple touches the ground
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
