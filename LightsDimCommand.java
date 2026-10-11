import java.util.ArrayDeque;
import java.util.Deque;

public class LightsDimCommand implements Command {
    private final HallLights lights;
    private final int brightness;
    private final Deque<Integer> previousBrightness = new ArrayDeque<>();

    public LightsDimCommand(HallLights lights, int brightness) {
        this.lights = lights;
        this.brightness = brightness;
    }

    public void execute() {
        previousBrightness.push(lights.getBrightness());
        lights.dim(brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void undo() {
        if (!previousBrightness.isEmpty()) {
            lights.dim(previousBrightness.pop());
        }
    }
}