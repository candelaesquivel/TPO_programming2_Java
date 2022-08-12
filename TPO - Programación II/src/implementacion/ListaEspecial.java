package implementacion;

import api.ListaEspecialTDA;


public class ListaEspecial implements ListaEspecialTDA {
	
	int pos;
	NodoDoble inicio;
	NodoDoble ultimo;

	public void inicializarLista() {
		inicio = null;		//constante O(1)+
		ultimo = null;		//constante O(1)+
		pos = 0;			//constante O(1)=
	}						//constante O(1)

	private NodoDoble crearNodo(int x, NodoDoble anterior, NodoDoble siguiente) {
		NodoDoble aux = new NodoDoble();		//constante O(1)+
		aux.info = x;							//constante O(1)+
		aux.anterior = anterior;				//constante O(1)+
		aux.siguiente = siguiente;				//constante O(1)=
		return aux;
	}											//constante O(1)

	public void print() {
		if (pos != 0) {							//constante O(1)+
			NodoDoble aux = new NodoDoble();	//constante O(1)+
			aux = inicio;						//constante O(1)+
			System.out.print("[");				//constante O(1)+
			while (aux != null) {				//n*(
				System.out.print(aux.info);		//constante O(1)+
				if (aux.siguiente != null) {	//constante O(1)+
					System.out.print(" , ");	//constante O(1)+
				}
				aux = aux.siguiente;			//constante O(1))+
			}
			System.out.print("]");				//constante O(1)+
		}else {
			System.out.print("[ ]");			//constante O(1)+
		}
		System.out.println();					//constante O(1)=
	}											//lineal O(n)

	public int size() {
		return pos;			//constante O(1)
	}

	public void append(int valor) {
		if (pos == 0) {											//constante O(1)+
			inicio = ultimo = crearNodo(valor, null, null);		//constante O(1)+
		} else {
			NodoDoble aux = new NodoDoble();					//constante O(1)+
			aux = crearNodo(valor, ultimo, null);				//constante O(1)+
			ultimo.siguiente = aux;								//constante O(1)+
			ultimo = aux;										//constante O(1)+
		}
		pos++;													//constante O(1)=
	}															//constante O(1)

	public void clear() {
		ultimo = inicio = null;			//constante O(1)+
		pos = 0;						//constante O(1)=
	}									//constante O(1)

	public ListaEspecialTDA copy() {

		ListaEspecialTDA listaCopy = new ListaEspecial();		//constante O(1)+
		listaCopy.inicializarLista();							//constante O(1)+

		NodoDoble aux = new NodoDoble();						//constante O(1)+

		aux = inicio;											//constante O(1)+
		while (aux != null) {									//n*(
			int valor = aux.info;								//constante O(1)+
			listaCopy.append(valor);							//constante O(1)+
			aux = aux.siguiente;								//constante O(1)=
		}
		return listaCopy;
	}															//lineal O(n)

	public int count(int valor) {
		int contador = 0;							//constante O(1)+
		NodoDoble aux = new NodoDoble();		//constante O(1)+
		aux = inicio;							//constante O(1)+
		while (aux != null) {					//n*(
			int valorAux = aux.info;			//constante O(1)+
			if (valorAux == valor)				//constante O(1)+
				contador++;						//constante O(1)+
			aux = aux.siguiente;				//constante O(1)=
		}
		return contador;						
	}											//lineal O(n)

	public void extend(ListaEspecialTDA lista) {        
		pos += lista.size();					//constante O(1)+
		ultimo.siguiente = lista.primero();		//constante O(1)+
		lista.primero().anterior = ultimo;		//constante O(1)+
		
		NodoDoble aux = new NodoDoble();		//constante O(1)+
		aux = ultimo;							//constante O(1)+
		
		//Se puede hacer que este método sea constante agregando un método Ultimo() en la interfaz
		while (aux.siguiente != null) {			//n*(
			aux=aux.siguiente;					//constante O(1))+
		}
		ultimo=aux;								//constante O(1)=
	}											//lineal O(n)

	public int index(int valor) {
		int posicion = -1;						//constante O(1)+
		int contador = 0;						//constante O(1)+

		NodoDoble aux = new NodoDoble();		//constante O(1)+
		aux = inicio;							//constante O(1)+

		while (aux != null) {					//n*(
			int valorAux = aux.info;			//constante O(1)+
			if (valorAux == valor) {			//constante O(1)+
				posicion = contador;			//constante O(1)+
				return posicion;				//constante O(1)+
			}
			contador++;							//constante O(1)+
			aux = aux.siguiente;				//constante O(1))+
		}

		if (posicion == -1)						//constante O(1)+
			throw new RuntimeException("No existe en la lista");		//constante O(1)=

		return posicion;
	}											//lineal O(n)

