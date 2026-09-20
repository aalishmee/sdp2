import app.DeliveryApplication;
import transport.Logistics;
import transport.RoadLogistics;
import transport.SeaLogistics;
import ui.GUIFactory;
import ui.MacOSFactory;
import ui.WindowsFactory;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Error: missing input. Usage: Main <ROAD|SEA> <WINDOWS|MACOS>");
            return;
        }

        String mode     = args[0].trim().toUpperCase();
        String platform = args[1].trim().toUpperCase();

        Logistics logistics;
        if (mode.equals("ROAD")) {
            logistics = new RoadLogistics();
        } else if (mode.equals("SEA")) {
            logistics = new SeaLogistics();
        } else {
            System.out.println("Error: unsupported delivery mode: " + mode);
            return;
        }

        GUIFactory guiFactory;
        if (platform.equals("WINDOWS")) {
            guiFactory = new WindowsFactory();
        } else if (platform.equals("MACOS")) {
            guiFactory = new MacOSFactory();
        } else {
            System.out.println("Error: unsupported platform: " + platform);
            return;
        }

        System.out.println("Delivery mode: " + mode + " UI platform: " + platform);

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run("laboratory equipment", "Aktau warehouse");
    }
}