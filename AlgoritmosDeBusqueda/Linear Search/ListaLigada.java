public class ListaLigada <T extends Comparable <T>> {

  private Node<T> start;

  public int busquedaLineal(T elemento) throws exception{
    Nodo<T> temp= inicial;
    if (estaVacia()){
      throw new Exception("Lista vacia");
    }
    int indice= 0;
    while (temp != null){
      if(temp.getElemento().comparteTo(elemento)==0){
        return indice;
      }else {
        temp= temp.getSiguiente();
      }
    }

    throw new Exception("Elemento no encontrado");

  }

}
