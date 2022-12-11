public class Knife {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;

    public Knife() {
        _image = new MyImage("img/knife.png");
        _xShift = -32;
        _yShift = -37;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getRightHand()[0] + _xShift, c.getRightHand()[1] + _yShift);
        return image;
    }
}
