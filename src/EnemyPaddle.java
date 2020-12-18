import java.awt.*;
import java.util.ArrayList;

public class EnemyPaddle implements Entity {

    public static final int PADDLE_WIDTH = (int) (Game.WIDTH / 20.0);
    public static final int PADDLE_HEIGHT = (int) (Game.WIDTH / 7.0);
    public static final int MAX_Y = 370; // 370
    public static final int MAX_X = Game.WIDTH - PADDLE_WIDTH;

    private Game game;
    private int x;
    private int y;
    private int vX;
    private int vY;
    private Handler handler;
    private int shootTimer;

    public EnemyPaddle(Game game, Handler handler, int x, int y, int vX, int vY) {
        this.game = game;
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        shootTimer = 0;
    }

    public void update() {
        if (vX == 0) {

            if (y >= 0 && y <= MAX_Y) {
                y += vY;
            } else if (y > MAX_Y) {
                y = MAX_Y;
                vY *= -1;
            } else if (y < 0) {
                y = 0;
                vY *= -1;
            }
        } else {
            if (x >= 0 && x <= MAX_X) {
                x += vX;
            } else if (x > MAX_X) {
                x = MAX_X;
                vX *= -1;
            } else if (x < 0) {
                x = 0;
                vX *= -1;
            }
        }

    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);

        shootTimer++;

        if(shootTimer >= 200) {
            shoot();
            shootTimer -= 200;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVY(int vY) {
        this.vY = vY;
    }

    public void shoot() {
        if(vX == 0) {
            synchronized (new Object()) {
                handler.add(new Bullet(game, handler, x, y + PADDLE_HEIGHT / 2, 8, 0, 2));
            }
        }
        else {
            handler.add(new Bullet(game, handler, x + PADDLE_WIDTH / 2, y, 0, 8, 2));
        }
    }
}



