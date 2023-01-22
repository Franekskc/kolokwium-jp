package pakiet;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    final MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public MainFrame() {
        setTitle("Animacja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int ww = 700, wh = 800;
        setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        int amplitude1 = 80;
        int amplitude2 = 50;
        int frequency1 = 100;
        int frequency2 = 100;



        SquareWavePanel squareWavePanel = new SquareWavePanel(amplitude1,frequency1);
        squareWavePanel.setBounds(50, 30, 600, 200);
        squareWavePanel.setBackground(Color.BLACK);
        contentPane.add(squareWavePanel);

        SquareWavePanel secondPanel = new SquareWavePanel(amplitude2,frequency2);
        secondPanel.setBounds(50, 280, 600, 200);
        secondPanel.setBackground(Color.BLACK);
        contentPane.add(secondPanel);

        SquareWavePanel thirdPanel = new SquareWavePanel(amplitude1+amplitude2,(frequency1+frequency2)/2);
        thirdPanel.setBounds(50, 530, 600, 200);
        thirdPanel.setBackground(Color.BLACK);
        contentPane.add(thirdPanel);



    }
}