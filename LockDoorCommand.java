class LockDoorCommand implements Command {
    public void execute(){
        System.out.println("[Door] Locking the door");
    }

    public void undo(){
        System.out.println("[Door] Unlocking the door");
    }
}
