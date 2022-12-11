public class Main3 {
    public static void main( String[] args ) {
        Knife k = new Knife();
        MyImage image = k.paintOnCharacter(new ChuckGreene(Color.YELLOW));
        image.display();
    }
}