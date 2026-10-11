public class HallLight {
    private boolean on;

    public void dim() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
