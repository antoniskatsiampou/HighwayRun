import greenfoot.*;  


public class Level1 extends World
{
    
    public GreenfootSound bgMusic;

    public Level1(){    
        // Δημιουργια επιπεδου 1 και τοποθετηση background 1.
        super(840, 650, 1, false); 
        setBackground("background-1.png");
        
        ScrollingBackground bg1 = new ScrollingBackground("background-1.png");
        addObject(bg1, 420, 325);
        
        ScrollingBackground bg2 = new ScrollingBackground("background-1.png");
        addObject(bg2, 420, -325);
        
        // δημιουργια του αυτοκινητου και τοποθετηση του κοσμου
        PlayerCar car = new PlayerCar();
        addObject(car, 485, 500);
        
        PlayerCar.isGameOver = false;
        
        bgMusic = new GreenfootSound("game_music.wav");
        bgMusic.playLoop();
        
    }
    
    public int getLeftBoundary(){ 
        return 186; 
    }
    
    public int getRightBoundary(){ 
        return 664; 
    }
    
    public int score = 0;
    
    private int[] laneTimers = {0, 0, 0, 0};
    
    private int globalTimer = 0;
    
    private int difficultyTimer = 0; // συνολικος χρονος
    private int maxCarsAllowed = 2;  // ξεκινημα - μεγιστο 2 αυτοκινητα
    private int spawnDelay = 40;     // delay για εξτρα αυτοκινητα
    
    public void act()
    {
        
        if (PlayerCar.isGameOver) return;
        
        score++;
        
        showText("Σκορ: " + (score / 10), 80, 30);
        
        
        // ενημερωση χρονου
        for (int i = 0; i < 4; i++) 
        {
            if (laneTimers[i] > 0) {
                laneTimers[i]--; 
            }
        }
        globalTimer++; 
        
        // κλιμακωση δυσκολιας
        difficultyTimer++; // μετρητης
        
        // 15 δευτερολεπτα 
        if (difficultyTimer == 1000) { 
            maxCarsAllowed = 3; 
            spawnDelay = 30;    // μειωση του delay
        }
        // 30 δευτερόλεπτα 
        else if (difficultyTimer == 2000) { 
            maxCarsAllowed = 4; 
            spawnDelay = 20;    // εξτρα μειωση του delay
        } 
        else if (difficultyTimer == 3000) { 
            maxCarsAllowed = 5; 
            spawnDelay = 10;    // εξτρα μειωση του delay
        } 
        

        spawnCars();
    }

    // λογικη δημιουργιας νεων αυτοκινητων
    private void spawnCars()
    {
        int carsOnScreen = getObjects(TrafficCar.class).size();
        
        if (carsOnScreen >= maxCarsAllowed) 
        {
            return; 
        }

       
        if (globalTimer > spawnDelay) 
        {
            int laneChoice = Greenfoot.getRandomNumber(4); 
            
            if (laneTimers[laneChoice] == 0) 
            {
                if (laneChoice == 0) {
                    addObject(new TrafficCar(true), 245, -50);
                    laneTimers[0] = 50; 
                } 
                else if (laneChoice == 1) {
                    addObject(new TrafficCar(true), 365, -50);
                    laneTimers[1] = 50; 
                } 
                else if (laneChoice == 2) {
                    addObject(new TrafficCar(false), 485, -50);
                    laneTimers[2] = 160; 
                } 
                else if (laneChoice == 3) {
                    addObject(new TrafficCar(false), 605, -50);
                    laneTimers[3] = 160; 
                }
                
                globalTimer = 0; 
            }
        }
    }
}
