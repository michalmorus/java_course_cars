package car.engine;

import org.springframework.stereotype.Service;

@Service
public class Engine {

    private static final float RPM_MAX = 9000;
    private boolean enabled;
    private float rpm;

    public Engine() {
        this.enabled = false;
        this.rpm = 0;
    }

    public void start() throws EngineStartException {
        if (this.enabled) {
            throw new EngineStartException();
        }
        this.enabled = true;
    }

    public void stop() throws EngineStopException {
        if (!this.enabled) {
            throw new EngineStopException();
        }
        this.enabled = false;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void increaseRPM(float value) throws EngineIncreaseRpmException {
        if (!this.isEnabled()) {
            throw new EngineIncreaseRpmException("Engine is not enabled!");
        }

        if (rpm + value > RPM_MAX) {
            throw new EngineIncreaseRpmException("rpm max value exceeded!");
        }

        rpm += value;
    }

    public float getRpm() {
        return this.rpm;
    }
}
