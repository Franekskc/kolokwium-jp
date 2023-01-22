package pakiet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareWavePanel extends JPanel {
    private final int prefW = 5000;
    private final int prefH = 400;
    public final int deltaX = 5;
    public final int startingMyImageX = -prefW;
    private final BufferedImage myImage;
    int amplitude;
    int frequency;
    public int myImageX = startingMyImageX;

    public SquareWavePanel(int amplitude,int frequency) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        setBackground(Color.BLACK);
        myImage = new BufferedImage(2 * prefW, prefH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = myImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int a = prefW;
        for (int i = 0; i < 100; i++) {

            g2.drawLine(a,150,a-frequency,150);
            g2.drawLine(a-frequency,150,a-frequency,150-amplitude);
            g2.drawLine(a-frequency,150-amplitude,a-2*frequency,150-amplitude);
            g2.drawLine(a-2*frequency,150-amplitude,a-2*frequency,150);
            a = a-2*frequency;
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




