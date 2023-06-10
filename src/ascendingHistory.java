import java.util.ArrayList;

public class ascendingHistory extends History {
    private static ArrayList<CircularQueue> Repeat = new ArrayList<>();

    public ascendingHistory(){
        super();
    }

    private static void createQueue (int count){
        for( int i = Repeat.size(); i < count ; i++){
            Repeat.add(new CircularQueue(6));
        }
    }

    private static void deleteStatement (Statement type ,int index){
        Statement [] temp = new Statement[6];
        for(int i = 0 ; i < temp.length; i++) {
            Statement s =  Repeat.get(index).remove();
            if (s.getClass() == type.getClass()) {
                for (int j = 0; j < i; j++) {
                    Repeat.get(index).insert(temp[j]);
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
        for (int i = ascendingHistory.Repeat.size() - 1; i >= 0; i--){
            if( !ascendingHistory.Repeat.get(i).isEmpty()){
                inputArray = ascendingHistory.Repeat.get(i).toString().split(" ");
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
        Repeat.get(counter - 1).insert(type);
    }
}
