import java.util.ArrayList;
import java.util.List;

public class AuditReplay {
    public static List<Command> replay(AuditLog auditLog, HallLights lights, PASystem pa,
            Blinds blinds, MotorisedScreen screen, AirConditioner ac) {
        List<Command> commands = new ArrayList<>();

        for (AuditLog.AuditEntry entry : auditLog.getEntries()) {
            Command command = createCommand(entry, lights, pa, blinds, screen, ac);
            command.execute();
            commands.add(command);
        }

        return commands;
    }

    private static Command createCommand(AuditLog.AuditEntry entry, HallLights lights,
            PASystem pa, Blinds blinds, MotorisedScreen screen, AirConditioner ac) {
        switch (entry.getCommandClass()) {
            case "LightsDimCommand":
                return new LightsDimCommand(lights, entry.getValue());
            case "LightsOffCommand":
                return new LightsOffCommand(lights);
            case "LightsOnCommand":
                return new LightsOnCommand(lights);
            case "PAVolumeCommand":
                return new PAVolumeCommand(pa, entry.getValue());
            case "PAOnCommand":
                return new PAOnCommand(pa);
            case "PAOffCommand":
                return new PAOffCommand(pa);
            case "BlindsOpenCommand":
                return new BlindsOpenCommand(blinds);
            case "BlindsCloseCommand":
                return new BlindsCloseCommand(blinds);
            case "ScreenUpCommand":
                return new ScreenUpCommand(screen);
            case "ScreenDownCommand":
                return new ScreenDownCommand(screen);
            case "ACTemperatureCommand":
                return new ACTemperatureCommand(ac, entry.getValue());
            case "ACOffCommand":
                return new ACOffCommand(ac);
            default:
                throw new IllegalArgumentException("Unknown command in audit log: " + entry.getCommandClass());
        }
    }
}
