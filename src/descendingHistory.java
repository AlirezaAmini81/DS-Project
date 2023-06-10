import java.util.ArrayList;

public class descendingHistory extends History{
    private static ArrayList<Stack> Repeat = new ArrayList<>();

    public descendingHistory(){
        super();
    }

    public static void createQueue(int count){
        for( int i = Repeat.size(); i < count ; i++){
            Repeat.add(new Stack());
        }
    }

    private static void deleteStatement (Statement type ,int index){
        Statement [] temp = new Statement[6];
        for(int i = 0 ; i < temp.length; i++) {
            Statement s = (Statement) Repeat.get(index).pop();
            if (s.getClass() == type.getClass()) {
                for (int j = 0; j < i; j++) {
                    Repeat.get(index).push(temp[j]);
                }
                break;
            }
            temp[i] = s;
        }
    }
    @Override
    public void showHistory() {
        String[] inputArray;
        setBounds();
        int k = 0;
        for (int i = 0; i < descendingHistory.Repeat.size(); i++){
            if( !descendingHistory.Repeat.get(i).isEmpty()){
                inputArray = descendingHistory.Repeat.get(i).toString().split(" ");
                for(int j = 0; j< inputArray.length; j++){
                    if(!inputArray[j].matches("")){
                        showLabel[k].setText(inputArray[j] + " : " + (i + 1));
                        add(showLabel[k]);
                        k++;
                    }
                }
            }
        }
    }

    public static void statementRepetition(Statement type, int counter) {
        createQueue(counter);
        if(counter!=1){
            deleteStatement(type, counter - 2);
        }
        Repeat.get(counter - 1).push(type);
    }
}
