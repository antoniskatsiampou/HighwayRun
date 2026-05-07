import greenfoot.*;  

public class PlayerCar extends Actor
{
    
    
    public PlayerCar()
    {
        // σμικρυνση της εικονας του παικτη στο 75%
        GreenfootImage img = getImage();
        img.scale(img.getWidth() * 75 / 100, img.getHeight() * 75 / 100);
        setImage(img);
    }
    
    public void act()
    {
        checkKeys(); // ελεγχος των πληκτρων που πατιουνται απο τον χρηστη 
        checkBoundaries(); // ελεγχος οριων ωστε να μην βγαινει απο την ασφαλτο
        checkCollision();
    }
    
   // ταχυτητα για τις στροφες
    public int speed = 5; 
    
    // ταχυτητα 
    public int verticalSpeed = 3; 

    private void checkKeys()
    {
        int currentX = getX();
        int currentY = getY();

        // στροφες δεξια-αριστερα
        if (Greenfoot.isKeyDown("left")) {
            currentX -= speed;
        }
        else if (Greenfoot.isKeyDown("right")) {
            currentX += speed;
        }

        // γκαζι
        if (Greenfoot.isKeyDown("up")) {
            if (currentY > 300) { 
                currentY -= verticalSpeed; 
            }
        }
        // φρενο
        else if (Greenfoot.isKeyDown("down")) {
            if (currentY < 550) { 
                currentY += verticalSpeed; 
            }
        }

        // τελικη θεση
        setLocation(currentX, currentY);
    }
    
    private void checkBoundaries()
    {
        // αναφορα στον τρεχοντα κοσμο
        World world = getWorld(); 
        int leftLimit = 0;
        int rightLimit = 0;

        // ελεγχος σε ποιο level βρισκεται
        if (world instanceof Level1){
            leftLimit = ((Level1)world).getLeftBoundary();
            rightLimit = ((Level1)world).getRightBoundary();
        } 
        else if (world instanceof Level2) {
            leftLimit = ((Level2)world).getLeftBoundary();
            rightLimit = ((Level2)world).getRightBoundary();
        }

        // εφαρμογη των οριων
        if (getX() <= leftLimit){
            setLocation(getX() + 10, getY());
        }
        
        if (getX() >= rightLimit){
            setLocation(getX() - 10, getY());
        }
    }

    private void checkCollision()
    {
        // εχει μπει καποιο αμαξι στο κουτι των .png εικονων;
        Actor hitCar = getOneIntersectingObject(TrafficCar.class);
        
        // αν καποιο ακουμπαει
        if (hitCar != null) 
        {
            // μετραει το ποσο απεχουν τα κεντρα των εικονων
            int distanceX = Math.abs(getX() - hitCar.getX());
            int distanceY = Math.abs(getY() - hitCar.getY());
            
            
            if (distanceX < 70 && distanceY < 145) 
            {
                setRotation(45); 
                
                World world = getWorld();
                
                if (world instanceof Level1) {
                    Level1 level1 = (Level1)world;
                    level1.showText("💥 ΜΠΟΥΜ! ΤΕΛΟΣ ΠΑΙΧΝΙΔΙΟΥ💥", 420, 325);
                }
                else if (world instanceof Level2) {
                    Level2 level2 = (Level2)world;
                    level2.showText("💥 ΜΠΟΥΜ! ΤΕΛΟΣ ΠΑΙΧΝΙΔΙΟΥ 💥", 420, 325);
                }
                
                Greenfoot.stop(); 
            }
        }
    }
}