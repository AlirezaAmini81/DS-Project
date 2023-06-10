import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfixToPostfix extends ConversionStatements {
    private Stack<String> operatorStack;
    private Stack<String> outputStack;
    private Label outputStackShow, operatorStackShow, l1,l2, top1, top2;
    private static int counter ;

    public InfixToPostfix() {
        super();
    }

    @Override
    public boolean evaluate(String input) {
         return infixEvaluation(input);
    }

    @Override
    public void perform(String input) {
        outputStack = new Stack<>();
        operatorStack = new Stack<>();
        outputStackShow = new Label();
        operatorStackShow = new Label();
        l1 = new Label("  Operator Stack");
        l2 = new Label("  Output Stack");
        top1 = new Label("Top");
        top2 = new Label("Top");
        outputStackShow.setBackground(Color.yellow);
        operatorStackShow.setBackground(Color.yellow);
        top1.setBackground(Color.orange);
        top2.setBackground(Color.orange);
        l1.setBackground(Color.lightGray);
        l2.setBackground(Color.lightGray);
        top1.setBounds(100,20,40,30);
        l1.setBounds(140,20,280,30);
        operatorStackShow.setBounds(100,50,320,40);
        top2.setBounds(100,100,40,30);
        l2.setBounds(140,100,280,30);
        outputStackShow.setBounds(100,130,320,40);
        History.storeHistory(this,++counter);
        add(outputStackShow);add(operatorStackShow);add(l1);add(l2);add(top1);add(top2);
        convert(input);
    }

    @Override
    public void convert(String input) {
        String[] inputArray = input.split(" ");
        Timer timer = new Timer(2000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {

                if( i >= inputArray.length && !operatorStack.isEmpty()){
                    outputStack.push(operatorStack.pop());
                }else if(inputArray[i].matches("[/*+^-]") || isFunction(inputArray[i])){
                    if(inputArray[i].matches("[-]")){
                        if(i == 0 || inputArray[i - 1].matches("[(]")){
                            inputArray[i] = "?";
                        }
                    }
                    while (true){
                        if(!operatorStack.isEmpty()){
                            String p = operatorStack.pop();
                            if(getPriority(inputArray[i]) > getPriority(p) || ((getPriority(inputArray[i]) == getPriority(p)) && p.matches("\\^"))){
                                operatorStack.push(p);
                                operatorStack.push(inputArray[i]);
                                break;
                            }else{
                                outputStack.push(p);
                            }
                        }else{
                            operatorStack.push(inputArray[i]);
                            break;
                        }
                    }
                }else if(inputArray[i].matches("[0-9a-zA-Z]+")){
                    outputStack.push(inputArray[i]);
                }else if(inputArray[i].matches("[(]")){
                    operatorStack.push(inputArray[i]);
                }
                else if(inputArray[i].matches("[)]")){
                    while (true){
                        String p = operatorStack.pop();
                        if(p.matches("[(]")){
                            break;
                        }else{
                            outputStack.push(p);
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
    public String toString() {
        return "InfixToPostfix";
    }
}
