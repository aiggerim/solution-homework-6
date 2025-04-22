class Thermostat {
    private int currentTemp = 20;
    private int prevTemp = 20;

    public void setTemperature(int temp) {
        prevTemp = currentTemp;
        currentTemp = prevTemp;
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
    }

    public void revertTemperature() {
        System.out.println("[Thermostat] Reverting to previous temperature " + prevTemp + "°C");
        int temp = currentTemp;
        currentTemp = prevTemp;
        prevTemp = temp;
    }
}


