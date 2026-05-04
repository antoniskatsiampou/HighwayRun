import greenfoot.*;  


public class Level2 extends World
{

   
    public Level2(){    
        // Δημιουργια επιπεδου 2 και τοποθετηση background 2.
        super(840, 650, 1); 
        setBackground("background-2.png");
        
        // δημιουργια του αυτοκινητου και τοποθετηση του κοσμου
        PlayerCar car = new PlayerCar();
        addObject(car, 510, 500);
    }
    
    public int getLeftBoundary(){ 
        return 235; 
    } 
 
    public int getRightBoundary(){ 
        return 610; 
    }
}
