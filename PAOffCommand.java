public class PAOffCommand implements Command {
    private final PASystem pa;

    public PAOffCommand(PASystem pa) {
        this.pa = pa;
    }

    public void execute() {
        pa.powerOff();
    }

    public void undo() {
        pa.powerOn();
    }
}
