package api;

public interface ConjuntoTDA {
	void InicializarConjunto(); // sin precondiciones
	void Agregar(int x); // conjunto inicializado
	int Elegir(); // conjunto inicializado y no vac´ıo
	boolean ConjuntoVacio(); // conjunto inicializado
	void Sacar(int x); // conjunto inicializado
	boolean Pertenece(int x); // conjunto inicializado
}
