import greenfoot.*;

public class GameOverPanel extends Actor
{
    private int levelId;

    public GameOverPanel(int score, int level)
    {
        levelId = level;
        
        GreenfootImage img = new GreenfootImage(840, 650);
        
        // σκουρο φοντο
        img.setColor(new Color(0, 0, 0, 180));
        img.fillRect(0, 0, 840, 650);
        
        // τιτλος
        img.setColor(Color.RED);
        img.setFont(new Font("Arial", true, false, 55));
        img.drawString("ΜΠΟΥΜ! ΤΕΛΟΣ ΠΑΙΧΝΙΔΙΟΥ", 50, 220);
        
        // σκορ
        img.setColor(Color.WHITE);
        img.setFont(new Font("Arial", true, false, 35));
        img.drawString("Τελικό Σκορ: " + score, 300, 300);
        
        // Οδηγιες 
        img.setColor(new Color(100, 255, 100)); // πρασινο
        img.setFont(new Font("Arial", true, false, 28));
        img.drawString("Πατησε [ R ] για Επανεκκίνηση", 220, 420);
        
        img.setColor(new Color(255, 100, 100)); // κοκκινο
        img.drawString("Πατησε [ Esc ] για επιστροφή στο μενού", 160, 480);
        
        setImage(img);
    }
    
    public void act()
    {
        // Αν πατησει ρ, isGameOver false και ξαναπαιζει το ιδιο level
        if (Greenfoot.isKeyDown("r")|| Greenfoot.isKeyDown("R") || Greenfoot.isKeyDown("ρ") || Greenfoot.isKeyDown("Ρ"))
        {
            PlayerCar.isGameOver = false; 
            if (levelId == 1) Greenfoot.setWorld(new Level1());
            else Greenfoot.setWorld(new Level2());
        }
        
        // Αν πατησει esc, isGameOver false και παμε στο StartMenu
        if (Greenfoot.isKeyDown("escape")) 
        {
            PlayerCar.isGameOver = false;
            Greenfoot.setWorld(new StartMenu());
        }
    }
}