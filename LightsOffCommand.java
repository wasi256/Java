public class LightsOffCommand implements Command {
    private final HallLights lights;

    public LightsOffCommand(HallLights lights) {
        this.lights = lights;
    }

    public void execute() {
        lights.off();
    }

    public void undo() {
        lights.dim();
    }
}