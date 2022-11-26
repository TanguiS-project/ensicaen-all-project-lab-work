import javax.swing.*;
import java.awt.FlowLayout;

public class MainWindow extends JFrame {
    private JComboBox<GreatArtist> _comboBox;

    public MainWindow() {
        build();
    }

    private void build() {
        setTitle("Album Cover Generator");
        setSize(320, 140);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Album");
        panel.add(label);
        GreatArtist[] elements = new GreatArtist[]{GreatArtist.PATRICK, GreatArtist.CARLOS, GreatArtist.CINDY, GreatArtist.RENE};
        _comboBox = new JComboBox<>(elements);
        panel.add(_comboBox);
        JButton button = new JButton(new GetAlbumAction(this, "Télécharger la pochette"));
        panel.add(button);
        return panel;
    }

    public JComboBox<GreatArtist> getComboBox() {
        return _comboBox;
    }
}

