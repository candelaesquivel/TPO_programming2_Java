package api;

public interface HeapTDA {
	
	
	/**
	* @Tarea_Nombre: Insertar_Push
	* @Tarea_Descripción: Inserta elementos en el heap
	* @Parámetros: Recibe un tipo de dato int.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: No existen precodinciones.
	* @Postcondiciones: El heap mantiene su orden al haber insertado un elemento.
	* @Excepción: No tiene excepción.
	*/
    public void push(int x) ; //COSTO: O(log(n))

    
    /**
	* @Tarea_Nombre: Eliminar_Pop
	* @Tarea_Descripción: Elimina el primer elemento del Heap.
	* @Parámetros: No recibe parámentros.
	* @Devuelve: No retorna ya que es de tipo void.
	* @Precondiciones: El Heap no debe estar vacío.
	* @Postcondiciones: El heap mantiene su orden al haber eliminado el primer elemento.
	* @Excepción: No tiene excepción.
	*/
    public void pop() ; //COSTO: O(log(n))

    
    /**
	* @Tarea_Nombre: Retorna_Peek
	* @Tarea_Descripción: Retorna el primer elemento del Heap.
	* @Parámetros: No recibe parámentros.
	* @Devuelve: Retorna un tipo de dato int que refiere al primer elemento del Heap.
	* @Precondiciones: El Heap no debe estar vacío.
	* @Postcondiciones: No tiene postcondición.
	* @Excepción: No tiene excepción.
	*/
    public int peek(); // COSTO: O(1)

    
    /**
	* @Tarea_Nombre: HeapVacío_isEmpty.
	* @Tarea_Descripción: Verifica si el Heap está vacío.
	* @Parámetros: No recibe parámentros.
	* @Devuelve: Retorna un booleano. False si el Heap no está vacío y true si tiene elementos.
	* @Precondiciones: No hay precondición.
	* @Postcondiciones: No tiene postcondición.
	* @Excepción: No tiene excepción.
	*/
    public boolean isEmpty() ; // COSTO: O(1)

}