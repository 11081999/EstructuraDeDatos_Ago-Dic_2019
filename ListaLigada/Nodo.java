public class Nodo<T> {

    Private T elemento;
    private Nodo<T> siguiente;

    public Nodo<T>(T elemento){
        super();
        this.elemento=elemento;
    }

    public T getElemento(){
        return elemento;
    }

    public void setElemento(T elemento){
        this.elemento=elemento;
    }

    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente=siguiente;
    }
}
