public class ListaLigada<T> {

    private Nodo<T> inicial;

    public Nodo<T> getInicial(){
        return inicial;
    }

    public void setInicial(Nodo<T> inicial){
        this.inicial=inicial;
    }

    public boolean estaVacia(){
        return inicial==null;
    }

    public void insertarAlInicio(T elemento){
        //Creamos un nuevo nodo en donde su apuntador sera el inicial de antes
        Nodo<T> aInsertar= new Nodo<>(elemento);
        aInsertar.setSiguiente(inicial);
        inicial=aInsertar;
    }

    public void insertarAlUltimo(T elemento){
        //Aqui no tienes que volver a instancear el nodo porque ya lo
        //haces en el método insertarAlInicio
        if(estaVacia()){
            insertarAlInicio(elemento);
        }else{
            //Vamos a recorer tod la lista hasta encontrar el último elemento
            //(el que es == null)
            Nodo<T> temp= inicial;
            while(temp.getSiguiente()!=null){
                temp= temp.getSiguiente();
            }
            //Aqui falta instancear el nuevo nodo que va a estar al último
            temp.setSiguiente(new Nodo<T> (elemento));
        }
    }

    public int contarElementos() {
        if(estaVacia())
            return 0;
        else {
            Nodo<T> temp = inicial;
            int contador=0;
            //REcorrer la lista hasta encontrar un nudod que apunte a null
            //vas a dejar de contar hasta encontrar el último nodo
            while(temp!=null) {
                contador++;
                temp=temp.getSiguiente();
            }
            return contador;
        }
    }

    public void quitarElPrimero() {
        if(estaVacia())
            System.out.println("No puedes quitar elementos");
        else {
            //haces que inicial ahora sea el que era su suguiente
            inicial=inicial.getSiguiente();
        }
    }

    public void quitarAlFinal() {
        if(estaVacia())
            System.out.println("No puedes quitar elementos");
        else {
            if(contarElementos()==1) {
                inicial=null;
            }else {
                Nodo<T> temp = inicial;
                //Recorres la lista hasta encontrar el PENÚLTIMO elemento
                //y al siguiente del penultimo, osea al ultimo, lo haces nulo
                while (temp.getSiguiente().getSiguiente()!=null) {
                    temp=temp.getSiguiente();
                }
                //temp ahora es el que antes era el Ante penúltimo, por lo que
                //al hacer su siguiente nulo se piderde el que antes era el
                //ultimo
                temp.setSiguiente(null);
            }

        }
    }

    //Este método es otra forma de quitar al final de la lista
    public void quitarAlFinalIndice() {
        if(contarElementos()==0) {
            System.out.println("No puedes borrar");
        }else if(contarElementos()==1) {
            quitarElPrimero();
        }else {
            //cuentas todos tus elementos y les restas 2 para quedar en el ante
            //antepenultimo y hacer al siguiente nulo, convirtiendolo en el
            //ultimo
            Nodo<T> antepenultimo= encontrarNodoEnIndice(contarElementos()-2);
            antepenultimo.setSiguiente(null);
        }
    }

    public Nodo<T> encontrarNodoEnIndice(int indice){
        if(indice<contarElementos()) {
            Nodo<T> temp = inicial;
            //El for es para "detenerse" en el lugar del nodo deseado
            for(int i=0;i<indice;i++) {
                temp=temp.getSiguiente();
            }
            //regresa el nodo del lugar del inidce
            return temp;
        }else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public void insertarEnElIndice(int index, T elemento) {
        if(estaVacia())
            insertarAlInicio(elemento);
        else {
            if(index>=contarElementos()) {
                System.out.println("No puedes insertar en ese indice");
                return;
            }
            if(index==contarElementos()-1) {
                insertarAlUltimo(elemento);
                return;
            }
            if(index==0) {
                insertarAlInicio(elemento);
                return;
            }
            Nodo<T> anterior=encontrarNodoEnIndice(index-1);
            Nodo<T> aInsertar= new Nodo<>(elemento);
            aInsertar.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(aInsertar);

        }
    }

    public void imprimeLista() {
        if(estaVacia()) {
            System.out.println("Lista vacía");
        }else {
            Nodo<T> temp = inicial;
            while (temp!=null) {
                System.out.println("Nodo: "+ temp.getElemento().toString());
                temp=temp.getSiguiente();
            }
        }
    }

    public void imprimeRec() {
        imprimeRecursivo(inicial);
    }
    private void imprimeRecursivo(Nodo<T> nodo) {
        if(nodo!=null) {
            System.out.println("Nodo: "+nodo.getElemento().toString());
            imprimeRecursivo(nodo.getSiguiente());
        }
    }

    private void swap(int index1, int index2){
        T temp1= getNodeAtIndex(index1).getFirst();
        T temp2= getNodeAtIndex(index2).getFirst();
        getNodeAtIndex(index1).setFirst(temp2);
        getNodeAtIndex(index2).setFirst(temp1);
    }
    //----------------Algoritmos de Ordenamiento----------------------///

    //QuickSort
    public void quickSort(ListaLigada lista, int derecha, int izquierda){
      int pivote= (izquierda+derecha)/2;
      //primer elemento
      int i= izquierda;
      //ulitmo elemento
      int j= derecha;
      while(i<=j){
        while(lista.encontrarNodoEnIndice(i)<pivote){
          i++
        }
        while(lista.encontrarNodoEnIndice(j)>pivote){
          j--
        }
        if(i<=j){
          if(i!=j){
            intercambiar(lista.encontrarNodoEnIndice(i), lista.encontrarNodoEnIndice(j))
          }
          i++
          j--
        }
      }
      while(){
        if(izquierda<j){
          quickSort(lista, izquierda, j);
        }
        if(i<derecha){
          quickSort(lista, i, derecha);
        }
      }



    }


}
