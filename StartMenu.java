import greenfoot.*;

public class StartMenu extends World
{
    public StartMenu()
    {    
        super(840, 650, 1); 
        
        getBackground().setColor(new Color(0, 0, 0, 180)); 
        getBackground().fillRect(0, 0, getWidth(), getHeight());
        
        // τιτλος
        getBackground().setColor(new Color(255, 215, 0)); 
        getBackground().setFont(new Font("Arial", true, false, 55));
        getBackground().drawString("HIGHWAY RUN", 235, 135);
        
        // σκοπος παιχνιδιου
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", false, false, 26));
        getBackground().drawString("Οδήγησε στο όριο και απόφυγε την κίνηση!", 175, 210);
        
        // οδηγιες παιχνιδιου
        getBackground().setColor(new Color(180, 220, 255)); 
        getBackground().setFont(new Font("Arial", true, false, 24));
        getBackground().drawString("Χειρισμός:", 360, 260);
        
        GreenfootImage upBtn = new GreenfootImage("upbutton.png");
        GreenfootImage downBtn = new GreenfootImage("downbutton.png");
        GreenfootImage leftBtn = new GreenfootImage("leftbutton.png");
        GreenfootImage rightBtn = new GreenfootImage("rightbutton.png");
        
        int iconSize = 40;
        upBtn.scale(iconSize, iconSize);
        downBtn.scale(iconSize, iconSize);
        leftBtn.scale(iconSize, iconSize);
        rightBtn.scale(iconSize, iconSize);
        
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", false, false, 20));
        
        // αριστερη στηλη (πιο κοντα στο κεντρο)
        getBackground().drawString("Αριστερά", 270, 318);
        getBackground().drawImage(leftBtn, 370, 290);
        
        getBackground().drawString("Φρένο", 295, 368);
        getBackground().drawImage(downBtn, 370, 340);
        
        // δεξια στηλη (απολυτη συμμετρια με την αριστερη)
        getBackground().drawImage(rightBtn, 430, 290);
        getBackground().drawString("Δεξιά", 480, 318);
        
        getBackground().drawImage(upBtn, 430, 340);
        getBackground().drawString("Γκάζι", 480, 368);
        
        // επιλογη mode
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", true, false, 28));
        getBackground().drawString("ΕΠΙΛΟΓΗ ΕΠΙΠΕΔΟΥ:", 265, 460);
        
        // επιλογη 1 
        getBackground().setColor(new Color(100, 255, 100)); 
        getBackground().drawString("Πάτησε [ 1 ] για Επίπεδο 1", 245, 520);
        
        // επιλογη 2
        getBackground().setColor(new Color(255, 100, 100)); 
        getBackground().drawString("Πάτησε [ 2 ] για Επίπεδο 2", 245, 570);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new Level1());
        }
        
        if (Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new Level2()); 
        }
    }
}