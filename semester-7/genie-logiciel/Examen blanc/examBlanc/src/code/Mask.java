package code;

import code.decorator.Decorator;

public class Mask extends Decorator {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;
    private Character _c;

    public Mask(Character c) {
        super(c);
        _image = new MyImage("src/code/img/mask.png");
        _xShift = -40;
        _yShift = -48;
        _c = c;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getHead()[0] + _xShift, c.getHead()[1] + _yShift);
        return image;
    }

    @Override
    public MyImage getImage() {
        return paintOnCharacter(_c);
    }
}
