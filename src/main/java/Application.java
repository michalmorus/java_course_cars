import car.Car;
import car.engine.EngineIncreaseRpmException;
import car.engine.EngineStartException;
import car.gearbox.InvalidGearException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"car"})
public class Application {
    public static void main(String... args) throws InvalidGearException, EngineIncreaseRpmException, EngineStartException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        Car car = (Car) ctx.getBean(Car.class);
        car.startEngine();
        car.setGear(2);
        car.increaseRpm(4000);

        System.out.println(car.getRpm());
        System.out.println(car.getSpeed());
    }
}