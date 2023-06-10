import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SelectionSort extends SortStatements{
    @Override
    public void perform(String input) {
        sort(input);
    }

    @Override
    public void sort(String input) {
        int[] inputArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        setLabelArray(inputArray);
        Timer timer = new Timer(1000, new ActionListener() {
            int i  = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = inputArray[minElement(inputArray, i)];
                inputArray[minElement(inputArray, i)] = inputArray[i];
                arrayShow[minElement(inputArray, i)].setText(Integer.toString(inputArray[i]));
                inputArray[i] = min;
                arrayShow[i].setText(Integer.toString(inputArray[i]));
                arrayShow[i].setBackground(Color.yellow);
                i++;
                if( i >= inputArray.length){
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    private int minElement(int  arr[], int index){
        for(int i = index + 1; i< arr.length  ; i++){
            if(arr[i] < arr[index]){
                index = i;
            }
        }
        return index;
    }
}