	public int pop(int index) {
		
		int valor = 0;									//constante O(1)+
		
		// primera posicion
		if (index == 0 || index == (size() * -1)) {  	//constante O(1)+
			valor = inicio.info;						//constante O(1)+
			inicio = inicio.siguiente;					//constante O(1)+
			inicio.anterior = null;						//constante O(1)+
			pos--;										//constante O(1)+
			
		// ultima posicion
		} else if (index == (size() - 1) || index == -1) {   //constante O(1)+
			valor = ultimo.info;							//constante O(1)+
			ultimo = ultimo.anterior;						//constante O(1)+
			ultimo.siguiente = null;						//constante O(1)+
			pos--;											//constante O(1)+
			
		// indice positivo
		} else if (0 < index && index < size() - 1) {		//constante O(1)+
			NodoDoble aux = new NodoDoble();				//constante O(1)+
			aux = inicio.siguiente;							//constante O(1)+
			int contadorPositivo = 1;						//constante O(1)+
			while (aux != ultimo) {							//n*(
				if (index == contadorPositivo) {			//constante O(1)+
					valor = aux.info;						//constante O(1)+	
					aux.anterior.siguiente = aux.siguiente;	    //constante O(1)+
					aux.siguiente.anterior = aux.anterior;		//constante O(1)+
				}
				contadorPositivo++;							//constante O(1)+
				aux = aux.siguiente;						//constante O(1))+

		}
		pos--;												//constante O(1)+

		// indice negativo
		} else if ((size() * -1) < index && index < -1) {		//constante O(1)+
			NodoDoble aux = new NodoDoble();					//constante O(1)+
			aux = ultimo.anterior;								//constante O(1)+
			int contadorNegativo = -2;							//constante O(1)+
			while (aux != inicio) {								//n*(
				if (index == contadorNegativo) {				//constante O(1)+
					valor = aux.info;							//constante O(1)+
					aux.anterior.siguiente = aux.siguiente;		//constante O(1)+
					aux.siguiente.anterior = aux.anterior;		//constante O(1)+
				}
				contadorNegativo--;								//constante O(1)+
				aux = aux.anterior;								//constante O(1))+
				
			}
			pos--;												//constante O(1)+
		} else {
			throw new RuntimeException("No existe en la lista ese indice");	//constante O(1)=
		}

		return valor;
	}															//lineal O(n)


	public void remove(int valor) {
		
		boolean removio=false;								//constante O(1)+
			
		if(inicio.info==valor) {							//constante O(1)+
			inicio=inicio.siguiente;						//constante O(1)+
			inicio.anterior=null;							//constante O(1)+
			removio=true;									//constante O(1)+
		}else if (ultimo.info==valor) {						//constante O(1)+
			ultimo=ultimo.anterior;							//constante O(1)+
			ultimo.siguiente=null;							//constante O(1)+
			removio=true;									//constante O(1)+
		}
		NodoDoble aux = new NodoDoble();					//constante O(1)+
		aux=inicio.siguiente;								//constante O(1)+
			
		while(aux!=ultimo && removio==false) {				//n*(
			if (valor==aux.info) {							//constante O(1)+
				aux.anterior.siguiente=aux.siguiente;		//constante O(1)+
				aux.siguiente.anterior=aux.anterior;		//constante O(1)+
				removio=true;								//constante O(1)+
					}
			aux=aux.siguiente;								//constante O(1))+
			 }

		if(removio==false) {													//constante O(1)+
			throw new RuntimeException("No existe en la lista ese valor");		//constante O(1)=
		}
		
	}														//lineal O(n)

	public void reverse() {
		
		NodoDoble aux = new NodoDoble();				//constante O(1)+
		aux=ultimo;//recorre la lista original			//constante O(1)+
		
		NodoDoble inicio2 = new NodoDoble();				//constante O(1)+
		inicio2=crearNodo(ultimo.info,null,null); 				//constante O(1)+
		
		NodoDoble aux2 = new NodoDoble();					//constante O(1)+
		aux2=inicio2;										//constante O(1)+
		
		while(aux.anterior!=null) {							//n*(
			aux=aux.anterior;								//constante O(1)+
			aux2.siguiente=crearNodo(aux.info,aux2,null);	//constante O(1)+
			aux2=aux2.siguiente;							//constante O(1))+
		}
		inicio=inicio2;										//constante O(1)+
	}														//lineal O(n)
	

