import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class Painter {
    protected JPanel panel;
    protected HashSet<Ant> ants;
    protected boolean[][] state;
    private boolean firstTime = true;
    protected Graphics oldg;

    public Painter() {
        ants = new HashSet<Ant>();
        state = new boolean[0][0];
        firstTime = true;

    }

    public void drawStuff(Graphics g) {
        if (oldg == null) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

            g.setColor(Color.GREEN);
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[0].length; j++) {
                    if (state[i][j]) {

                        g.fillRect(i, j, 1, 1);

                    }
                }
            }

            g.setColor(Color.RED);
            for (Ant ant : ants) {
                g.fillRect(ant.top, ant.left, 1, 1);
            }

        }
        else {

            g = oldg.create();
            for (Ant ant : ants) {
                if (state[ant.prevTop][ant.prevLeft]) {
                    g.setColor(Color.GREEN);
                }
                else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(ant.prevTop,ant.prevLeft,1,1);

                g.setColor(Color.RED);
                g.fillRect(ant.top, ant.left, 1, 1);
            }

        }
        oldg = g.create();
    }



    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void drawModel(HashSet<Ant> ants, boolean[][] state) {
        this.ants = ants;
        this.state = state;

        panel.repaint();
    }

}
