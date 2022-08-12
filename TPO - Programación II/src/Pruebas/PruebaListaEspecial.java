package Pruebas;

import api.ConjuntoTDA;
import api.ListaEspecialTDA;
import implementacion.ConjuntoDin;
import implementacion.ListaEspecial;

public class PruebaListaEspecial {
	
	/** Recorremos la lista recibida por parámetro utilizando dos índices.
	 * El primero recorre la lista desde la posición 0 y el segundo recorre la lista
	 * desde la última posición. En cada iteración se van comparando ambos valores y si son 
	 * diferentes, deja de comparar y retorna False. Si no, retorna true. Ambos recorridos de 
	 * los índices se realizan hasta la mitad de la lista.
	 */
	public static boolean esCapicua(ListaEspecialTDA lista) {
		int i = 0;															//constante O(1)+
		int j = lista.size() - 1;											//constante O(1)+
		while (lista.get(i) == lista.get(j) && i < (lista.size() / 2)) {	//n*((lineal O(n)+lineal O(n))+
			i++;															//constante O(1)+
			j--;															//constante O(1))+
		}
		if (i == (lista.size() / 2)) {										//constante O(1)=
			return true;
		}

		return false;
	}																		//cuadrático O(n^2)

	
	/** A medida que recorremos la lista pasada por parámetro, consultamos si cada uno de sus
	 * elementos pertence a un conjunto. Si pertenece, eliminamos el elemento de la lista.
	 * Si no pertenece, lo agregamos al conjunto.
	 */
	public static void limpiarRepetidos(ListaEspecialTDA lista) {
		ConjuntoTDA repetidos = new ConjuntoDin();				//constante O(1)+
		repetidos.InicializarConjunto();						//constante O(1)+
		int i = 0;												//constante O(1)+
		while (i < lista.size()) {								//n*(constante O(1)+
			if (!repetidos.Pertenece(lista.get(i))) {			//(lineal O(n)+lineal O(n))+
				repetidos.Agregar(lista.get(i));				//(lineal O(n)+lineal O(n))+
				i++;											//constante O(1))+
			} else {
				lista.pop(i);									//constante O(1)=
			}
		}
	}															//cuadrático O(n^2)
	
	/** Se recorre la lista enviada por parámetro y vamos sumando sus elementos hasta tener el total.
	 * Dividimos cada valor de la lista por la suma total y obtenemos el valor normalizado. 
	 * Luego retornamos un arreglo con dichos valores normalizados.
	 */
	public static float[] normalizar(ListaEspecialTDA lista) {

		int cont = 0;										//constante O(1)+
		float sum = 0;										//constante O(1)+
		float[] arreglo = new float[lista.size()];			//constante O(1)+
		
		while (cont < lista.size()) {						//n*(constante O(1)+
			sum = sum + lista.get(cont);					//lineal O(n)+
			cont++;											//constante O(1))+
		}
		cont = 0;											//constante O(1)+
		
		while (cont < lista.size()) {						//n*(constante O(1)+
			float valor = lista.get(cont) / sum;			//lineal O(n)+
			arreglo[cont] = valor;							//constante O(1)+
			cont++;											//constante O(1))=
		}
		return arreglo;
	}														//cuadrático O(n^2)
	
	public static void main(String[] args) {

		ListaEspecialTDA lista1 = new ListaEspecial();
		lista1.inicializarLista();
		lista1.append(1);
		lista1.append(2);
		lista1.append(1);

		boolean respuesta = esCapicua(lista1);
		System.out.println("La lista , es capicua? "+respuesta);
		
		limpiarRepetidos(lista1);
		lista1.print();
		
		float[] arreglo=  normalizar(lista1);
		System.out.print("[");
		for (int i=0; i<arreglo.length; i++) {
			System.out.print(arreglo[i]+" ");
		}
		System.out.println("]");
		
		ListaEspecialTDA lista2 = new ListaEspecial();
		lista2.inicializarLista();
		lista2.append(9);
		lista2.append(1);
		lista2.append(70);
			
		lista1.extend(lista2);

		lista1.print();
}
}
