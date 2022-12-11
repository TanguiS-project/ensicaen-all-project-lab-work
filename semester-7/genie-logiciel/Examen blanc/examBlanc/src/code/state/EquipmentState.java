package code.state;

import code.Character;
import code.Club;
import code.Knife;
import code.Mask;
import code.Sabre;

import java.util.Scanner;

public class EquipmentState extends State {
    public EquipmentState(Character _c) {
        super(_c);
    }

    public EquipmentState() {
    }

    @Override
    public State request() {
        System.out.println(this);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> {
                setCharacter(new Mask(getChar()));
            }
            case 2 -> setCharacter(new Knife(getChar()));
            case 3 -> setCharacter(new Sabre(getChar()));
            case 4 -> setCharacter(new Club(getChar()));
            case 5 -> {
                if ( getChar() != null ) {
                    displayChar();
                } else {
                    System.out.println("issou_3");
                    return new EquipmentState();
                }
            }
            default -> {
                return new CreateCharacter(getChar());
            }
        }
        return new EquipmentState(getChar());
    }
    @Override
    public String toString() {
        return "  1: put mask\n  2: put knife\n  3: put sabre\n  4: put club\n  5: display char\n  q: quit";
    }
}
