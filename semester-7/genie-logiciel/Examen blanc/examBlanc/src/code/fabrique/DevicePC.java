package code.fabrique;

import code.Character;
import code.GraphicMultiPlatform;

public class DevicePC implements Device {
    @Override
    public GraphicMultiPlatform getGraphicForDevice(Character c) {
        GraphicMultiPlatform g = new GraphicMultiPlatform(c);
        g.load3DMeshesOntoGpu();
        g.load32BitsTextures();
        g.load3DEnvironments();
        g.loadSurroundSound();
        g.checkOnLineUpdates();
        g.checkGameIsOriginal();
        return g;
    }
}
