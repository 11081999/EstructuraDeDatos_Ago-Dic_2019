
public class Main {
	public static void main(String args[]) {
		ListaLigada<Integer> lista= new ListaLigada<>();
		lista.insertarAlUltimo(20);
		lista.insertarAlUltimo(25);
		lista.insertarAlUltimo(30);
		lista.insertarAlUltimo(35);
		lista.imprimeLista();
		
		System.out.println("El elemento en la pos 1 es: " + lista.encontrarElementoEnElIndice(1);
		//Alterantivamente se puede usar
		System.out.println("El elemento en la pos 2 es (lin): " + lista.encontrarNodoEnIndice(2).getElemento());
		//VS Binary Search
		System.out.println("El elemento 30 esta en la pos (bin): " + lista.encontrarNodoEnIndice(30));
	}
}
