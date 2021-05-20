package sebedo.window;

import sebedo.image.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Loads the PaintPanel on the JFrame.
 * @see PaintPanel
 */
public class PaintFrame extends JFrame implements ImageLoader {
    public static int width, height;
    private final String title;

    private static PaintFrame paintFrame;

    private PaintFrame() {
        width = 800;
        height = 600;
        this.title = "Sebedo Graphics Engine";
        this.setJMenuBar(PaintPanel.menuBar);

        this.init();
        this.setVisible(true);

        System.out.println("Welcome to Sebedo Graphics Engine.");
    }

    public static PaintFrame get() {
        if (paintFrame == null) {
            paintFrame = new PaintFrame();
        }

        return paintFrame;
    }

    public void init() {
        add(PaintPanel.get());
        pack();

        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(loadImage("src/main/resources/images/cookie.png"));

        PaintPanel.get().requestFocusInWindow();
    }
}
