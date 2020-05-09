/**
 *
 * @author Julius
 * @Project: Game of life
 * 
 * 
 */
public class Game_of_Life {

    public static void main(String[] args) {
        
        int dydis = 3;
        char[][] laukas = new char[dydis][dydis];
        
            // Random sugeneruotas laukas
            for(int y = 0; y<laukas.length; y++) {
                for(int x = 0; x<laukas.length; x++) {
                    if(Math.random() < 0.50) {
                        laukas[y][x] = 'X';
                    } else {
                        laukas[y][x] = '.';
                    }
                }
            }
            
            // Pirmas gautas laukas
            for(int y = 0; y<laukas.length; y++) {
                for(int x = 0; x<laukas.length; x++) {
                    System.out.print(laukas[y][x]);
                }
                System.out.println();
            }
            
            // Iteraciju kiekis ( Gyvenimo ciklai )
            for(int LifeTime = 0; LifeTime<50; LifeTime++) {
                char[][] iteracija = new char[dydis][dydis];
                
                // Ieskome aplikui esanciu kaimynu
                for(int y = 0; y<laukas.length; y++) {
                    for(int x = 0; x<laukas.length; x++) {
                        int kaimynai = 0;
                        
                        if ( y != 0) {
                            kaimynai += ( x != 0 && laukas[y - 1][x - 1] == 'X') ? 1 : 0;
                            kaimynai += ( laukas[y - 1][x] == 'X') ? 1 : 0;
                            kaimynai += ( x < dydis - 1 && laukas[y][x + 1] == 'X' ) ? 1 : 0;
                        }
                        kaimynai += ( x != 0 && laukas[y][x - 1] == 'X' ) ? 1 : 0;
                        kaimynai += ( x < dydis - 1 && laukas[y][x + 1] == 'X') ? 1 : 0;
                        if( y < dydis - 1) {
                            kaimynai += ( x != 0 && laukas[y + 1][x - 1] == 'X') ? 1 : 0;
                            kaimynai += ( laukas[y + 1][x] == 'X') ? 1 : 0;
                            kaimynai += ( x < dydis - 1 && laukas[y + 1][x + 1] == 'X') ? 1 : 0;
                        } 
                        // Gavome kaimynu kieki lauke
                        
                        // Salygos pasilikti arba dingti
                        if(laukas[y][x] == 'X' && (kaimynai == 2 || kaimynai == 3)) {
                           iteracija[y][x] = 'X';
                        } else if(laukas[y][x] != 'X' && kaimynai == 3) {
                            iteracija[y][x] = 'X';
                        } else {
                            iteracija[y][x] = '.';
                        }
                    }
                }
                System.out.println("__________");
                for(int y = 0; y<iteracija.length; y++) {
                    for(int x = 0; x<iteracija.length; x++) {
                        System.out.print(iteracija[y][x]);
                    }
                    System.out.println();
                }
                laukas = iteracija;
            }
        
    }
    
}