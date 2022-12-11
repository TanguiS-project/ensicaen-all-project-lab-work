package code.decorator;

import code.Character;
import code.MyImage;

public abstract class Decorator implements Character {
    private Character _component;

    public Decorator(Character component) {
        this._component = component;
    }

    @Override
    public MyImage getImage() {
        return _component.getImage();
    }

    @Override
    public int[] getRightHand() {
        return _component.getRightHand();
    }

    @Override
    public int[] getLeftHand() {
        return _component.getLeftHand();
    }

    @Override
    public int[] getHead() {
        return _component.getHead();
    }

    @Override
    public int[] getTorso() {
        return _component.getTorso();
    }

}
