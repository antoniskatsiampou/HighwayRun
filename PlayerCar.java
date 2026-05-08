import greenfoot.*;  

public class PlayerCar extends Actor
{
    // global ελεγχος isGameOver
    public static boolean isGameOver = false;
    
    public PlayerCar()
    {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() * 75 / 100, img.getHeight() * 75 / 100);
        setImage(img);
    }
    
    public void act()
    {
        // αν εχουμε τρακαρει, μπλοκαρουμε τον χειρισμο
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

        if (Greenfoot.isKeyDown("left")) currentX -= speed;
        else if (Greenfoot.isKeyDown("right")) currentX += speed;

        if (Greenfoot.isKeyDown("up") && currentY > 300) currentY -= verticalSpeed;
        else if (Greenfoot.isKeyDown("down") && currentY < 550) currentY += verticalSpeed;

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
        
        // Αν εντοπισει επαφη με το "αορατο κουτι"
        if (hitCar != null) 
        {
            // Επαναφορα των μαθηματικων του σφιχτου Hitbox
            int distanceX = Math.abs(getX() - hitCar.getX());
            int distanceY = Math.abs(getY() - hitCar.getY());
            
            // Τσεκαρει αν τα αυτοκινητα εχουν οντως χτυπησει (70 pixels οριζοντια, 145 καθετα)
            if (distanceX < 70 && distanceY < 145) 
            {
                isGameOver = true; // Σηκωνουμε τη σημαια του τελους
                setRotation(45); 
                
                World world = getWorld();
                int finalScore = 0;
                int levelId = 1;
                
                if (world instanceof Level1) {
                    finalScore = ((Level1)world).score / 10;
                    levelId = 1;
                } else if (world instanceof Level2) {
                    finalScore = ((Level2)world).score / 10;
                    levelId = 2;
                }
                
                // Εμφανιζει το μεγαλο μενου ακριβως στο κεντρο της οθονης
                world.addObject(new GameOverPanel(finalScore, levelId), 420, 325);
            }
        }
    }
}