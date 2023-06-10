import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private JButton l1, l2, l3, l4, l5, l6, l7, l8, l9;
    public Menu(){
        setSize(600,500);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JButton("Infix to Prefix");
        l2 = new JButton("Infix to Postfix");
        l3 = new JButton("Postfix to Infix");
        l4 = new JButton("Postfix to Prefix");
        l5 = new JButton("Prefix to Postfix");
        l6 = new JButton("Prefix to Infix");
        l7 = new JButton(" Ascending History");
        l8 = new JButton(" Descending History");
        l9 = new JButton(" Sort Menu");
        l1.setBounds(100,20,320,30);
        l2.setBounds(100,60,320,30);
        l3.setBounds(100,100,320,30);
        l4.setBounds(100,140,320,30);
        l5.setBounds(100,180,320,30);
        l6.setBounds(100,220,320,30);
        l7.setBounds(100,260,320,30);
        l8.setBounds(100,300,320,30);
        l9.setBounds(100,340,320,30);
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);
        l1.addActionListener(this);l2.addActionListener(this);
        l3.addActionListener(this);l4.addActionListener(this);
        l5.addActionListener(this);l6.addActionListener(this);
        l7.addActionListener(this);l8.addActionListener(this);
        l9.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == l1){
            InfixToPrefix f = new InfixToPrefix();
        }else if(e.getSource() == l2){
            InfixToPostfix f = new InfixToPostfix();
        }else if(e.getSource() == l3){
            PostfixToInfix f = new PostfixToInfix();
        }else if(e.getSource() == l4){
            PostfixToPrefix f = new PostfixToPrefix();
        }else if(e.getSource() == l5){
            PrefixToPostfix f = new PrefixToPostfix();
        }else if(e.getSource() == l6){
            PrefixToInfix f = new PrefixToInfix();
        }else if(e.getSource() == l7){
            ascendingHistory f = new ascendingHistory();
        }else if(e.getSource() == l8){
            descendingHistory f = new descendingHistory();
        }else if(e.getSource() == l9){
            SortMenu  f = new SortMenu();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        Menu f = new Menu();
    }


}
