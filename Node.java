
public class Node<T> {
    T dato;
    Node<T> siguiente;
    Node<T> anterior;

    public Node(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
