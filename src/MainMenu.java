import java.awt.*;
import java.awt.event.MouseEvent;


public class MainMenu {

    private Game game;

    private int titleX = Game.WIDTH/2 - (700/2);
    private int titleY = Game.HEIGHT / 4;

    private int playX = Game.WIDTH / 2 - (219 / 2);
    private int playY = Game.HEIGHT / 2;
    private int enlargedPlayX = Game.WIDTH/2 - (308/2);

    private int quitX = playX;
    private int quitY = playY + 100;
    private int enlargedQuitX = enlargedPlayX;

    private boolean playHover = false;
    private boolean quitHover = false;

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
        

        if(!playHover) {
            g.setFont(new Font("Arial",Font.BOLD,50));
            g2.drawString("< PLAY >", playX, playY);
        }
        else {
            g.setFont(new Font("Arial",Font.BOLD,70));
            g2.drawString("< PLAY >", enlargedPlayX, playY);
        }

        if(!quitHover) {
            g.setFont(new Font("Arial",Font.BOLD,50));
            g2.drawString("< QUIT >", quitX, quitY);
        }
        else {
            g.setFont(new Font("Arial",Font.BOLD,70));
            g2.drawString("< QUIT >", enlargedQuitX, quitY);
        }

    }

    public void mouseMoved(MouseEvent e) {
        Rectangle playRect = new Rectangle(playX, playY - 58, 219, 58);
        Rectangle quitRect = new Rectangle(quitX, quitY - 58, 219, 58);

        if(playRect.contains(e.getX(), e.getY())) {
            playHover = true;
        }
        else {
            playHover = false;
        }

        if(quitRect.contains(e.getX(), e.getY())) {
            quitHover = true;
        }
        else {
            quitHover = false;
        }
    }

    public void mousePressed(MouseEvent e) {
        Rectangle playRect = new Rectangle(playX, playY - 58, 219, 58);
        Rectangle quitRect = new Rectangle(quitX, quitY - 58, 219, 58);

        if(playRect.contains(e.getX(), e.getY())) {
            Panel.status = "GAME";
        }

        if(quitRect.contains(e.getX(), e.getY())) {
            System.exit(0);
        }

    }
}
