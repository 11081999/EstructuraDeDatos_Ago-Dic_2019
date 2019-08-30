public class Fibonacci{

  public static Fibonacci(int a, int b){
    int a = 0;
    int b = 1;
    int sum = 0;

    for( int i = 2; i < number ; i++ ){
      sum = a + b;
      a = b;
      b = sum;

    }

  }

  private static int fibonacci(int number){
      if(number < 2 )
          return number;

      return fibonacci(number - 1) + fibonacci(number - 2);
  }

}
