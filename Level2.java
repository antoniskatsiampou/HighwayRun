import greenfoot.*;

public class Level2 extends World
{
    public int score = 0; 
    private int speedTimer = 0;
    private int spawnTimer = 0;
    
    // ρυθμισεις δυσκολιας
    private int spawnInterval = 100; 
    public static int currentSpeed = 5; 
    
    public GreenfootSound bgMusic;

    public Level2()
    {    
        // δημιουργια επιπεδου 2 και τοποθετηση background 2 
        super(840, 650, 1, false);
        setBackground("background-2-night.png");
        
        ScrollingBackground bg1 = new ScrollingBackground("background-2-night.png");
        addObject(bg1, 420, 325);
        
        ScrollingBackground bg2 = new ScrollingBackground("background-2-night.png");
        addObject(bg2, 420, -325);
        
        // δημιουργια του αυτοκινητου του παικτη
        PlayerCar car = new PlayerCar();
        addObject(car, 510, 500); 
        
        PlayerCar.isGameOver = false;
        
        bgMusic = new GreenfootSound("game_music.wav");
        bgMusic.playLoop();
    }
    
    public void act()
    {
        
        if (PlayerCar.isGameOver) return;
        updateScore();
        increaseDifficulty();
        spawnTrafficSafely();
    }
    
    private void updateScore()
    {
        score++; 
        showText("Σκορ: " + (score / 10), 80, 30);
    }
    
    private void increaseDifficulty()
    {
        speedTimer++;
        
        if (speedTimer % 600 == 0)
        {
            currentSpeed++; 
            
            if (spawnInterval > 40)
            {
                spawnInterval -= 10;
            }
        }
    }
    
    private void spawnTrafficSafely()
    {
        spawnTimer++;
        
        if (spawnTimer >= spawnInterval)
        {
            int lane = Greenfoot.getRandomNumber(2); 
            int centerXPos;
            
            if (lane == 0) {
                centerXPos = 335; // κεντρο αριστερης λωριδας
            } else {
                centerXPos = 510; // κεντρο δεξιας λωριδας
            }
            
            // λογικη αναρχιας αυτοκινητων
            // εαν πηγαιναν κανονικα στην λωριδα τους, ο παιχτης μπορουσε να κλεψει πηγαινοντας ευθεια με τις μεσαιες γραμμες, η να πηγαινει στις τερμα πλαγειες
            int anarchyOffset = Greenfoot.getRandomNumber(131) - 65;
            
            int finalXPos = centerXPos + anarchyOffset;
            
            TrafficCar enemy = new TrafficCar(true); 
            addObject(enemy, finalXPos, -50); 
            
            spawnTimer = 0; 
        }
    }
    
    public int getLeftBoundary() {
        return 235;
    }
    
    public int getRightBoundary() {
        return 610;
    }
}