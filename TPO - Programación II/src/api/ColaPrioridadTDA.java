package api;

public interface ColaPrioridadTDA {

	
	/**
	* @Tarea_Nombre: Inicializa_InicializarCola.
	* @Tarea_Descripción: Inicializa la cola para comenzar a trabajarla.
	* @Parámetros: Recibe un int con el tamaño de la cola.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: No tiene precondiciones.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public void inicializarCola(int x); //COSTO: O(1).

	
	/**
	* @Tarea_Nombre: Agregar_AcolarPrioridad.
	* @Tarea_Descripción: Agrega un elemento con su prioridad a una cola.
	* @Parámetros: Recibe un int con el valor y un int con la prioridad.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La cola debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public void acolarPrioridad(int x, int prioridad); //COSTO: O(n).

	
	/**
	* @Tarea_Nombre: Eliminar_Desacolar.
	* @Tarea_Descripción: Elimina el elemento de mayor prioridad de una cola.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: La cola debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: Si la cola está vacía devuelve la excepcion tipo RuntimeException con el mensaje "La cola está vacía".
	*/
	public void desacolar(); //COSTO: O(1).

	
	/**
	* @Tarea_Nombre: EstaVacía_colaVacia.
	* @Tarea_Descripción: Permite saber si una cola con prioridad está vacía.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Retorna un booleano. Devuelve False si la cola no está vacía y True si lo está.
	* @Precondiciones: La cola debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: No tiene excepciones.
	*/
	public boolean colaVacia(); //COSTO: O(1).

	
	/**
	* @Tarea_Nombre: RetornaPrimero_Primero.
	* @Tarea_Descripción: Permite conocer el elemento de mayor prioridad de una cola.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Retorna un int con el valor del elemento de mayor prioridad.
	* @Precondiciones: La cola debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: Si la cola está vacía devuelve la excepcion tipo RuntimeException con el mensaje "La cola está vacía".
	*/
	public int primero(); //COSTO: O(1).

	
	/**
	* @Tarea_Nombre: RetornaPrioridad_Prioridad.
	* @Tarea_Descripción: Permite conocer la prioridad del elemento de mayor prioridad.
	* @Parámetros: No recibe parámetros.
	* @Devuelve: Retorna un int con la prioridad.
	* @Precondiciones: La cola debe estar inicializada.
	* @Postcondiciones: No tiene postcondiciones.
	* @Excepción: Si la cola está vacía devuelve la excepcion tipo RuntimeException con el mensaje "La cola está vacía".
	*/
	public int prioridad(); //COSTO: O(1).

}
