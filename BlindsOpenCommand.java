public class BlindsOpenCommand implements Command {
    private final Blinds blinds;

    public BlindsOpenCommand(Blinds blinds) {
        this.blinds = blinds;
    }

    public void execute() {
        blinds.open();
    }

    public void undo() {
        blinds.close();
    }
}