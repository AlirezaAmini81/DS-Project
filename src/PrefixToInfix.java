import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrefixToInfix extends ConversionStatements{
    private static int counter;
    private Stack<String> outputStack ;
    private Label outputStackShow, top;
    public PrefixToInfix() {
        super();
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
    public void convert(String input) {
        input = new StringBuffer(input).reverse().toString();
        String[] inputArray = input.split(" ");
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;String expression = "";
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputArray[i].matches("[+*^\\-/?]") || isFunction(inputArray[i]) ){
                    if(inputArray[i].matches("[?]")){
                        inputArray[i] = "-";
                    }
                    String op1 = outputStack.pop();
                    String op2;
                    if (outputStack.isEmpty()) {
                        op2 = "";
                    } else {
                        op2 = outputStack.pop();
                    }
                    if(inputArray[i].matches("[?]")){
                        outputStack.push(op2);
                        expression =  "-" + op1 ;
                    }else {
                        expression =  "(" + op1 + inputArray[i] + op2 + ")";
                    }
                    outputStack.push(expression);
                }else{
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
    public boolean evaluate(String input) {
        return prefixEvaluation(input);
    }

    @Override
    public String toString() {
        return "PrefixToInfix" ;
    }
}
