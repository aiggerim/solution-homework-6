class SmartHomeRemoteControl {
    private java.util.Map<String, Command> slots = new java.util.HashMap<>();
    private Command lastCommand;

    public void setCommand(String slot, Command command) {
        slots.put(slot, command);
    }

    public void pressButton(String slot) {
        Command command = slots.get(slot);
        if (command != null) {
            command.execute();
            lastCommand = command;
        }
    }

    public void undoButton() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}