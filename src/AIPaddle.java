import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class AIPaddle {

    public static final int PADDLE_WIDTH = (int) (Game.WIDTH / 20.0);
    public static final int PADDLE_HEIGHT = (int) (Game.WIDTH / 7.0);
    public static final int MAX_Y = 370;
    public static final int PIXEL_RANGE = PADDLE_HEIGHT/3;


    private Game game;
    private Ball ball;
    private int x;
    private int y;
    private int vY;
    public static int score;
    private int offset = 20;

    public AIPaddle(Game game, Ball ball) {
        this.game = game;
        this.ball = ball;

        x = 937 - offset;
        y = (Game.HEIGHT / 2) - (PADDLE_HEIGHT / 2);
        vY = 6;
        score = 0;
    }

    public void update() {
        if(y >= 0 && y <= MAX_Y) {
            if(ball.getY() +  PIXEL_RANGE > y + PADDLE_HEIGHT/2 || ball.getY() - PIXEL_RANGE > y + PADDLE_HEIGHT/2) {
                vY = Math.abs(vY);
            }
            else if(ball.getY() + PIXEL_RANGE < y + PADDLE_HEIGHT/2 || ball.getY() - PIXEL_RANGE < y + PADDLE_HEIGHT/2){
                vY = Math.abs(vY) * -1;
            }

            y += vY;
        }
        else if(y < 0) {
            y = 0;
        }
        else if(y > MAX_Y) {
            y = MAX_Y;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);
    }

    public int getX() {
        return x;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

}
