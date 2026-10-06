public class CeilingFanOnCommand implements Command {
    private final CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        switch (previousSpeed) {
            case CeilingFan.HIGH:
                ceilingFan.high();
                break;

            case CeilingFan.MEDIUM:
                ceilingFan.medium();
                break;

            case CeilingFan.LOW:
                ceilingFan.low();
                break;

            default:
                ceilingFan.off();
                break;
        }
    }
}