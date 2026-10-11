public class ScreenDownCommand implements Command {
    private final MotorisedScreen screen;

    public ScreenDownCommand(MotorisedScreen screen) {
        this.screen = screen;
    }

    public void execute() {
        screen.lower();
    }

    public void undo() {
        screen.raise();
    }
}
