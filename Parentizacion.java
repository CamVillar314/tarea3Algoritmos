import java.util.*;
import java.io.*;
import java.lang.*;

public class Parentizacion{

	public static String multiplicacionCadenaMatrices(int[] p, int[][] m, String[][] s)
	{
		// Matriz Ai tiene dimensiones p[i-1] x p[i] para i = 1..n
		// El primer indice para p es 0 y el primer indice para m y s es 1
		// m[i][j] contiene el minimo de multiplicaciones escalares a efectuar entre matrices
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
		{
			// Si hay solo una matriz, la cantidad de multiplicaciones escalares es cero
			m[i][i] = 0;
		}

		// l es el largo de la cadena de matrices
		for (int l = 2; l <= n; l++)
		{
			for (int i = 1; i <= n - l + 1; i++)
			{
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j-1; k++)
				{
					int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; //cantidad de multiplicaciones
					if (q < m[i][j])
					{
						m[i][j] = q; // cantidad minima de multiplicaciones se actualiza dada la posicion k
						// en esta posicion de la matriz s se va guardando la solucion optima
						s[i][j] = "(" + s[i][k] + s[k+1][j] + ")";
					} 
				}
			}
		}
		return s[1][n];
	}

	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);

		String dimensiones = d.nextLine();

		String[] arrOfDim = dimensiones.split(" "); 

		int[] dimFinal = new int[arrOfDim.length];

		for (int i = 0; i < arrOfDim.length; ++i) {

			dimFinal[i] = Integer.parseInt(arrOfDim[i]);
			
		}

		int n = arrOfDim.length;
		int[][] m = new int[n][n];
		String[][] s = new String[n][n];

		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < n; ++k) {

				m[j][k] = 0;
				
			}	
		}
		for(int l = 0; l < n; ++l){
		    
		    s[l][l] = ".";
		}

		String ans = multiplicacionCadenaMatrices(dimFinal,m,s);

		System.out.println(ans);

	}
}
