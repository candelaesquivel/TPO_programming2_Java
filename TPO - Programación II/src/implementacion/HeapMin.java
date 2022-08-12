package implementacion;

import api.HeapTDA;

public class HeapMin implements HeapTDA {

	private int[] heap;
	private int size;

	public HeapMin(int capacidad) {
		heap = new int[capacidad + 1];     //constante O(1)+
		heap[0] = Integer.MIN_VALUE;	   //constante O(1)+
		size = 0;						   //constante O(1)=
	}									   //constante O(1)

	private void intercambio(int i, int j) {
		int tmp = heap[i];			//constante O(1)+
		heap[i] = heap[j];			//constante O(1)+
		heap[j] = tmp;				//constante O(1)=
	}								//constante O(1)

	private void heapifyDown(int k) {
		int posMenor = k; 														//constante O(1)+
		int posIzquierdo = 2 * k;												//constante O(1)+
		int posDerecho = 2 * k + 1;												//constante O(1)+

		if (posIzquierdo <= size && heap[posIzquierdo] < heap[posMenor]) {		//(constante O(1)+
			posMenor = posIzquierdo;											//constante O(1))+
		}

		if (posDerecho <= size && heap[posDerecho] < heap[posMenor]) {			//(constante O(1)+
			posMenor = posDerecho;												//constante O(1))+
		}

		if (posMenor != k) {													//(constante O(1)+
			intercambio(k, posMenor);											//constante O(1)+
			heapifyDown(posMenor);												//logaritmico O(log(n)))=
		}
	}																			//logaritmico O(log(n))

	private void heapifyUp(int k) {
		while (heap[k] < heap[k / 2] && (k / 2) != 0) {							//log n*(
			intercambio(k, k / 2);												//constante O(1)+
			k = k / 2;															//constante O(1))=
		}
	}																			//logaritmico O(log(n))

	public void push(int x) {
		heap[++size] = x;				//constante O(1)+
		heapifyUp(size);				//logaritmico O(log(n))=
	}									//logaritmico O(log(n))

	public void pop() {
		heap[1] = heap[size--];			//constante O(1)+
		heapifyDown(1);					//logaritmico O(log(n))=

	}									//logaritmico O(log(n))

	public int peek() {
		return heap[1];		//constante O(1)
	}

	public boolean isEmpty() {
		return size == 0;      //constante O(1)
	}

}
