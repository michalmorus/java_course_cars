package car;

import car.engine.Engine;
import car.engine.EngineIncreaseRpmException;
import car.engine.EngineStartException;
import car.engine.EngineStopException;
import car.gearbox.Gearbox;
import car.gearbox.InvalidGearException;
import car.speedometer.Speedometer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Car {

    private Engine engine;

    private Gearbox gearbox;

    private Speedometer speedometer;

    @Autowired
    public Car(Engine engine, Gearbox gearbox, Speedometer speedometer) {
        this.engine = engine;
        this.gearbox = gearbox;
        this.speedometer = speedometer;
    }

    public void startEngine() throws EngineStartException {
        this.engine.start();
    }

    public void stopEngine() throws EngineStopException {
        this.engine.stop();
    }

    public void increaseRpm(float value) throws EngineIncreaseRpmException {
        this.engine.increaseRPM(value);
    }

    public float getRpm() {
        return this.engine.getRpm();
    }

    public void setGear(int gear) throws InvalidGearException {
        this.gearbox.setGear(gear);
    }

    public int getGear() {
        return gearbox.getGear();
    }

    public float getSpeed() {
        return this.speedometer.getValue();
    }
}
