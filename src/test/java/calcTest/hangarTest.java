package calcTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class hangarTest {
	@Test
    public void test() {

        calculator.Hangar h = new calculator.Hangar(5, 9, 6) {};
        assertTrue(h.getHangarFoundationArea()==54&&h.getHangarDoorArea()==29.25);

    }

}
