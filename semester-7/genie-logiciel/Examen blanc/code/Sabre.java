public class Sabre {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;

    public Sabre() {
        _image = new MyImage("img/sabre.png");
        _xShift = -189;
        _yShift = -90;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getLeftHand()[0] + _xShift, c.getLeftHand()[1] + _yShift);
        return image;
    }
}
