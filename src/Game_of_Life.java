/**
 *
 * @author Julius
 * @Project: Game of life
 * 
 * 
 */
public class Game_of_Life {

    public static void main(String[] args) {
        
         int cords = 5;
         char[][] laukas = new char[cords][cords];
         // Sugeneruojamas pirmas laukas
         for(int x=0; x<laukas.length; x++) {
             for(int y=0; y<laukas.length; y++){
                 if(Math.random() < 0.22) {
                     laukas[x][y] = 'X';
                 } else {
                     laukas[x][y] = '.';
                 }
             }
         }
         // Spausdina pirma sugeneruota lauka
         for(int x=0; x<laukas.length; x++) {
             for(int y=0; y<laukas.length; y++) {
                 System.out.print(laukas[x][y]);
             }
             System.out.println();
         }
         
         for(int kiek=0; kiek<50; kiek++) {
             
         }
        
    }
    
}