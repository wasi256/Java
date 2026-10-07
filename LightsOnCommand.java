public class LightsOnCommand implements Command {
    private final HallLights lights;

    public LightsOnCommand(HallLights lights) {
        this.lights = lights;
    }

    public void execute() {
        lights.on();
    }

    public void undo() {
        lights.off();
    }
}
