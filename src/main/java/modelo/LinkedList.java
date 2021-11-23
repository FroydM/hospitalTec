
package modelo;

/**
 *
 * @author march
 */
public class LinkedList<T> {
    public class Node{
    
        private T element;
        private Node next;
        /**
         * Este constructor se encarga de crear un nodo que almecenara un objeto vacio y un puntero al siguiente nodo vacio
         */
        public Node(){
            this.element = null;
            this.next = null;
        }
        /**
         * Este constructor se encarga de generar un nodo con objeto
         * @param element Objeto que sera almacenado al nodo
         */
        public Node(T element){
            this.element = element;
            this.next = null;
        }
        /**
         * Este constructor se encarga de crear un nodo que almecenara un objeto y un puntero al siguiente nodo
         * @param element Objeto que sera almacenado al nodo
         * @param next Puntero al siguiente nodo
         */
        public Node(T element,Node next){
            this.element = element;
            this.next = next;
        }
        
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
   
    /**
     * Se encarga de crear una objeto de tipo LinkedList vacia
     */
    public LinkedList(){
        this.head = new Node();
        this.current = this.head;
        this.tail = this.head;
        this.size = 0;
        this.position = -1;
    }
    /**
     * Agrega un elemento al final de la lista
     * @param element El objeto que sera agregado a la lista
     */
    public void append(T element){
        Node newNode = new Node(element);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.size++;
    }
    /**
     * Este metodo se encarga de buscar un elemento en un index en especifico
     * @param index
     * @return Un objeto de tipo T en el index buscado
     */
    public T getElement(int index){
        if(getSize()==0){
            return null;
        }
        for(this.goToStart();this.position <= this.size-1;this.next()) {
            T currentElement = getElement();
            if(currentElement!=null && this.position == index){
                return currentElement;
            }
            
        }
        return null;
    }
    
    
    public int getSize(){
        return this.size;
    }
    
    private T getElement(){
        return this.current.getElement();
    }
    
    /**
     * Mueve el vector al siguiente nodo
     * @return  Error si no ya el vector esta en el ultimo nodo
     */
    private boolean next(){
        if(this.current == this.tail){
            System.out.println("Error: This is the last node!!!");
            return false;
        }
        this.current = this.current.getNext();
        this.position++;
        return true;
    }
    /**
     * Este metodo hace que el vector apunto al primer elemento de la lista
     */
    private void goToStart(){
        this.current=this.head;
        this.position = -1;
    }
}
