package pakiet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    SquareWavePanel panel;
    public TimerListener(SquareWavePanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.myImageX += panel.deltaX;
        if (panel.myImageX >= 0) {
            panel.myImageX = panel.startingMyImageX;
        }
        panel.repaint();
    }

}
