import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EquipoBaloncesto {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] nombres;
    private static int[] edad;
    private static double[] estaturas;
    private static double[] velocidades;
    private static double[] saltos;
    private static double[] pesos;
    private static double[] envergaduras;

    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de jugadores:");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        nombres = new String[cantidadJugadores];
        estaturas = new double[cantidadJugadores];
        velocidades = new double[cantidadJugadores];
        saltos = new double[cantidadJugadores];
        pesos = new double[cantidadJugadores];
        envergaduras = new double[cantidadJugadores];

        // Ingresar los datos de los jugadores
        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
            nombres[i] = scanner.nextLine();
            System.out.println("Ingrese la estatura de " + nombres[i] + " (en metros):");
            estaturas[i] = scanner.nextDouble();
            System.out.println("Ingrese la velocidad de " + nombres[i] + " (en m/s):");
            velocidades[i] = scanner.nextDouble();
            System.out.println("Ingrese el salto de " + nombres[i] + " (en metros):");
            saltos[i] = scanner.nextDouble();
            System.out.println("Ingrese el peso de " + nombres[i] + " (en kg):");
            pesos[i] = scanner.nextDouble();
            System.out.println("Ingrese la envergadura de " + nombres[i] + " (en metros):");
            envergaduras[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
        }

        // 1. Listado de los nombres de los jugadores ordenados por velocidad
        ordenarJugadoresPorVelocidad();

        // 2. Mostrar el promedio de estatura de la línea titular
        double promedioEstatura = calcularPromedioEstatura();
        System.out.println("El promedio de estatura de la línea titular es: " + promedioEstatura + " metros");

        // 3. Calcular el jugador más completo
        int jugadorMasCompleto = calcularJugadorMasCompleto();
        System.out.println("El jugador más completo es: " + nombres[jugadorMasCompleto]);

        // 4. Listar jugadores capacitados para clavar el balón en el aro
        listarJugadoresCapacitadosParaClavar();

        // 5. Ordenar y listar jugadores por su índice de masa corporal (IMC)
        ordenarJugadoresPorIMC();
    }

    private static void ordenarJugadoresPorVelocidad() {
        // Implementar la lógica para ordenar los nombres de los jugadores según su velocidad
        for(int i = 0; i < velocidades.length; i++){
            for(int j = i+1; j < velocidades.length; j++){
                if(velocidades[i] < velocidades[j]){
                    double temp = velocidades[i];
                    velocidades[i] = velocidades[j];
                    velocidades[j] = temp;

                    String temp2 = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = temp2;
                }
            }
        }
        System.out.println("Jugadores ordenados por velocidad: " + Arrays.toString(nombres));
    }

    private static double calcularPromedioEstatura() {
        // Implementar el cálculo del promedio de estatura de la línea titular
        double sum = 0;
        for(int i = 0; i < estaturas.length; i++){
            sum += estaturas[i];
        }
        return sum / estaturas.length; // Reemplazar con el valor calculado
    }

    private static int calcularJugadorMasCompleto() {
        // Implementar el cálculo del jugador más completo
        double[] total = new double[nombres.length];
        int index = 0;
        double max = 0;
        for(int i = 0; i < nombres.length; i++){
            total[i] = estaturas[i] + velocidades[i] + saltos[i] + pesos[i] + envergaduras[i];
            if(total[i] > max){
                max = total[i];
                index = i;
            }
        }
        return index; // Reemplazar con el índice del jugador más completo
    }

    private static void listarJugadoresCapacitadosParaClavar() {
        // Implementar la lógica para listar jugadores capacitados para clavar el balón en el aro
        System.out.println("Jugadores capacitados para clavar el balón en el aro:");
        for(int i = 0; i < nombres.length; i++){
            if(saltos[i] >= 3){
                System.out.println(nombres[i]);
            }
        }
    }

    private static void ordenarJugadoresPorIMC() {
        // Implementar la lógica para ordenar y listar jugadores por su índice de masa corporal (IMC)
        double[] imc = new double[nombres.length];
        for(int i = 0; i < nombres.length; i++){
            imc[i] = pesos[i] / (estaturas[i] * estaturas[i]);
        }
        for(int i = 0; i < imc.length; i++){
            for(int j = i+1; j < imc.length; j++){
                if(imc[i] > imc[j]){
                    double temp = imc[i];
                    imc[i] = imc[j];
                    imc[j] = temp;

                    String temp2 = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = temp2;
                }
            }
        }
        System.out.println("Jugadores ordenados por IMC: " + Arrays.toString(nombres));
    }
}