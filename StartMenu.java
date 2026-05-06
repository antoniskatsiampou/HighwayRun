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
        getBackground().drawString("HIGHWAY RUN", 220, 135);
        
        // σκοπός παιχνιδιο΄ύ
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", false, false, 26));
        getBackground().drawString("Οδήγησε στο όριο και απόφυγε την κίνηση!", 170, 210);
        
        // οδηγιες παιχνιδιού
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
        
        // αριστερη στήλη
        getBackground().drawString("Αριστερά", 275, 315);
        getBackground().drawImage(leftBtn, 375, 290);
        
        getBackground().drawString("Φρένο", 300, 365);
        getBackground().drawImage(downBtn, 375, 340);
        
        // δεξια στήλη
        getBackground().drawImage(rightBtn, 425, 290);
        getBackground().drawString("Δεξιά", 475, 315);
        
        getBackground().drawImage(upBtn, 425, 340);
        getBackground().drawString("Γκάζι", 475, 365);
        
        // επιλογη mode 
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font("Arial", true, false, 28));
        getBackground().drawString("ΕΠΙΛΟΓΗ ΕΠΙΠΕΔΟΥ:", 290, 460);
        
        // επιλογη 1
        getBackground().setColor(new Color(100, 255, 100)); 
        getBackground().drawString("Πάτησε [ 1 ] για Level 1 (Μέρα)", 230, 520);
        
        // επιλογη 2 
        getBackground().setColor(new Color(255, 100, 100)); 
        getBackground().drawString("Πάτησε [ 2 ] για Level 2 (Νύχτα + Αστυνομία)", 150, 570);
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