import greenfoot.*;  


public class Level2 extends World
{

    public Level2(){    
        // Δημιουργια επιπεδου 2 και τοποθετηση background 2.
        super(840, 650, 1, false); 
        setBackground("background-2.png");
        
        ScrollingBackground bg1 = new ScrollingBackground("background-2.png");
        addObject(bg1, 420, 325);
        
        ScrollingBackground bg2 = new ScrollingBackground("background-2.png");
        addObject(bg2, 420, -325);
        
        // δημιουργια του αυτοκινητου και τοποθετηση του κοσμου
        PlayerCar car = new PlayerCar();
        addObject(car, 510, 500);
    }
    
    
    //αριστερο οριο δρομου
    public int getLeftBoundary(){ 
        return 235; 
    } 
 
    //δεξι οριο δρομου
    public int getRightBoundary(){ 
        return 610; 
    }
}
