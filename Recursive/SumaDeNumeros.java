public class SumaDeNumeros {
  private int resultado= 0;

  public static sumaDeNumeros(int numeroMaximo){
    this.resultado= resutlado;

    for (int i; i <= numeroMaximo; i++){
      resultado+=1;

    }
    return resultado;

  }

  public int getResultado(){
    return resultado;
  }

  public int setResultado(int i){
    return this.resultado= i;
  }

  public static int sumaDeNumerosRecursiva(int numeroMaximo){
    if (numeroMaximo==1){
      return 1;

    }else {
      return numeroMaximo+ sumaDeNumerosRecursiva(numeroMaximo);

    }
  }

}
