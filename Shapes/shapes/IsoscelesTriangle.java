package shapes;

public class IsoscelesTriangle extends Triangle {
  
    public IsoscelesTriangle(double base, double sides){
        super(base, sides, sides);
    }

    @Override
      public double calculateArea() {
  	  // TODO Auto-generated method stub
      double base = super.getSideA();
      double height = Math.sqrt(Math.pow(super.getSideB(), 2)-(Math.pow(super.getSideA()/2, 2)));
      return height*base/2;
    }
}
