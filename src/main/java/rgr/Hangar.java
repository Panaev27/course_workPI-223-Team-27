package rgr;

public abstract class Hangar {
	 double height;
	 double width;
	 double length;

	   public Hangar(double x_height, double y_width, double z_length) {
	        height=x_height;
	        width=y_width;
	        length=z_length;
	    }

	    public double getHangarArea() {
	        return 2*(width*height+length*height+length*width);
	     }

	    public double getHangarDoorArea() {
	        return width*height*0.65;
	    }

	    public double getHangarFoundationArea() {
	        return length*width;
	    }
}
