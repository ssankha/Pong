import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener, ActionListener {

    private Game game;
    private HumanPaddle hp;
    private AIPaddle ai;
    private Ball ball;
    private Score score;
    

    public String status;


    public Panel(Game game) {
        this.game = game;
        setBackground(Color.darkGray);

        ball = new Ball(this.game);
        hp = new HumanPaddle(this.game);
        ai = new AIPaddle(this.game, ball);
        score = new Score(game);

        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        status = "MENU";
    }

    public void update() {
        ai.update();
        hp.update();
        ball.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        score.paint(g);
        ball.paint(g);
        hp.paint(g);
        ai.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent keyEvent) {
        hp.keyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        hp.keyReleased(keyEvent);
    }

    public HumanPaddle getHumanPaddle() {
        return hp;
    }

    public AIPaddle getAIPaddle() {
        return ai;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }
}
