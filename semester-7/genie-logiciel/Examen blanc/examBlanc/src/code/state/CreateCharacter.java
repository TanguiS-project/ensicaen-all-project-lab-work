package code.state;

import code.Character;

import java.util.Scanner;

public class CreateCharacter extends State {
    public CreateCharacter(Character aChar) {
        super(aChar);
    }

    public CreateCharacter() {
    }

    @Override
    public State request() {
        System.out.println(this);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> {
                return new ColorState();
            }
            case 2 -> {
                if ( getChar() != null ) {
                    displayChar();
                } else {
                    System.out.println("issou");
                }
            }
        }
        return new CreateCharacter();

    }

    @Override
    public String toString() {
        return "  1: create character\n  2: display char\n  q: quit";
    }


}
