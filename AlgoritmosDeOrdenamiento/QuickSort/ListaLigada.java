public class ListaLigada<T extends Comparable<T>> {

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

//________________Algoritmos de Búsqueda__________________________________//

	//Linear Search
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

	//Esto es para regresar el elemento que encuentra el metodo Linear Search
	public T encontrarElementoEnElIndice(int indice) {
		return encontrarNodoEnIndice(indice).getElemento();
	}

  //Binary Search
  public int busquedaBinaria(T elemento) {
    int inicio=0;
    int fin= contarElementos()-1;
    while(inicio<=fin) {
      int mitad= (inicio+fin)/2;
      if(encontrarElementoEnElIndice(mitad).compareTo(elemento)==0) {
        return mitad;
      }else {
        if(encontrarElementoEnElIndice(mitad).compareTo(elemento)>0) {
          fin=mitad-1;
        }else {
          inicio=mitad+1;
        }
      }
    }
    return -1;
  }
//________________Algoritmos de Orednamineto__________________________________//

  //Este método intercambia los elementos que le das en una lista ligada
  private void intercambiar(int index1, int index2) {
		System.out.println("Se intercambia "+encontrarElementoEnElIndice(index1)+" con:"+encontrarElementoEnElIndice(index2));
		Nodo<T> temp= encontrarNodoEnIndice(index1);
		T tempT= temp.getElemento();
		Nodo<T> temp2= encontrarNodoEnIndice(index2);
		temp.setElemento(temp2.getElemento());
		temp2.setElemento(tempT);
	}

	public void bubbleSort() {
		for(int i=0;i<contarElementos()-1;i++) {
			boolean intercambiado=false;
			for(int j=0;j<contarElementos()-1; j++) {
				if(encontrarElementoEnElIndice(j).compareTo(encontrarElementoEnElIndice(j+1))>0) {
					intercambiar(j,j+1);
					intercambiado=true;
				}
			}
			if(!intercambiado) {
				break;
			}
		}
	}

	public void selectionSort() {
		for(int i=0;i<contarElementos()-1;i++) {
			int masPequenio=i;
			for(int j=i+1;j<contarElementos()-1;j++) {
				if(encontrarElementoEnElIndice(j).compareTo(encontrarElementoEnElIndice(masPequenio))<0) {
					masPequenio=j;
				}
			}
			intercambiar(masPequenio,i);
		}
	}

	public void insertionSort() {
		int i=1;
		while(i<contarElementos()) {
			int j=i;
			while(j>0 && encontrarElementoEnElIndice(j-1).compareTo(encontrarElementoEnElIndice(j))>0) {
				intercambiar(j,j-1);
				j=j-1;
			}
			i++;
		}
	}

	public void mergeSort(){
		inicial=mergeSortInterno(inicial);
	}

	private Nodo<T> mergeSortInterno(Nodo<T> inicial) {
		Nodo<T> inicioAnterior= inicial;
		int mid= contarElementos()/2;
		System.out.println("Contar elementos: "+mid+" "+inicial.getElemento());
		if(inicial.getSiguiente()==null) {
			return inicial;
		}

		while(mid-1>0) {
			inicioAnterior=inicioAnterior.getSiguiente();
			mid--;
		}
		Nodo<T> nuevoInicio=inicioAnterior.getSiguiente();
		inicioAnterior.setSiguiente(null);
		inicioAnterior=inicial;
		Nodo<T> temp1= mergeSortInterno(inicioAnterior);
		Nodo<T> temp2= mergeSortInterno(nuevoInicio);
		return merge(temp1,temp2);
	}

	public Nodo<T> merge(Nodo<T> a, Nodo<T> b){
		Nodo<T> resultado;
		if (a==null)
			return b;
		if(b==null)
			return a;
		if(a.getElemento().compareTo(b.getElemento())>0) {
			resultado=b;
			resultado.setSiguiente(merge(a,b.getSiguiente()));
		}else {
			resultado=a;
			resultado.setSiguiente(merge(a.getSiguiente(),b));
		}
		return resultado;
	}

  public void quickSort(ListaLigada lista, int izquierda, int derecha){
    int pivote= (derecha+izquierda)/2;
    int i= izquierda;
    int j= derecha;
    while(i<=j){
      while(lista.encontrarElementoEnElIndice(i) < lista.encontrarElementoEnElIndice(pivote)){
        i++;
      }
      while(lista.encontrarElementoEnElIndice(j) > lista.encontrarElementoEnElIndice(pivote)){
        j--;
      }
      if(i<=j){
        if(i!=j){
          intercambiar(lista.encontrarElementoEnElIndice(i), lista.encontrarElementoEnElIndice(j));
        }
        i++;
        j--;
      }
    }
    if(izquierda<j){
      quickSort(lista, izquierda, j);
    }
    if(i<derecha){
      quickSort(lista, i, derecha);
    }
  }

}
