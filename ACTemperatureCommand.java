import java.util.ArrayDeque;
import java.util.Deque;

public class ACTemperatureCommand implements Command {
    private final AirConditioner ac;
    private final int temperature;
    private final Deque<Integer> previousTemperatures = new ArrayDeque<>();

    public ACTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.temperature = temperature;
    }

    public void execute() {
        previousTemperatures.push(ac.getTemperature());
        ac.setTemperature(temperature);
    }

    public int getTemperature() {
        return temperature;
    }

    public void undo() {
        if (!previousTemperatures.isEmpty()) {
            ac.setTemperature(previousTemperatures.pop());
        }
    }
}