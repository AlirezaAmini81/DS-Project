import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortMenu  extends JFrame implements ActionListener {
    private JButton l1, l2, l3, l4,l5;

    public SortMenu(){
        setSize(600,500);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);
        l1 = new JButton("Bubble Sort");
        l2 = new JButton("Insertion Sort");
        l3 = new JButton("Selection Sort");
        l4 = new JButton("Counting Sort");
        l5 = new JButton(" Main Menu");
        l1.setBounds(100,20,320,30);
        l2.setBounds(100,60,320,30);
        l3.setBounds(100,100,320,30);
        l4.setBounds(100,140,320,30);
        l5.setBounds(100,180,320,30);
        add(l1);add(l2);add(l3);add(l4);add(l5);
        l1.addActionListener(this);l2.addActionListener(this);
        l3.addActionListener(this);l4.addActionListener(this);
        l5.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == l1){
            BubbleSort f = new BubbleSort();
        }else if(e.getSource() == l2){
            InsertionSort f = new InsertionSort();
        }
        else if(e.getSource() == l3){
            SelectionSort f = new SelectionSort();
        }
        else if(e.getSource() == l4){
            CountingSort f = new CountingSort();
        }
        else if(e.getSource() == l5){
            Menu f = new Menu();
            setVisible(false);
        }
    }
}
