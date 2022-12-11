package code;

import code.fabrique.ConcretFactory;
import code.fabrique.DEVICE;

public class Main2 {
    public static void main( String[] args ) {
        Character c = new ChuckGreene(Color.RED);
        ConcretFactory cf = new ConcretFactory();
        GraphicMultiPlatform g = cf.createDevice(DEVICE.PC).getGraphicForDevice(c);
        g.display();
        g = cf.createDevice(DEVICE.GAMEBOY).getGraphicForDevice(c);
        g.display();
    }
}