
package modelo;

/**
 *
 * @author march
 */
public class LinkedList<T> {
    public class Node{
    //Attributes
        private T element;
        private Node next;
    
        public Node(){
            this.element = null;
            this.next = null;
        }
        public Node(T element){
            this.element = element;
            this.next = null;
        }
        public Node(T element,Node next){
            this.element = element;
            this.next = next;
        }
    //Methods
        public T getElement(){
            return this.element;
        }
        public void setElement(T element){
            this.element = element;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    private Node head;
    private Node current;
    private Node tail;
    private int position;
    private int size;
   
    public LinkedList(){
        this.head = new Node();
        this.current = this.head;
        this.tail = this.head;
        this.size = 0;
        this.position = -1;
    }
    public void append(T element){
        Node newNode = new Node(element);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.size++;
    }
    
    public T getElement(){
        return this.current.getElement();
    }
    
    public int getSize(){
        return this.size;
    }
    public boolean next(){
        if(this.current == this.tail){
            System.out.println("Error: This is the last node!!!");
            return false;
        }
        this.current = this.current.getNext();
        this.position++;
        return true;
    }
    public void goToStart(){
        this.current=this.head;
        this.position = -1;
    }
}
