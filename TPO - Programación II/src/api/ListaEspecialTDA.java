package api;


public interface ListaEspecialTDA {
	
	public static class NodoDoble {
		public int info;
		public NodoDoble anterior;
		public NodoDoble siguiente;
	}
	
	
	/**
	* @Tarea_Nombre: Inicializa_InicializarLista.
	* @Tarea_Descripción: Inicializa la lista para comenzar a trabajarla.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: No tiene precondición.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public void inicializarLista(); //COSTO: O(1).
	

	/**
	* @Tarea_Nombre: Tamaño_Size.
	* @Tarea_Descripción: Devuelve el tamaño de la lista, es decir, la cantidad de elementos que tiene la lista.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Devuelve un int con la cantidad de elementos de la lista.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public int size(); //COSTO: O(1).
	
	
	/**
	* @Tarea_Nombre: Agregar_Append.
	* @Tarea_Descripción: Agrega elementos al final de la lista.
	* @Parámetros: Recibe un int con el valor a agregar.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: Incrementa uno el tamaño de la lista.
	* @Excepción: No tiene excepciones.
	*/
	public abstract void append(int valor); //COSTO: O(1).
	
	
	/**
	* @Tarea_Nombre: VacíaLista_Clear.
	* @Tarea_Descripción: Elimina todos los elementos de la lista.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: El tamaño de la lista es igual a 0.
	* @Excepción: No tiene excepciones.
	*/
	public abstract void clear(); //COSTO: O(1).
	
	
	/**
	* @Tarea_Nombre: Copiar_Copy.
	* @Tarea_Descripción: Copia los elementos de una lista en una lista nueva.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Retorna la copia de la lista.
	* @Precondiciones: No tiene precondiciones.
	* @Postcondiciones: No hay postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public abstract ListaEspecialTDA copy();  //COSTO: O(n)
	
	
	/**
	* @Tarea_Nombre: Contar_Count.
	* @Tarea_Descripción: Cuenta la cantidad de apariciones que hay de un valor en la lista.
	* @Parámetros: Recibe un int con el valor.
	* @Devuelve: Retorna un int con la cantidad de apariciones de ese valor en la lista.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No hay postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public abstract int count(int valor);  //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: AgregaLista_Extend.
	* @Tarea_Descripción: Agrega la lista recibida por parámetro al final de la lista original.
	* @Parámetros: Recibe una lista de tipo ListaEspecialTDA.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: Incrementa el tamaño de la lista original.
	* @Excepción: No tiene excepciones.
	*/
	public abstract void extend(ListaEspecialTDA lista);  //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: Indice_Index.
	* @Tarea_Descripción: Busca en qué posición de la lista se encuentra el elemento valor;
	* si aparece varias veces, devuelve la primera. 
	* @Parámetros: Recibe un int con el valor a buscar.
	* @Devuelve: Retorna la posición del valor en la lista.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondición.
	* @Excepción: Cuando no existe el elemento lanza una excepción de 
	* tipo RuntimeException con el mensaje "No existe en la lista".
	*/
	public abstract int index(int valor); //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: EliminaIndice_Pop.
	* @Tarea_Descripción: Elimina el elemento de la posición enviada por parámetro. Permite la utilización de índices negativos.
	* @Parámetros: Recibe un int con la posición del valor a eliminar.
	* @Devuelve: Devuelve el valor eliminado.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: Decrementa uno el tamaño de la lista.
	* @Excepción: En caso de sobrepasar el tamaño de la lista, lanza una excepción 
	* de tipo RuntimeException con el mensaje "No existe en la lista ese índice".
	*/
	public abstract int pop(int index);   //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: EliminaValor_Remove.
	* @Tarea_Descripción: Elimina el elemento valor de la lista; si aparece varias veces, elimina la primera.
	* @Parámetros: Recibe un int con el valor a eliminar.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: Decrementa uno el tamaño de la lista.
	* @Excepción: En caso de no existir el valor a eliminar, lanza una excepción de 
	* tipo RuntimeException con el mensaje "No existe en la lista ese valor".
	*/
	public abstract void remove(int valor);   //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: Invertir_Reverse.
	* @Tarea_Descripción: Invierte la lista.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: La lista está invertida.
	* @Excepción: No tiene excepciones.
	*/
	public abstract void reverse();  //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: Ordenar_Sort.
	* @Tarea_Descripción: Ordena los elementos de la lista de menor a mayor segun el valorde dichos elementos.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: La lista se encuentra ordenada.
	* @Excepción: No tiene excepciones.
	*/
	public abstract void sort();  //COSTO: O(n^2).
	
	
	/**
	* @Tarea_Nombre: EstaOrdenado_isSorted.
	* @Tarea_Descripción: Valida si la lista está ordenada tanto de forma creciente como decreciente.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public abstract boolean isSorted();  //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: Buscar_binarySearch.
	* @Tarea_Descripción: Busca el valor ingresado mediante una búsqueda binaria.
	* @Parámetros: Recibe un int con el valor a buscar.
	* @Devuelve: Retorna un boolean. False si no encontró el elemento y True si lo encontró.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: Si la lista no está ordenada (creciente o decrecientemente), 
	* lanza una excepción de tipo RuntimeException con el mensaje "Lista no ordenada".
	*/
	public abstract boolean binarySearch(int valor); //COSTO: O(n^2)
	
	
	/**
	* @Tarea_Nombre: Imprime_Print.
	* @Tarea_Descripción: Imprime por pantalla los elementos de la lista.
	* @Parámetros: No recibe parámetros.
	* @Devuelve:No retorna ya que es de tipo void.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public void print();  //COSTO: O(n).
	
	
	/**
	* @Tarea_Nombre: DevuelveValor_Get.
	* @Tarea_Descripción: Devuelve el valor del índice pasado por parámetro.
	* @Parámetros: Recibe un int con el índice.
	* @Devuelve:Retorna un int con el valor.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public int get(int index);  //COSTO: O(n).
	
	/**
	* @Tarea_Nombre:DevuelvePrimero_Primero.
	* @Tarea_Descripción: Devuelve el primer elemento de la lista.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Retorna un elemento tipo NodoDoble.
	* @Precondiciones: La lista debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public NodoDoble primero();  //COSTO: O(1).
	

}