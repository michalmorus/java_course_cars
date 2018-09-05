package car.gearbox;

import org.springframework.stereotype.Service;

@Service
public class Gearbox {

    static int REVERSE_GEAR = -1;
    static int NEUTRAL_GEAR = 0;
    static int GEARS_COUNT = 5;

    private int currentGear;

    Gearbox() {
        this.currentGear = 0;
    }

    public void setGear(int newGear) throws InvalidGearException {
        if (newGear > GEARS_COUNT || newGear < REVERSE_GEAR || newGear == currentGear) {
            throw new InvalidGearException();
        }
        currentGear = newGear;
    }

    void setReverseGear() {
        currentGear = REVERSE_GEAR;
    }

    void setNeutralGear() {
        this.currentGear = NEUTRAL_GEAR;
    }

    public int getGear() {
        return currentGear;
    }

    int getGearsCount() {
        return GEARS_COUNT;
    }
}
