public class Nodo<T> {

	private T elemento;
	private Nodo<T> derecha;
	private Nodo<T> izquierda;

	public Nodo(T elemento) {
		super();
		this.elemento = elemento;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Nodo<T> getderecha() {
		return derecha;
	}

	public void setderecha(Nodo<T> derecha) {
		this.derecha = derecha;
	}

	public Nodo<T> getizquierda() {
		return izquierda;
	}
	public void setizquierda(Nodo<T> izquierda) {
		this.derecha = izquierda;
	}

}
