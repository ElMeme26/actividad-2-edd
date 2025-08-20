
public class LinkedList<T> {

    private Node<T> cabeza;
    private Node<T> cola;
    private boolean esCircular;
    private boolean esDoble;

    public LinkedList(boolean esDoble, boolean esCircular) {
        this.cabeza = null;
        this.cola = null;
        this.esDoble = esDoble;
        this.esCircular = esCircular;
    }

    public void insertarInicio(T dato) {

        if (cabeza == null) {
            Node<T> nuevoNodo = new Node<T>(dato);
            cabeza = nuevoNodo;
            cola = nuevoNodo;

            if (esCircular) {
                nuevoNodo.siguiente = nuevoNodo;

                if (esDoble) {
                    nuevoNodo.anterior = nuevoNodo;
                }
            } else {
                nuevoNodo.siguiente = null;
                if (esDoble) {
                    nuevoNodo.anterior = null;
                }

            }
            return;
        } else {
            Node<T> nuevoNodo = new Node<T>(dato);
            nuevoNodo.siguiente = cabeza;
            
            if (esDoble) {
                cabeza.anterior = nuevoNodo;
                nuevoNodo.anterior = null;
            }

            cabeza = nuevoNodo;

            if (esCircular) {
                cola.siguiente = cabeza;
                
                if (esDoble) {
                    cabeza.anterior = cola;
                }
            }

        }
        
    }

    public void insertarFinal(T dato) {

        if (cabeza == null) {
            Node<T> nuevoNodo = new Node<T>(dato);
            cabeza = nuevoNodo;
            cola = nuevoNodo;

            if (esCircular) {
                nuevoNodo.siguiente = nuevoNodo;

                if (esDoble) {
                    nuevoNodo.anterior = nuevoNodo;
                }
            } else {
                nuevoNodo.siguiente = null;
                if (esDoble) {
                    nuevoNodo.anterior = null;
                }

            }
            return;
        } else {
            Node<T> nuevoNodo = new Node<T>(dato);
            cola.siguiente = nuevoNodo;

            if (esDoble) {
                nuevoNodo.anterior = cola;
            }

            cola = nuevoNodo;

            if (esCircular) {
                cola.siguiente = cabeza;

                if (esDoble) {
                    cabeza.anterior = cola;
                }
            }
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (esCircular) {
            Node<T> nodoIterador = cabeza;

            if (esDoble) { // doble circular
                Node<T> cola = cabeza.anterior; // en lista doble circular, la cabeza apunta atrás a la cola
                System.out.print("(vuelve a " + cola.dato + ") <- ");
                do {
                    System.out.print(nodoIterador.dato);
                    if (nodoIterador.siguiente != cabeza) {
                        System.out.print(" <-> ");
                    }
                    nodoIterador = nodoIterador.siguiente;
                } while (nodoIterador != cabeza);
                System.out.println(" -> (vuelve a " + cabeza.dato + ")");
            } else { // simple circular
                do {
                    System.out.print(nodoIterador.dato + " -> ");
                    nodoIterador = nodoIterador.siguiente;
                } while (nodoIterador != cabeza);
                System.out.println("(vuelve a " + cabeza.dato + ")");
            }
            return;
        }

        if (esDoble) {
            Node<T> nodoIterador = cabeza;
            System.out.print("null <- ");
            while (nodoIterador != null) {
                System.out.print(nodoIterador.dato);
                if (nodoIterador.siguiente != null) {
                    System.out.print(" <-> ");
                }
                nodoIterador = nodoIterador.siguiente;
            }
            System.out.println(" -> null");
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

            if (esDoble) {
                cabeza.anterior = null;
            }

            if (esCircular) {
                cola.siguiente = cabeza;

                if (esDoble) {
                    cabeza.anterior = cola;
                }
            }
        }
    }

    public void eliminarFinal() {
        if (cabeza == null) {
            System.out.println("La lista está vacía, nada que eliminar");
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            return;
        }

        if (esDoble) {
                cola = cola.anterior;

                if (esCircular) {
                    cola.siguiente = cabeza;
                    cabeza.anterior = cola;
                } else {
                    cola.siguiente = null;
                }
        } else {
            Node<T> nodoIterador = cabeza;
            while (nodoIterador.siguiente != cola) {
                nodoIterador = nodoIterador.siguiente;
            }
            cola = nodoIterador;
            if (esCircular) {
                cola.siguiente = cabeza;
            } else {
                cola.siguiente = null;
            }
        }
    }

    public T verCabeza() {
        return cabeza.dato;
    }

    public boolean esVacio() {
        return cabeza == null; 
    }
}


