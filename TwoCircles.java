import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;


class DrawOval extends JPanel{
    private int d = 300;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(5, 5, d, d);
        
    }
    
    public void setD(int newD) {
        d = (newD >= 0 ? newD : 0);
        repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}


class DrawOval1 extends JPanel{
    private int d = 1;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(5, 5, d, d);
        
    }
    
    public void setD(int newD) {
        d = (newD >= 0 ? newD : 0);
        repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}


class TheWindow extends JFrame{
    
    private JSlider slider;
    private JSlider slider1;
    private DrawOval myPanel;
    private DrawOval1 myPanel1;
    private JLabel l;

    public TheWindow() {
        super("Test 2: two sliders effect one circle");
        
        myPanel = new DrawOval();
        myPanel1 = new DrawOval1();
        myPanel.setBackground(Color.WHITE);
        myPanel1.setBackground(Color.WHITE);
        
        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 300, 150);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);

        l = new JLabel(String.valueOf(slider.getValue()));
        l.setBackground(Color.WHITE);

        slider.addChangeListener(
            new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                myPanel.setD(slider.getValue());
                myPanel1.setD(300 - slider.getValue());
                l.setText(String.valueOf(slider.getValue()));
            }
        }
        );
        add(slider, BorderLayout.NORTH);
        add(l,BorderLayout.EAST);
        add(myPanel, BorderLayout.CENTER);
        add(myPanel1, BorderLayout.SOUTH);
        
    }
    
}
public class TwoCircles{
    public static void main(String s[]){
        
        TheWindow w = new TheWindow();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows program to exit on close
        w.setSize(500,1000);
        w.setVisible(true);
    }
}

