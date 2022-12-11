package code.state;

import code.Character;

public abstract class State {
    private Character _c;
    public abstract State request();

    public State(Character _c) {
        this._c = _c;
    }

    public State() {
    }

    public Character getChar() {
        return _c;
    }
    public void displayChar() {
        _c.getImage().display();
    }
    public void setCharacter( Character c ) {
        _c = c;
    }
}
