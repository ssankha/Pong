import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayerBall {

    public static final int BALL_DIAMETER = (int) (Game.WIDTH / 30.0);

    private Game game;
    private int x;
    private int y;
    private ArrayList<Bullet> bullets;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public PlayerBall(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        bullets = new ArrayList<Bullet>();
    }

    public void update() {

    }

    public void paint(Graphics g) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }



}
