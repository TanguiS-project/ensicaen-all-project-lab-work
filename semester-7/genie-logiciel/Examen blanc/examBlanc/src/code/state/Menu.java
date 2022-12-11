package code.state;

public class Menu {
    private State _state = new CreateCharacter();

    public void execute() {
        _state = _state.request();
    }
}
