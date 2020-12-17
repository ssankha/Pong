import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {


    public static String status; // controls what's on the screen

    // create Pong objects
    private Game game;
    private HumanPaddle hp;
    private AIPaddle ai;
    private Ball ball;
    private Score score;
    private MainMenu mainMenu;
    private Fade fade;

    // create Pong messages
    private Message welcome;
    private Message instructions;
    private Message goodLuck;

    // create real game messages




    public Panel(Game game) {
        this.game = game;
        setBackground(Color.darkGray);

        ball = new Ball(this.game);
        hp = new HumanPaddle(this.game);
        ai = new AIPaddle(this.game, ball);
        score = new Score(this.game);
        mainMenu = new MainMenu(this.game);
        fade = new Fade(this.game);

        welcome = new Message(this.game, Game.WIDTH / 2 - (176/2), "Welcome to Pong!", 300);
        instructions = new Message(this.game, Game.WIDTH / 2 - (406/2), "A player wins when their score reaches 6!", 300);
        goodLuck = new Message(this.game, Game.WIDTH / 2 - (106/2), "Good luck!", 200);

        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);

        status = "MAIN MENU";
    }

    public void update() {

        if(status.equals("GAME") && AIPaddle.score < 6 && HumanPaddle.score < 6 ) {
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

            if(!welcome.getStopMessage()) {
                welcome.paint(g);
            }
            else if(!instructions.getStopMessage()) {
                instructions.paint(g);
            }
            else if(!goodLuck.getStopMessage()){
                goodLuck.paint(g);
            }
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
