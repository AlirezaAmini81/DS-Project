public class CircularQueue {
    private int size;
    private LinkedList linkedlist;
    private int front;
    private int rear;
    private boolean lastOperationIsPush = false;

    public CircularQueue(int size){
        setSize(size);
        linkedlist = new LinkedList();
    }

    public void insert(Statement value){
        if( ((front != rear) || !lastOperationIsPush) && size != 0){
            linkedlist.add(value);
            rear = (rear + 1)% size;
        }
        lastOperationIsPush = true;
    }

    public Statement remove(){
        Statement output = null;
        if(((front != rear) || lastOperationIsPush) && size != 0){
            output = linkedlist.getFirstNode().getData();
            linkedlist.delete(linkedlist.getFirstNode().getData());
            front = (front + 1)% size;
        }
        lastOperationIsPush = false;
        return output;
    }

    public void setSize(int size) {
        if(size > 0){
            this.size = size;
        }
    }

    @Override
    public String toString() {
        return linkedlist.toString();
    }

    public boolean isEmpty (){
        return (front == rear) && !lastOperationIsPush;
    }
}

