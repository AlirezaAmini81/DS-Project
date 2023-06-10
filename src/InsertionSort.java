import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class InsertionSort extends SortStatements{
    @Override
    public void perform(String input) {
        sort(input);
    }

    @Override
    public void sort(String input) {
        int[] inputArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        setLabelArray(inputArray);
        Timer timer = new Timer(1000, new ActionListener() {
            int i  = 1, j = 1;
            int v = inputArray[i];
            boolean breakLoop = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(j > 0 &&  v < inputArray[j - 1]){
                    inputArray[j] = inputArray[j - 1];
                    arrayShow[j].setText(Integer.toString(inputArray[j]));
                    j--;
                }else{
                    breakLoop = true;
                }
                if(breakLoop){
                    inputArray[j] = v;
                    arrayShow[j].setText(Integer.toString(inputArray[j]));
                    i++;
                    j = i;
                    if( i < inputArray.length){
                        v = inputArray[i];
                    }
                    breakLoop = false;
                }
                if( i >= inputArray.length){
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
