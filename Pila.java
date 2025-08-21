public class Pila<T> {
    
    LinkedList<T> listaInterna;

    public Pila() {
        listaInterna = new LinkedList<>();
    }

    public void push(T dato) {
        listaInterna.insertarInicio(dato);
    }

    public void pop() {
        listaInterna.eliminarInicio();
    }

    public T peek() {
        return listaInterna.verCabeza();
    }

    public boolean isEmpty() {
        return listaInterna.esVacio();
    }

    public void show() {
        listaInterna.mostrar();
    }
}
