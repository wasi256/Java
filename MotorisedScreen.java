public class MotorisedScreen {
    private int position;

    public void raise() {
        position++;
    }

    public void lower() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}
