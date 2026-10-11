public class PAOnCommand implements Command {
    private final PASystem pa;

    public PAOnCommand(PASystem pa) {
        this.pa = pa;
    }

    public void execute() {
        pa.powerOn();
    }

    public void undo() {
        pa.powerOff();
    }
}