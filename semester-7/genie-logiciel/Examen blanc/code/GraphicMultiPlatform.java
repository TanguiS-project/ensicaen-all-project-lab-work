public class GraphicMultiPlatform {
    private final Character _character;
    private final boolean[] _doneOperations;

    public GraphicMultiPlatform( Character a ) {
        _character = a;
        _doneOperations = new boolean[12];
    }

    public void load3DMeshesOntoGpu() {
        _doneOperations[0] = true;
    }

    public void load3DMeshesOntoCpu() {
        _doneOperations[1] = true;
        _character.getImage().pixelate(2);
    }

    public void load2DSprite() {
        _doneOperations[2] = true;
        _character.getImage().pixelate(8);
    }

    public void load32BitsTextures() {
        _doneOperations[3] = true;
    }

    public void load16BitsTextures() {
        _doneOperations[4] = true;
        _character.getImage().fourBitsColor();
    }

    public void loadBWTextures() {
        _doneOperations[5] = true;
        _character.getImage().blackAndWhite();
    }

    public void load3DEnvironments() {
        _doneOperations[6] = true;
    }

    public void load2DEnvironments() {
        _doneOperations[7] = true;
    }

    public void loadSound() {
        _doneOperations[8] = true;
    }

    public void loadSurroundSound() {
        _doneOperations[9] = true;
    }

    public void checkOnLineUpdates() {
        _doneOperations[10] = true;
    }

    public void checkGameIsOriginal() {
        _doneOperations[11] = true;
    }

    public void display() {
        if (_doneOperations[0] && !_doneOperations[1] && !_doneOperations[2] && _doneOperations[3] &&
                !_doneOperations[4] && !_doneOperations[5] && _doneOperations[6] && !_doneOperations[7] &&
                !_doneOperations[8] && _doneOperations[9] && _doneOperations[10] && _doneOperations[11]) {
            _character.getImage().display();
            System.out.println("Load PC graphics ok");
        } else if (!_doneOperations[0] && _doneOperations[1] && !_doneOperations[2] && !_doneOperations[3] &&
                _doneOperations[4] && !_doneOperations[5] && _doneOperations[6] && !_doneOperations[7] &&
                _doneOperations[8] && !_doneOperations[9] && _doneOperations[10] && _doneOperations[11]) {
            _character.getImage().display();
            System.out.println("Load IPhone graphics ok");
        } else if (!_doneOperations[0] && !_doneOperations[1] && _doneOperations[2] && !_doneOperations[3] &&
                !_doneOperations[4] && _doneOperations[5] && !_doneOperations[6] && _doneOperations[7] &&
                _doneOperations[8] && !_doneOperations[9] && !_doneOperations[10] && _doneOperations[11]) {
            _character.getImage().display();
            System.out.println("Load Gameboy graphics ok");
        } else {
            MyImage err = new MyImage("img/error.jpg");
            err.display();
            System.out.println("Error loading graphics");
        }
    }
}
