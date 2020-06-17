import rmFrontU.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExampleSliderAutomatic extends JFrame implements ActionListener {
    private JPanel Slide = new JPanel();

    private JPanel pane1 = new JPanel();
    private JPanel pane2 = new JPanel();
    private JPanel pane3 = new JPanel();

    private rmSliderAutomatic Slider = new rmSliderAutomatic(Slide);
    private JButton btn = new JButton("Presioname");

    public ExampleSliderAutomatic(){
        super("RM-Front-U - SliderAutomatic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(255,255,255));
        initComponents();
    }

    public void initComponents(){

        Slide.setSize(2100,250);
        Slide.setLocation(0,0);
        Slide.setLayout(null);

        pane1.setSize(700,250);
        pane1.setLocation(0,0);
        pane1.setBackground(new Color(0,0,0));

        pane2.setSize(700,250);
        pane2.setLocation(700,0);
        pane2.setBackground(new Color(200,100,0));

        pane3.setSize(700,250);
        pane3.setLocation(1400,0);
        pane3.setBackground(new Color(0,100,200));

        Slide.add(pane1);
        Slide.add(pane2);
        Slide.add(pane3);

        this.add(Slide);
        Slider.configSlide(2,4000,700,3,0,0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btn)){

        }
    }

    public static void main( String [] args ){
        new ExampleSliderAutomatic().setVisible(true);
    }
}
