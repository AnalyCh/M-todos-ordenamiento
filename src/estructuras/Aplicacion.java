package estructuras;

import java.util.Arrays;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a= new  int[90];
		for(int i=0; i<a.length;i++){
			a[i]= (int) ((Math.random())*20)+1;
		}
		
		long tinicio, tfin, tiempo;
		tinicio= System.currentTimeMillis();
		selecccion(a);
		tfin= System.currentTimeMillis();
		tiempo= tfin-tinicio;
		System.out.println(Arrays.toString(a));
		System.out.println("Selección: El tiempo que se demora en milisegundos es: "+ tiempo);
		//////
		tinicio= System.currentTimeMillis();
		OrdenaBurbuja(a);
		tfin= System.currentTimeMillis();
		tiempo= tfin-tinicio;
		System.out.println(Arrays.toString(a));
		System.out.println("Burbuja: El tiempo que se demora en milisegundos es: "+ tiempo);
		//////
		tinicio= System.currentTimeMillis();
		insercionDirecta(a);
		tfin= System.currentTimeMillis();
		tiempo= tfin-tinicio;
		System.out.println(Arrays.toString(a));
		System.out.println("Inserción: El tiempo que se demora en milisegundos es: "+ tiempo);
		//////
		tinicio= System.currentTimeMillis();
		ordenarQuicksort(a, 0, 0);
		tfin= System.currentTimeMillis();
		tiempo= tfin-tinicio;
		System.out.println(Arrays.toString(a));
		System.out.println("Quicksort: El tiempo que se demora en milisegundos es: "+ tiempo);

	}
	
	public static void selecccion(int[] a) {
		

	       for (int i = 0; i < a.length - 1; i++)
	       {
	               int min = i;
	               for (int j = i + 1; j < a.length; j++)
	               {
	                       if (a[j] < a[min])
	                       {
	                               min = j;
	                       }
	               }
	               if (i != min) 
	               {
	                       int aux= a[i];
	                       a[i] = a[min];
	                       a[min] = aux;
	               }
	       }
	 }
	
	public static void OrdenaBurbuja (int v[]){
		int t=0, h, e;

		for (h=1; h<v.length; h++)
		{
			for(e=0; e<v.length-1;e++){
					if (v[e]>v[e+1]){
						v[e+1] = t;
						v[e] = v[e+1];
						t= v[e];
						}
					}
			}

	}
	
	public static void ordenarQuicksort(int[] vector, int primero, int ultimo){
		int i=primero, j=ultimo;
		int pivote=vector[(primero + ultimo) / 2];
		int auxiliar;
		do{
			while(vector[i]<pivote) i++; 
			while(vector[j]>pivote) j--;
			if (i<=j){
				auxiliar=vector[j];
				vector[j]=vector[i];
				vector[i]=auxiliar;
				i++;
				j--;
				}
			} while (i<=j);
		if(primero<j) ordenarQuicksort(vector,primero, j);
		if(ultimo>i) ordenarQuicksort(vector,i, ultimo);
	}

	public static void insercionDirecta(int A[]){
	    int p, j;
	    int aux;
	    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
	              aux = A[p]; // el final, guardamos el elemento y
	              j = p - 1; // empezamos a comprobar con el anterior
	              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
	                                                                    // valor de aux sea menor que los
	                             A[j + 1] = A[j];       // de la izquierda, se desplaza a
	                             j--;                   // la derecha
	              }
	              A[j + 1] = aux; // colocamos aux en su sitio
	    }
	}
}
