import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class MultiplicaciónMatrices {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static boolean multiplicables(int columnasA, int renglonesB) {
        if (columnasA == renglonesB) {
            return true;
        }
        return false;
    }

    public static int[][] rellenarMatriz(int r, int c) throws IOException {
        int[][] array = new int[r][c];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println("Escribe el valor [" + i + "][" + j + "]:");
                entrada = bufer.readLine();
                array[i][j] = Integer.parseInt(entrada);
            }
        }
        return array;
    }

    public static int[][] multiplicacionMatrices(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    
    public static void imprimirMatriz(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.printf("%3d", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int[][] matrizA, matrizB, matrizC;
        int renglonesA, columnasA, renglonesB, columnasB;
        boolean multiplicable;
        String respuesta;

        System.out.println("PROGRAMA QUE MULTIPLICA DOS MATRICES");
        System.out.println("Ingresa el número de renglones de la MATRIZ A");
        entrada = bufer.readLine();
        renglonesA = Integer.parseInt(entrada);
        System.out.println("Ingresa el número de columnas de la MATRIZ A");
        entrada = bufer.readLine();
        columnasA = Integer.parseInt(entrada);
        System.out.println("Ingresa el número de renglones de la MATRIZ B");
        entrada = bufer.readLine();
        renglonesB = Integer.parseInt(entrada);
        System.out.println("Ingresa el número de columnas de la MATRIZ B");
        entrada = bufer.readLine();
        columnasB = Integer.parseInt(entrada);

        multiplicable = multiplicables(columnasA, renglonesB);

        if (!multiplicable) {
            System.out.println("Tus matrices no son multiplicables, porque el número de columnas de la MATRIZ A no es igual a la cantidad de renglones de la MATRIZ B");
            System.out.println("¿Quieres volver a intentarlo?[Y/N]");
            entrada = bufer.readLine();
            respuesta = entrada;
            if (respuesta.equals("Y")) {
                System.out.println("Ingresa el número de renglones de la MATRIZ A");
                entrada = bufer.readLine();
                renglonesA = Integer.parseInt(entrada);
                System.out.println("Ingresa el número de columnas de la MATRIZ A");
                entrada = bufer.readLine();
                columnasA = Integer.parseInt(entrada);
                System.out.println("Ingresa el número de renglones de la MATRIZ B");
                System.out.println("Recuerda el número de columnas de la MATRIZ A debe ser igual a la cantidad de renglones de la MATRIZ B");
                entrada = bufer.readLine();
                renglonesB = Integer.parseInt(entrada);
                System.out.println("Ingresa el número de columnas de la MATRIZ B");
                entrada = bufer.readLine();
                columnasB = Integer.parseInt(entrada);
                System.out.println("---------------------------------");
                System.out.println("Rellena la MATRIZ A");
                matrizA = rellenarMatriz(renglonesA, columnasA);
                System.out.println("Rellena la MATRIZ B");
                matrizB = rellenarMatriz(renglonesB, columnasB);
                System.out.println("---------------------------------");
                matrizC = multiplicacionMatrices(matrizA, matrizB);
                
                System.out.println("---------------------------------");
                imprimirMatriz(matrizC);
            } 
        }else{
        System.out.println("---------------------------------");
        System.out.println("Rellena la MATRIZ A");
        matrizA = rellenarMatriz(renglonesA, columnasA);
        System.out.println("Rellena la MATRIZ B");
        matrizB = rellenarMatriz(renglonesB, columnasB);

        System.out.println("---------------------------------");
        matrizC = multiplicacionMatrices(matrizA, matrizB);
        
        System.out.println("---------------------------------");
        imprimirMatriz(matrizC);
        }
    }

}
