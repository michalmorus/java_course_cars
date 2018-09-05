package car.gearbox;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GearboxTest {

    private Gearbox gearbox;

    @Before
    public void setUp() throws Exception {
        this.gearbox = new Gearbox();
    }

    @Test
    public void shouldSetGear() throws InvalidGearException {
        gearbox.setGear(1);
        assertEquals(1, gearbox.getGear());
    }

    @Test(expected = InvalidGearException.class)
    public void shouldThrowExceptionWhenGearIsToHigh() throws InvalidGearException {
        gearbox.setGear(100);
    }

    @Test(expected = InvalidGearException.class)
    public void shouldThrowExceptionWhenGearIsToLower() throws InvalidGearException {
        gearbox.setGear(-213);
    }


    @Test
    public void shouldSetReverseGear() {
        this.gearbox.setReverseGear();
        assertEquals(Gearbox.REVERSE_GEAR, gearbox.getGear());
    }

    @Test
    public void shouldSetNeutralGear() {
        this.gearbox.setNeutralGear();
        assertEquals(Gearbox.NEUTRAL_GEAR, gearbox.getGear());
    }

}