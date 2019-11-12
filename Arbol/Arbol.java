
public class Arbol<T extendas comparable<T>> {

	private Nodo<T> raiz;

	public Entrada() {

	}

	public Nodo<T> getRaiz(){
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz){
		this.raiz= raiz;
	}

	public void insertar(T elemento){
		if (raiz==null){
			raiz= new Nodo<>(elemento);
		}


	}

}
