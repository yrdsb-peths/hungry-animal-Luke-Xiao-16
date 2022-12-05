import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * The world of the game.
 * @author (Luke Xiao) 
 * @version (11.30.2022)
 */
public class MyWorld extends World
{
    public int Score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // Create the elephant
        Elephant elephant = new Elephant();
        addObject(elephant,300,300);
        
        // Create a label
        scoreLabel = new Label(0,100); // (String value, int FontSize)
        addObject(scoreLabel,70,50);
        
        // Create apples
        createApple();
        
    }
    
    // Spawn apples at random locations
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600); //getRandomNumber(int limit);
        int y = 0;//Greenfoot.getRandomNumber(300);
        addObject(apple,x,y);
    }
    
    // Score keeping
    public void score()
    {
        Score++;        
        scoreLabel.setValue(Score);
    }
    
    // Ends the game
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
    }
}