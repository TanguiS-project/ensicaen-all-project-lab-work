public class Player extends Thread {
    @Override
    public void run() {
        Server server = new Server();
        Character character = server.getNewCharacter();
        GraphicMultiPlatform g = new GraphicMultiPlatform(character);

        g.load3DMeshesOntoCpu();
        g.load16BitsTextures();
        g.load3DEnvironments();
        g.loadSound();
        g.checkOnLineUpdates();
        g.checkGameIsOriginal();
        g.display();
    }
}
