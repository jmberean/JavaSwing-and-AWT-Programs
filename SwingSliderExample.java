import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;


class DrawOval extends JPanel{
    private int d = 100;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(40, 10, d, d);
        
    }
    
    public void setD(int newD) {
        d = (newD >= 100 ? newD : 100);
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
    private JLabel l;

    public TheWindow() {
        super("Test 2: two sliders effect one circle");
        
        myPanel = new DrawOval();
        myPanel.setBackground(Color.WHITE);
        
        slider = new JSlider(SwingConstants.HORIZONTAL, 100, 400, 100);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        
        
        slider1 = new JSlider(SwingConstants.VERTICAL, 100, 400, 100);
        slider1.setMajorTickSpacing(50);
        slider1.setPaintTicks(true);

        l = new JLabel(String.valueOf(slider.getValue()));
        l.setBackground(Color.WHITE);

        slider.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    myPanel.setD(slider.getValue());
                    slider1.setValue(slider.getValue());
                    l.setText(String.valueOf(slider.getValue()));
                    l.setBackground(Color.WHITE);
                }
            }
        );  add(slider, BorderLayout.SOUTH);
        
        slider1.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    myPanel.setD(slider1.getValue());
                    slider.setValue(slider1.getValue());
                    l.setText(String.valueOf(slider1.getValue()));
                    l.setBackground(Color.WHITE);

                }
            }
        );  add(slider1, BorderLayout.WEST);
        
        add(l,BorderLayout.EAST);
        add(myPanel, BorderLayout.CENTER);
    }    
}
    public class SwingSliderExample{
    public static void main(String s[]){
        
        TheWindow w = new TheWindow();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows program to exit on close
        w.setSize(800,800);
        w.setVisible(true);
    }
}

