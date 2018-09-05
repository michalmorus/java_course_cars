package car.speedometer;

import car.engine.Engine;
import car.gearbox.Gearbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Speedometer {
    public static final float CONVERSION_UNIT = 0.0043f;
    private Engine engine;
    private Gearbox gearbox;

    @Autowired
    public Speedometer(Engine engine, Gearbox gearbox) {
        this.engine = engine;
        this.gearbox = gearbox;
    }

    public float getValue() {
        return engine.getRpm() * Math.abs(gearbox.getGear()) * CONVERSION_UNIT;
    }
}
