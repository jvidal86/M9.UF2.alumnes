public class ThreadDifusio extends Thread {

    /**
     * Constructor:
     */
    //ThreadDifusio (){

   // }

    @Override
    public void run() {

    }

    private void pasDifusio(int x, int y, double[][] lattice){
        //Si la cel·la és SOURCE: valor és = 1
        lattice[x][y] = 1.0;
        // Si la cel·la és SINK: valor és = 0
        lattice[x][y] = 0.0;

        // Si la cel·la és PARET dalt o baix valor és = cel·la reflectida ( y-1 o y+1)

        // Sinó: aplica fórmula de difusió C = 1/4*N + 1/4*S + 1/4*E + 1/4*W
        lattice[x][y] = ;
    }
}
