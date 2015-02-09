package multiplicacaomatrizesthread;

/**
 * *----------------------------------------------------------- 
 * Eugenio Cunha
 * genio.py@gmail.com
 * *-----------------------------------------------------------
 */
public class WorkerThread implements Runnable {

    private int linha;
    private int coluna;
    private int a[][];
    private int b[][];
    private int r[][];

    public WorkerThread(int linha, int coluna, int a[][], int b[][], int r[][]) {
        this.linha = linha;
        this.coluna = coluna;
        this.a = a;
        this.b = b;
        this.r = r;
    }

    @Override
    public void run() {
        for (int auxiliar = 0; auxiliar < a[0].length; auxiliar++) {
            r[linha][coluna] += a[linha][auxiliar] * b[auxiliar][coluna];
        }
    }

}
