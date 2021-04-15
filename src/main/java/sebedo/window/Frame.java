package sebedo.window;

import sebedo.image.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Loads the PaintPanel on the JFrame.
 * @see PaintPanel
 */
public class Frame extends JFrame implements ImageLoader, Runnable {
    private final int width, height;
    private final String title;

    private static Frame frame;

    private static double dt;

    private Frame() {
        this.width = 800;
        this.height = 400;
        this.title = "Sebedo Graphics Engine";

        this.init();
        this.setVisible(true);

        System.out.println("Welcome to Sebedo Graphics Engine.");
    }

    public static Frame get() {
        if (frame == null) {
            frame = new Frame();
        }

        return frame;
    }

    public void init() {
        add(PaintPanel.get());
        pack();

        setTitle(title);
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setBackground(new Color(0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(loadImage("src/main/resources/images/cookie.png"));
    }

    public void run() {
        PaintPanel.get().requestFocusInWindow();

        while (this.isEnabled()) {
            try {
                Thread.sleep(0, 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            PaintPanel.get().update();
        }
    }
}
