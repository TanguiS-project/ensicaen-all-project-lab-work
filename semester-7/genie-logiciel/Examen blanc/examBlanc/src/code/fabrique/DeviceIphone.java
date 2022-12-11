package code.fabrique;

import code.Character;
import code.GraphicMultiPlatform;

public class DeviceIphone implements Device {
    @Override
    public GraphicMultiPlatform getGraphicForDevice(Character c) {
        GraphicMultiPlatform g = new GraphicMultiPlatform(c);
        g.load3DMeshesOntoCpu();
        g.load16BitsTextures();
        g.load3DEnvironments();
        g.loadSound();
        g.checkOnLineUpdates();
        g.checkGameIsOriginal();
        return g;
    }
}
