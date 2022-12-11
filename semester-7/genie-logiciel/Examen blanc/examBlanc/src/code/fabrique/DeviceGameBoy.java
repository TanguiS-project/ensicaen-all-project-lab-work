package code.fabrique;

import code.Character;
import code.GraphicMultiPlatform;

public class DeviceGameBoy implements Device {
    @Override
    public GraphicMultiPlatform getGraphicForDevice(Character c) {
        GraphicMultiPlatform g = new GraphicMultiPlatform(c);
        g.load2DSprite();
        g.loadBWTextures();
        g.load2DEnvironments();
        g.loadSound();
        g.checkGameIsOriginal();
        return g;
    }
}
