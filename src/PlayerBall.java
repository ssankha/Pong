import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayerBall implements Entity {

    public static final int BALL_DIAMETER = (int) (Game.WIDTH / 30.0);

    private Game game;
    private int x;
    private int y;
    private int vX;
    private int vY;
    private int health;
    private Handler handler;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public PlayerBall(Game game, Handler handler, int x, int y) {
        this.game = game;
        this.handler = handler;
        this.x = x;
        this.y = y;
        vX = 0;
        vY = 0;

        health = 100;
    }

    public void update() {

    }

    public void paint(Graphics g) {

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void mousePressed(MouseEvent e) {
        double bulletVelocity = 1.0; //however fast you want your bullet to travel
        //mouseX/Y = current x/y location of the mouse
        //originX/Y = x/y location of where the bullet is being shot from
        double angle = Math.atan2(e.getX() - x, e.getY() - y);
        double xVelocity = (bulletVelocity) * Math.cos(angle);
        double yVelocity = (bulletVelocity) * Math.sin(angle);

        handler.add(new Bullet(game, handler, x, y, xVelocity, yVelocity, 1));
    }



}
