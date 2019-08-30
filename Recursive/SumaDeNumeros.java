public class SumaDeNumeros {

  public static sumaDeNumeros(int numeroMaximo){
    int resultado= 0;
    for (int i; i <= numeroMaximo; i++){
      resultado+=1;
      
    }
    return resultado;

  }

  public static int sumaDeNumerosRecursiva(int numeroMaximo){
    if (numeroMaximo==1){
      return 1;

    }else {
      return numeroMaximo+ sumaDeNumerosRecursiva(numeroMaximo);

    }
  }

}
