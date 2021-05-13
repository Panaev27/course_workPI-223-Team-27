package calculator;

public class ArcHangar extends Hangar {

	public ArcHangar(double _height, double _width, double _length) {
		super(_height, _width, _length);
	}
	@Override
	public double getHangarDoorArea() {
	            return width*height*0.6;
	}
	@Override
	public double getHangarArea() {
		return Math.PI*(width/2)*((width/2)+length);
	}
}
