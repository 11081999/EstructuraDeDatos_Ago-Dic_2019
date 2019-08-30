package shapes;

public class EquilateralTriangle extends Triangle{
    public EquilateralTriangle(double side){
      super(side, side, side);
    }

    @Override
	  public double calculateArea() {
  	  // TODO Auto-generated method stub
      double base = super.getSideC();
      double height = Math.sqrt(Math.pow(super.getSideA(), 2)-(Math.pow(super.getSideB()/2, 2)));
      return height*base/2;
    }
}
