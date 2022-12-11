package code.fabrique;

public class ConcretFactory implements Factory {
    @Override
    public Device createDevice(DEVICE d) {
        switch (d) {
            case PC -> {
                return new DevicePC();
            }
            case IPHONE -> {
                return new DeviceIphone();
            }
            default -> {
                return new DeviceGameBoy();
            }
        }
    }
}
