import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * Title screen of the game
 * @author (Luke Xiao) 
 * @version (2022.12.12)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant",80);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        addObject(titleLabel,getWidth()/2,100);
        prepare();
    }

    //main world act loop
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))//start the game if space bar is pressed
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,300,260);
        elephant.setLocation(285,225);
        
        Label label = new Label("Press <Space> To Start", 35);
        addObject(label,280,300);
        label.setLocation(300,315);
        
        Label label2 = new Label("Use \u2190 And \u2192 To Move", 35);
        addObject(label2,280,370);
        label2.setLocation(300,360);
    }
}
