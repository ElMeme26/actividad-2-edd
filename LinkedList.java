
public class LinkedList<T> {

    private Node<T> cabeza;
    private Node<T> cola;

    public LinkedList() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarInicio(T dato) {
        Node<T> nuevoNodo = new Node<T>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        
    }

    public void insertarFinal(T dato) {
        Node<T> nuevoNodo = new Node<T>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Node<T> nodoIterador = cabeza;
        
        while (nodoIterador != null) {
            System.out.print(nodoIterador.dato);
            if (nodoIterador.siguiente != null) {
                System.out.print(" -> ");
            }
            nodoIterador = nodoIterador.siguiente;
        }
        System.out.println(" -> null");
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("La lista está vacía, nada que eliminar");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
        }
    }

    public T verCabeza() {
        return cabeza.dato;
    }

    public boolean esVacio() {
        return cabeza == null; 
    }
}


