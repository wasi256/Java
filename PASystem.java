public class PASystem {
    private boolean poweredOn;
    private int volume;

    public void powerOn() {
        poweredOn = true;
    }

    public void powerOff() {
        poweredOn = false;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }
}
