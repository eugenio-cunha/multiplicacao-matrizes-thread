package multiplicacaomatrizesthread;

/**
 * *----------------------------------------------------------- 
 * Eugenio Cunha
 * genio.py@gmail.com
 * *-----------------------------------------------------------
 */

public class MultiplicacaoMatrizesThread {

    //Matriz A
    public static int a[][] = {
        {3, 2},
        {3, 3},
        {1, 2}
    };

    //Matriz B
    public static int b[][] = {
        {3, 2, 6},
        {1, 2, 5}
    };

    //Numero de threads
    public static final int NUMERO_DE_THREAD = (a.length * b[0].length);

    //Matriz resultante
    public static int r[][] = new int[3][3];

    public static void main(String[] args) throws InterruptedException {
        int indice_thread = 0;
        Thread[] thread = new Thread[NUMERO_DE_THREAD];

        for (int linha = 0; linha < a.length; linha++) {
            for (int coluna = 0; coluna < b[0].length; coluna++) {
                thread[indice_thread] = new Thread(new WorkerThread(linha, coluna, a, b, r));
                thread[indice_thread].start();
                thread[indice_thread].join();
                ++indice_thread;
            }
        }

        for (int linha = 0; linha < a.length; linha++) {
            for (int coluna = 0; coluna < b[0].length; coluna++) {
                System.out.print("[" + r[linha][coluna] + "] ");
            }
            System.out.print("\n");
        }

    }

}
