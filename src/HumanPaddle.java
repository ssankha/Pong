import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class HumanPaddle {

    public static final int PADDLE_WIDTH = (int) (Game.WIDTH / 20.0);
    public static final int PADDLE_HEIGHT = (int) (Game.WIDTH / 7.0);
    public static final int MAX_Y = 370; // 370

    private Game game;
    private int x;
    private int y;
    private int vY;
    public static int score;
    private int offset = 20;

    public HumanPaddle(Game game) {
        this.game = game;

        x = offset;
        y = (Game.HEIGHT / 2) - (PADDLE_HEIGHT / 2);
        vY = 0;
        score = 0;
    }

    public void update() {
        if(y >= 0 && y <= MAX_Y) {
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
        g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);

//        try {
//            BufferedImage image = ImageIO.read(new FileInputStream("police_officer.png"));
//            g.drawImage(image, x, y, PADDLE_WIDTH, PADDLE_HEIGHT, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            vY = -6;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            vY = 6;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            vY = 0;
        }
    }

    public int getX() {
        return x;
    }

}
