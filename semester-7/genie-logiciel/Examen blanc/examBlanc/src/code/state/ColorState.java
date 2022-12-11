package code.state;

import code.Character;
import code.ChuckGreene;
import code.Color;

import java.util.Scanner;

public class ColorState extends State {
    public ColorState(Character _c) {
        super(_c);
    }

    public ColorState() {
    }

    @Override
    public State request() {
        System.out.println(this);
        Scanner scanner = new Scanner(System.in);
        Color _color = null;
        switch (scanner.nextInt()) {
            case 1 -> _color = Color.YELLOW;
            case 2 -> _color = Color.RED;
            case 3 -> _color = Color.GREEN;
            case 4 -> _color = Color.BLUE;
            case 5 -> {
                if ( getChar() != null ) {
                    displayChar();
                } else {
                    System.out.println("issou_2");
                    return new ColorState();
                }
            }
            default -> {
                return new CreateCharacter( getChar() );
            }
        }
        assert _color != null;
        setCharacter(new ChuckGreene(_color));
        return new EquipmentState(getChar());
    }

    @Override
    public String toString() {
            return "  1: Yellow\n  2: red\n  3: Green\n  4: Blue\n  5: display char\n  q: Quit";
    }
}
