import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.*;

public class CountingSort extends SortStatements{
    private Label[] outputArrayShow;
    private Label[]  countArrayShow;
    private int[] outputArray;
    private int[] countArray;
    @Override
    public void perform(String input) {
        sort(input);
    }

    @Override
    public void sort(String input) {
        int[] inputArray = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        outputArray = new int[inputArray.length];
        setLabelArray(inputArray);
        setLabelOutputArray();
        countArray = new int[maxElement(inputArray) + 1];
        setLabelCountArray();
        Timer timer = new Timer(1000, new ActionListener() {
            int i,sortOrder = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sortOrder == 0){
                    countArray[inputArray[i]] = countArray[inputArray[i]] + 1;
                    countArrayShow[inputArray[i]].setText(Integer.toString(countArray[inputArray[i]]));
                    i++;
                    if(i >= inputArray.length){
                        i = 1;
                        sortOrder++;
                    }
                }else if(sortOrder == 1){
                    countArray[i] = countArray[i] + countArray[i - 1];
                    countArrayShow[i].setText(Integer.toString(countArray[i]));
                    i++;
                    if(i >= countArray.length){
                        i = inputArray.length - 1;
                        sortOrder++;
                    }
                }else if(sortOrder == 2){
                    if(i <= 0){
                        ((Timer) e.getSource()).stop();
                    }
                    outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
                    outputArrayShow[countArray[inputArray[i]] - 1].setText(Integer.toString(outputArray[countArray[inputArray[i]] - 1]));
                    countArray[inputArray[i]] = countArray[inputArray[i]] - 1;
                    countArrayShow[inputArray[i]].setText(Integer.toString(countArray[inputArray[i]]));
                    i--;
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();

    }


    private int maxElement(int  arr[]){
        int max = 0;
        for(int i = 0; i< arr.length  ; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private void setLabelCountArray(){
        countArrayShow = new Label[countArray.length];
        for(int i = 0; i < countArrayShow.length; i++){
            countArray[i] = 0;
            countArrayShow[i] = new Label(Integer.toString(countArray[i]));
            countArrayShow[i].setBounds(50 + 20*i,100,20,30);
            countArrayShow[i].setBackground(Color.lightGray);
            countArrayShow[i].setText(Integer.toString(0));
            add(countArrayShow[i]);
        }
    }

    private void setLabelOutputArray(){
        outputArrayShow = new Label[outputArray.length];
        for(int i = 0; i < outputArrayShow.length; i++){
            outputArrayShow[i] = new Label(Integer.toString(outputArray[i]));
            outputArrayShow[i].setBounds(50 + 20*i,180,20,30);
            outputArrayShow[i].setBackground(Color.lightGray);
            add(outputArrayShow[i]);
        }
    }
}
