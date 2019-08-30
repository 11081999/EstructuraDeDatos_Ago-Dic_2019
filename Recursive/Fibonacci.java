public class Fibonacci{
  private int a= 0;
  private int b= 1;
  private int sum= 0;

  public static Fibonacci(int a, int b){
    for(int i = 2; i < number; i++){
      sum= a + b;
      a= b;
      b= sum;
    }

  }

  private static int fibonacci(int number){
      if(number==0){
        return 0;
      }
      if(number==1){
        return 1;
      }
      return fibonacci(number - 1) + fibonacci(number - 2);
  }

}
