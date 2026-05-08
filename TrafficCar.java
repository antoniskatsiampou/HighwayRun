import greenfoot.*;  

public class TrafficCar extends Actor
{
    private int speed; // η ταχυτητα που κατεβαινει στην οθονη

    // ο κατασκευαστης δεχεται boolean αναλογα με το αν ειναι στηιδια η στην αντιθετη κατευθυνση
    public TrafficCar(boolean isOppositeLane)
    {
        // array με τις εικονες των τυχαιων αυτοκινητων
        String[] carImages = {"Car.png", "Mini_truck.png", "Mini_van.png", "taxi.png", "truck.png", "Black_viper.png"};
        
        // επιλογη τυχαιας εικονας
        int randomIndex = Greenfoot.getRandomNumber(6); 
        setImage(carImages[randomIndex]);
        
        // σμίκρυνση της εικόνας του αυτοκινήτου της κίνησης στο 75%
        GreenfootImage img = getImage();
        img.scale(img.getWidth() * 75 / 100, img.getHeight() * 75 / 100);
        setImage(img);
        
        // ρυθμιση συμπεριφορας αυτοκινητου αναλογως σε ποια λωριδα ειναι
        if (isOppositeLane) 
        {
            setRotation(180); 
            
            speed = 8; 
        } 
        else 
        {
           
            speed = 1;
        }
    }

    public void act()
    {

        if (PlayerCar.isGameOver) return;
        
        setLocation(getX(), getY() + speed);
        
        // αν βγει απο την οθονη, διαγραφεται
        if (getY() >= 649) 
        {
            getWorld().removeObject(this);
        }
    }
}