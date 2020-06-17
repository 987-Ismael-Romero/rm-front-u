import rmFrontU.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExampleDisplacementXY extends JFrame implements ActionListener {

    private int state = 1;
    private int state2 = 1;
    private JButton btn = new JButton("Desplazamiento X");
    private JButton btn2 = new JButton("Desplazamiento Y");

    private JPanel mainPanel = new JPanel();
    private JPanel menuPanel = new JPanel();
    private JPanel workPanel = new JPanel();

    public ExampleDisplacementXY(){
        super("RM-Displacement-XY");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,450);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        initComponents();
    }

    private void initComponents(){
        mainPanel.setSize(this.getWidth(), this.getHeight());
        mainPanel.setBackground(new Color(255,255,255));
        mainPanel.setLayout(null);

        btn2.addActionListener(this);
        btn.addActionListener(this);

        menuPanel.setBackground(new Color(100,155,155));
        menuPanel.setSize(200,this.getHeight());
        menuPanel.setLocation(0,0);
        menuPanel.add(btn);

        workPanel.setBackground(new Color(6, 2, 65));
        workPanel.setSize(500, this.getHeight());
        workPanel.setLocation(200,0);
        workPanel.add(btn2);

        mainPanel.add(menuPanel);
        mainPanel.add(workPanel);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn) && state == 1){
            new rmDisplacementX(menuPanel, -100,0,0,0,1,1);
            new rmDisplacementX(workPanel, 100,200,0,100,1,3);
            state = 0;
        }else if(e.getSource().equals(btn) && state == 0){
            new rmDisplacementX(menuPanel, 0,-100,0,0,1,2);
            new rmDisplacementX(workPanel, 200,100,0,100,1,4);
            state = 1;
        }

        if(e.getSource().equals(btn2) && state2 == 1){
            new rmDisplacementY(workPanel, 100,200,0,0,5,2);
            //new rmDisplacementY(workPanel, 100,200,0,100,5,4);
            state2 = 0;
        }else if(e.getSource().equals(btn2) && state2 == 0){
            new rmDisplacementY(workPanel, 0,200,100,0,5,1);
            //new rmDisplacementY(workPanel, 0,200,100,100,5,3);
            state2 = 1;
        }
    }

    public static void main(String [] args){
        new ExampleDisplacementXY().setVisible(true);
    }
}