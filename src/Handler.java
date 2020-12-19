
import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private Game game;
    private LinkedList<Entity> entities;
    private LinkedList<Entity> toAdd;
    private LinkedList<Entity> toRemove;

    public Handler(Game game) {
        this.game = game;
        entities = new LinkedList<Entity>();
        toAdd = new LinkedList<Entity>();
        toRemove = new LinkedList<Entity>();
    }

    public LinkedList<Entity> getEntities() {
        return entities;
    }


    public void addToEntities(Entity e) {
        entities.add(e);
    }


    public void update() {
        entities.addAll(toAdd);
        entities.removeAll(toRemove);

        for (Entity e : entities) {
            e.update();
        }

    }

    public void paint(Graphics g) {
        entities.addAll(toAdd);
        entities.removeAll(toRemove);

        for (Entity e : entities) {
            e.paint(g);
        }

    }


    public void addToRemove(Entity e) {
        toRemove.add(e);
    }

    public LinkedList<Entity> getToRemove() {
        return toRemove;
    }

    public void addToAdd(Entity e) {
        toAdd.add(e);
    }

    public LinkedList<Entity> getToAdd() {
        return toAdd;
    }
}
