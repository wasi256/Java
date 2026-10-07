public class ScreenUpCommand implements Command {
    private final MotorisedScreen screen;

    public ScreenUpCommand(MotorisedScreen screen) {
        this.screen = screen;
    }

    public void execute() {
        screen.raise();
    }

    public void undo() {
        screen.lower();
    }
}