import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

            Pila<String> pila = new Pila<>();
            Cola<String> cola = new Cola<>();

            Scanner scanner = new Scanner(System.in);
            int opcion = 0;
        do {
            System.out.println("*** ¡¡¡Bienvenido a tu sistema operativo!!! ***");
            System.out.println("\n¿Qué deseas realizar hoy?");
            System.out.println("\n1- Gestionar comandos\n2- Gestionar programas\n3- Salir del programa");

            try {
                System.out.print("Ingresa una opción: ");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Elige una opción correcta.");
                scanner.nextLine();
            }

            switch (opcion) {
                case 1: // Pila
                    int tareaPila = 0;

                    do {
                        System.out.println("\n*** ¡¡¡Bienvenido al gestor de comandos!!! ***");
                        System.out.println("\n¿Qué tarea deseas realizar?");
                        System.out.println("\n1- Ejecutar un comando\n2- Eliminar el último comando\n3- Mostrar último comando\n4- Mostrar historial de comandos\n5-Regresar al SO");

                        try {
                            System.out.print("\nIngresa una opción: ");
                            tareaPila = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Error. Ingresa una opción correcta.");
                            scanner.nextLine();
                        }

                        switch (tareaPila) {
                            case 1:
                                try {
                                    System.out.println("\nEscribe el nombre de un comando. (Ej. lsblk, cd, mkdir)");
                                    System.out.print("\n[java@datastructures ~]$ ");
                                    String comando = scanner.next();
                                    pila.push(comando);
                                    System.out.println("\nEjecutando el comando...");
                                } catch (InputMismatchException e) {
                                    System.out.println("Error. Escriba un comando válido.");
                                    scanner.nextLine();
                                }
                                
                                break;

                            case 2:
                                if (verificarListaPila(pila)) {
                                    String comando = pila.peek();
                                    System.out.println("\nEliminando el comando " + comando + "...");
                                    pila.pop();
                                }
                                
                                break;

                            case 3:
                                if (verificarListaPila(pila)) {
                                    System.out.println("");
                                    pila.peek();
                                }

                                break;
                            
                            case 4:
                                if (verificarListaPila(pila)) {
                                    pila.show();
                                }
                                
                                break;

                            default:
                                System.out.println("Elige una opción correcta.");
                                break;
                        }
                    } while (tareaPila !=5);
                    break;

                case 2: // Cola
                    int tareaCola = 0;

                    do {
                        System.out.println("\n*** ¡¡¡Bienvenido al gestor de aplicaciones!!! ***");
                        System.out.println("\n¿Qué tarea deseas realizar?");
                        System.out.println("\n1- Abrir una aplicación\n2- Finalizar programa en ejecución\n3- Ver programa en ejecución\n4- Mostrar los programas en espera\n5- Regresar al SO");

                        try {
                            System.out.print("\nIngresa una opción: ");
                            tareaCola = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Error. Ingresa una opción correcta.");
                            scanner.nextLine();
                        }

                        switch (tareaCola) {
                            case 1:
                                try {
                                    System.out.println("\nEscribe el nombre de una aplicación. (Ej. Firefox, Spotify)");
                                    System.out.print("\n[java@datastructures ~]$ ");
                                    String app = scanner.next();
                                    cola.enqueue(app);
                                    System.out.println("\nAbriendo la aplicación...");
                                } catch (InputMismatchException e) {
                                    System.out.println("Error. Escriba un aplicación válida.");
                                    scanner.nextLine();
                                }
                                break;
                            
                            case 2:
                                if (verificarListaCola(cola)) {
                                    String programa = cola.peek();
                                    System.out.println("\nFinalizando " + programa + "...");
                                    cola.dequeue();
                                };
                                
                                break;

                            case 3:
                                if (verificarListaCola(cola)) {
                                    System.out.println("\nPrograma en ejecución: " + cola.peek());
                                }
                                
                                break;

                            case 4:
                                if (verificarListaCola(cola)) {
                                    System.out.println("\nProgramas en espera:\n");
                                    cola.show();
                                }
                                
                                break;
                        
                            default:
                                System.out.println("Elige una opción correcta.");
                                break;
                        }
                    } while (tareaCola != 5);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
            
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

        } while (opcion != 3);

        scanner.close();
    }

    private static boolean verificarListaPila(Pila<String> pila) {
        if (pila.isEmpty()) {
            System.out.println("No hay historial de comandos.");
            return false;
        } 
        return true;
    }

    private static boolean verificarListaCola(Cola<String> cola) {
        if (cola.isEmpty()) {
            System.out.println("No hay aplicaciones en ejecución.");
            return false;
        } 
        return true;
    }
}
