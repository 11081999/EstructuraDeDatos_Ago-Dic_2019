package shapes;

public class Tetrahedron extends Shape {
  //A tetrahedron is a 3D equilateral triangle
  private Triangle face;
  
  public Tetrahedron(double side){
    //we instance a triangle with the same size in each side
    face = new ScaleneTriangle(side, side, side);
  }

  @Override
	public double calculateArea() {
		// TODO Auto-generated method stub
    return face.calculateArea()*4;
  }

	@Override
	public double calculatePerimeter() {
    //Calculates volume instead of perimeter
		// TODO Auto-generated method stub
		return Math.sqrt(2)*Math.pow(face.calculatePerimeter(), 3) / 12;
	}
}
