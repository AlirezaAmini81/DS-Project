import javax.swing.*;
import java.awt.*;

public abstract class Statement extends JFrame implements Performable {

    public Statement(){
        setSize(600,500);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        while(true){
            String input = enterData();
            if((input != null)){
                if(evaluate(input)){
                    setVisible(true);
                    perform(input);
                    break;
                }
                else{
                    if(!wrongFormat()){
                        break;
                    }
                }
            }else{
                break;
            }
        }
    }

    public  abstract boolean evaluate(String input);

    public boolean wrongFormat(){
        boolean stay = false;
        String[] options = {"Enter new input! " , "Go to the menu!"};
        int x = JOptionPane.showOptionDialog(null, "Please Enter Correct format", "Wrong Format!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(x == 0){
            stay = true;
        }
        return stay;
    }

    public String enterData(){
        String input = JOptionPane.showInputDialog("Enter the data : ");
        return input;
    }


}
