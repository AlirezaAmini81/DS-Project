import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfixToPrefix  extends ConversionStatements{
    private Stack<String> operatorStack;
    private Stack<String> outputStack;
    private Label outputStackShow, operatorStackShow, l1,l2, top1, top2;
    private static int counter ;

    public InfixToPrefix() {
        super();
    }

    @Override
    public void convert(String input) {
        String[] inputArray = input.split(" ");
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if( i >= inputArray.length && !operatorStack.isEmpty()){
                    String op = operatorStack.pop();
                    String op1 = outputStack.pop();
                    String op2;
                    if (outputStack.isEmpty()) {
                        op2 = "";
                    } else {
                        op2 = outputStack.pop();
                    }
                    String expression =  op + op2 + op1 ;
                    outputStack.push(expression);
                }
                else if(inputArray[i].matches("[0-9A-Za-z]+")){
                    outputStack.push(inputArray[i]);
                }else if(inputArray[i].matches("[(]")){
                    operatorStack.push(inputArray[i]);
                }
                else if(inputArray[i].matches("[)]")){
                    while (true){
                        String op = operatorStack.pop();
                        if(op.matches("[(]")){
                            break;
                        }else{
                            String op1 = outputStack.pop();
                            String op2;
                            if (outputStack.isEmpty()) {
                                op2 = "";
                            } else {
                                op2 = outputStack.pop();
                            }
                            String expression =  op + op2 + op1 ;
                            outputStack.push(expression);
                        }
                    }
                }else if(inputArray[i].matches("[/*+^-]") || isFunction(inputArray[i])){
                    if(inputArray[i].matches("[-]")){
                        if(i == 0 || inputArray[i - 1].matches("[(]")){
                            inputArray[i] = "?";
                        }
                    }
                    while (true){
                        if(!operatorStack.isEmpty()){
                            String op = operatorStack.pop();
                            if(getPriority(inputArray[i]) > getPriority(op) ){
                                operatorStack.push(op);
                                operatorStack.push(inputArray[i]);
                                break;
                            }else{
                                String op1 = outputStack.pop();
                                String op2;
                                if (outputStack.isEmpty()) {
                                    op2 = "";
                                } else {
                                    op2 = outputStack.pop();
                                }
                                String expression =  op + op2 + op1 ;
                                outputStack.push(expression);
                            }
                        }else{
                            operatorStack.push(inputArray[i]);
                            break;
                        }
                    }
                }
                operatorStackShow.setText(operatorStack.toString());
                outputStackShow.setText(outputStack.toString());
                i++;
                if (i >= inputArray.length && operatorStack.isEmpty()) {
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
        operatorStack = new Stack<>();
        operatorStackShow = new Label();
        outputStackShow = new Label();
        outputStackShow.setBackground(Color.yellow);
        operatorStackShow.setBackground(Color.yellow);
        l1 = new Label("  Operator Stack");
        l2 = new Label("  Output Stack");
        top1 = new Label("Top");
        top2 = new Label("Top");
        top1.setBackground(Color.orange);
        top2.setBackground(Color.orange);
        l1.setBackground(Color.LIGHT_GRAY);
        l2.setBackground(Color.LIGHT_GRAY);
        top1.setBounds(100,20,40,30);
        l1.setBounds(140,20,280,30);
        operatorStackShow.setBounds(100,50,320,40);
        top2.setBounds(100,100,40,30);
        l2.setBounds(140,100,280,30);
        outputStackShow.setBounds(100,130,320,40);
        add(l1);add(operatorStackShow);add(l2);add(outputStackShow);add(top1);add(top2);
        History.storeHistory(this,++counter);
        convert(input);
    }

    @Override
    public boolean evaluate(String input) {
        return infixEvaluation(input);
    }

    @Override
    public String toString() {
        return "InfixToPrefix";
    }
}
