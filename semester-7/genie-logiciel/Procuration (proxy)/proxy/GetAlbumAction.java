import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class GetAlbumAction extends AbstractAction {
    private final MainWindow _window;

    public GetAlbumAction( MainWindow window, String text ) {
        super(text);
        _window = window;
    }

    public void actionPerformed( ActionEvent event ) {
        GreatArtist selected = (GreatArtist) _window.getComboBox().getSelectedItem();
        AlbumExporter exporter = FactoryAlbumExporter.getAlbumExporter(selected);
        exporter.displayAlbum();
    }
}