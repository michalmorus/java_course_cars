package car.engine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {

    private Engine engine;

    @Before
    public void setUp() {
        this.engine = new Engine();
    }

    @Test
    public void shouldEngineStart() throws EngineStartException {
        engine.start();
        assertTrue(engine.isEnabled());
    }

    @Test(expected = EngineStartException.class)
    public void shouldEngineNotStartWhenWasStarted() throws EngineStartException {
        Engine engine = mock(Engine.class);
        doThrow(EngineStartException.class).when(engine).start();
        engine.start();
    }

    @Test
    public void shouldEngineIncreaseRpm() throws EngineIncreaseRpmException, EngineStartException {
        engine.start();
        engine.increaseRPM(200);
    }

    @Test(expected = EngineIncreaseRpmException.class)
    public void shouldEngineNotIncreaseRpmWhenIsNotStarted() throws EngineIncreaseRpmException {
        engine.increaseRPM(200);
    }

    @Test(expected = EngineIncreaseRpmException.class)
    public void shouldEngineNotIncreaseRpmOverLimit() throws EngineIncreaseRpmException, EngineStartException {
        engine.start();
        engine.increaseRPM( 11000 );
    }
}