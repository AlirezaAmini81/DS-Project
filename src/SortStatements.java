
import java.awt.*;
public abstract class SortStatements extends Statement implements Sortable{
    Label[] arrayShow;

    void setLabelArray(int[] array){
        arrayShow = new Label[array.length];
        for(int i = 0; i < arrayShow.length; i++){
            arrayShow[i] = new Label(Integer.toString(array[i]));
            arrayShow[i].setBounds(50 + 20*i,20,20,30);
            arrayShow[i].setBackground(Color.lightGray);
            add(arrayShow[i]);
        }
    }

    @Override
    public boolean evaluate(String input) {
        return input.matches("([0-9]+[ ]?)+");
    }
}
