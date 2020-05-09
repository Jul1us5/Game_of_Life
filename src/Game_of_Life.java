/**
 *
 * @author Julius
 * @Project: Game of life
 * 
 * 
 */
public class Game_of_Life {

    public static void main(String[] args) {
        
        int dydis = 20;
        int iterLength = 50;
        char[][] laukas = new char[dydis][dydis];
        
            // Random sugeneruotas laukas
            for(int y = 0; y<laukas.length; y++) {
                for(int x = 0; x<laukas.length; x++) {
                    if(Math.random() < 0.22) {
                        laukas[y][x] = 'X';
                    } else {
                        laukas[y][x] = '.';
                    }
                }
            }
            
            // Pirmas gautas laukas
            System.out.println("[ Random ]");
            for(int y = 0; y<laukas.length; y++) {
                for(int x = 0; x<laukas.length; x++) {
                    System.out.print(laukas[y][x]);
                }
                System.out.println();
            }
            
            // Iteraciju kiekis ( Gyvenimo ciklai )
            // Sukuriam nauja 3 mati masyva, kad saugoti visas iteracijas
            
            char[][][] istorija = new char[iterLength][dydis][dydis];
            
            for(int LifeTime = 0; LifeTime < iterLength; LifeTime++) {
                
                // Priskiriam iteracija i istorija
                istorija[LifeTime] = laukas;
                
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
                    // Gauname uzpildyta nauja iteracija
                
                    // Tikriname ar iteracija kartojasi
                    
                    int i = LifeTime;
                    for(; i >= 0; i--) {
                        boolean sutampa = true;
                        for(int y = 0; sutampa && y<laukas.length; y++) {
                            for(int x = 0; sutampa && x<laukas.length; x++) {
                               if(istorija[i][y][x] != iteracija[y][x]) {
                                   sutampa = false;
                               } 
                            }
                        }
                        if(sutampa) {
                            break;
                        }
                    }
                    if( i >= 0) {
                        System.out.println("- - -[ Iteracija pasikartoko: " + i + " ]- - -");
                        break;
                       
                    }
        
                
                System.out.println("- - - - - - -[ " + (LifeTime + 1) + " ] - - - - - - - - - -");
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