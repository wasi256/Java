public class BlindsCloseCommand implements Command {
    private final Blinds blinds;

    public BlindsCloseCommand(Blinds blinds) {
        this.blinds = blinds;
    }

    public void execute() {
        blinds.close();
    }

    public void undo() {
        blinds.open();
    }
}
