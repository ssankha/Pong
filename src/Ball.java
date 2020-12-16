

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;


public class Ball {

    public static final int BALL_DIAMETER = (int) (Game.WIDTH / 30.0);

    private Game game;
    private int x;
    private int y;
    private double vX;
    private double vY;

    public Ball(Game game) {
        this.game = game;
        x = Game.WIDTH / 2;
        y = Game.HEIGHT / 2;
        vX = 4;
        vY = 4;
    }

    public void update() {
        x += vX;
        y += vY;

        if (x < 0 - BALL_DIAMETER) {
            resetBall();
            AIPaddle.score++;
        } else if (x > Game.WIDTH) {
            resetBall();
            HumanPaddle.score++;
        }

        if (y < 0 || y > Game.HEIGHT - BALL_DIAMETER * 2) {
            vY = -vY;
        }

        checkCollision();
    }

    public void resetBall() {
        x = Game.WIDTH / 2;
        vX = -vX;

        if (vX < 0) {
            vX = -4;
        } else {
            vX = 4;
        }

        if (vY < 0) {
            vY = -4;
        } else {
            vY = 4;
        }


    }


    public void checkCollision() {
        HumanPaddle hp = game.getPanel().getHumanPaddle();
        AIPaddle ai = game.getPanel().getAIPaddle();

        if (hp.getBounds().intersects(getBounds()) || ai.getBounds().intersects(getBounds())) {

            if (hp.getX() > x) {
                x -= 50;
            }

            if (ai.getX() < x) {
                x += 50;
            }

            vX = -vX;


            if (vX < 0 && vX > -12) {
                vX -= 1;
            }

            if (vY < 0 && vY < -12) {
                vY -= 1;
            }

            if (vX > 0 && vX < 12) {
                vX += 1;
            }

            if (vY > 0 && vY < 12) {
                vY += 1;
            }

        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }

    public int getY() {
        return y;
    }
}
