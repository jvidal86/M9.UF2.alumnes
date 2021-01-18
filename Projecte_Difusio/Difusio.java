import java.util.ArrayList;

/**
 * Simulació del procés de Difusió en una graella rectangular (ample * alt)
 * Condicions de costats:
 *  Dreta: Source (=1)
 *  Esquerra: Sink (=0)
 *  Dalt i Baix: Parets reflectores
 */

public class Difusio {
    static float lattice[][];
    public static void main(String[] args) {

    }

    public static void simulaDifusio(int ample, int alt){
        lattice = new float[ample][alt];
        ThreadDifusio th[] = new ThreadDifusio[4];

        th[0] = new ThreadDifusio(ample, alt, 1);
        th[1] = new ThreadDifusio(ample, alt, 2);
        th[2] = new ThreadDifusio(ample, alt, 3);
        th[3] = new ThreadDifusio(ample, alt, 4);

        for (int i = 0; i < 4; i++) {
            th[i].start();
        }
    }
}