import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrefixToPostfix extends ConversionStatements{
    private static int counter;
    private Stack<String> outputStack;
    private Label outputStackShow, top;
    public PrefixToPostfix() {
        super();
    }

    @Override
    public void convert(String input) {
        input = new StringBuffer(input).reverse().toString();
        String[] inputArray = input.split(" ");
        System.out.println(inputArray[0]);
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputArray[i].matches("[0-9A-Za-z]+")) {
                    outputStack.push(inputArray[i]);
                } else{
                    String op1 = outputStack.pop();
                    String op2;
                    if (outputStack.isEmpty()) {
                        op2 = "";
                    } else {
                        op2 = outputStack.pop();
                    }
                    String expression = op1 + op2 + inputArray[i] ;
                    outputStack.push(expression);
                }
                System.out.println(outputStack);
                outputStackShow.setText(outputStack.toString());
                i++;
                if (i >= inputArray.length) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public void perform(String input) {
        outputStack = new Stack<>();
        outputStackShow = new Label();
        top = new Label("Top");
        outputStackShow.setBackground(Color.yellow);
        top.setBackground(Color.orange);
        top.setBounds(100,20,40,30);
        outputStackShow.setBounds(100,50,320,60);
        History.storeHistory(this,++counter);
        add(outputStackShow);add(top);
        convert(input);
    }

    @Override
    public String toString() {
        return "PrefixToPostfix";
    }

    @Override
    public boolean evaluate(String input) {
        return prefixEvaluation(input);
    }
}
