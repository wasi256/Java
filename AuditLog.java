import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditLog {
    private final List<AuditEntry> entries = new ArrayList<>();

    public void record(int slot, Command command, int value) {
        entries.add(new AuditEntry(Instant.now(), slot, command.getClass().getSimpleName(), value));
    }

    public List<AuditEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    public static class AuditEntry {
        private final Instant timestamp;
        private final int slot;
        private final String commandClass;
        private final int value;

        private AuditEntry(Instant timestamp, int slot, String commandClass, int value) {
            this.timestamp = timestamp;
            this.slot = slot;
            this.commandClass = commandClass;
            this.value = value;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public int getSlot() {
            return slot;
        }

        public String getCommandClass() {
            return commandClass;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return timestamp + " slot=" + slot + " command=" + commandClass + " value=" + value;
        }
    }
}
