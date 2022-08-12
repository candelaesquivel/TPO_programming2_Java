package Pruebas;

import api.ColaPrioridadTDA;
import implementacion.ColaPrioridad;


public class PruebaColaPrioridad {

	public static void main(String[] args) {
		ColaPrioridadTDA cola = new ColaPrioridad();
		cola.inicializarCola(4);
		
		cola.acolarPrioridad(10, 1);
		cola.acolarPrioridad(20, 2);
		cola.acolarPrioridad(30, 3);
		
		int primero = cola.primero();
		int prioridad= cola.prioridad();
		boolean bol =cola.colaVacia();
		
		System.out.println( "Prioridad: "+ prioridad +  "  Valor: " +primero + " ¿Está Vacia? "+bol);
		
		cola.desacolar();
		cola.desacolar();
		cola.desacolar();

		boolean bol2 =cola.colaVacia();
		System.out.println( "¿Está Vacia? " +bol2);
	}

}