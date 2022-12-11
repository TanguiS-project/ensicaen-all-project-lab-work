package observer;


import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Observer {
    private final JLabel _label = new JLabel();
    private Clock _clock;
    private int _stateTime;

    public static void main( String[] args ) {
        Clock clock = new Clock();
        Window window = new Window(clock);
        clock.addObserver(window);
        clock.setNewState();
        window.setVisible(true);
    }

    public Window(Clock clock) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(200, 80);
        _clock = clock;
        Font police = new Font("DS-digital", Font.BOLD, 30);
        _label.setFont(police);
        _label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(_label, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        _label.setText(_clock.getTime());
    }
}
