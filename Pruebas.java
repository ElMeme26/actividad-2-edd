public class Pruebas {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();
        Cola<String> cola = new Cola<>();

        System.out.println("=== PRUEBA DE FUNCIONES PILA ===");

        pila.push("Comando 1");
        System.out.println("- Comando 1 insertado PUSH");
        pila.push("Comando 2");
        System.out.println("- Comando 2 insertado PUSH");
        pila.push("Comando 3");
        System.out.println("- Comando 3 insertado PUSH");
        pila.push("Comando 4");
        System.out.println("- Comando 4 insertado PUSH");

        System.out.println("\nPila de comandos: ");
        pila.show();

        System.out.println("\nEliminación con POP");
        pila.pop();
        pila.show();

        System.out.println("\nVer último comando PEEK");
        System.out.println(pila.peek());


        System.out.println("\n=== PRUEBA DE FUNCIONES COLA ===");

        cola.enqueue("Programa 1");
        System.out.println("Programa 1 puesto en cola ENQUEUE");
        cola.enqueue("Programa 2");
        System.out.println("Programa 2 puesto en cola ENQUEUE");
        cola.enqueue("Programa 3");
        System.out.println("Programa 3 puesto en cola ENQUEUE");
        cola.enqueue("Programa 4");
        System.out.println("Programa 4 puesto en cola ENQUEUE");

        System.out.println("\nCola de programas: ");
        cola.show();

        System.out.println("\nEliminación con DEQUEUE");
        cola.dequeue();
        cola.show();

        System.out.println("\nVer primer programa PEEK");
        System.out.println(cola.peek());

    }
}
