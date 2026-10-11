import java.util.ArrayDeque;
import java.util.Deque;

public class WallPanel {
    private static final int DEFAULT_UNDO_DEPTH = 10;
    private static final int MODE_SLOT = 6;

    private final Command[] onCommands;
    private final Command[] offCommands;
    private final Deque<Command> undoHistory;
    private final int undoDepth;
    private final NoCommand noCommand;
    private final AuditLog auditLog;
    private SmartHallMode activeMode;

    public WallPanel() {
        this(DEFAULT_UNDO_DEPTH, new AuditLog());
    }

    public WallPanel(int undoDepth) {
        this(undoDepth, new AuditLog());
    }

    public WallPanel(int undoDepth, AuditLog auditLog) {
        if (undoDepth <= 0) {
            throw new IllegalArgumentException("Undo depth must be greater than zero");
        }

        this.undoDepth = undoDepth;
        this.undoHistory = new ArrayDeque<>();
        this.noCommand = new NoCommand();
        this.auditLog = auditLog;
        onCommands = new Command[7];
        offCommands = new Command[7];

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onPressed(int slot) {
        executeAndRecord(slot, onCommands[slot]);
    }

    public void offPressed(int slot) {
        executeAndRecord(slot, offCommands[slot]);
    }

    public void activateMode(SmartHallMode mode) {
        activeMode = mode;
        executeAndRecord(MODE_SLOT, mode.getOnCommand());
    }

    public void deactivateMode() {
        if (activeMode != null) {
            executeAndRecord(MODE_SLOT, activeMode.getOffCommand());
        }
    }

    public void undo() {
        if (undoHistory.isEmpty()) {
            return;
        }

        undoHistory.removeLast().undo();
    }

    public boolean canUndo() {
        return !undoHistory.isEmpty();
    }

    public AuditLog getAuditLog() {
        return auditLog;
    }

    private void executeAndRecord(int slot, Command command) {
        if (command == noCommand) {
            return;
        }

        command.execute();
        recordCommand(slot, command);
        undoHistory.addLast(command);

        while (undoHistory.size() > undoDepth) {
            undoHistory.removeFirst();
        }
    }

    private void recordCommand(int slot, Command command) {
        if (command instanceof MacroCommand) {
            for (Command child : ((MacroCommand) command).getCommands()) {
                recordCommand(slot, child);
            }
            return;
        }

        auditLog.record(slot, command, commandValue(command));
    }

    private int commandValue(Command command) {
        if (command instanceof LightsDimCommand) {
            return ((LightsDimCommand) command).getBrightness();
        }
        if (command instanceof PAVolumeCommand) {
            return ((PAVolumeCommand) command).getVolume();
        }
        if (command instanceof ACTemperatureCommand) {
            return ((ACTemperatureCommand) command).getTemperature();
        }
        return 0;
    }
}
