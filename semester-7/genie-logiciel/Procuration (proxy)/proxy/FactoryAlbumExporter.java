public class FactoryAlbumExporter {
    private FactoryAlbumExporter() {
    }

    public static AlbumExporter getAlbumExporter( GreatArtist artist ) {
        return new AlbumViewer(artist);
    }
}
