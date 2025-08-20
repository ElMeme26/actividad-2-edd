public class Pila<T> {
    
    LinkedList<T> listaInterna;

    public Pila() {
        listaInterna = new LinkedList<>(false, false);
    }

    public void push(T dato) {
        listaInterna.insertarInicio(dato);
    }

    public void pop() {
        listaInterna.eliminarInicio();
    }

    public void peek() {
        System.out.println(listaInterna.verCabeza());
    }

    public boolean isEmpty() {
        return listaInterna.esVacio();
    }

    public void show() {
        listaInterna.mostrar();
    }
}
