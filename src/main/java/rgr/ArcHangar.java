package rgr;

public class ArcHangar extends Hangar {

	ArcHangar(double _height, double _width, double _length) {
		super(_height, _width, _length);
	}
	
	@Override
	public double getHangarArea() {
		return Math.PI*(width/2)*((width/2)+length);
	}
}
