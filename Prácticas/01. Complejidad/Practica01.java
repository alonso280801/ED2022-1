import java.util.Arrays;
import java.lang.System;

/**
* Práctica 1 del curso de Estructuras de Datos.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Septiembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Practica01{

	/**
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArray(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");

		int[] result = new int[n + m];
		int pointer;
		for(pointer = 0; pointer < n; pointer++)
			result[pointer] = array1[pointer];
		for(int i = 0 ; i < m ; i++, pointer++)
			result[pointer] = array2[i];

		// Ordenamiento del arreglo result
		for(int j = 0; j < result.length - 1; j++){
			for(int k = j+1; k < result.length; k++){
				if(result[k] < result[j]){
					int aux = result[k];
					result[k] = result[j];
					result[j] = aux;
				}
			}
		}

		return result;
	}

    /**
    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
    * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	* false en otro caso.
    */
    public static boolean isValidBoard(int[][] board){
    	int length = board.length;
		for (int i = 0; i < length ; i++) {
			for (int j = 0; j < length ; j++ ) {
				boolean verificador = false;
				// Verifica sobre las filas
				for(int k = 0 ; k < length; k++){
					if(board[i][k] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
				verificador = false;
				// Verifica sobre las columnas
				for(int k = 0 ; k < length; k++){
					if(board[k][i] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
			}
		}
		return true;
	}

	/**
	* Rota position cantidad de veces los elementos de un arreglo
	* hacia el vecino izquierdo.
	* @param num el arreglo de enteros a rotar.
	* @param position la cantidad de espacios a rotar.
	*/
	public static void rotateArray(int[] num, int position){
		for(int i = 0; i < position ; i++){
			int aux = num[0];
			for(int j = 0; j < num.length -1 ; j++){
				num[j] = num[j+1];
			}
			num[num.length-1] = aux;
		}
	}

    /**
    * Rota un arreglo a la izquierda
    * @param num el arreglo de entrada
    * @param position la cantidad de espacios a rotar
    */

    public static void rotateArrayMejorado(int[] num, int position){

        if(position < 0){
            throw  new NegativeArraySizeException("'position' no puede ser negativo");
        }
        if(position > num.length){
            throw new ArrayIndexOutOfBoundsException("'position' no puede ser mas grande que el arreglo");
        }

        //declara un arreglo auxiliar de tamano 'position'
        //coloca los el numero de elementos establecidos por position del arreglo de entrada
        int[] aux = new int[position];
        for (int i = 0; i < position; i++) {
            aux[i] = num[i];
        }

        //mueve los elementos restantes en el arreglo de entrada a la izquierda
        for (int i = position; i < num.length; i++) {
            num[i - position] = num[i];
        }

        //Coloca los elementos del arreglo aux en su lugar indicado
        for (int i = num.length - position; i < num.length ; i++) {
            num[i] = aux[i - (num.length - position)];
        }
        System.out.println(Arrays.toString(num));
    }

	public static void main(String[] args) {

		String directorio1 = "Examples/ArrayExamples/";
		String directorio2 = "Examples/BoardExamples/";
        String directorio3 = "Tests/ArrayTests/";
        String directorio4 = "Tests/BoardTests/";

		// EJEMPLOS DE ACTIVIDAD 1
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 1\n");

		int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] resultA = mergeSortedArray(arrayA1, 3, arrayA2, 5);
		System.out.println("Resultado A: "+Arrays.toString(resultA));

		int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] resultB = mergeSortedArray(arrayB1, 5, arrayB2, 5);
		System.out.println("Resultado B: "+Arrays.toString(resultB));

		int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");
		int[] resultC = mergeSortedArray(arrayC1, 4, arrayC2, 6);
		System.out.println("Resultado C: "+Arrays.toString(resultC));

		// EJEMPLOS DE ACTIVIDAD 2
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 2\n");

		int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
		boolean boardResultA = isValidBoard(boardA);
		System.out.println("El tablero A es válido: "+boardResultA);

		int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
		boolean boardResultB = isValidBoard(boardB);
		System.out.println("El tablero B es válido: "+boardResultB);

		int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
		boolean boardResultC = isValidBoard(boardC);
		System.out.println("El tablero C es válido: "+boardResultC);

		int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
		boolean boardResultD = isValidBoard(boardD);
		System.out.println("El tablero D es válido: "+boardResultD);

		// EJEMPLOS DE ACTIVIDAD 3
		System.out.println("\nEJEMPLOS DE ACTIVIDAD 3\n");

        String currentArray = "ArrayA2.txt";
        int[] arrayR = ArrayReader.readArray(directorio1 + currentArray);
        int[] arrayRM = ArrayReader.readArray(directorio1 + currentArray);

        //int[] megaArray = new int[100000000];
        long inicio = System.currentTimeMillis();
        rotateArray(arrayR, 5);
        long fin = System.currentTimeMillis();
        System.out.println("Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayR));
        System.out.println("Tiempo de ejecución de rotateArray: " + (fin - inicio) + " milisegundos");

        inicio = System.currentTimeMillis();
        rotateArrayMejorado(arrayRM, 5);
        fin = System.currentTimeMillis();
        System.out.println("Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayRM));
        System.out.println("Tiempo de ejecución de rotateArrayMejorado: " + (fin - inicio) + " milisegundos");

        //System.out.println("Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1));
		//System.out.println("Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1));
		System.out.println("\n\nFIN DE EJEMPLOS\n");
	}
}
