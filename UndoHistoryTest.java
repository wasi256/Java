public class UndoHistoryTest {
    public static void main(String[] args) {
        WallPanel panel = new WallPanel(10);

        HallLights lights = new HallLights();
        PASystem pa = new PASystem();
        Blinds blinds = new Blinds();
        MotorisedScreen screen = new MotorisedScreen();
        AirConditioner ac = new AirConditioner();

        panel.setCommand(0, new LightsDimCommand(lights, 70), new NoCommand());
        panel.setCommand(1, new PAVolumeCommand(pa, 6), new NoCommand());
        panel.setCommand(2, new BlindsOpenCommand(blinds), new NoCommand());
        panel.setCommand(3, new ScreenDownCommand(screen), new NoCommand());
        panel.setCommand(4, new ACTemperatureCommand(ac, 23), new NoCommand());
        panel.setCommand(5, new LightsOnCommand(lights), new NoCommand());

        int[] slots = {0, 1, 2, 3, 4, 5};
        for (int slot : slots) {
            panel.onPressed(slot);
            printState(lights, pa, blinds, screen, ac);
        }

        System.out.println("\nUndoing six commands:");
        for (int i = 0; i < slots.length; i++) {
            panel.undo();
            printState(lights, pa, blinds, screen, ac);
        }

        if (panel.canUndo()) {
            throw new AssertionError("Undo history should be empty after six undos");
        }
    }

    private static void printState(
            HallLights lights,
            PASystem pa,
            Blinds blinds,
            MotorisedScreen screen,
            AirConditioner ac) {
        System.out.printf(
                "lights=%s brightness=%d, pa=%s volume=%d, blinds=%s, screen=%d, ac=%d%n",
                lights.isOn(),
                lights.getBrightness(),
                pa.isPoweredOn(),
                pa.getVolume(),
                blinds.isOpen(),
                screen.getPosition(),
                ac.getTemperature());
    }
}
