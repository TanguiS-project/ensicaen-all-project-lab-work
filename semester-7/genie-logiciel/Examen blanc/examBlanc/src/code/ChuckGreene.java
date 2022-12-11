package code;

public class ChuckGreene implements Character {
    private final int[] _rightHand = {73, 249};
    private final int[] _leftHand = {178, 266};
    private final int[] _head = {130, 76};
    private final int[] _torso = {130, 165};

    private MyImage myImage;

    public ChuckGreene( Color c ) {
        switch (c) {
            case RED -> myImage = new MyImage(SystemValues.PROJECT_PATH + "img/chuck_red.png");
            case YELLOW -> myImage = new MyImage(SystemValues.PROJECT_PATH + "img/chuck_yellow.png");
            case BLUE -> myImage = new MyImage(SystemValues.PROJECT_PATH + "img/chuck_blue.png");
            case GREEN -> myImage = new MyImage(SystemValues.PROJECT_PATH + "img/chuck_green.png");
        }
    }

    public MyImage getImage() {
        return myImage;
    }

    public int[] getRightHand() {
        return _rightHand;
    }

    public int[] getLeftHand() {
        return _leftHand;
    }

    public int[] getHead() {
        return _head;
    }

    public int[] getTorso() {
        return _torso;
    }

}
