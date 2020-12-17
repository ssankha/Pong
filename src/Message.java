import java.awt.*;


public class Message {

    private Game game;
    private int x;
    private int y;
    private String message;
    private int numTimesToRun;

    private int numTimesRan = 0;
    private boolean stopMessage = false;
    private boolean isDisplayed = true;

    public Message(Game game, int x, String message, int numTimesToRun) {
        this.game = game;
        this.x = x;
        this.message = message;
        this.numTimesToRun = numTimesToRun;
        y = Game.WIDTH / 12;
    }

    public void paint(Graphics g) {
        int offset = 50;
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(new Font("Arial",Font.BOLD, 20));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2.setStroke(new BasicStroke(5));

        g.setColor(Color.lightGray);
        g.fillRoundRect(x - offset, Game.WIDTH/8 - 2*offset, g2.getFontMetrics().stringWidth(message) + 2*offset, offset*2, 10, 10);

        g2.setStroke(new BasicStroke(8));
        g.setColor(Color.black);
        g2.drawRoundRect(x-offset, Game.WIDTH/8 - 2*offset, g2.getFontMetrics().stringWidth(message) + 2*offset, offset*2, 10, 10);
        g2.drawString(message, x, y);

        //System.out.println(g2.getFontMetrics().stringWidth("Use the mouse to shoot."));
        numTimesRan++;

       if(numTimesRan >= numTimesToRun) {
           stopMessage = true;
       }
    }

    public boolean getStopMessage() {
        return stopMessage;
    }

}
