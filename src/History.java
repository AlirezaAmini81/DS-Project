import javax.swing.*;
import java.awt.*;

public abstract class History extends JFrame {
    Label[] showLabel;

    public History(){
        setSize(600,500);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showLabel = new Label[6];
        setVisible(true);
        showHistory();
    }

    void setBounds(){
        showLabel = new Label[6];
        for(int i = 0; i < 6; i++){
            showLabel[i] = new Label();
            showLabel[i].setBackground(Color.yellow);
            showLabel[i].setBounds(100,10 * (i + 1) + 40 * i,320,40);
        }
    }

    public abstract void showHistory();

    public static void storeHistory(Statement type, int counter) {
        ascendingHistory.statementRepetition(type, counter);
        descendingHistory.statementRepetition(type, counter);
    }

}
