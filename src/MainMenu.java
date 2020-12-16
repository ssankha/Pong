import java.awt.*;

public class MainMenu {

    private Game game;

    private int titleX = Game.WIDTH/2 - (700/2);
    private int titleY = Game.HEIGHT / 4;

    private int playX;
    private int playY;

    private int quitX;
    private int quitY;

    public MainMenu(Game game) {
        this.game = game;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,150));
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setStroke(new BasicStroke(10));
        g2.drawString("< PONG >", titleX, titleY);

        System.out.println( g2.getFontMetrics().stringWidth("< PONG >"));
    }
}
