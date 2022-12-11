package code;


import code.state.Menu;

public class Main4 {
    public static void main( String[] args ) {
        Menu menu = new Menu();
        while (true) {
            menu.execute();
        }
    }
}
