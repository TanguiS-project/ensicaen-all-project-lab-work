public class AlbumViewer extends Thread implements AlbumExporter {
    private final GreatArtist _artist;
    private MyImage _image;

    public AlbumViewer( GreatArtist artists ) {
        _artist = artists;
    }

    public void buildImage() {
        try {
            Thread.sleep(5000);
            _image = new MyImage(_artist.getPath());
        } catch (Exception ignored) {
            // Nothing to do
        }
    }

    @Override
    public void displayAlbum() {
        start();
    }

    public MyImage getImage() {
        return _image;
    }

    @Override
    public void run() {
        buildImage();
        _image.display();
    }
}
