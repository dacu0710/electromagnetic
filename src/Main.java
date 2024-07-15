import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("E");
        Canvas canvas = new Canvas();
        frame.add(canvas);
        frame.setSize(canvas.getSize());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}