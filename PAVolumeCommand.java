import java.util.ArrayDeque;
import java.util.Deque;

public class PAVolumeCommand implements Command {
    private final PASystem pa;
    private final int volume;
    private final Deque<Integer> previousVolumes = new ArrayDeque<>();

    public PAVolumeCommand(PASystem pa, int volume) {
        this.pa = pa;
        this.volume = volume;
    }

    public void execute() {
        previousVolumes.push(pa.getVolume());
        pa.setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void undo() {
        if (!previousVolumes.isEmpty()) {
            pa.setVolume(previousVolumes.pop());
        }
    }
}
