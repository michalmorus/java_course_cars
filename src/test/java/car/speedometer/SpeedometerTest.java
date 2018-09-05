package car.speedometer;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import car.engine.Engine;
import car.gearbox.Gearbox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpeedometerTest {

    @Mock
    Engine engine;

    @Mock
    Gearbox gearbox;

    @InjectMocks
    Speedometer speedometer;

    @Test
    public void getValue() {
        float rpm = 300f;
        int gear = 2;
        when(engine.getRpm()).thenReturn(rpm);
        when(gearbox.getGear()).thenReturn(gear);
        float value = Speedometer.CONVERSION_UNIT * gear * rpm;
        assertEquals(value, speedometer.getValue(), 0.0);
    }
}