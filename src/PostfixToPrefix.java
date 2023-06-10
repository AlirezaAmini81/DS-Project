import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostfixToPrefix extends ConversionStatements {
    private static int counter;
    private Stack<String> outputStack ;
    private Label outputStackShow, top;
    public PostfixToPrefix() {
        super();
    }

    @Override
    public boolean evaluate(String input) {
        return postfixEvaluation(input);
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
        add(outputStackShow);add(top);
        History.storeHistory(this,++counter);
        convert(input);
    }

    @Override
    public void convert(String input) {
        String[] inputArray = input.split(" ");
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputArray[i].matches("[0-9]+")) {
                    outputStack.push(inputArray[i]);
                } else if (inputArray[i].matches("[*/+^\\-?]")) {
                    String op1 = outputStack.pop();
                    String op2;
                    if (outputStack.isEmpty()) {
                        op2 = "";
                    } else {
                        op2 = outputStack.pop();
                    }
                    String expression = inputArray[i] + op2 + op1;
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
    public String toString() {
        return "PostfixToPrefix";
    }
}
