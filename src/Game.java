import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Game extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 550;
    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);

    private Panel panel;

    public Game() {
        setSize(SCREEN_SIZE);
        setTitle("Pong");
        setBackground(Color.darkGray);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new Panel(this);
        add(panel);
        setVisible(true);
    }

    public Panel getPanel() {
        return panel;
    }

    public static void main(String[] args)  {
        Game game = new Game();
    }
}
