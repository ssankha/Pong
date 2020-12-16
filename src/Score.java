import java.awt.*;

public class Score {

    private int leftX;
    private int rightX;
    private int y;
    private Game game;

    public Score(Game game) {
        this.game = game;

        leftX = (int) (Game.WIDTH/4.0);
        rightX = (int) (3*Game.WIDTH/4.0);
        y = Game.HEIGHT / 10;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,60));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));


        g.drawLine(Game.WIDTH/2, 0, Game.WIDTH/2, Game.HEIGHT);

        int radius = 100;
        g.drawOval(Game.WIDTH/2 - radius, Game.HEIGHT/2 - radius, 2*radius, 2*radius);

        g.drawString(HumanPaddle.score + "", leftX, y);
        g.drawString(AIPaddle.score + "", rightX, y);
    }
}
