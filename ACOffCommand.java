public class ACOffCommand implements Command {
    private final AirConditioner ac;

    public ACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    public void execute() {
        ac.setTemperature(0);
    }

    public void undo() {
        ac.setTemperature(23);
    }
}
