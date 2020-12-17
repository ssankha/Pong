import java.awt.*;

public class Fade {

    private Game game;
    private float alpha = 0.0f;
    private boolean isDark = false;

    public Fade(Game game) {
        this.game = game;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        //set the opacity
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);


        //do the drawing here
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);


        //increase the opacity and repaint
        if(!isDark) {
            alpha += 0.3f;
        }
        if (alpha >= 1.0f && !isDark) {
            alpha = 1.0f;
            isDark = true;
        } else if(isDark) {
            if(alpha > 0.1f) {
                alpha -= 0.1f;
            }
            else {
                alpha = 0.0f;
                Panel.status = "PONG";
            }

        }

        //sleep for a bit
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
