public class SumaDeNumeros {

  public static int sumaDeNumerosRecursiva(int numeroMaximo){
    if (numeroMaximo==1){
      return 1;

    }else {
      return numeroMaximo+ sumaDeNumerosRecursiva(numeroMaximo-1);

    }
  }

} 
