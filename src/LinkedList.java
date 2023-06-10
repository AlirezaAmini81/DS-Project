public class LinkedList {
    private int count;
    private Node firstNode;

    public LinkedList() {
        count = 0;
        firstNode = null;
    }

    public int length(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0 ;
    }


    public void add(Statement data){
        Node newNode = new Node(data);
        if(isEmpty()){
            firstNode = newNode;
        }
        else{
            Node current = firstNode;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        count ++;
    }
    public String toString() {
        if(isEmpty()) {
            return null;
        } else {
            String str = "";
            Node current = firstNode;
            while(current != null) {
                str = str.concat(current.toString() + " ");
                current = current.getNext();
            }
            return str;
        }
    }

    public boolean delete(Statement data) {
        if (isEmpty()) {
            throw new EmptyListException();
        } else {
            boolean deleted = false;
            if (firstNode.getData().equals(data)) {
                Node temp = firstNode;
                firstNode = firstNode.getNext();
                temp.setNext(null);
                deleted = true;
            } else {
                Node current = firstNode;
                while (current != null) {
                    if (current.getNext() != null && current.getNext().getData() == data) {
                        Node temp = current.getNext();
                        current.setNext(temp.getNext());
                        temp.setNext(null);
                        deleted = true;
                        break;
                    } else {
                        current = current.getNext();
                    }
                }
            }
            if (deleted) {
                count--;
            }
            return deleted;
        }
    }

    public Node getFirstNode() {
        return firstNode;
    }

}