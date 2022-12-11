public class Main2 {
    public static void main( String[] args ) {
        Character c = new ChuckGreene(Color.RED);
        GraphicMultiPlatform g = new GraphicMultiPlatform(c);

        //Pour afficher la version PC, il faut faire ces étapes
//        g.load3DMeshesOntoGpu();
//        g.load32BitsTextures();
//        g.load3DEnvironments();
//        g.loadSurroundSound();
//        g.checkOnlineUpdates();
//        g.checkGameIsOriginal();

        //Pour afficher la version IPhone, il faut faire ces étapes
//        g.load3DMeshesOntoCpu();
//        g.load16BitsTextures();
//        g.load3DEnvironments();
//        g.loadSound();
//        g.checkOnlineUpdates();
//        g.checkGameIsOriginal();

        //Pour afficher la version Gameboy, il faut faire ces étapes
//        g.load2DSprite();
//        g.loadBWTextures();
//        g.load2DEnvironments();
//        g.loadSound();
//        g.checkGameIsOriginal();

        //Si l'on essaye d'afficher tout de suite, sans
        //faire les étapes précédentes, on a une erreur
        g.display();
    }
}