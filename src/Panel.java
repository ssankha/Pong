import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {

    private Game game;
    private HumanPaddle hp;
    private AIPaddle ai;
    private Ball ball;
    private Score score;
    private MainMenu mainMenu;
    private Fade fade;


    public static String status;


    public Panel(Game game) {
        this.game = game;
        setBackground(Color.darkGray);

        ball = new Ball(this.game);
        hp = new HumanPaddle(this.game);
        ai = new AIPaddle(this.game, ball);
        score = new Score(game);
        mainMenu = new MainMenu(game);
        fade = new Fade(game);

        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);

        status = "MAIN MENU";
    }

    public void update() {

        if(status.equals("GAME")) {
            ai.update();
            hp.update();
            ball.update();
        }
    }

    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        if(status.equals("FADE")) {
            fade.paint(g);
        }

        if(status.equals("MAIN MENU")) {
            mainMenu.paint(g);
        }
        else if(status.equals("GAME")) {
            score.paint(g);
            ball.paint(g);
            hp.paint(g);
            ai.paint(g);
        }
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
    public void mouseMoved(MouseEvent mouseEvent) {
        mainMenu.mouseMoved(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        mainMenu.mousePressed(mouseEvent);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) { }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) { }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }

    @Override
    public void mouseExited(MouseEvent mouseEvent) { }
}
