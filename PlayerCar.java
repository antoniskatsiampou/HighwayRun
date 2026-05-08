import greenfoot.*;  

public class PlayerCar extends Actor
{
    public static boolean isGameOver = false;
    
    private GreenfootImage imageNormal;
    private GreenfootImage imageFlame;
    
    public PlayerCar()
    {
        imageNormal = new GreenfootImage("Audi.png");
        imageNormal.scale(imageNormal.getWidth() * 75 / 100, imageNormal.getHeight() * 75 / 100);
        
        imageFlame = new GreenfootImage("Audi_flame.png");
        imageFlame.scale(imageFlame.getWidth() * 75 / 100, imageFlame.getHeight() * 75 / 100);
        
        setImage(imageNormal);
    }
    
    public void act()
    {
        if (isGameOver) return;
        
        checkKeys(); 
        checkBoundaries(); 
        checkCollision();
    }
    
    public int speed = 5; 
    public int verticalSpeed = 3; 

    private void checkKeys()
    {
        int currentX = getX();
        int currentY = getY();
        
        // τσεκαρει αν ειναι πατημενο το γκαζι
        boolean isAccelerating = false;

        // Στροφες
        if (Greenfoot.isKeyDown("left")) currentX -= speed;
        else if (Greenfoot.isKeyDown("right")) currentX += speed;

        // Γκαζι
        if (Greenfoot.isKeyDown("up")) {
            if (currentY > 300) currentY -= verticalSpeed;
            isAccelerating = true; // πατηθηκε το γκαζι, αρα επιταχυνει
        }
        // Φρενο
        else if (Greenfoot.isKeyDown("down")) {
            if (currentY < 550) currentY += verticalSpeed;
        }

        //animation
        if (isAccelerating) {
            setImage(imageFlame); // Βαζει τη φλογα οσο κρατας το πανω βελακι
        } else {
            setImage(imageNormal); // Γυρναει στο κανονικο μολις το αφησεις
        }

        setLocation(currentX, currentY);
    }
    
    private void checkBoundaries()
    {
        World world = getWorld(); 
        int leftLimit = 0;
        int rightLimit = 0;

        if (world instanceof Level1){
            leftLimit = ((Level1)world).getLeftBoundary();
            rightLimit = ((Level1)world).getRightBoundary();
        } 
        else if (world instanceof Level2) {
            leftLimit = ((Level2)world).getLeftBoundary();
            rightLimit = ((Level2)world).getRightBoundary();
        }

        if (getX() <= leftLimit) setLocation(getX() + 10, getY());
        if (getX() >= rightLimit) setLocation(getX() - 10, getY());
    }

    private void checkCollision()
    {
        Actor hitCar = getOneIntersectingObject(TrafficCar.class);
        
        if (hitCar != null) 
        {
            int distanceX = Math.abs(getX() - hitCar.getX());
            int distanceY = Math.abs(getY() - hitCar.getY());
            
            if (distanceX < 70 && distanceY < 145) 
            {
                isGameOver = true; 
                setRotation(45); 
                
                World world = getWorld();
                
                Greenfoot.playSound("crash_sound.wav");
                world.addObject(new Blast(), getX(), getY());
                
                int finalScore = 0;
                int levelId = 1;
                
                if (world instanceof Level1) {
                    finalScore = ((Level1)world).score / 10;
                    levelId = 1;
                    ((Level1)world).bgMusic.stop(); 
                } else if (world instanceof Level2) {
                    finalScore = ((Level2)world).score / 10;
                    levelId = 2;
                    ((Level2)world).bgMusic.stop(); 
                }
                
                world.addObject(new GameOverPanel(finalScore, levelId), 420, 325);
            }
        }
    }
}