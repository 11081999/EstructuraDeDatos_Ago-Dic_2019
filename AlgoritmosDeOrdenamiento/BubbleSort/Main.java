
public class Main {
	public static void main(String args[]) {
		ListaLigada<Integer> lista= new ListaLigada<>();
		lista.insertarAlInicio(3);
		lista.insertarAlInicio(10);
		lista.insertarAlInicio(20);
		lista.insertarAlInicio(15);
		lista.insertarAlInicio(8);
		lista.insertarAlUltimo(22);
		lista.insertarAlUltimo(24);
		lista.insertarAlUltimo(26);
		lista.imprimeLista();

		System.out.println("/Ordenar (Bubble)-------------------------------/");

		//bubble Sort
		lista.bubbleSort();
		lista.imprimeLista();

	}
}
