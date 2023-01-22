package pakiet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareWavePanel extends JPanel {
    private final int prefW = 400;
    private final int prefH = 200;
    public final int deltaX = 2;
    public final int startingMyImageX = -prefW;
    private BufferedImage myImage;
    public int myImageX = startingMyImageX;

    public SquareWavePanel() {
        int amplitude = 100;
        int frequency = 200;
        setBackground(Color.BLACK);
        myImage = new BufferedImage(2 * prefW, prefH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = myImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < 100; i++) {
            g2.drawLine(400,150,400-frequency,150);
            g2.drawLine(400-frequency,150,400-frequency,150-amplitude);
            g2.drawLine(400-frequency,150-amplitude,400-2*frequency,150-amplitude);
            g2.drawLine(400-2*frequency,150-amplitude,400-2*frequency,150);
        }
        g2.dispose();
        int timerDelay = 40;
        new Timer(timerDelay, new TimerListener(this)).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (myImage != null) {
            int myImageY = 0;
            g.drawImage(myImage, myImageX, myImageY, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }
}




