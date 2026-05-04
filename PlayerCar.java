import greenfoot.*;  

public class PlayerCar extends Actor
{
    
    //δηλωση ταχυτητας στροφης
    public int speed = 5;
    
    public void act()
    {
        checkKeys(); //ελεγχος των πληκτρων που πατιουνται απο τον χρηστη 
        checkBoundaries(); // ελεγχος οριων ωστε να μην βγαινει απο την ασφαλτο
    }
    
    // λογικη συμπεριφορας αυτοκινητου
    public void checkKeys(){
        
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
        }
        
        
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
        }
        
    }
    
    private void checkBoundaries()
{
    // Παίρνουμε μια αναφορά στον τρέχοντα κόσμο
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
}
