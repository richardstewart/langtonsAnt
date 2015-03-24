import java.util.HashSet;
import java.util.Random;

public class Model {

    protected Painter painter;
    protected int height, width;
    protected boolean[][] state;
    protected HashSet<Ant> ants;

    public Model(Painter painter, int height, int width) {

        this.painter = painter;
        this.height = height;
        this.width = width;
        state = new boolean[height][width];
        ants = new HashSet<Ant>();
        Random rng = new Random();
        for (int i=0; i<100000; i++) {
            ants.add(new Ant(rng.nextInt(width-1),rng.nextInt(height-1),rng.nextInt(4)));
        }

    }

    public void iterate() {
        for (Ant ant : ants) {
            ant.iterateAnt(state);
        }
        painter.drawModel(ants, state);

    }



}
