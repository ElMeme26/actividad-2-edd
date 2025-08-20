public class Cola<T> {
    
    LinkedList<T> listaInterna;

    public Cola() {
        listaInterna = new LinkedList<>(false, false);
    }
    
    public void enqueue(T dato) {
        listaInterna.insertarFinal(dato);
    }

    public void dequeue() {
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
