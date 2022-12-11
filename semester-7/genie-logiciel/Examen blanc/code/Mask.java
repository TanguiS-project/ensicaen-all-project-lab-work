public class Mask {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;

    public Mask() {
        _image = new MyImage("img/mask.png");
        _xShift = -40;
        _yShift = -48;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getHead()[0] + _xShift, c.getHead()[1] + _yShift);
        return image;
    }
}
