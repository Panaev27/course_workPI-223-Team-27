package calcTest;
import static org.junit.Assert.*;
import org.junit.Test;

public class TypeHangarTest {

    @Test
    public void testHangar() {

        calculator.Hangar hangarBox = new calculator.BoxHangar(5, 5, 5);
        calculator.Hangar hangarTent = new calculator.TentHangar(4, 5, 5);
        calculator.Hangar hangarArc = new calculator.ArcHangar(1, 1, 1);
        boolean rightArea = hangarBox.getHangarArea()==125.0&&hangarTent.getHangarArea()==25.0&&hangarArc.getHangarArea()==3*Math.PI/4;
        boolean rightDoorArea = hangarBox.getHangarDoorArea()==16.25&&hangarTent.getHangarDoorArea()==12.4&&hangarArc.getHangarDoorArea()==0.6;
        assertTrue(rightArea&&rightDoorArea);

    }

}