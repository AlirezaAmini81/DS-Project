import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.*;

public class BubbleSort extends SortStatements{

    @Override
    public void perform(String input) {
        sort(input);
    }

    @Override
    public void sort(String input) {
        int[] inputArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        setLabelArray(inputArray);
        Timer timer = new Timer(1000, new ActionListener() {
            int i = 1, j = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(j!=0){
                    arrayShow[j-1].setBackground(Color.lightGray);
                }else{
                    arrayShow[arrayShow.length-2].setBackground(Color.lightGray);
                    arrayShow[arrayShow.length-1].setBackground(Color.lightGray);
                }
                arrayShow[j].setBackground(Color.yellow);
                arrayShow[j+1].setBackground(Color.yellow);
                if(inputArray[j] > inputArray[j+1]){
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                    arrayShow[j].setText(Integer.toString(inputArray[j]));
                    arrayShow[j + 1].setText(Integer.toString(inputArray[j + 1]));
                }
                j++;
                if(j >= inputArray.length - 1){
                    j = 0;
                    i++;
                }
                if( i >= inputArray.length){
                    arrayShow[arrayShow.length-2].setBackground(Color.lightGray);
                    arrayShow[arrayShow.length-1].setBackground(Color.lightGray);
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
