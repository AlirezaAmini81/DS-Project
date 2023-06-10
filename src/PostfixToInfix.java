import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostfixToInfix extends ConversionStatements{
    private static int counter;
    private Stack<String> outputStack ;
    private Label outputStackShow, top;
    public PostfixToInfix() {
        super();
    }

    @Override
    public void perform(String input) {
        outputStack = new Stack<>();
        top = new Label("Top");
        outputStackShow = new Label();
        top.setBackground(Color.orange);
        outputStackShow.setBackground(Color.yellow);
        top.setBounds(100,20,40,30);
        outputStackShow.setBounds(100,50,320,60);
        History.storeHistory(this,++counter);
        add(outputStackShow);add(top);
        convert(input);
    }

    @Override
    public boolean evaluate(String input) {
         return postfixEvaluation(input);
    }

    @Override
    public void convert(String input) {
        String[] inputArray = input.split(" ");
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;String expression = "";
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputArray[i].matches("[+\\-*^/?]") || isFunction(inputArray[i])){
                    String op1 = outputStack.pop();
                    String op2;
                    if (outputStack.isEmpty() || isFunction(inputArray[i])) {
                        op2 = "";
                    } else {
                        op2 = outputStack.pop();
                    }
                    if(inputArray[i].matches("[?]")){
                        outputStack.push(op2);
                        expression =  "-" + op1 ;
                    }else {
                        expression =  "(" +op2 + inputArray[i] + op1 + ")";
                    }
                    outputStack.push(expression);
                }else {
                    outputStack.push(inputArray[i]);
                }
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
    public String toString() {
        return "PostfixToInfix" ;
    }
}
