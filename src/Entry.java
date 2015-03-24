import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Entry {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(500, 500);


        frame.setExtendedState (frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);


        final Painter painter = new Painter();
        JPanel panel = new JPanel() { public void paintComponent(Graphics g) {painter.drawStuff(g);}};

        painter.setPanel(panel);
        frame.setContentPane(panel);

        final Model model = new Model(painter, frame.getWidth(), frame.getHeight());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() { public void run() {model.iterate();} },1,30);

    }

}

