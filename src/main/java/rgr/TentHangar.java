package rgr;

public class TentHangar extends Hangar {

	TentHangar(double _height, double _width, double _length) {
		super(_height, _width, _length);
	}
	
	@Override
	public double getHangarArea() {
		return 2*(22/30*width*height+length*Math.sqrt(Math.pow(0.1*width,2)+Math.pow(2/3*height,2)) + length*Math.sqrt(Math.pow(1/3*height,2)+Math.pow(0.4*width,2)) );
	}
}
