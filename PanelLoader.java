/** Client: creates the receivers and commands, loads the slots, then presses the buttons.
 *  Follows the flow of RemoteLoader in Head First Design Patterns, chapter 6. */
public class PanelLoader {
    public static void main(String[] args) {
        WallPanel wallPanel = new WallPanel();

        // Create all the receivers (vendor devices)
        HallLights lights = new HallLights();
        PASystem pa = new PASystem();
        Blinds blinds = new Blinds();
        MotorisedScreen screen = new MotorisedScreen();
        AirConditioner ac = new AirConditioner();

        // Create all the command objects, passing each one its receiver
        LightsDimCommand lightsDim = new LightsDimCommand(lights, 70);
        LightsOffCommand lightsOff = new LightsOffCommand(lights);

        PAVolumeCommand paVolume = new PAVolumeCommand(pa, 6);
        PAOffCommand paOff = new PAOffCommand(pa);

        BlindsCloseCommand blindsClose = new BlindsCloseCommand(blinds);
        BlindsOpenCommand blindsOpen = new BlindsOpenCommand(blinds);

        ScreenDownCommand screenDown = new ScreenDownCommand(screen);
        ScreenUpCommand screenUp = new ScreenUpCommand(screen);

        ACTemperatureCommand acTemp = new ACTemperatureCommand(ac, 23);
        ACOffCommand acOff = new ACOffCommand(ac);

        // Load the commands into the slots (5 and 6 stay NoCommand for now)
        wallPanel.setCommand(0, lightsDim, lightsOff);
        wallPanel.setCommand(1, paVolume, paOff);
        wallPanel.setCommand(2, blindsClose, blindsOpen);
        wallPanel.setCommand(3, screenDown, screenUp);
        wallPanel.setCommand(4, acTemp, acOff);

        System.out.println(wallPanel);

        // Press every button, slot by slot, printing the panel after each pair
        wallPanel.onPressed(0);
        wallPanel.offPressed(0);
        wallPanel.onPressed(1);
        wallPanel.offPressed(1);
        wallPanel.onPressed(2);
        wallPanel.offPressed(2);
        wallPanel.onPressed(3);
        wallPanel.offPressed(3);
        wallPanel.onPressed(4);
        wallPanel.offPressed(4);
        System.out.println(wallPanel);

        // NoCommand slots: pressing them must be harmless
        wallPanel.onPressed(5);
        wallPanel.offPressed(5);
        wallPanel.onPressed(6);
        wallPanel.offPressed(6);
        System.out.println(wallPanel);
    }
}