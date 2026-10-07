public class SmartHallMode {
    private final Command onCommand;
    private final Command offCommand;

    public SmartHallMode(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public Command getOnCommand() {
        return onCommand;
    }

    public Command getOffCommand() {
        return offCommand;
    }
}
