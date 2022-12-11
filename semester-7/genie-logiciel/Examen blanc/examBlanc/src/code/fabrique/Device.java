package code.fabrique;

import code.Character;
import code.GraphicMultiPlatform;

public interface Device {
    GraphicMultiPlatform getGraphicForDevice(Character c);
}
