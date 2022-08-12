package implementacion;

import api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {


	int [][] Matriz; // matriz que contiene prioridad en la posición 0 y valor en la posición 1.
	
	int size;
	
	
	public void inicializarCola(int capacidad) {
		Matriz= new int [capacidad+1][2]; 	//constante O(1)+
		size=0;								//constante O(1)=
	}										//constante O(1)
	
	
	   private void swap(int i, int j) { // el valor y prioridad se modifican juntos 
			int tmp = Matriz[i][0];         //constante O(1)+
			int tmp2 = Matriz[i][1];		//constante O(1)+

			Matriz[i][0] = Matriz[j][0];	//constante O(1)+
			Matriz[i][1] = Matriz[j][1];	//constante O(1)+

			Matriz[j][0] = tmp;				//constante O(1)+
			Matriz[j][1] = tmp2;			//constante O(1)=
	        
	    }									//constante O(1)

	   private void heapifyUp(int k) {
	        while (Matriz[k][0] > Matriz[k/2][0] && (k/2)!=0 ) { 	//n*(
	            swap(k , k/2);										//constante O(1)+
	            k = k/2;											//constante O(1))=
	        }
	    }															//logarítmico O(log(n))

	

	public void acolarPrioridad(int valor, int prioridad) {
		Matriz[++size][0]=prioridad;			//constante O(1)+
		Matriz[size][1]=valor;					//constante O(1)+
		heapifyUp(size);						//logaritmico O(log(n))=
	}											//logaritmico O(log(n))
		
	 private void heapifyDown(int k) {
		 
        int posMayor = k; 							//constante O(1) +
        int posIzquierdo = 2*k;						//constante O(1) +
        int posDerecho = 2*k + 1;					//constante O(1) +

        if (posIzquierdo <= size && Matriz[posIzquierdo][0] > Matriz[posMayor][0] ){ 	// constante O(1) +
            posMayor = posIzquierdo; 													//constante O(1) +
        }

        if (posDerecho <= size && Matriz[posDerecho][0] > Matriz[posMayor][0] ) { 		//constante O(1) +
        	posMayor = posDerecho; 														//constante O(1) +
        }

        if (posMayor != k ) {														//constante O(1) +
            swap(k, posMayor);														//constante O(1) +
            heapifyDown(posMayor); 													//logaritmico O(log(n))=
        }
		 
	  }																				//logaritmico O(log(n))

	
	
	public void desacolar() {
		 if(colaVacia()) {												//constante O(1) +		
		   	throw new RuntimeException("La cola esta vacia");			//constante O(1) +
		 }
		
       Matriz[1][0] = Matriz[size][0];									//constante O(1) +
       Matriz[1][1]=Matriz[size][1];									//constante O(1) +
      
       size--;															//constante O(1) +
   
       heapifyDown(1);													//logaritmico O(log(n))=

	}																	//logaritmico O(log(n))
	
	public boolean colaVacia() {
		return size==0 ;				//constante O(1)
	}

	
	public int primero() {
		if(colaVacia()) {											//constante O(1) +
			throw new RuntimeException("La cola esta vacia");		//constante O(1)=
		}else {
			return Matriz[1][1];									
		}															//constante O(1)
		
		
	}

	public int prioridad() {
		
		if(colaVacia()) {												//constante O(1) +
			throw new RuntimeException("La cola esta vacia");			//constante O(1)=
		}else {
			return Matriz[1][0];									
		}																
	}																	//constante O(1)

}
