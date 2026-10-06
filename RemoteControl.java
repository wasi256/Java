public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int slot = 0; slot < onCommands.length; slot++) {
            onCommands[slot] = noCommand;
            offCommands[slot] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n------ Remote Control -------\n");
        for (int slot = 0; slot < onCommands.length; slot++) {
            result.append("[slot ").append(slot).append("] ")
                    .append(onCommands[slot].getClass().getSimpleName()).append("  ")
                    .append(offCommands[slot].getClass().getSimpleName()).append('\n');
        }
        return result.toString();
    }
}