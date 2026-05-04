import greenfoot.*;  


public class Level1 extends World
{

    
    public Level1(){    
        // Δημιουργια επιπεδου 1 και τοποθετηση background 1.
        super(840, 650, 1); 
        setBackground("background-1.png");
        
        // δημιουργια του αυτοκινητου και τοποθετηση του κοσμου
        PlayerCar car = new PlayerCar();
        addObject(car, 485, 500);
    }
    
    public int getLeftBoundary(){ 
        return 186; 
    }
    
    public int getRightBoundary(){ 
        return 664; 
    }
}
