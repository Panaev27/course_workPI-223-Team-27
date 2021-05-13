package calculator;

public class BoxHangar extends Hangar {

	public BoxHangar(double _height, double _width, double _length) {
		super(_height, _width, _length);
	}
	
	@Override
	public double getHangarArea() {
		return (2*(width*height+length*height)+length*width);
	}
}
