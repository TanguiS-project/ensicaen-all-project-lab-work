package code;

import code.decorator.Decorator;

public class Sabre extends Decorator {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;
    private Character _c;

    public Sabre(Character c) {
        super(c);
        _image = new MyImage("src/code/img/sabre.png");
        _xShift = -189;
        _yShift = -90;
        _c = c;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getLeftHand()[0] + _xShift, c.getLeftHand()[1] + _yShift);
        return image;
    }

    @Override
    public MyImage getImage() {
        return paintOnCharacter(_c);
    }
}
