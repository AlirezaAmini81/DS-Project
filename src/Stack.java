import java.util.ArrayList;

public class Stack<T> {
    private T data;
    private int top = -1 ;
    private int size;
    private final ArrayList<T> DS ;

    public Stack() {
        DS = new ArrayList<T>();
    }

    public boolean isEmpty (){
        return ( top < 0);
    }

    public void push (T _data){
        top ++;
        DS.add(_data);
    }

    public T pop (){
        T output = DS.get(top);
        DS.remove(top);
        top --;
        return output;
    }

    public void set(T _data){
        this.data = _data;
    }

    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = top; i >= 0 ; i--){
             str = str.concat(DS.get(i).toString() + " ");
        }
        return str;
    }
}
