public class Club {
    private final MyImage _image;
    private final int _xShift;
    private final int _yShift;

    public Club() {
        _image = new MyImage("img/golf.png");
        _xShift = -174;
        _yShift = -145;
    }

    public MyImage paintOnCharacter( Character c ) {
        MyImage image = c.getImage();
        image.paintOver(_image, c.getLeftHand()[0] + _xShift, c.getLeftHand()[1] + _yShift);
        return image;
    }
}
