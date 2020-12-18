
import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private Game game;
    private LinkedList<Entity> entities;

    public Handler(Game game) {
        this.game = game;
        entities = new LinkedList<Entity>();
    }

    public LinkedList<Entity> getEntities() {
        return entities;
    }

    public void add(Entity e) {
        entities.add(e);
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public void paint(Graphics g) {
        for (Entity e : entities) {
            e.paint(g);
        }

    }

    public void remove(Entity e) {
        entities.remove(e);
    }
}
