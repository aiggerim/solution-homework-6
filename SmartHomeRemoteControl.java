class SmartHomeRemoteControl {
    private java.util.Map<String, Command> slots = new java.util.HashMap<>();
    private java.util.Deque<Command> undoStack = new java.util.ArrayDeque<>();
    private java.util.Deque<Command> redoStack = new java.util.ArrayDeque<>();

    public void setCommand(String slot, Command command) {
        slots.put(slot, command);
    }

    public void pressButton(String slot) {
        Command command = slots.get(slot);
        if (command != null) {
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        }
    }

    public void undoButton() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redoButton() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}