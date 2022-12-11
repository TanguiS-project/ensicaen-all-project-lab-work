package code;

import code.decorator.Decorator;

public class Knife extends Decorator {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;
    private Character _c;

    public Knife(Character c) {
        super(c);
        _image = new MyImage("src/code/img/knife.png");
        _xShift = -32;
        _yShift = -37;
        _c = c;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getRightHand()[0] + _xShift, c.getRightHand()[1] + _yShift);
        return image;
    }

    @Override
    public MyImage getImage() {
        return paintOnCharacter(_c);
    }
}
