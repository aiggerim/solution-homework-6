public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        Command lockDoor = new LockDoorCommand();

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light_on", new TurnOnLightCommand(light));
        remote.setCommand("set_temp", new SetThermostatCommand(thermostat, 22));

        java.util.List<Command> goodnightCommands = new java.util.ArrayList<>();
        goodnightCommands.add(new TurnOnLightCommand(light));
        goodnightCommands.add(lockDoor);
        remote.setCommand("goodnight", new MacroCommand(goodnightCommands));

        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        while (true) {
            System.out.println("\n=== Smart Home Menu ===");
            System.out.println("1. Turn ON light");
            System.out.println("2. Set temperature to 22°C");
            System.out.println("3. Activate Goodnight mode");
            System.out.println("4. Undo");
            System.out.println("5. Redo");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    remote.pressButton("light_on");
                    break;
                case 2:
                    remote.pressButton("set_temp");
                    break;
                case 3:
                    remote.pressButton("goodnight");
                    break;
                case 4:
                    remote.undoButton();
                    break;
                case 5:
                    remote.redoButton();
                    break;
                case 6:
                    System.out.println("Existing Smart Home...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}