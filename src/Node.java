public class Node {
    private Statement data;
    private Node next;
    private final long timestamp;


    public Node(Statement data){
        setData(data);
        setNext(null);
        this.timestamp = System.currentTimeMillis();
    }

    void setData(Statement data) {
        this.data = data;
    }

    void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Statement getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString(){
        return data.toString() ;
    }
}