	public void sort() {
		NodoDoble aux = new NodoDoble();					//constante O(1)+
		NodoDoble auxInicio = new NodoDoble();				//constante O(1)+
		
		aux = auxInicio = inicio;							//constante O(1)+
		
		if (pos != 0) {										//constante O(1)+
			while (auxInicio.siguiente != null) { // revisar esto		//n*(
				while (aux.siguiente != null) {							//n*(
					if (aux.info > aux.siguiente.info) {				//constante O(1)+
						int temp = aux.info;							//constante O(1)+
						aux.info = aux.siguiente.info;					//constante O(1)+
						aux.siguiente.info = temp;						//constante O(1)+
					}
					aux = aux.siguiente;						//constante O(1)+
				}
				auxInicio = auxInicio.siguiente;				//constante O(1)+
				aux = inicio;									//constante O(1)=

			}
		}

	}														//cuadrático O(n^2)


	public boolean isSorted() {
		if (pos == 0)												//constante O(1)+
			throw new RuntimeException("Lista vacia");				//constante O(1)+
		else if (pos == 1)											//constante O(1)+
			return true;										
		else {						
			NodoDoble aux = new NodoDoble();						//constante O(1)+
		
			aux = inicio;											//constante O(1)+
			
			if (aux.info <= aux.siguiente.info) {					//constante O(1)+
				while ((aux.info <= aux.siguiente.info) && (aux.siguiente.siguiente != null)) {	//n*(
					aux = aux.siguiente;														//constante O(1))+
					
					}
				if ((aux.info <= aux.siguiente.info) && (aux.siguiente.siguiente == null)) {  //constante O(1)+
					return true;
				}
			} else if (aux.info >= aux.siguiente.info) {											//constante O(1)+
				while ((aux.info >= aux.siguiente.info) && (aux.siguiente.siguiente != null)) {		//n*(
					aux = aux.siguiente;															//constante O(1))+
				}
				if ((aux.info >= aux.siguiente.info) && (aux.siguiente.siguiente == null)) {		//constante O(1)=
					return true;
				}
			}
		}
		return false;
	}																								//lineal O(n)
	

	public boolean binarySearch(int valor) {
		if (isSorted()) {								//lineal O(n)+
			NodoDoble inf = new NodoDoble();			//constante O(1)+	
			NodoDoble sup = new NodoDoble();			//constante O(1)+
			NodoDoble aux = new NodoDoble();			//constante O(1)+
			int posicion = (size()) / 2;				//constante O(1)+
			inf = inicio;								//constante O(1)+
			sup = ultimo;								//constante O(1)+
			aux = get_nodo(posicion);					//lineal O(n)+

			if (inf.info == valor || sup.info == valor)		//constante O(1)+
				return true;

			while (inf.info <= valor && valor <= sup.info) {		//log n*(
				if (valor < aux.info) {								//constante O(1)+
					sup = aux.anterior;								//constante O(1)+
					aux = get_nodo(posicion / 2);					//lineal O(n)+
				} else if (valor > aux.info) {						//constante O(1)+
					inf = aux.siguiente;							//constante O(1)+
					aux = get_nodo(posicion + posicion / 2);		//lineal O(n)+
				} else if (valor == aux.info) {						//constante O(1))+
					return true;
				}

			}
			return false;

		} else {								
			throw new RuntimeException("Lista no ordenada");		//constante O(1)=
		}
	}																//casi lineal O(n log(n))



	private NodoDoble get_nodo(int posicion) {
		NodoDoble aux = new NodoDoble();			//constante O(1)+
		aux = inicio;								//constante O(1)+
		while (posicion != 0) {						//n*(
			posicion--;								//constante O(1)+
			aux = aux.siguiente;					//constante O(1)=
		}
		return aux;
	}												//lineal O(n)



	public int get(int posicion) {
		if(posicion>=size()) {													//constante O(1)+
			throw new RuntimeException("Índice fuera de rango");		//constante O(1)=
		}else {
			
			NodoDoble aux = new NodoDoble();			//constante O(1)+
			aux = inicio;								//constante O(1)+
			while (posicion != 0) {						//n*(
				posicion--;								//constante O(1)+
				aux = aux.siguiente;					//constante O(1)=
			}
			return aux.info;
		}
		
		}											//lineal O(n)
	

	public  NodoDoble primero() {
		return inicio;						//constante O(1)
	}


}
