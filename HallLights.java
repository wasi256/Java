public class HallLights {
    private boolean on;
    private int brightness;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public void dim() {
        dim(0);
    }

    public void dim(int brightness) {
        this.brightness = brightness;
        on = true;
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean isOn() {
        return on;
    }
}
