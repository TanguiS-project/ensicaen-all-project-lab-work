package code;

public class Main3 {
    public static void main( String[] args ) {
        Character c = new Sabre(new Mask(new Knife(new Sabre(new Club(new ChuckGreene(Color.YELLOW))))));
        c.getImage().display();
    }
}