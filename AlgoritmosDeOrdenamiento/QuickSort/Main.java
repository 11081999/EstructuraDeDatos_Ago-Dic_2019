public class Main {

	public static void main(String args[]) {
		ListaLigada<Integer> listaLigada= new ListaLigada<>();
		listaLigada.insertarAlInicio(3);
		listaLigada.insertarAlInicio(10);
		listaLigada.insertarAlInicio(20);
		listaLigada.insertarAlInicio(15);
		listaLigada.insertarAlInicio(8);
		listaLigada.insertarAlUltimo(22);

		listaLigada.quickSort();

  }

}
