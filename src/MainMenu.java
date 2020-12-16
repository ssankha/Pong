import java.awt.*;

public class MainMenu {

    private Game game;

    private int titleX = Game.WIDTH/2 - (700/2);
    private int titleY = Game.HEIGHT / 4;

    private int playX = Game.WIDTH / 2 - (219 / 2);
    private int playY = Game.HEIGHT / 2;

    private int quitX = playX;
    private int quitY = playY + 100;

    public MainMenu(Game game) {
        this.game = game;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,150));
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setStroke(new BasicStroke(10));

        g2.drawString("< PONG >", titleX, titleY);

        g.setFont(new Font("Arial",Font.BOLD,50));

        g2.drawString("< PLAY >", playX, playY);
        g2.drawString("< QUIT >", quitX, quitY);
    }
}
