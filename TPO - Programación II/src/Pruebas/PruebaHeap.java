package Pruebas;

import api.HeapTDA;
import implementacion.HeapMax;
import implementacion.HeapMin;
import api.PilaTDA;
import implementacion.PilaEstatica;

public class PruebaHeap {

	/**Se recibe un valor int por parámetro junto con el Heap. Verificamos que el Heap no esté vacío.
	* Luego comparamos el valor con el primer elemento del heap. Si son iguales, devolvemos true. 
	* Si son distintos, y mientras el valor sea menor al primer elemento, continúamos buscando.
	* A medida que iteramos, apilamos en una pila los elementos que vamos eliminando del heap para no
	* perderlos. Luego, volvemos a insertarlos en el Heap. Utilizamos la estrategia 1 para la 
	* implementación de la pila.
	*/
	public static boolean valorPerteneceHeapMin(int valor, HeapTDA heap) {
		PilaTDA pila = new PilaEstatica();                       //constante O(1)+
		pila.InicializarPila();									 //constante O(1)+
		boolean existe = false;									//constante O(1)+
		
		while (!heap.isEmpty() && heap.peek() <= valor && existe != true ) {		//n*((constante O(1)+constante O(1))
			if(heap.peek()==valor) { 								//constante O(1)+
				existe=true;									//constante O(1))+
			}else {
			pila.Apilar(heap.peek());							//(constante O(1)+constante O(1))+
			heap.pop();											//logaritmico O(log(n)))
		}
		}
		
		while (!pila.PilaVacia()) {								//n*(constante O(1)+
			heap.push(pila.Tope());								//(logaritmico O(log(n)) + constante O(1))+
			pila.Desapilar();									//constante O(1)) =
		}
		return existe;
	}															//casi lineal O(n log(n))
	
	
	/**Se recibe un valor int por parámetro junto con el Heap. Verificamos que el Heap no esté vacío.
	* Luego comparamos el valor con el primer elemento del heap. Si son iguales, devolvemos true. 
	* Si son distintos, y mientras el valor sea mayor al primer elemento, continúamos buscando.
	* A medida que iteramos, apilamos en una pila los elementos que vamos eliminando del heap para no
	* perderlos. Luego, volvemos a insertarlos en el Heap.
	*/
	public static boolean valorPerteneceHeapMax(int valor, HeapTDA heap) {
		PilaTDA pila = new PilaEstatica();						//constante O(1)+
		pila.InicializarPila();									//constante O(1)+
		boolean existe=false;									//constante O(1)+
		
		while (!heap.isEmpty() && heap.peek() >= valor && existe !=true) {		//n*((constante O(1)+constante O(1))
			if(heap.peek()==valor) { 								//constante O(1)+
				existe= true;									//constante O(1))+
			}else {
			pila.Apilar(heap.peek());							//(constante O(1)+constante O(1))+
			heap.pop();											//logaritmico O(log(n))+
			}
		}
	
		while (!pila.PilaVacia()) {								//n*(constante O(1)+
			heap.push(pila.Tope());								//(logaritmico O(log(n)) + constante O(1))+
			pila.Desapilar();									//constante O(1)) =
		}
		return existe;
	}															//casi lineal O(n log(n))
	
	
	/** Recibimos un arreglo y la cantidad de elementos del mismo por parámetro.
	 * Se inserta cada elemento del arreglo en el Heap y el mismo los va ordenando.
	 * Luego, mientras el Heap no quede vacío, pisamos los elementos del arreglo con los 
	 * elementos que hemos ordenado previamente.
	 */
	public static void ordenar (int[] arr , int n) {
		HeapTDA heap = new HeapMin(n);							//constante O(1)+
		
		for (int i=0 ; i<n; i++) {								//n*(
			heap.push(arr[i]);									//logaritmico O(log(n)))
		}
		
		int i=0;												//constante O(1)+
		
		
		while (!heap.isEmpty()) {								//n*(constante O(1)+
			arr[i]=heap.peek();									//constante O(1)+
			heap.pop();											//logaritmico O(log(n))+
			i++;												//constante O(1))=
			
		}
	}															//casi lineal O(n log(n))
	
	
	
	/** Se reciben dos Heaps por parámetro. Mientras el heap no esté vacío, vamos comparando los 
	 * primeros elementos de ambos heaps. Si son distintos, determinamos que los heaps no son iguales,
	 * por ende devolvemos false. Si son iguales, apilamos dichos elementos en dos pilas, eliminamos
	 * el primer elemento del heap y continuamos con la iteración hasta que un heap o ambos
	 * estén vacíos o encuentren elementos que sean distintos. Al final, en el caso de haber eliminado
	 * elementos del heap, se vuelve a insertar los elementos apilados en la pila, al heap.
	 */
	public static boolean igualesHeap(HeapTDA heap , HeapTDA heap2) {
		PilaTDA pila1 = new PilaEstatica();                       	  //constante O(1)+
		pila1.InicializarPila();									 //constante O(1)+
		PilaTDA pila2 = new PilaEstatica();                       	 //constante O(1)+
		pila2.InicializarPila();									 //constante O(1)+
		boolean iguales=true;										//constante O(1)+
		
		while(!heap.isEmpty() && !heap2.isEmpty() && iguales==true ) {		//n*((constante O(1)+constante O(1))
			if(heap.peek()!=heap2.peek() )	{								//(constante O(1)+constante O(1))+
				iguales= false;												//constante O(1)+
			}else {
			pila1.Apilar(heap.peek());										//(constante O(1)+constante O(1))+
			heap.pop();														//logaritmico O(log(n))+
			pila2.Apilar(heap2.peek());										//(constante O(1)+constante O(1))+
			heap2.pop();													//logaritmico O(log(n)))
		}
		}
		
		if( (heap.isEmpty() && !heap2.isEmpty()) || (!heap.isEmpty() && heap2.isEmpty()) && iguales==true) //constante O(1)+
			iguales= false;																				   //constante O(1)+
		
		while(!pila1.PilaVacia()) {								//n*(constante O(1)+
			heap.push(pila1.Tope());							//(logaritmico O(log(n))+constante O(1))+
			pila1.Desapilar();									//constante O(1)+
			heap2.push(pila2.Tope());							//(logaritmico O(log(n))+constante O(1))+
			pila2.Desapilar();									//constante O(1))=
		}
		
		return iguales;
	}																		//casi lineal (n log(n))
	
	
	

	
	
	public static void main(String[] args) {
		HeapTDA heap = new HeapMax(4);
		heap.push(5);
		heap.push(2);
		heap.push(1);
		heap.push(6);

		boolean respuesta = valorPerteneceHeapMax(5, heap); 
		System.out.println("El valor :" + 5 + " pertenece a el heap? :" + respuesta); 

		HeapTDA heap2 = new HeapMin(4);
		heap2.push(7);
		heap2.push(9);
		heap2.push(1);
		heap2.push(6);

		boolean respuesta2 = valorPerteneceHeapMin(5, heap2);
		System.out.println("El valor :" + 5 + " pertenece a el heap? :" + respuesta2);

		boolean respuesta3 = igualesHeap(heap, heap2);
		System.out.println("Los heaps son equivalentes? :" + respuesta3);

		int[] arreglo = new int[10];
		arreglo[0] = 4;
		arreglo[1] = 1;
		arreglo[2] = 3;
		arreglo[3] = 9;
		int n = 4;

		ordenar(arreglo, n);

	}

	

}
