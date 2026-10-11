public class ModeAuditTest {
    public static void main(String[] args) {
        HallLights lights = new HallLights();
        PASystem pa = new PASystem();
        Blinds blinds = new Blinds();
        MotorisedScreen screen = new MotorisedScreen();
        AirConditioner ac = new AirConditioner();

        WallPanel panel = new WallPanel();
        panel.setCommand(0, new LightsOnCommand(lights), new LightsOffCommand(lights));
        panel.setCommand(1, new PAVolumeCommand(pa, 6), new PAOffCommand(pa));
        panel.setCommand(2, new BlindsOpenCommand(blinds), new BlindsCloseCommand(blinds));
        panel.setCommand(3, new ScreenDownCommand(screen), new ScreenUpCommand(screen));
        panel.setCommand(4, new ACTemperatureCommand(ac, 23), new ACOffCommand(ac));

        Command[] modeOn = {
                new PAOnCommand(pa),
                new PAVolumeCommand(pa, 8)
        };
        Command[] modeOff = {
                new PAVolumeCommand(pa, 0),
                new PAOffCommand(pa)
        };
        SmartHallMode mode = new SmartHallMode(new MacroCommand(modeOn), new MacroCommand(modeOff));

        panel.activateMode(mode);
        System.out.println("Mode on: " + state(pa));
        panel.undo();
        System.out.println("Mode undo: " + state(pa));

        AuditLog log = panel.getAuditLog();
        HallLights freshLights = new HallLights();
        PASystem freshPa = new PASystem();
        Blinds freshBlinds = new Blinds();
        MotorisedScreen freshScreen = new MotorisedScreen();
        AirConditioner freshAc = new AirConditioner();
        AuditReplay.replay(log, freshLights, freshPa, freshBlinds, freshScreen, freshAc);

        System.out.println("Replay state: " + state(freshPa));
        if (!freshPa.isPoweredOn() || freshPa.getVolume() != 8) {
            throw new AssertionError("Audit replay did not restore the PA mode state");
        }
    }

    private static String state(PASystem pa) {
        return "powered=" + pa.isPoweredOn() + ", volume=" + pa.getVolume();
    }
}
