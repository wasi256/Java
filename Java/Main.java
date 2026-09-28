import java.util.ArrayList;
import java.util.List;

// 1. Observer Interface
// Defines the common contract for what an observer must do when updated[cite: 1]
interface BasicObserver {
    void update();
}

// 2. Subject Class
// Maintains a list of observers and provides methods to attach, detach, and notify[cite: 1]
class BasicSubject {
    private List<BasicObserver> observers = new ArrayList<>();

    public void attach(BasicObserver observer) {
        observers.add(observer);
    }

    public void detach(BasicObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BasicObserver observer : observers) {
            observer.update();
        }
    }
}

// 3. Concrete Subject (Weather Station)
// Contains the actual state (temperature) and triggers notifications upon change[cite: 1]
class BasicWeatherStation extends BasicSubject {
    private int temperature;

    public void setTemperature(int newTemperature) {
        this.temperature = newTemperature;
        System.out.println("\n[WeatherStation] Temperature changed to: " + temperature + "°C");
        notifyObservers(); // Automatically notify registered observers[cite: 1]
    }

    public int getTemperature() {
        return temperature;
    }
}

// 4. Concrete Observers (Phone Display and TV Display)
class PhoneDisplay implements BasicObserver {
    @Override
    public void update() {
        System.out.println("-> Phone display updated: New temperature received.");
    }
}

class TVDisplay implements BasicObserver {
    @Override
    public void update() {
        System.out.println("-> TV display updated: New temperature received.");
    }
}

// 5. Main Execution Class
public class Main {
    public static void main(String[] args) {
        // Step 1: Create the Subject[cite: 1]
        BasicWeatherStation weatherStation = new BasicWeatherStation();

        // Step 2: Create the Observers[cite: 1]
        BasicObserver phoneDisplay = new PhoneDisplay();
        BasicObserver tvDisplay = new TVDisplay();

        // Step 3: Register Observers with the Subject using attach()[cite: 1]
        weatherStation.attach(phoneDisplay);
        weatherStation.attach(tvDisplay);

        // Step 4 & 5: Change state, triggering notify() and update()[cite: 1]
        weatherStation.setTemperature(25);

        // Step 11: Removing an Observer using detach()[cite: 1]
        System.out.println("\n--- Removing TVDisplay ---");
        weatherStation.detach(tvDisplay);

        // Change temperature again (only PhoneDisplay will update now)[cite: 1]
        weatherStation.setTemperature(30);
    }
}