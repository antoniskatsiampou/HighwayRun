import greenfoot.*;  

    public class ScrollingBackground extends Actor{
        
        private int speed = 4; // η ταχυτητα που κυλαει ο δρομος
        
        //ο κατασκευαστης δεχεται το ονομα της εικονας οταν δημιουργειται το αντικειμενο 
        public ScrollingBackground(String imageName){
            
            setImage(imageName);
        }
    
    public void act(){
        
        if (PlayerCar.isGameOver) return;
        
        //μετακινηση προς τα κατω
        setLocation(getX(), getY() + speed);
        
        //οταν περασει το οριο, 
        if (getY() >= 975){
            
            
        // ξαναεπιστρεφει πισω
            setLocation(getX(), getY() - 1300);
        }
      
    }
}
